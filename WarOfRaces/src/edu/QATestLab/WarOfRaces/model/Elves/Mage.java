package edu.QATestLab.WarOfRaces.model.Elves;


public class Mage extends RaceOfElves {

	private byte damageSecond;
	
	
	public byte getDamageSecond() {
		return damageSecond;
	}

	public void setDamageSecond(byte damageSecond) {
		this.damageSecond = damageSecond;
	}

	public Mage(byte hp, String name, byte damageFirst, byte damageSecond) {
		super(hp, name, damageSecond, damageSecond);
		this.damageSecond = damageSecond;
	}

	@Override
	public void attackFirst(Unit u) {
		u.setDamageFirst((byte) (u.getDamageFirst() * 1.5));
		u.setDamageSecond((byte) (getDamageSecond() * 1.5));
		System.out.println("____________");
	}

	@Override
	public void attackSecond(Unit u) {
		u.setHp((byte) (u.getHp() - damageSecond));
	}

	
	

	



	
	
	

}
