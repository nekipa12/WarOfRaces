package edu.QATestLab.WarOfRaces.model.Elves;

import edu.QATestLab.WarOfRaces.model.Unit.Unit;

public class Archer extends RaceOfElves {
	
	private float damageFirst;
	private float damageSecond;
	
	public float getDamageFirst() {
		return damageFirst;
	}

	public void setDamageFirst(float damageFirst) {
		this.damageFirst = damageFirst;
	}

	public float getDamageSecond() {
		return damageSecond;
	}

	public void setDamageSecond(float damageSecond) {
		this.damageSecond = damageSecond;
	}

	public Archer(float hp, String name, float damageFirst, float damageSecond) {
		super(hp, name, damageSecond, damageSecond);
		this.damageFirst = damageFirst;
		this.damageSecond = damageSecond;
	}

	@Override
	public void attackFirst(Unit u) {
		u.setHp(u.getHp() - damageFirst);
	}

	@Override
	public void attackSecond(Unit u) {
		u.setHp(u.getHp() - damageSecond);
	}
	

}
