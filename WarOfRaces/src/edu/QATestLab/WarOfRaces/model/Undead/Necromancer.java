package edu.QATestLab.WarOfRaces.model.Undead;

import edu.QATestLab.WarOfRaces.model.Elves.Unit;

public class Necromancer extends RaceOfUndead {
	
	private byte damageSecond;
	
	public Necromancer(byte hp, String name, byte damageFirst, byte damageSecond) {
		super(hp, name, damageSecond, damageSecond);
		this.damageSecond = damageSecond;
	}

	@Override
	public void attackFirst(Unit u) {
		u.setDamageFirst((byte) (u.getDamageFirst() / 2));
		u.setDamageSecond((byte) (u.getDamageSecond() / 2));
	}

	@Override
	public void attackSecond(Unit u) {
		u.setHp((byte) (u.getHp() - damageSecond));
	}

	
	

	



	
	
	

}
