package edu.QATestLab.WarOfRaces.model.Elves;

import edu.QATestLab.WarOfRaces.model.Unit.Unit;

public class Mage extends RaceOfElves {

	private float damageSecond;
	
	public float getDamageSecond() {
		return damageSecond;
	}

	public void setDamageSecond(float damageSecond) {
		this.damageSecond = damageSecond;
	}

	public Mage(float hp, String name, float damageFirst, float damageSecond) {
		super(hp, name, damageSecond, damageSecond);
		this.damageSecond = damageSecond;
	}

	@Override
	public void attackSecond(Unit u) {
		u.setHp((float) (u.getHp() - damageSecond));
	}

	
	

	



	
	
	

}
