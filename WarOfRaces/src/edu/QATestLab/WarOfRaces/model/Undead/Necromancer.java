package edu.QATestLab.WarOfRaces.model.Undead;

import edu.QATestLab.WarOfRaces.model.Unit.Unit;

public class Necromancer extends RaceOfUndead {
	
	private float damageSecond;
	
	public Necromancer(float hp, String name, float damageFirst, float damageSecond) {
		super(hp, name, damageSecond, damageSecond);
		this.damageSecond = damageSecond;
	}

	@Override
	public void attackFirst(Unit u) {
		u.setDamageFirst((float) (u.getDamageFirst() / 2));
		u.setDamageSecond((float) (u.getDamageSecond() / 2));
	}

	@Override
	public void attackSecond(Unit u) {
		u.setHp((float) (u.getHp() - damageSecond));
	}
}
