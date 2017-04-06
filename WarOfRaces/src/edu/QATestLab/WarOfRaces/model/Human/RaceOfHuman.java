package edu.QATestLab.WarOfRaces.model.Human;

import edu.QATestLab.WarOfRaces.model.Unit.Unit;

public class RaceOfHuman extends Unit {

	public RaceOfHuman(float hp, String name, float damageFirst, float damageSecond) {
		super(hp, name, damageSecond, damageSecond);
	}
}
