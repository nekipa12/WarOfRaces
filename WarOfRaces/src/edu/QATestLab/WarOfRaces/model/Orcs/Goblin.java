package edu.QATestLab.WarOfRaces.model.Orcs;

import edu.QATestLab.WarOfRaces.model.Elves.Unit;

public class Goblin extends RaceOfOrcs {
	
	private byte damageSecond;
	
	
	
	public byte getDamageSecond() {
		return damageSecond;
	}

	public void setDamageSecond(byte damageSecond) {
		this.damageSecond = damageSecond;
	}

	public Goblin(byte hp, String name, byte damageFirst, byte damageSecond) {
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
