package edu.QATestLab.WarOfRaces.controller;

import java.util.ArrayList;
import java.util.Random;

import edu.QATestLab.WarOfRaces.model.Elves.Mage;
import edu.QATestLab.WarOfRaces.model.Elves.Unit;
import edu.QATestLab.WarOfRaces.model.Human.MageHuman;

public class Game {
	private Teams t;
	private ArrayList<Unit> teamFirst;
	private ArrayList<Unit> teamSecond;
	private Random rnd;
	private int count;
	private ArrayList<Unit> privilegedGroupForTeamFirst;
	private ArrayList<Unit> privilegedGroupForTeamSecond;
	private ArrayList<Integer> al;
	public Game() {
		t = new Teams();
		teamFirst = new ArrayList<>();
		teamSecond = new ArrayList<>();
		rnd = new Random();
		count = 1;
		privilegedGroupForTeamFirst = new ArrayList<>();
		privilegedGroupForTeamSecond = new ArrayList<>();
		al = new ArrayList<>();
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
			a(teamFirst);
			teamFirstAction();
		} else {
			System.out.println("Ход " + count);
			count++;
			a(teamSecond);
			teamSecondAction();
		}
	}

	private void teamSecondAction() {
		while(true){
			if(al.isEmpty()) break;
			int index = rnd.nextInt(al.size());
			Unit u = teamSecond.get(al.get(index));
			al.remove(index);
			if(teamFirst.isEmpty()) return;
			int idx = rnd.nextInt(teamFirst.size());
			if (rnd.nextInt(2) == 1) {
				/*if (u instanceof Mage || u instanceof MageHuman) {
					int r = rnd.nextInt(teamFirst.size());
					privilegedGroupForTeamFirst.add(teamFirst.get(r));
					//teamFirst.remove(r);
					u.attackFirst(teamFirst.get(r));
					System.out.println(u.getName() + " улучшение на " + teamFirst.get(r).getName());
					continue;
				} else {*/
					u.attackFirst(teamFirst.get(idx));
				//}
			} else {
				u.attackSecond(teamFirst.get(idx));
			}
			if (teamFirst.get(idx).getHp() <= 0) {
				System.out.println(u.getName() + "(" + u.getHp() + ")" + "\t" + "убил" + "\t\t" + teamFirst.get(idx).getName());
				teamFirst.remove(idx);
			} else {
				System.out.println(u.getName() + "(" + u.getHp() + ")" + "\t" + "aтаковал" + "\t" + teamFirst.get(idx).getName() + "(" + teamFirst.get(idx).getHp() + ")");
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*for (Unit u : teamSecond) {
			if (teamFirst.isEmpty()) {
				return;
			}
			int idx = rnd.nextInt(teamFirst.size());
			if (rnd.nextInt(2) == 1) {
				u.attackFirst(teamFirst.get(idx));
			} else {
				u.attackSecond(teamFirst.get(idx));
			}
			if (teamFirst.get(idx).getHp() <= 0) {
				System.out.println(u.getName() + "(" + u.getHp() + ")" + "\t" + "убил" + "\t\t" + teamFirst.get(idx).getName());
				teamFirst.remove(idx);
			} else {
				System.out.println(u.getName() + "(" + u.getHp() + ")" + "\t" + "aтаковал" + "\t" + teamFirst.get(idx).getName() + "(" + teamFirst.get(idx).getHp() + ")");
			}
		}*/
		System.out.println();
	}
	private void a(ArrayList<Unit> team){
		for (int i = 0; i < team.size(); i++) {
			al.add(i);
		}
		
	}

	private void teamFirstAction() {
		
		while(true){
			if(al.isEmpty()) break;
			int index = rnd.nextInt(al.size());
			Unit u = teamFirst.get(al.get(index));
			al.remove(index);
			if(teamSecond.isEmpty()) return;
			int idx = rnd.nextInt(teamSecond.size());
			if (rnd.nextInt(2) == 1) {
				if (u instanceof Mage || u instanceof MageHuman) {
					int r = rnd.nextInt(teamFirst.size());
					privilegedGroupForTeamFirst.add(teamFirst.get(r));
					u.attackFirst(teamFirst.get(r));
					
					teamFirst.remove(r);
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
			} else {
				System.out.println(u.getName() + "(" + u.getHp() + ")" + "\t" + "aтаковал" + "\t" + teamSecond.get(idx).getName() + "(" + teamSecond.get(idx).getHp() + ")");
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*for (Unit u : teamFirst) {
			if (teamSecond.isEmpty()) return;
			int idx = rnd.nextInt(teamSecond.size());
			if (rnd.nextInt(2) == 1) {
				if (u instanceof Mage || u instanceof MageHuman) {
					int r = rnd.nextInt(teamFirst.size());
					privilegedGroupForTeamFirst.add(teamFirst.get(r));
					teamFirst.remove(r);
					u.attackFirst(teamFirst.get(r));
					System.out.println("улучшение на " + teamFirst.get(r).getName());
				} else {
					u.attackFirst(teamSecond.get(idx));
				}
			} else {
				u.attackSecond(teamSecond.get(idx));
			}
			if (teamSecond.get(idx).getHp() <= 0) {
				System.out.println(u.getName() + "(" + u.getHp() + ")" + "\t" + "убил" + "\t\t" + teamSecond.get(idx).getName());
				teamSecond.remove(idx);
			} else {
				System.out.println(u.getName() + "(" + u.getHp() + ")" + "\t" + "aтаковал" + "\t" + teamSecond.get(idx).getName() + "(" + teamSecond.get(idx).getHp() + ")");
			}
		}*/
		System.out.println();
	}

	private void add() {
		teamFirst = t.addTeamOpponents1();
		teamSecond = t.addTeamOpponents2();
	}
}
