package edu.QATestLab.WarOfRaces.model.Undead;

import edu.QATestLab.WarOfRaces.model.Elves.Unit;

public class Zombie extends RaceOfUndead {

	private byte damageSecond;
	
	public Zombie(byte hp, String name, byte damageFirst, byte damageSecond) {
		super(hp, name, damageSecond, damageSecond);
		this.damageSecond = damageSecond;
	}

	@Override
	public void attackFirst(Unit u) {
		u.setHp((byte) (u.getHp() - damageSecond));
	}

	@Override
	public void attackSecond(Unit u) {
		attackFirst(u);
	}

	
}
