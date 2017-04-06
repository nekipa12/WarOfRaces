package edu.QATestLab.WarOfRaces.model.Undead;

import edu.QATestLab.WarOfRaces.model.Unit.Unit;

public class RaceOfUndead extends Unit {

	public RaceOfUndead(float hp, String name, float damageFirst, float damageSecond) {
		super(hp, name, damageSecond, damageSecond);
	}
}
