package com.sinius15.sandbox.brush;

import com.sinius15.sandbox.abstrct.Brush;

public class StandardBrush extends Brush{

	int size = 0;
	String name;
	
	public StandardBrush(int size, String name){
		this.size = size;
		this.name = name;
	}
	
	@Override
	public int getSize() {
		return size;
	}

	@Override
	public String getName() {
		return name;
	}

}
