package edu.QATestLab.WarOfRaces.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import edu.QATestLab.WarOfRaces.model.Elves.Mage;
import edu.QATestLab.WarOfRaces.model.Elves.Unit;
import edu.QATestLab.WarOfRaces.model.Human.MageHuman;
import edu.QATestLab.WarOfRaces.model.Orcs.Shaman;
import edu.QATestLab.WarOfRaces.model.Undead.Necromancer;

public class Game {
	private Teams t;
	private ArrayList<Unit> teamFirst;
	private ArrayList<Unit> teamSecond;
	private Random rnd;
	private int count;
	private ArrayList<Unit> privilegedGroupForTeamFirst;
	private ArrayList<Unit> privilegedGroupForTeamSecond;
	private ArrayList<Unit> ill;
	
	public Game() {
		t = new Teams();
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
		Collections.shuffle(teamSecond);
		if (!privilegedGroupForTeamSecond.isEmpty()) {
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
			dellSkillS();
			un = privilegedGroupForTeamSecond.get(0);
			privilegedGroupForTeamSecond.remove(0);
			teamSecond.add(un);
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
							dellSkillF();
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
		addSkillS();
	}

	private void teamFirstAction() {
		Collections.shuffle(teamFirst);
		if (!privilegedGroupForTeamFirst.isEmpty()) {
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
			dellSkillF();
			un = privilegedGroupForTeamFirst.get(0);
			privilegedGroupForTeamFirst.remove(0);
			teamFirst.add(un);
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
		if (!ill.isEmpty()) {
			for (Unit unit : ill) {
				unit.setDamageFirst(unit.getDamageFirst() * 2);
				unit.setDamageSecond(unit.getDamageSecond() * 2);
			}
			ill.clear();
		}
		addSkillF();
		System.out.println();
	}

	private void addSkillS() {
		if (!privilegedGroupForTeamSecond.isEmpty()) {
			privilegedGroupForTeamSecond.get(0).setDamageFirst((float) (privilegedGroupForTeamSecond.get(0).getDamageFirst() * 1.5));
			privilegedGroupForTeamSecond.get(0).setDamageSecond((float) (privilegedGroupForTeamSecond.get(0).getDamageSecond() * 1.5));
			teamSecond.remove(privilegedGroupForTeamSecond.get(0));
		}
	}

	private void addSkillF() {
		if (!privilegedGroupForTeamFirst.isEmpty()) {
			privilegedGroupForTeamFirst.get(0).setDamageFirst((float) (privilegedGroupForTeamFirst.get(0).getDamageFirst() * 1.5));
			privilegedGroupForTeamFirst.get(0).setDamageSecond((float) (privilegedGroupForTeamFirst.get(0).getDamageSecond() * 1.5));
			teamFirst.remove(privilegedGroupForTeamFirst.get(0));
		}
	}
	
	private void dellSkillS() {
		privilegedGroupForTeamSecond.get(0).setDamageFirst( (float) (privilegedGroupForTeamSecond.get(0).getDamageFirst() / 1.5));
		privilegedGroupForTeamSecond.get(0).setDamageSecond( (float) (privilegedGroupForTeamSecond.get(0).getDamageSecond() / 1.5));
		
	}
	
	private void dellSkillF() {
		privilegedGroupForTeamFirst.get(0).setDamageFirst( (float) (privilegedGroupForTeamFirst.get(0).getDamageFirst() / 1.5));
		privilegedGroupForTeamFirst.get(0).setDamageSecond( (float) (privilegedGroupForTeamFirst.get(0).getDamageSecond() / 1.5));
	}

	private void add() {
		teamFirst = t.addTeamOpponents1();
		teamSecond = t.addTeamOpponents2();
	}
}
