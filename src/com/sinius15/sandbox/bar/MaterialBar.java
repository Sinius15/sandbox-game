package com.sinius15.sandbox.bar;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.sinius15.sandbox.SandBoxGame;
import com.sinius15.sandbox.abstrct.Bar;
import com.sinius15.sandbox.abstrct.Material;

public class MaterialBar extends Bar<Material>{

	public MaterialBar(int x, int y) {
		super(null, x, y, 70, 25, 1, 1, 6);
		data = new ArrayList<>();
		for(Class<? extends Material> s :  Material.materials){
			try {
				data.add(s.newInstance());
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void clicked(Point p) {
		super.clicked(p);
	}
	
	@Override
	public String eToString(Material obj) {
		return obj.getName();
	}

	@Override
	public void onBlockDraw(Graphics2D graphis, Rectangle rec, Material data) {
		graphis.setColor(data.getColor());
		graphis.fillRect(rec.x+rec.width-20, rec.y+rec.height-20,15, 15);
	}

	@Override
	public void onSelect(Material selected) {
		SandBoxGame.get().selectedMat = selected.getClass();
	}

	@Override
	public String getTitle() {
		return "";
	}

}
