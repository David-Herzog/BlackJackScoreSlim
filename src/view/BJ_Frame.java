package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * 
 * @author David Herzog
 * 
 * KeyCodes: left:37 up:38 right:39 down:40
 *
 */

public class BJ_Frame extends JFrame implements	KeyListener{

	private static final long serialVersionUID = 1L;
	
	JLabel label = new JLabel("The Label", SwingConstants.CENTER);
	private int score;

	public BJ_Frame(){
		score = 0;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("21 Slim");
		this.setSize(300,150);
		label.setBackground(Color.DARK_GRAY);
		label.setOpaque(true);
		label.setText("Score: " + score);
		label.setForeground(Color.white);
		label.setFont(new Font("Playbill", Font.PLAIN, 80));
		this.add(label);
		this.addKeyListener(this);
		this.setVisible(true);
	}

	public void highCard() {
		score --;
	
		label.setText("Score: " + score);
	}

	
	public void lowCard() {
		score++;
		label.setText("Score: " + score);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case 37 : lowCard();  break;
		case 38 : highCard(); break;
		case 39 : highCard(); break;
		case 40 : lowCard();  break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// not needed
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// not needed
	}
	
	
}
