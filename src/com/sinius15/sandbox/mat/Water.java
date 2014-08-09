package com.sinius15.sandbox.mat;

import java.awt.Color;

import com.sinius15.sandbox.abstrct.Material;

public class Water extends Material{

	@Override
	public String getName() {
		return "Water";
	}

	@Override
	public Color getColor() {
		return Color.blue;
	}

	@Override
	public float density() {
		return 998;
	}

	@Override
	public boolean stationary() {
		return false;
	}
	
	@Override
	public State state() {
		return State.LIQUID;
	}
	
	@Override
	public void tick() {
		super.tick();
	}

}
