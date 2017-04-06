package edu.QATestLab.WarOfRaces.controller;

import java.util.ArrayList;
import java.util.Random;
import edu.QATestLab.WarOfRaces.model.Elves.Archer;
import edu.QATestLab.WarOfRaces.model.Elves.Mage;
import edu.QATestLab.WarOfRaces.model.Elves.Warrior;
import edu.QATestLab.WarOfRaces.model.Human.CrossbowArcher;
import edu.QATestLab.WarOfRaces.model.Human.MageHuman;
import edu.QATestLab.WarOfRaces.model.Human.WarriorHuman;
import edu.QATestLab.WarOfRaces.model.Orcs.ArcherOrc;
import edu.QATestLab.WarOfRaces.model.Orcs.Goblin;
import edu.QATestLab.WarOfRaces.model.Orcs.Shaman;
import edu.QATestLab.WarOfRaces.model.Undead.Hunter;
import edu.QATestLab.WarOfRaces.model.Undead.Necromancer;
import edu.QATestLab.WarOfRaces.model.Undead.Zombie;
import edu.QATestLab.WarOfRaces.model.Unit.Unit;

public class Teams {
	
	private ArrayList<Unit> alElvesTeam;
	private ArrayList<Unit> alHumanTeam;
	private ArrayList<Unit> alOrcsTeam;
	private ArrayList<Unit> alUndeadsTeam;

	public Teams() {
		alElvesTeam = new ArrayList<>();
		alHumanTeam = new ArrayList<>();
		alOrcsTeam = new ArrayList<>();
		alUndeadsTeam = new ArrayList<>();
		makeTeams();
	}

	private void makeTeams() {
		alElvesTeam.add(new Mage(100, "Mage", 0, 10));
		alElvesTeam.add(new Archer(100, "Archer1", 7, 3));
		alElvesTeam.add(new Archer(100, "Archer2", 7, 3));
		alElvesTeam.add(new Archer(100, "Archer3", 7, 3));
		alElvesTeam.add(new Warrior(100, "Warrior1", 0, 15));
		alElvesTeam.add(new Warrior(100, "Warrior2", 0, 15));
		alElvesTeam.add(new Warrior(100, "Warrior3", 0, 15));
		alElvesTeam.add(new Warrior(100, "Warrior4", 0, 15));
		
		alHumanTeam.add(new MageHuman(100, "MageHuman", 0, 4));
		alHumanTeam.add(new CrossbowArcher(100, "CrossbowArcher1", 5, 3));
		alHumanTeam.add(new CrossbowArcher(100, "CrossbowArcher2", 5, 3));
		alHumanTeam.add(new CrossbowArcher(100, "CrossbowArcher3", 5, 3));
		alHumanTeam.add(new WarriorHuman(100, "WarriorHuman1", 0, 18));
		alHumanTeam.add(new WarriorHuman(100, "WarriorHuman2", 0, 18));
		alHumanTeam.add(new WarriorHuman(100, "WarriorHuman3", 0, 18));
		alHumanTeam.add(new WarriorHuman(100, "WarriorHuman4", 0, 18));
		
		alOrcsTeam.add(new Shaman(100, "Shaman", 0, 0));
		alOrcsTeam.add(new ArcherOrc(100, "ArcherOrc1", 3, 2));
		alOrcsTeam.add(new ArcherOrc(100, "ArcherOrc2", 3, 2));
		alOrcsTeam.add(new ArcherOrc(100, "ArcherOrc3", 3, 2));
		alOrcsTeam.add(new Goblin(100, "Goblin1", 0, 20));
		alOrcsTeam.add(new Goblin(100, "Goblin2", 0, 20));
		alOrcsTeam.add(new Goblin(100, "Goblin3", 0, 20));
		alOrcsTeam.add(new Goblin(100, "Goblin4", 0, 20));
		
		alUndeadsTeam.add(new Necromancer(100, "Necromancer", 0, 5));
		alUndeadsTeam.add(new Hunter(100, "Hunter1", 4, 2));
		alUndeadsTeam.add(new Hunter(100, "Hunter2", 4, 2));
		alUndeadsTeam.add(new Hunter(100, "Hunter3", 4, 2));
		alUndeadsTeam.add(new Zombie(100, "Zombie1", 0, 18));
		alUndeadsTeam.add(new Zombie(100, "Zombie2", 0, 18));
		alUndeadsTeam.add(new Zombie(100, "Zombie3", 0, 18));
		alUndeadsTeam.add(new Zombie(100, "Zombie4", 0, 18));
	}
	
	public ArrayList<Unit> addTeamOpponents1() {
		ArrayList<ArrayList<Unit>> alu = new ArrayList<>();
		alu.add(alElvesTeam);
		alu.add(alHumanTeam);
		Random rnd = new Random();
		return alu.get(rnd.nextInt(2));
	}
	
	public ArrayList<Unit> addTeamOpponents2() {
		ArrayList<ArrayList<Unit>> alu = new ArrayList<>();
		alu.add(alOrcsTeam);
		alu.add(alUndeadsTeam);
		Random rnd = new Random();
		return alu.get(rnd.nextInt(2));
	}
}
