package com.sinius15.sandbox.abstrct;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;

import com.sinius15.lib.Util;
import com.sinius15.sandbox.Level;
import com.sinius15.sandbox.mat.Acid;
import com.sinius15.sandbox.mat.Air;
import com.sinius15.sandbox.mat.C4;
import com.sinius15.sandbox.mat.Glass;
import com.sinius15.sandbox.mat.Magma;
import com.sinius15.sandbox.mat.Metal;
import com.sinius15.sandbox.mat.Sand;
import com.sinius15.sandbox.mat.Water;
import com.sinius15.sandbox.util.Direction;

public abstract class Material {
	
	public static ArrayList<Class<? extends Material>> materials = new ArrayList<>();
	public static void initMats(){
		materials.add(Air.class);
		materials.add(Acid.class);
		materials.add(C4.class);
		materials.add(Glass.class);
		materials.add(Magma.class);
		materials.add(Metal.class);
		materials.add(Water.class);
		materials.add(Sand.class);
	}
	
	public int x, y, heat;
	protected Level level;
	
	public boolean isMoved = false;
	
	public void init(Level l, int x, int y, int heat){
		this.x = x;
		this.y = y;
		this.y = y;
		this.heat = heat;
		this.level = l;
	}
	
	public void tick(){
		if(!stationary() && !isMoved)
			doGravity();
		if(state() == State.LIQUID && !stationary() && !isMoved)
			doWaterFlow();
	}
	
	protected void doGravity(){
		Material below = level.getMaterial(x, y, Direction.DOWN);
		if(below == null)
			return;
		if(below.stationary())
			return;
		if(below.state() == State.SOLID)
			return;
		if(below.density() < density())
			level.switchMaterial(below, this);
	}
	
	protected void doWaterFlow(){
		Material left = level.getMaterial(x, y, Direction.LEFT);
		Material righ = level.getMaterial(x, y, Direction.RIGHT);
		
		boolean canGoToLeft = left != null && !left.stationary() && !left.isMoved && left.state() != State.SOLID && !left.getName().equals(getName());
		boolean canGoToRigh = righ != null && !righ.stationary() && !righ.isMoved && righ.state() != State.SOLID && !righ.getName().equals(getName());
		
		if(canGoToLeft && canGoToRigh){
			if(Util.getRandomBoolean())
				level.switchMaterial(this, left, false);
			else
				level.switchMaterial(this, righ, false);
			return;
		}
		if(canGoToLeft)
			level.switchMaterial(this, left);
		else if(canGoToRigh)
			level.switchMaterial(this, righ);
	}
	
	
	public abstract String getName();
	public abstract Color getColor();
	public abstract float density();
	public abstract boolean stationary();
	public abstract State state();
	
	public Point getPoint(){
		return new Point(x, y);
	}
	
	public static enum State{
		SOLID, LIQUID, GAS;
	}
}
