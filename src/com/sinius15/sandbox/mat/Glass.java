package com.sinius15.sandbox.mat;

import java.awt.Color;

import com.sinius15.sandbox.abstrct.Material;

public class Glass extends Material{

	@Override
	public String getName() {
		return "Glass";
	}

	@Override
	public Color getColor() {
		return new Color(230, 230, 230);
	}

	@Override
	public float density() {
		return 2600;
	}

	@Override
	public boolean stationary() {
		return true;
	}

	@Override
	public State state() {
		return State.SOLID;
	}

}