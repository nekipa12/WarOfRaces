package edu.QATestLab.WarOfRaces.model.Human;


import edu.QATestLab.WarOfRaces.model.Elves.Unit;

public class MageHuman extends RaceOfHuman {
	
	private byte damageSecond;
	
	
	
	public byte getDamageSecond() {
		return damageSecond;
	}

	public void setDamageSecond(byte damageSecond) {
		this.damageSecond = damageSecond;
	}

	public MageHuman(byte hp, String name, byte damageFirst, byte damageSecond) {
		super(hp, name, damageSecond, damageSecond);
		this.damageSecond = damageSecond;
	}

	@Override
	public void attackFirst(Unit u) {
		u.setDamageFirst((byte) (u.getDamageFirst() * 1.5));
		u.setDamageSecond((byte) (u.getDamageSecond() * 1.5));
	}

	@Override
	public void attackSecond(Unit u) {
		u.setHp((byte) (u.getHp() - damageSecond));
	}
	
	

	
	

	



	
	
	

}
