package edu.QATestLab.WarOfRaces.model.Elves;


public class Unit implements Attack{
	private byte hp;
	private String name;
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

	public String getName() {
		return name;
	}

	public byte getHp() {
		return hp;
	}

	public void setHp(byte hp) {
		this.hp = hp;
	}

	public Unit(byte hp, String name, byte damageFirst, byte damageSecond) {
		this.hp = hp;
		this.name = name;
		this.damageFirst = damageFirst;
		this.damageSecond = damageSecond;
	}

	@Override
	public String toString() {
		return "Unit [hp=" + hp + ", name=" + name + "]";
	}

	@Override
	public void attackFirst(Unit u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attackSecond(Unit u) {
		// TODO Auto-generated method stub
		
	}

	
}

/*
public class BattleUnit extends Unit {
	@Override
	public void attacFirst() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void attacSecond() {
		// TODO Auto-generated method stub
		
	}
}

public class MageBattleUnit extends BattleUnit {
	public void spell() {
		
	}
}
*/

