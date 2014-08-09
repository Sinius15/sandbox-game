package com.sinius15.sandbox;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import com.sinius15.sandbox.abstrct.Drawable;
import com.sinius15.sandbox.abstrct.Material;
import com.sinius15.sandbox.mat.Air;
import com.sinius15.sandbox.util.Direction;

public class Level extends Drawable{

	private Material[][] grid;
	public int width, height;
	
	public Level(int width, int height, int x, int y){
		this.onScreen = new Rectangle(x, y, width, height);
		this.width = width;
		this.height = height;
		grid = new Material[width][height];
		for(int w = 0; w<width; w++){
			for(int h = 0; h<height; h++){
				Material m = new Air();
				m.init(this, w, h, 20);
				grid[w][h] = m;
			}
		}
	}
	
	@Override
	public void draw(Graphics2D g){
		g.setColor(Color.gray);
		g.drawRect(onScreen.x-1, onScreen.y-1, width+1, height+1);
		g.setColor(Color.black);
		g.fillRect(onScreen.x, onScreen.y, width, height);
		for(int w = 0; w<width; w++){
			for(int h = 0; h<height; h++){
				g.setColor(grid[w][h].getColor());
				g.drawLine(w+onScreen.x, h+onScreen.y, w+onScreen.x, h+onScreen.y);
			}
		}
	}

	public void tick(){
		if(!SandBoxGame.get().isPlaying)
			return;
		for(int y = 0; y<height; y++){
			for(int x = 0; x<width; x++){
				grid[x][y].tick();
			}
		}
		for(int h = 0; h<height; h++){
			for(int w = 0; w<width; w++){
				grid[w][h].isMoved = false;
			}	
		}
	}
	
	public Material getMaterial(int x, int y){
		if(x > 0 && y>0 && x < width && y < height)
			return grid[x][y];
		else {
			//System.err.println("could not find material at " + x + ";" + y);
			return null;
		}
	}
	
	public void setMaterial(int x, int y, Material m){
		if(x > 0 && y>0 && x < width && y < height){
			grid[x][y] = m;
			grid[x][y].x = x;
			grid[x][y].y = y;
		}
		//else System.err.println("Could not set material at " + x + ";" + y);
	}
	
	public Material[] getMaterialsArround(Point p){
		Material[] out = new Material[4];
		out[0] = getMaterial(p.x, p.y, Direction.UP);
		out[1] = getMaterial(p.x, p.y, Direction.RIGHT);
		out[2] = getMaterial(p.x, p.y, Direction.DOWN);
		out[3] = getMaterial(p.x, p.y, Direction.LEFT);
		return out;
	}
	
	public Material getMaterial(int x, int y, Direction d){
		switch(d){
		case DOWN:
			return getMaterial(x, y+1);
		case LEFT:
			return getMaterial(x-1, y);
		case RIGHT:
			return getMaterial(x+1, y);
		case UP:
			return getMaterial(x, y-1);
		case LEFTDOWN:
			return getMaterial(x-1, y+1);
		case LEFTUP:
			return getMaterial(x-1, y-1);
		case RIGHTDOWN:
			return getMaterial(x+1, y+1);
		case RIGHTUP:
			return getMaterial(x+1, y-1);
		default:
			return null;
		}
	}
	
	@Override
	public void clicked(Point point) {
		SandBoxGame.get().selectedBrush.onClick(SandBoxGame.get().selectedMat, this, point);
	}

	@Override
	public Rectangle recOnScreen() {
		return onScreen;
	}
	
	public void switchMaterial(Material a, Material b){
		switchMaterial(a, b, true);
	}
	
	public void switchMaterial(Material a, Material b, boolean setMoved){
		Point c = new Point(b.getPoint());
		setMaterial(a.x, a.y, b);
		setMaterial(c.x, c.y, a);
		a.isMoved = true;
		b.isMoved = true;
	}
}
