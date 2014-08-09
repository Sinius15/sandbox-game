package com.sinius15.sandbox.abstrct;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

public abstract class Bar<E> extends Drawable{

	public ArrayList<E> data;
	public int selected = 0, x = 0, y = 0, blockW = 70, blockH = 25, marginX = 1, marginY = 1, maxCol = 5;
	private Point clicked = null;
	private Color textColor = Color.white, selectedColor = Color.black, bgColor = Color.gray;
	
	
	public Bar(ArrayList<E> data, int x, int y, int blockW, int blockH, int marginX, int marginY, int maxCol){
		this.x = x;
		this.y = y;
		this.data = data;
		this.blockH = blockH;
		this.blockW = blockW;
		this.marginX = marginX;
		this.marginY = marginY;
		this.maxCol = maxCol;
	}
	
	@Override
	public void draw(Graphics2D g){
		int row = 0;
		int col = 0;
		int i = 0;
		for(E txt : data){
			Rectangle rec = new Rectangle(x+col*(blockW+marginX)+2, y+row*(blockH+marginY)+2, blockW, blockH);
			if(clicked != null){
				if(rec.contains(clicked)){
					selected = i;
					onSelect(txt);
				}
			}
			g.setColor(bgColor);
			if(i == selected)
				g.setColor(selectedColor);
			
			g.fillRect(rec.x, rec.y, rec.width, rec.height);
			g.setColor(textColor);
			g.drawString(eToString(txt), rec.x+5, rec.y+blockH/1.5f);
			onBlockDraw(g, rec, txt);
			if(col+1 >= maxCol){
				col = 0;
				row++;
			}else
				col++;
			i++;
		}
		clicked = null;
		g.setColor(Color.black);
		if(col == 0){
			row--;
			col = maxCol;
		}else if(row > 0)
			col = maxCol;
		g.drawString(getTitle(), x+1, y-2);
		g.drawRect(x, y, col*(blockW+marginX)+2, row*(blockH+marginY)+blockH+3);
		onScreen = new Rectangle(x, y, col*(blockW+marginX)+2, row*(blockH+marginY)+blockH+3);
	}
	
	public abstract void onBlockDraw(Graphics2D graphis, Rectangle rec, E data);
	public abstract String eToString(E obj);
	public abstract void onSelect(E selected);
	public abstract String getTitle();
	
	@Override
	public Rectangle recOnScreen(){
		return onScreen;
	}

	@Override
	public void clicked(Point p) {
		clicked = p;
	}
	
	
	
}
