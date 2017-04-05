package edu.QATestLab.WarOfRaces.controller;

import java.util.ArrayList;
import java.util.Random;

import edu.QATestLab.WarOfRaces.model.Elves.Archer;
import edu.QATestLab.WarOfRaces.model.Elves.Mage;
import edu.QATestLab.WarOfRaces.model.Elves.RaceOfElves;
import edu.QATestLab.WarOfRaces.model.Elves.Unit;
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
		
		alElvesTeam.add(new Mage((byte)100, "Mage", (byte)0, (byte)10));
		alElvesTeam.add(new Archer((byte)100, "Archer1", (byte)7, (byte)3));
		alElvesTeam.add(new Archer((byte)100, "Archer2", (byte)7, (byte)3));
		alElvesTeam.add(new Archer((byte)100, "Archer3", (byte)7, (byte)3));
		alElvesTeam.add(new Warrior((byte)100, "Warrior1", (byte)0, (byte)15));
		alElvesTeam.add(new Warrior((byte)100, "Warrior2", (byte)0, (byte)15));
		alElvesTeam.add(new Warrior((byte)100, "Warrior3", (byte)0, (byte)15));
		alElvesTeam.add(new Warrior((byte)100, "Warrior4", (byte)0, (byte)15));
		
		alHumanTeam.add(new MageHuman((byte)100, "MageHuman", (byte)0, (byte)4));
		alHumanTeam.add(new CrossbowArcher((byte)100, "CrossbowArcher1", (byte)5, (byte)3));
		alHumanTeam.add(new CrossbowArcher((byte)100, "CrossbowArcher2", (byte)5, (byte)3));
		alHumanTeam.add(new CrossbowArcher((byte)100, "CrossbowArcher3", (byte)5, (byte)3));
		alHumanTeam.add(new WarriorHuman((byte)100, "WarriorHuman1", (byte)0, (byte)18));
		alHumanTeam.add(new WarriorHuman((byte)100, "WarriorHuman2", (byte)0, (byte)18));
		alHumanTeam.add(new WarriorHuman((byte)100, "WarriorHuman3", (byte)0, (byte)18));
		alHumanTeam.add(new WarriorHuman((byte)100, "WarriorHuman4", (byte)0, (byte)18));
		
		alOrcsTeam.add(new Shaman((byte)100, "Shaman", (byte)0, (byte)0));
		alOrcsTeam.add(new ArcherOrc((byte)100, "ArcherOrc1", (byte)3, (byte)2));
		alOrcsTeam.add(new ArcherOrc((byte)100, "ArcherOrc2", (byte)3, (byte)2));
		alOrcsTeam.add(new ArcherOrc((byte)100, "ArcherOrc3", (byte)3, (byte)2));
		alOrcsTeam.add(new Goblin((byte)100, "Goblin1", (byte)0, (byte)20));
		alOrcsTeam.add(new Goblin((byte)100, "Goblin2", (byte)0, (byte)20));
		alOrcsTeam.add(new Goblin((byte)100, "Goblin3", (byte)0, (byte)20));
		alOrcsTeam.add(new Goblin((byte)100, "Goblin4", (byte)0, (byte)20));
		
		alUndeadsTeam.add(new Necromancer((byte)100, "Necromancer", (byte)0, (byte)5));
		alUndeadsTeam.add(new Hunter((byte)100, "Hunter1", (byte)4, (byte)2));
		alUndeadsTeam.add(new Hunter((byte)100, "Hunter2", (byte)4, (byte)2));
		alUndeadsTeam.add(new Hunter((byte)100, "Hunter3", (byte)4, (byte)2));
		alUndeadsTeam.add(new Zombie((byte)100, "Zombie1", (byte)0, (byte)18));
		alUndeadsTeam.add(new Zombie((byte)100, "Zombie2", (byte)0, (byte)18));
		alUndeadsTeam.add(new Zombie((byte)100, "Zombie3", (byte)0, (byte)18));
		alUndeadsTeam.add(new Zombie((byte)100, "Zombie4", (byte)0, (byte)18));
	}
	
	public ArrayList<Unit> addTeamOpponents1(){
		ArrayList<ArrayList<Unit>> alu = new ArrayList<>();
		alu.add(alElvesTeam);
		alu.add(alHumanTeam);
		Random rnd = new Random();
		return alu.get(rnd.nextInt(2));
	}
	
	public ArrayList<Unit> addTeamOpponents2(){
		ArrayList<ArrayList<Unit>> alu = new ArrayList<>();
		alu.add(alOrcsTeam);
		alu.add(alUndeadsTeam);
		Random rnd = new Random();
		return alu.get(rnd.nextInt(2));
	}

}
