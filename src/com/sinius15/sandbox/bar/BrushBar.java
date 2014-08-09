package com.sinius15.sandbox.bar;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import com.sinius15.sandbox.SandBoxGame;
import com.sinius15.sandbox.abstrct.Bar;
import com.sinius15.sandbox.abstrct.Brush;

public class BrushBar extends Bar<Brush>{

	public BrushBar( int x, int y) {
		super(Brush.brushes, x, y, 30, 15, 1, 1, 1);
		selected = 3;
	}

	@Override
	public void onBlockDraw(Graphics2D graphis, Rectangle rec, Brush data) {
		
	}

	@Override
	public String eToString(Brush obj) {
		return obj.getName();
	}

	@Override
	public void onSelect(Brush selected) {
		SandBoxGame.get().selectedBrush = selected;
	}

	@Override
	public String getTitle() {
		return "";
	}

}
