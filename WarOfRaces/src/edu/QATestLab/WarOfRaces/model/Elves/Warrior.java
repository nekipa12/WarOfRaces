package edu.QATestLab.WarOfRaces.model.Elves;

public class Warrior extends RaceOfElves{
	
	private byte damageSecond;
	
	
	public byte getDamageSecond() {
		return damageSecond;
	}

	public void setDamageSecond(byte damageSecond) {
		this.damageSecond = damageSecond;
	}

	public Warrior(byte hp, String name, byte damageFirst, byte damageSecond) {
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
