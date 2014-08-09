package com.sinius15.sandbox.mat;

import java.awt.Color;

import com.sinius15.sandbox.abstrct.Material;

public class Air extends Material{

	@Override
	public String getName() {
		return "Air";
	}

	@Override
	public Color getColor() {
		return Color.black;
	}

	@Override
	public float density() {
		return 1.293f;
	}

	@Override
	public boolean stationary() {
		return false;
	}
	
	@Override
	public State state() {
		return State.GAS;
	}

}
