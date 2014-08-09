package com.sinius15.sandbox.mat;

import java.awt.Color;

import com.sinius15.lib.Util;
import com.sinius15.sandbox.abstrct.Material;
import com.sinius15.sandbox.util.Direction;

public class Acid extends Material{
	
	@Override
	public String getName() {
		return "Acid";
	}

	@Override
	public Color getColor() {
		return Color.GREEN;
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
		if(doAcid(Direction.DOWN))
			return;
		if(Util.getRandomBoolean())
			if(doAcid(Direction.LEFT))
				return;
			else if(doAcid(Direction.RIGHT))
				return;
		doAcid(Direction.UP);
	}
	private boolean doAcid(Direction d){
		Material m = level.getMaterial(x, y, d);
		if(m != null && !m.getName().equals("Air") && !m.getName().equals("Glass") && !m.getName().equals(getName())){
			Air a = new Air();
			a.init(level, m.x, m.y, m.heat);
			a.isMoved = true;
			level.setMaterial(m.x, m.y, a);
			if(Util.getRandomBoolean()){
				a = new Air();
				a.init(level, x, y, heat);
				level.setMaterial(x, y, a);
			}
			return true;
		}else
			return false;
	}	
	

}
