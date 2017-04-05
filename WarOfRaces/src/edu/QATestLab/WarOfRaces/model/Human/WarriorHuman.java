package edu.QATestLab.WarOfRaces.model.Human;

import edu.QATestLab.WarOfRaces.model.Elves.Unit;

public class WarriorHuman extends RaceOfHuman{
	
	private byte damageSecond;
	
	
	
	public byte getDamageSecond() {
		return damageSecond;
	}

	public void setDamageSecond(byte damageSecond) {
		this.damageSecond = damageSecond;
	}

	public WarriorHuman(byte hp, String name, byte damageFirst, byte damageSecond) {
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
