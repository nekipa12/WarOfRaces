package edu.QATestLab.WarOfRaces.model.Elves;


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
	public void attackFirst(Unit u) {
		u.setDamageFirst((float) (u.getDamageFirst() * 1.5));
		u.setDamageSecond((float) (getDamageSecond() * 1.5));
		System.out.println("____________");
	}

	@Override
	public void attackSecond(Unit u) {
		u.setHp((float) (u.getHp() - damageSecond));
	}

	
	

	



	
	
	

}
