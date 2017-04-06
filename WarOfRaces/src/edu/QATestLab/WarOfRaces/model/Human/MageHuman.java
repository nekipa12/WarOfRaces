package edu.QATestLab.WarOfRaces.model.Human;


import edu.QATestLab.WarOfRaces.model.Elves.Unit;

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
	public void attackFirst(Unit u) {
		u.setDamageFirst((float) (u.getDamageFirst() * 1.5));
		u.setDamageSecond((float) (u.getDamageSecond() * 1.5));
	}

	@Override
	public void attackSecond(Unit u) {
		u.setHp((float) (u.getHp() - damageSecond));
	}
	
	

	
	

	



	
	
	

}
