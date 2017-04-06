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
			System.out.println("Ход " + count);
			count++;
			teamFirstAction();
		} else {
			System.out.println("Ход " + count);
			count++;
			teamSecondAction();
		}
	}

	private void teamSecondAction() {
		int count = 0;
		Collections.shuffle(teamSecond);
		if (!privilegedGroupForTeamSecond.isEmpty()) {
			count++;
			int idx = rnd.nextInt(teamFirst.size());
			if (rnd.nextInt(2) == 1) {
				privilegedGroupForTeamSecond.get(0).attackFirst(teamFirst.get(idx));
				System.out.println(privilegedGroupForTeamSecond.get(0).getName() + "(" + privilegedGroupForTeamSecond.get(0).getHp() + ")"
						+ "\t" + "aтаковал" + "\t" + teamFirst.get(idx).getName() + "(" + teamFirst.get(idx).getHp() + ")");
			} else {
				System.out.println();
				privilegedGroupForTeamSecond.get(0).attackSecond(teamFirst.get(idx));
				System.out.println(privilegedGroupForTeamSecond.get(0).getName() + "(" + privilegedGroupForTeamSecond.get(0).getHp() + ")"
						+ "\t" + "aтаковал" + "\t" + teamFirst.get(idx).getName() + "(" + teamFirst.get(idx).getHp() + ")");
			}
			if (teamFirst.get(idx).getHp() <= 0) {
				System.out.println(privilegedGroupForTeamSecond.get(0).getName() + "(" + privilegedGroupForTeamSecond.get(0).getHp() + ")" + "\t" + "убил" + "\t\t" + teamFirst.get(idx).getName());
				teamFirst.remove(idx);
				if (teamFirst.isEmpty()) return;
			}
		}
		Unit un = null;
		if (!privilegedGroupForTeamSecond.isEmpty()) {
			dellSkill(privilegedGroupForTeamSecond);
			un = privilegedGroupForTeamSecond.get(0);
			privilegedGroupForTeamSecond.remove(0);
		}
		while (true) {
			for (Unit u : teamSecond) {
				int idx = rnd.nextInt(teamFirst.size());
				if (rnd.nextInt(2) == 1) {
					if (u instanceof Necromancer) {
						u.attackFirst(teamFirst.get(idx));
						ill.add(teamFirst.get(idx));
						System.out.println(u.getName() + "\t" + " недуг на " + "\t" + teamFirst.get(idx).getName());
						continue;
					} else if (u instanceof Shaman) {
						int r = rnd.nextInt(teamSecond.size());
						privilegedGroupForTeamSecond.add(teamSecond.get(r));
						System.out.println(u.getName()+ "\t" + " улучшение на " + "\t" + teamSecond.get(r).getName());
						continue;
					} else {
						u.attackFirst(teamFirst.get(idx));
					}
				} else {
					if (u instanceof Shaman) {
						if (!privilegedGroupForTeamFirst.isEmpty()) {
							dellSkill(privilegedGroupForTeamFirst);
							System.out.println(u.getName()+ "\t" + "снял улучшение с" + "\t" + privilegedGroupForTeamFirst.get(0).getName());
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
					System.out.println(u.getName() + "(" + u.getHp() + ")" + "\t" + "убил" + "\t\t" + teamFirst.get(idx).getName());
					teamFirst.remove(idx);
					if (teamFirst.isEmpty()) break;
				} else {
					System.out.println(u.getName() + "(" + u.getHp() + ")" + "\t" + "aтаковал" + "\t" + teamFirst.get(idx).getName() + "(" + teamFirst.get(idx).getHp() + ")");
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
		if (!privilegedGroupForTeamFirst.isEmpty()) {
			count++;
			int idx = rnd.nextInt(teamSecond.size());
			if (rnd.nextInt(2) == 1) {
				privilegedGroupForTeamFirst.get(0).attackFirst(teamSecond.get(idx));
			} else {
				privilegedGroupForTeamFirst.get(0).attackSecond(teamSecond.get(idx));
			}
			if (teamSecond.get(idx).getHp() <= 0) {
				System.out.println(privilegedGroupForTeamFirst.get(0).getName() + "(" + privilegedGroupForTeamFirst.get(0).getHp() + ")" + "\t" + "убил" + "\t\t" + teamSecond.get(idx).getName());
				teamSecond.remove(idx);
				if (teamSecond.isEmpty()) return;
			} else {
				System.out.println(privilegedGroupForTeamFirst.get(0).getName() + "(" + privilegedGroupForTeamFirst.get(0).getHp() + ")" + "\t" + "aтаковал" + "\t" + teamSecond.get(idx).getName() + "(" + teamSecond.get(idx).getHp() + ")");
			}
		}
		Unit un = null;
		if (!privilegedGroupForTeamFirst.isEmpty()) {
			dellSkill(privilegedGroupForTeamFirst);
			un = privilegedGroupForTeamFirst.get(0);
			privilegedGroupForTeamFirst.remove(0);
		}
		while (true) {
			for (Unit u : teamFirst) {
				int idx = rnd.nextInt(teamSecond.size());
				if (rnd.nextInt(2) == 1) {
					if (u instanceof Mage || u instanceof MageHuman) {
						int r = rnd.nextInt(teamFirst.size());
						privilegedGroupForTeamFirst.add(teamFirst.get(r));
						System.out.println(u.getName() + " улучшение на " + teamFirst.get(r).getName());
						continue;
					} else {
						u.attackFirst(teamSecond.get(idx));
					}
				} else {
					u.attackSecond(teamSecond.get(idx));
				}
				if (teamSecond.get(idx).getHp() <= 0) {
					System.out.println(u.getName() + "(" + u.getHp() + ")" + "\t" + "убил" + "\t\t" + teamSecond.get(idx).getName());
					teamSecond.remove(idx);
					if(teamSecond.isEmpty()) break;
				} else {
					System.out.println(u.getName() + "(" + u.getHp() + ")" + "\t" + "aтаковал" + "\t" + teamSecond.get(idx).getName() + "(" + teamSecond.get(idx).getHp() + ")");
				}
			}
			break;
		}
		if (count == 1) {
			teamFirst.add(un);
		}
		if (!ill.isEmpty()) {
			for (Unit unit : ill) {
				unit.setDamageFirst(unit.getDamageFirst() * 2);
				unit.setDamageSecond(unit.getDamageSecond() * 2);
			}
			ill.clear();
		}
		addSkill(privilegedGroupForTeamFirst, teamFirst);
		System.out.println();
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
