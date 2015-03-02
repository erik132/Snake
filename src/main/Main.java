package main;


import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;

import com.jogamp.opengl.util.FPSAnimator;

import engine.GameEngine;
import gamecomponents.Gameboard;
import gamecomponents.Player;
import gamecomponents.PlayerSkin;

public class Main {
	
	public static final String GAME_NAME = "python vs cobra";
	
	public static final int WINDOW_SIZE_X = 800;
	
	public static final int WINDOW_SIZE_Y = 800;
	
	public static void main(String[] args) {
		GLProfile glp = GLProfile.getDefault();
        GLCapabilities caps = new GLCapabilities(glp);
        GLCanvas canvas = new GLCanvas(caps);

        Frame frame = new Frame(GAME_NAME);
        frame.setSize(WINDOW_SIZE_X, WINDOW_SIZE_Y);
        frame.add(canvas);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        
        Player player = new Player(new PlayerSkin(1,1));
        GameEngine engine = new GameEngine(new Gameboard(player));
        canvas.addGLEventListener(engine);

        FPSAnimator animator = new FPSAnimator(canvas, 60);
        animator.start();

	}

}
