package com.sinius15.sandbox.abstrct;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.sinius15.sandbox.Level;
import com.sinius15.sandbox.SandBoxGame;
import com.sinius15.sandbox.brush.StandardBrush;

public abstract class Brush extends Drawable{
	
	public static ArrayList<Brush> brushes = new ArrayList<>();
	public static void initBrushes(){
		brushes.add(new StandardBrush(1, "xxs"));
		brushes.add(new StandardBrush(5, "xs"));
		brushes.add(new StandardBrush(15, "s"));
		brushes.add(new StandardBrush(25, "m"));
		brushes.add(new StandardBrush(45, "l"));
		brushes.add(new StandardBrush(65, "xl"));
		brushes.add(new StandardBrush(85, "xxl"));
	}
	
	public void onClick(Class<? extends Material> m, Level l, Point p){
		Point mouseInLevel = new Point(p.x - l.onScreen.x, p.y - l.onScreen.y);
		for(int w = 0; w<l.width; w++){
			for(int h = 0; h<l.height; h++){
				if(isInsideCircle(mouseInLevel.x, mouseInLevel.y, getSize()/2, w, h)){
					Material s;
					try {
						s = m.newInstance();
						s.init(l, w, h, 20);
						l.setMaterial(w, h, s);
					} catch (InstantiationException | IllegalAccessException e) {
						e.printStackTrace();
					}
					
				}
					
			}
		}
	};
	
	public abstract int getSize();
	public abstract String getName();
	
	@Override
	public void draw(Graphics2D g) {
		g.setStroke(new BasicStroke(0.1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, new float[]{4.0f}, 0.0f));
		g.setColor(Color.white);
		g.drawOval(SandBoxGame.get().input.mouseX-getSize()/2, SandBoxGame.get().input.mouseY-getSize()/2, getSize(), getSize());
		g.setStroke(new BasicStroke());
	}
	
	public boolean isInsideCircle(int circleX, int circleY, int circleR, int pointX, int pointY){
		int dX = Math.abs(circleX-pointX);
		int dY = Math.abs(circleY-pointY);
		int c = (int) Math.sqrt(dX*dX+dY*dY);
		return c <= circleR;
	}
	
	@Override
	public Rectangle recOnScreen() {
		return null; //is nowwhere and everywhere at the same time
	}
	
	@Override //never happens
	public void clicked(Point p) {}
	
	
}
