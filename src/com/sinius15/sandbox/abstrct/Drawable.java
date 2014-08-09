package com.sinius15.sandbox.abstrct;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public abstract class Drawable {

	public Rectangle onScreen;
	
	public abstract Rectangle recOnScreen();
	public abstract void clicked(Point p);
	public abstract void draw(Graphics2D g);
	
}
