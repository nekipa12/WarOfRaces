package edu.QATestLab.WarOfRaces.model.Human;

import edu.QATestLab.WarOfRaces.model.Elves.Unit;

public class RaceOfHuman extends Unit{

	public RaceOfHuman(byte hp, String name, byte damageFirst, byte damageSecond) {
		super(hp, name, damageSecond, damageSecond);
	}

}
