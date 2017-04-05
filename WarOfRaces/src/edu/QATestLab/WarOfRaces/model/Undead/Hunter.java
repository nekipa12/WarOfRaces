package edu.QATestLab.WarOfRaces.model.Undead;

import edu.QATestLab.WarOfRaces.model.Elves.Unit;

public class Hunter extends RaceOfUndead {

	private byte damageFirst;
	private byte damageSecond;
	
	public Hunter(byte hp, String name, byte damageFirst, byte damageSecond) {
		super(hp, name, damageSecond, damageSecond);
		this.damageFirst = damageFirst;
		this.damageSecond = damageSecond;
	}

	@Override
	public void attackFirst(Unit u) {
		u.setHp((byte) (u.getHp() - damageFirst));
	}

	@Override
	public void attackSecond(Unit u) {
		u.setHp((byte) (u.getHp() - damageSecond));
	}

	

	

}
