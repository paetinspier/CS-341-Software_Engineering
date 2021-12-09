package game;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.LinkedList;

import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Type_A_GameObject extends GameObject implements KeyListener {

	// constructor
	public Type_A_GameObject(int x, int y) {
		super(x, y);

		imageList = new LinkedList<Icon>();
		imageList.add(new ImageIcon("images/Type_A_Up.png"));
		imageList.add(new ImageIcon("images/Type_A_Down.png"));
		
	}

	// implement abstract method move

	public void move(Canvas c) {
		Icon icon = getCurrentImage();
		
		

		int iconHeight = icon.getIconHeight();
		int canvasHeight = (int) c.getSize().getHeight();
		
		
		

		if (getHighlight() == true) {
			
			
			// move the object
			switch (getDirection()) {
			case Direction.UP:
				setY(getY() - getVelocity());
				if (getY() < 0) {
					setY(0);
				}
				break;
			case Direction.DOWN:
				setY(getY() + getVelocity());
				if (getY() + iconHeight > canvasHeight) {
					setY((int) (canvasHeight - iconHeight));
				}
				break;
			}
		} else {
			if (getDirection() == Direction.UP) {
				setY(getY() - getVelocity());
				if (getY() < 0) {
					setY(0);
					setDirection(Direction.DOWN);
					setImage();
				}
			} else {
				setY(getY() + getVelocity());
				if (getY() + iconHeight > canvasHeight) {
					setY((int) (canvasHeight - iconHeight));
					setDirection(Direction.UP);
					setImage();
				}
			}
		}
		

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (getHighlight() == true) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				setDirection(Direction.UP);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setDirection(Direction.DOWN);
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (getHighlight() == true) {
			if (e.getKeyCode() != KeyEvent.VK_TAB) {
				setDirection(Direction.NONE);
			}
		}

	}

	@Override
	public void setImage() {
		switch (getDirection()) {
		case Direction.NONE:
			break;
		case Direction.UP:
			currentImage = 0;
			break;
		case Direction.DOWN:
			currentImage = 1;
			break;
		}

	}
	
	
}
