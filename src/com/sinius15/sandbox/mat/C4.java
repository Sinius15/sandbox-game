package com.sinius15.sandbox.mat;

import java.awt.Color;

import com.sinius15.sandbox.abstrct.Material;

public class C4 extends Material{
	@Override
	public String getName() {
		return "C4";
	}

	@Override
	public Color getColor() {
		return Color.white;
	}

	@Override
	public float density() {
		return 1630;
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