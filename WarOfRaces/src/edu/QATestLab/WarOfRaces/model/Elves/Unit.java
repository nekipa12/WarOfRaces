package edu.QATestLab.WarOfRaces.model.Elves;


public class Unit implements Attack{
	private float hp;
	private String name;
	private float damageFirst;
	private float damageSecond;
	
	public float getDamageFirst() {
		return damageFirst;
	}

	public void setDamageFirst(float damageFirst) {
		this.damageFirst = damageFirst;
	}

	public float getDamageSecond() {
		return damageSecond;
	}

	public void setDamageSecond(float damageSecond) {
		this.damageSecond = damageSecond;
	}

	public String getName() {
		return name;
	}

	public float getHp() {
		return hp;
	}

	public void setHp(float hp) {
		this.hp = hp;
	}

	public Unit(float hp, String name, float damageFirst, float damageSecond) {
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

