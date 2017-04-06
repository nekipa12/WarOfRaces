package edu.QATestLab.WarOfRaces.model.Human;


import edu.QATestLab.WarOfRaces.model.Unit.Unit;

public class MageHuman extends RaceOfHuman {
	
	private float damageSecond;
	
	
	
	public float getDamageSecond() {
		return damageSecond;
	}

	public void setDamageSecond(float damageSecond) {
		this.damageSecond = damageSecond;
	}

	public MageHuman(float hp, String name, float damageFirst, float damageSecond) {
		super(hp, name, damageSecond, damageSecond);
		this.damageSecond = damageSecond;
	}

	@Override
	public void attackSecond(Unit u) {
		u.setHp((float) (u.getHp() - damageSecond));
	}
}
