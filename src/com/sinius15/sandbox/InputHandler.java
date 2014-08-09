package com.sinius15.sandbox;

import java.awt.Point;
import java.awt.event.WindowEvent;

import com.sinius15.lib.DisplayInput;

public class InputHandler extends DisplayInput{

	public InputHandler(){
		
	}

	public void tick() {
		if(leftDown){
			if(SandBoxGame.get().matBar.recOnScreen().contains(getMousePoint()))
				SandBoxGame.get().matBar.clicked(new Point(getMousePoint()));
			else if(SandBoxGame.get().brushBar.recOnScreen().contains(getMousePoint()))
				SandBoxGame.get().brushBar.clicked(new Point(getMousePoint()));
			else if(SandBoxGame.get().level.recOnScreen().contains(getMousePoint()))
				SandBoxGame.get().level.clicked(getMousePoint());
			else if(SandBoxGame.get().pauseBar.recOnScreen().contains(getMousePoint()))
				SandBoxGame.get().pauseBar.clicked(getMousePoint());
		}
	}
	
	@Override
	public void dispClosing(WindowEvent e) {
		SandBoxGame.get().gameRunning = false;
	}
	
}
