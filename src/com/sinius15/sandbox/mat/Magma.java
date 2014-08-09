package com.sinius15.sandbox.mat;

import java.awt.Color;

import com.sinius15.sandbox.abstrct.Material;

public class Magma extends Material{

	@Override
	public String getName() {
		return "Magma";
	}

	@Override
	public Color getColor() {
		return Color.orange;
	}

	@Override
	public float density() {
		return 2650.0f;
	}

	@Override
	public boolean stationary() {
		return false;
	}
	
	@Override
	public State state() {
		return State.LIQUID;
	}

}