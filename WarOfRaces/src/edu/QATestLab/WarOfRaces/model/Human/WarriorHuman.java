package edu.QATestLab.WarOfRaces.model.Human;

import edu.QATestLab.WarOfRaces.model.Elves.Unit;

public class WarriorHuman extends RaceOfHuman{
	
	private float damageSecond;
	
	
	
	public float getDamageSecond() {
		return damageSecond;
	}

	public void setDamageSecond(float damageSecond) {
		this.damageSecond = damageSecond;
	}

	public WarriorHuman(float hp, String name, float damageFirst, float damageSecond) {
		super(hp, name, damageSecond, damageSecond);
		this.damageSecond = damageSecond;
	}

	@Override
	public void attackFirst(Unit u) {
		u.setHp((float) (u.getHp() - damageSecond));
	}

	@Override
	public void attackSecond(Unit u) {
		attackFirst(u);
	}

	
}
