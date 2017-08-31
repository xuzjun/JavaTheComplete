package javaBeans;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;

public class Colors extends Canvas implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean rectangular;
	
	public Colors() {
		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				change();
			}
		});
			
		rectangular = false;
		setSize(200, 200);
		change();
	}
	
	protected void change() {
		randomColor();
		repaint();
	}

	private Color randomColor() {
		int r = (int)(255 * Math.random());
		int g = (int)(255 * Math.random());
		int b = (int)(255 * Math.random());
		return new Color(r, g, b);
	}
	
	public void paint(Graphics g) {
		Dimension d = getSize();
		int h = d.height;
		int w = d.width;
		g.getColor();
		if (rectangular) {
			g.fillRect(0, 0, w - 1, h - 1);
		} else {
			g.fillOval(0, 0, w - 1, h - 1);
		}
	}

	public static void main(String[] args) {
		new Colors();
	}

}
