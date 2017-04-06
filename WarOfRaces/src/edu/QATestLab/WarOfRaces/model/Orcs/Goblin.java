package edu.QATestLab.WarOfRaces.model.Orcs;

import edu.QATestLab.WarOfRaces.model.Elves.Unit;

public class Goblin extends RaceOfOrcs {
	
	private float damageSecond;
	
	
	
	public float getDamageSecond() {
		return damageSecond;
	}

	public void setDamageSecond(float damageSecond) {
		this.damageSecond = damageSecond;
	}

	public Goblin(float hp, String name, float damageFirst, float damageSecond) {
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
