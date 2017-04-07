package edu.QATestLab.WarOfRaces.view;

import java.util.ArrayList;

public class ViewProcess {
	
	private ArrayList<String> als;

	public ArrayList<String> getAls() {
		return als;
	}

	public ViewProcess() {
		als = new ArrayList<>();
	}

	public void step(int count) {
		als.add("STEP " + count);
		show();
	}

	private void show() {
		System.out.println(als.get(als.size()-1));
	}

	public void necromancerSkill(String name, String name2) {
		als.add(name + "\t" + "ill on" + "\t" + name2);
		show();
	}

	public void improvement(String string, String string2) {
		als.add(string+ "\t" + "improvement on" + "\t" + string2);
		show();
	}

	public void killed(String name, float hp, String name2) {
		als.add(name + "(" + hp + ")" + "\t" + "killed" + "\t" + name2);
		show();
	}

	public void attacked(String name, float hp, String name2, float hp2) {
		als.add(name + "(" + hp + ")" + "\t" + "attacked" + "\t" + name2 + "(" + hp2 + ")");
		show();
	}

	public void shamanSkills(String name, String name2) {
		als.add(name+ "\t" + "removed the improvement with" + "\t" + name2);
		show();
	}
	
	
}
