package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
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
	
	JLabel label = new JLabel();
	private int score;

	public BJ_Frame(){
		score = 0;
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("21 Slim");
		this.setSize(316,189);
		setImageAndFontColor();
//		label.setIcon(new ImageIcon("src/view/images/lame.gif"));
//		label.setBackground(Color.DARK_GRAY);
//		label.setOpaque(true);
		label.setText(getScoreToString());
//		label.setForeground(Color.white);
		label.setFont(new Font("Playbill", Font.PLAIN, 80));
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.CENTER);
		this.add(label);
		this.addKeyListener(this);
		this.setVisible(true);
	}
	
	public void setImageAndFontColor() {
		if (score < -4) {
			label.setIcon(new ImageIcon("src/view/images/ice.gif"));
			label.setForeground(new Color(139,69,19));
		}else if (score < 5) {
			label.setIcon(new ImageIcon("src/view/images/lame.gif"));
			label.setForeground(Color.black);
		}else {
			label.setIcon(new ImageIcon("src/view/images/hot.gif"));
			label.setForeground(Color.white);
		}
	}

	public void highCard() {
		score --;
		setImageAndFontColor();
		label.setText(getScoreToString());
	}
	
	public void lowCard() {
		score++;
		setImageAndFontColor();
		label.setText(getScoreToString());
	}
	
	public String getScoreToString() {
		return score > 0 ? "Score: +" + score : "Score: " + score; 
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
