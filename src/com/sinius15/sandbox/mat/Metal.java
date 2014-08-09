package com.sinius15.sandbox.mat;

import java.awt.Color;

import com.sinius15.sandbox.abstrct.Material;

public class Metal extends Material{

	@Override
	public String getName() {
		return "Metal";
	}

	@Override
	public Color getColor() {
		return Color.gray;
	}

	@Override
	public float density() {
		return 7860;
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
