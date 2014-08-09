package com.sinius15.sandbox.util;

import java.awt.Point;

public enum Direction {

	UP, DOWN, LEFT, RIGHT, LEFTDOWN, RIGHTDOWN, LEFTUP, RIGHTUP;
	
	public static Direction calcDirection(Point from,Point to) {
		if(from.x==to.x) {
			if(from.y > to.y) {
				return UP;
			} else if(from.y < to.y) {
				return DOWN;
			}
		} else if(from.y==to.y) {
			if(from.x > to.x) {
				return LEFT;
			} else if(from.x < to.x) {
				return RIGHT;
			}
		}
		return null;
	}

	public static Direction redirect(Direction d) {
		switch (d) {
		case DOWN: return UP;
		case LEFT: return RIGHT;
		case LEFTDOWN: return RIGHTUP;
		case LEFTUP: return RIGHTDOWN;
		case RIGHT: return LEFT;
		case RIGHTDOWN: return LEFTUP;
		case RIGHTUP: return LEFTDOWN;
		case UP: return DOWN;
		default: return null;
		}
	}
}
