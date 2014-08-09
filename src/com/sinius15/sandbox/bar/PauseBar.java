package com.sinius15.sandbox.bar;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import com.sinius15.sandbox.SandBoxGame;
import com.sinius15.sandbox.abstrct.Bar;

public class PauseBar extends Bar<Boolean> {

	public PauseBar(int x, int y) {
		super(null, x, y, 40, 20, 1, 1, 2);
		
		data = new ArrayList<>();
		this.data.add(true);
		this.data.add(false);
	}

	@Override
	public void onBlockDraw(Graphics2D graphis, Rectangle rec, Boolean data) {
	}

	@Override
	public String eToString(Boolean obj) {
		if(obj)
			return "Play";
		return "Pause";
	}

	@Override
	public void onSelect(Boolean selected) {
		SandBoxGame.get().isPlaying = selected;
	}

	@Override
	public String getTitle() {
		return "";
	}

}
