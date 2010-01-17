/*  
 *  Copyright (C) 2010  Luca Wehrstedt
 *
 *  This file is released under the GPLv2
 *  Read the file 'COPYING' for more information
 */

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

public class Title extends Animation {
	private int[][] space = {
		{0,1,1,1,1,0,0,0,0,0,1,1,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,0,0,0,0,0,0,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1}, // Green
		{1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1},
		{1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1},
		{1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1},
		{1,1,0,0,0,1,1,1,0,0,1,1,1,0,0,0,1,1,1,0,1,1,1,1,1,1,1,1,1,0,0,1,1,1,0,0,1,1,1,0,1,1,1,0,0,0,0,0},
		{1,1,1,0,0,1,1,1,0,0,1,1,1,0,0,0,1,1,1,0,1,1,1,1,1,1,1,1,1,0,0,1,1,1,0,0,1,1,1,0,1,1,1,0,0,0,0,0},
		{0,1,1,1,0,0,0,0,0,0,1,1,1,0,0,0,1,1,1,0,1,1,1,0,1,0,1,1,1,0,0,1,1,1,0,0,0,0,0,0,1,1,1,0,0,0,0,0},
		{0,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1,1,0,1,1,1,0,1,0,1,1,1,0,0,1,1,1,0,0,0,0,0,0,1,1,1,1,1,0,0,0},
		{0,0,1,1,1,1,1,1,0,0,0,1,1,1,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,0,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0}, // Blue
		{0,0,0,0,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,0,0,0,1,1,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0},
		{0,0,0,0,0,0,1,1,1,0,0,1,1,1,0,0,0,0,0,0,0,1,1,1,0,1,1,1,0,0,1,1,1,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
		{0,0,0,1,1,0,0,1,1,0,0,1,1,1,0,0,0,0,0,0,0,1,1,1,0,1,1,1,0,0,1,1,1,0,1,1,1,0,0,1,1,0,0,0,0,0,0,0},
		{0,0,0,1,1,0,0,1,1,0,0,1,1,1,0,0,0,0,0,0,1,1,1,0,0,0,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0,0,0,0,0,0,0},
		{0,0,0,1,1,1,1,1,1,0,0,1,1,1,0,0,0,0,0,0,1,1,1,0,0,0,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1,1,0,0,0,0},
		{0,0,0,0,1,1,1,1,0,0,0,1,1,1,0,0,0,0,0,0,0,1,1,1,0,1,1,1,0,0,0,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,0,0},
		{0,0,0,0,0,1,1,0,0,0,0,1,1,1,0,0,0,0,0,0,0,1,1,1,0,1,1,1,0,0,0,0,1,1,1,0,0,0,1,1,1,1,1,1,0,0,0,0}
	};
	private int[][] invaders = {
		{0,1,1,0,1,1,0,0,1,1,0,1,1,0,0,1,1,0,0,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,0,1,1,1,1,0,0,0,1,1,1,0,0}, // Pink
		{0,1,1,0,1,1,0,0,1,1,0,1,1,0,0,1,1,0,0,1,1,1,0,0,1,1,0,1,1,0,1,1,0,0,0,0,1,1,0,1,1,0,1,1,0,1,1,0},
		{0,1,1,0,1,1,1,0,1,1,0,1,1,0,0,1,1,0,1,1,0,1,1,0,1,1,0,1,1,0,1,1,0,0,0,0,1,1,0,1,1,0,1,1,0,0,0,0},
		{0,1,1,0,1,1,1,1,1,1,0,1,1,0,0,1,1,0,1,1,0,1,1,0,1,1,0,1,1,0,1,1,0,0,0,0,1,1,0,1,1,0,1,1,0,0,0,0},
		{0,1,1,0,1,1,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,0,1,1,0,1,1,0,1,1,1,1,0,0,1,1,1,1,0,0,0,1,1,1,0,0}, // Yellow
		{0,1,1,0,1,1,0,1,1,1,0,0,1,1,1,1,0,0,1,1,0,1,1,0,1,1,0,1,1,0,1,1,0,0,0,0,1,1,0,1,1,0,0,0,0,1,1,0},
		{0,1,1,0,1,1,0,0,1,1,0,0,0,1,1,0,0,0,1,1,0,1,1,0,1,1,0,1,1,0,1,1,0,0,0,0,1,1,0,1,1,0,1,1,0,1,1,0},
		{0,1,1,0,1,1,0,0,1,1,0,0,0,1,1,0,0,0,1,1,0,1,1,0,1,1,1,1,0,0,1,1,1,1,1,0,1,1,0,1,1,0,0,1,1,1,0,0}
	};
	
	private int count = 0;
	private int state = 0;
	
	private static final int SPEED = 2;
	private static final int DELAY = 25;
	
	// Constructor
	public Title () {
		createFont ();
	}
	
	// Draw
	public void paint (Graphics2D g) {
		if (state == 3 && count >= Animation.FADE_TIME) {
			LevelManager.reset ();
			Arcade.setAnimation (new StartLevel ());
		}
		
		int start_x = Arcade.getWidth () / 2 - 143;
		int start_y = Arcade.getHeight () / 2 - 166;
		int alpha = getFadeAlpha ();
		
		count ++;
		
		if (state == 0 && count == 2 * DELAY + 16 * SPEED) {
			state = 1;
			count = 0;
		}
		else if (state == 1 && count == 2 * DELAY + 8 * SPEED) {
			state = 2;
			count = 0;
		}
		else if (state == 2 && count >= 2 * DELAY) {
			count = 0;
		}
		
		for (int i = 0; i < 16; i++) {
			if (i == 0)
				g.setColor (new Color (26, 189, 36, alpha));
			else if (i == 8)
				g.setColor (new Color (60, 201, 217, alpha));
			for (int j = 0; j < 48; j++) {
				if ((state > 0 && space[i][j] == 1) ||
				    (state == 0 && count >= DELAY && 
				     (space[i][j] == 1 || count < 2 * DELAY + i * SPEED)))
					g.fillRect (start_x + j * 6, start_y + i * 7, 4, 5);
			}
		}
		
		start_y += 21 * 7;
		
		for (int i = 0; i < 8; i++) {
			if (i == 0)
				g.setColor (new Color (251, 46, 233, alpha));
			else if (i == 4)
				g.setColor (new Color (246, 235, 15, alpha));
			for (int j = 0; j < 48; j++) {
				if ((state > 1 && invaders[i][j] == 1) ||
				    (state == 1 && count >= DELAY && 
				     (invaders[i][j] == 1 || count < 2 * DELAY + i * SPEED)))
					g.fillRect (start_x + j * 6, start_y + i * 7, 4, 5);
			}
		}
		
		if (state == 2 && count > DELAY) {
			g.setColor (new Color (255, 255, 255));
			g.setFont (small_font);
			
			int top = 425 - getSmallFontHeight (g, "PRESS ENTER TO START") / 2;
			int left = 200 - getSmallFontWidth (g, "PRESS ENTER TO START") / 2;
			g.drawString ("PRESS ENTER TO START", left, top);
		}
	}
	
	// Key pressed
	public void enterPressed () {
		if (state == 2) {
			startFadeOut ();
			state = 3;
			count = 0;
		}
	}
}
