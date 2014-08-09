package com.sinius15.sandbox;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import com.sinius15.lib.Display;
import com.sinius15.lib.DisplayDrawer;
import com.sinius15.sandbox.abstrct.Brush;
import com.sinius15.sandbox.abstrct.Material;
import com.sinius15.sandbox.bar.BrushBar;
import com.sinius15.sandbox.bar.MaterialBar;
import com.sinius15.sandbox.bar.PauseBar;
import com.sinius15.sandbox.mat.Air;

public class SandBoxGame implements DisplayDrawer, Runnable{

	public static SandBoxGame thiss;
	public Display display;
	public Thread ticker;
	public Level level;
	
	public MaterialBar matBar;
	public BrushBar brushBar;
	public PauseBar pauseBar;
	
	public InputHandler input;
	public Brush selectedBrush;
	public Class<? extends Material> selectedMat;
	public boolean gameRunning = true;
	public boolean isPlaying = true;
	
	public Point levelLoc, matBarLoc, brushBarLoc, pauseBarLoc;
	
	public SandBoxGame(String[] args){
		thiss=  this;
		levelLoc = new Point(50, 250);
		matBarLoc = new Point(50, 50);
		brushBarLoc = new Point(50, 120);
		pauseBarLoc = new Point(150, 120);
		
		Brush.initBrushes();
		Material.initMats();
		
		level = new Level(400, 400, levelLoc.x, levelLoc.y);
		
		brushBar = new BrushBar(brushBarLoc.x, brushBarLoc.y);
		brushBar.onSelect(Brush.brushes.get(3));
		
		matBar = new MaterialBar(matBarLoc.x, matBarLoc.y);
		matBar.onSelect(new Air());
		
		pauseBar = new PauseBar(pauseBarLoc.x, pauseBarLoc.y);
		pauseBar.onSelect(true);
		
		display = new Display(500, 700, "sand box", this, input = new InputHandler());
		ticker = new Thread(this);
		ticker.start();
	}
	
	public void Tick(){
		level.tick();
		display.reDraw();
		input.tick();
		
	}

	@Override
	public void Draw(Graphics2D img) {
		img.setColor(Color.white);
		img.fillRect(0, 0, display.getContentSize().width, display.getContentSize().height);
		level.draw(img);
		matBar.draw(img);
		brushBar.draw(img);
		pauseBar.draw(img);
		if(level.recOnScreen().contains(input.getMousePoint())){
			selectedBrush.draw(img);
		}
		
	}
	
	public static void main(String[] args) {
		new SandBoxGame(args);
	}
	
	@Override
	public void run() {
		while(gameRunning){
			Tick();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static SandBoxGame get(){
		return thiss;
	}
	
}
