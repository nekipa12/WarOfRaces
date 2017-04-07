package edu.QATestLab.WarOfRaces.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import edu.QATestLab.WarOfRaces.model.Elves.Mage;
import edu.QATestLab.WarOfRaces.model.Human.MageHuman;
import edu.QATestLab.WarOfRaces.model.Orcs.Shaman;
import edu.QATestLab.WarOfRaces.model.Undead.Necromancer;
import edu.QATestLab.WarOfRaces.model.Unit.Unit;
import edu.QATestLab.WarOfRaces.view.ViewProcess;

public class Game {
	
	private Teams t;
	private ViewProcess vp;
	private ArrayList<Unit> teamFirst;
	private ArrayList<Unit> teamSecond;
	private Random rnd;
	private int count;
	private ArrayList<Unit> privilegedGroupForTeamFirst;
	private ArrayList<Unit> privilegedGroupForTeamSecond;
	private ArrayList<Unit> ill;
	private Unit un;
	
	public Game() {
		t = new Teams();
		vp = new ViewProcess();
		teamFirst = new ArrayList<>();
		teamSecond = new ArrayList<>();
		rnd = new Random();
		count = 1;
		privilegedGroupForTeamFirst = new ArrayList<>();
		privilegedGroupForTeamSecond = new ArrayList<>();
		ill = new ArrayList<>();
	}

	public void start() {
		add();
		while (true) {
			if (teamSecond.isEmpty() || teamFirst.isEmpty()) break;
			chooseWhoFirst();
		}
		outLogs();
	}

	private void outLogs() {
		for (String log : vp.getAls()) {
			try (FileWriter fw = new FileWriter("./Results/book.txt", true)) {
				fw.write(log + "\r\n");
				fw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void chooseWhoFirst() {
		if (rnd.nextInt(2) == 1) {
			vp.step(count);
			count++;
			teamFirstAction();
		} else {
			vp.step(count);
			count++;
			teamSecondAction();
		}
	}

	private int teamSecondAction(ArrayList<Unit> privilegedGroup, ArrayList<Unit> teams, int count) {
		if (!privilegedGroup.isEmpty()) {
			count++;
			int idx = rnd.nextInt(teams.size());
			if (rnd.nextInt(2) == 1) {
				privilegedGroup.get(0).attackFirst(teams.get(idx));
				vp.attacked(privilegedGroup.get(0).getName(), privilegedGroup.get(0).getHp(), teams.get(idx).getName(), teams.get(idx).getHp());
			} else {
				System.out.println();
				privilegedGroup.get(0).attackSecond(teams.get(idx));
				vp.attacked(privilegedGroup.get(0).getName(), privilegedGroup.get(0).getHp(), teams.get(idx).getName(), teams.get(idx).getHp());
			}
			if (teams.get(idx).getHp() <= 0) {
				vp.killed(privilegedGroup.get(0).getName(), privilegedGroup.get(0).getHp(), teams.get(idx).getName());
				teams.remove(idx);
			}
		}
		return count;
	}
	
	private void teamSecondAction() {
		int count = 0;
		Collections.shuffle(teamSecond);
		count = teamSecondAction(privilegedGroupForTeamSecond, teamFirst, count);
		if (teamFirst.isEmpty()) return;
		clearPrivilegedGroup(privilegedGroupForTeamSecond);
		while (true) {
			for (Unit u : teamSecond) {
				int idx = rnd.nextInt(teamFirst.size());
				if (rnd.nextInt(2) == 1) {
					if (u instanceof Necromancer) {
						u.attackFirst(teamFirst.get(idx));
						ill.add(teamFirst.get(idx));
						vp.necromancerSkill(u.getName(), teamFirst.get(idx).getName());
						continue;
					} else if (u instanceof Shaman) {
						int r = rnd.nextInt(teamSecond.size());
						privilegedGroupForTeamSecond.add(teamSecond.get(r));
						vp.improvement(u.getName(), teamSecond.get(r).getName());
						continue;
					} else {
						u.attackFirst(teamFirst.get(idx));
					}
				} else {
					if (u instanceof Shaman) {
						if (!privilegedGroupForTeamFirst.isEmpty()) {
							dellSkill(privilegedGroupForTeamFirst);
							vp.shamanSkills(u.getName(), privilegedGroupForTeamFirst.get(0).getName());
							Unit uni = privilegedGroupForTeamFirst.get(0);
							privilegedGroupForTeamFirst.remove(0);
							teamFirst.add(uni);
							continue;
						}
					} else {
						u.attackSecond(teamFirst.get(idx));
					}
				}
				if (teamFirst.get(idx).getHp() <= 0) {
					vp.killed(u.getName(), u.getHp(), teamFirst.get(idx).getName());
					teamFirst.remove(idx);
					if (teamFirst.isEmpty()) return;
				} else {
					vp.attacked(u.getName(), u.getHp(), teamFirst.get(idx).getName(), teamFirst.get(idx).getHp());
				}
			}
			System.out.println();
			break;
		}
		if (count == 1) {
			teamSecond.add(un);
		}
		addSkill(privilegedGroupForTeamSecond, teamSecond);
	}

	private void teamFirstAction() {
		int count = 0;
		Collections.shuffle(teamFirst);
		count = teamSecondAction(privilegedGroupForTeamFirst, teamSecond, count);
		if (teamSecond.isEmpty()) return;
		clearPrivilegedGroup(privilegedGroupForTeamFirst);
		while (true) {
			for (Unit u : teamFirst) {
				int idx = rnd.nextInt(teamSecond.size());
				if (rnd.nextInt(2) == 1) {
					if (u instanceof Mage || u instanceof MageHuman) {
						int r = rnd.nextInt(teamFirst.size());
						privilegedGroupForTeamFirst.add(teamFirst.get(r));
						vp.improvement(u.getName(), teamFirst.get(r).getName());
						continue;
					} else {
						u.attackFirst(teamSecond.get(idx));
					}
				} else {
					u.attackSecond(teamSecond.get(idx));
				}
				if (teamSecond.get(idx).getHp() <= 0) {
					vp.killed(u.getName(), u.getHp(), teamSecond.get(idx).getName());
					teamSecond.remove(idx);
					if (teamSecond.isEmpty()) return;
				} else {
					vp.attacked(u.getName(), u.getHp(), teamSecond.get(idx).getName(), teamSecond.get(idx).getHp());
				}
			}
			break;
		}
		if (count == 1) {
			teamFirst.add(un);
		}
		treatmentUnit();
		addSkill(privilegedGroupForTeamFirst, teamFirst);
		System.out.println();
	}

	private void treatmentUnit() {
		if (!ill.isEmpty()) {
			for (Unit unit : ill) {
				unit.setDamageFirst(unit.getDamageFirst() * 2);
				unit.setDamageSecond(unit.getDamageSecond() * 2);
			}
			ill.clear();
		}
	}

	private void clearPrivilegedGroup(ArrayList<Unit> privilegedGroup) {
		if (!privilegedGroup.isEmpty()) {
			dellSkill(privilegedGroup);
			un = privilegedGroup.get(0);
			privilegedGroup.remove(0);
		}
	}

	private void addSkill(ArrayList<Unit> privilegedGroupForTeams, ArrayList<Unit> teams) {
		if (!privilegedGroupForTeams.isEmpty()) {
			privilegedGroupForTeams.get(0).setDamageFirst((float) (privilegedGroupForTeams.get(0).getDamageFirst() * 1.5));
			privilegedGroupForTeams.get(0).setDamageSecond((float) (privilegedGroupForTeams.get(0).getDamageSecond() * 1.5));
			teams.remove(privilegedGroupForTeams.get(0));
		}
	}
	
	private void dellSkill(ArrayList<Unit> privilegedGroupForTeams) {
		privilegedGroupForTeams.get(0).setDamageFirst( (float) (privilegedGroupForTeams.get(0).getDamageFirst() / 1.5));
		privilegedGroupForTeams.get(0).setDamageSecond( (float) (privilegedGroupForTeams.get(0).getDamageSecond() / 1.5));
	}

	private void add() {
		teamFirst = t.addTeamOpponents1();
		teamSecond = t.addTeamOpponents2();
	}
}
