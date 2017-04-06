package edu.QATestLab.WarOfRaces.model.Undead;

import edu.QATestLab.WarOfRaces.model.Unit.Unit;

public class Hunter extends RaceOfUndead {

	private float damageFirst;
	private float damageSecond;
	
	public Hunter(float hp, String name, float damageFirst, float damageSecond) {
		super(hp, name, damageSecond, damageSecond);
		this.damageFirst = damageFirst;
		this.damageSecond = damageSecond;
	}

	@Override
	public void attackFirst(Unit u) {
		u.setHp((float) (u.getHp() - damageFirst));
	}

	@Override
	public void attackSecond(Unit u) {
		u.setHp((float) (u.getHp() - damageSecond));
	}
}
