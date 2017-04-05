package edu.QATestLab.WarOfRaces.model.Orcs;

import edu.QATestLab.WarOfRaces.model.Elves.Unit;

public class ArcherOrc extends RaceOfOrcs {
	
	private byte damageFirst;
	private byte damageSecond;
	
	
	
	public byte getDamageFirst() {
		return damageFirst;
	}

	public void setDamageFirst(byte damageFirst) {
		this.damageFirst = damageFirst;
	}

	public byte getDamageSecond() {
		return damageSecond;
	}

	public void setDamageSecond(byte damageSecond) {
		this.damageSecond = damageSecond;
	}

	public ArcherOrc(byte hp, String name, byte damageFirst, byte damageSecond) {
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
