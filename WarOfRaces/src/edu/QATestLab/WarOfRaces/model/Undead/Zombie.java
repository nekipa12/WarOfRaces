package edu.QATestLab.WarOfRaces.model.Undead;

import edu.QATestLab.WarOfRaces.model.Elves.Unit;

public class Zombie extends RaceOfUndead {

	private float damageSecond;
	
	public Zombie(float hp, String name, float damageFirst, float damageSecond) {
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
