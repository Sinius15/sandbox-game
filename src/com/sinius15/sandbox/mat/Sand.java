package com.sinius15.sandbox.mat;

import java.awt.Color;

import com.sinius15.sandbox.abstrct.Material;

public class Sand extends Material{

	@Override
	public String getName() {
		return "Sand";
	}

	@Override
	public Color getColor() {
		return Color.yellow;
	}

	@Override
	public float density() {
		return 1600f;
	}

	@Override
	public boolean stationary() {
		return false;
	}
	
	@Override
	public State state() {
		return State.SOLID;
	}
	
	@Override
	public void tick() {
		super.tick();
	}

}
