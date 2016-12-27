import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

public class Start extends Applet implements KeyListener {

	static Applet applet;
	int wielkoscX = 800, wielkoscY = 600;
	Obliczenia zad = new Obliczenia();
	Timer timer = new Timer();
	Image bgImage;
	Graphics bgGrap;
	Image player, tex1, texK1, texD1, texT1, pigulka, trap, coin;
	
	public void init() {
		applet = this;
		applet.setSize(wielkoscX, wielkoscY);
		applet.addKeyListener(this);
		applet.setBackground(Color.BLACK);
		
		timer.scheduleAtFixedRate(zad, 10, 10);
		bgImage = createImage(wielkoscX, wielkoscY);
		bgGrap = bgImage.getGraphics();
		
		zad.tworzenieMapy();
		
		player = getImage(getDocumentBase(), "img/player.png");
		tex1 = getImage(getDocumentBase(), "img/tex1.png");
		texK1 = getImage(getDocumentBase(), "img/texK1.png");
		texD1 = getImage(getDocumentBase(), "img/texD1.png");
		texT1 = getImage(getDocumentBase(), "img/texT1.png");
		pigulka = getImage(getDocumentBase(), "img/pigulka.png");
		trap = getImage(getDocumentBase(), "img/trap.png");
		coin = getImage(getDocumentBase(), "img/coin.png");
	}
	
	public void update(Graphics g) {
		bgGrap.clearRect(0, 0, wielkoscX, wielkoscY);
		paint(bgGrap);
		g.drawImage(bgImage, 0, 0, applet);
	}
	
	public void paint(Graphics g){	
		g.setColor(Color.WHITE);
		g.drawString("!Console: " + zad.komunikatWKonsoli, 10, 500);
		
		g.setColor(Color.RED);
		g.drawString("¯ycie: " + zad.zyciePostaci, 410, 15);
		g.drawRect(410, 25, 100, 10);
		g.fillRect(410, 25, zad.zyciePostaci, 10);
		
		g.setColor(Color.YELLOW);
		g.drawString("Punkty: " + zad.punkty, 410, 50);
		
		rysujMapeGry(g);
	}
	
	public void rysujMapeGry(Graphics g) {
		for(int i = 0; i < zad.mapa1.length; i++) {
			for(int j = 0; j < zad.mapa1[0].length; j++) {
				g.drawImage(texT1, 20 * j, 20 * i, this);				
				switch(zad.mapa1[i][j]) {
					case 1:						
						g.drawImage(texK1, 20 * j, 20 * i, this);
					break;
					case 2:
						g.drawImage(tex1, 20 * j, 20 * i, this);
					break;
					case 3:
						g.drawImage(tex1, 20 * j, 20 * i, this);
						g.drawImage(texD1, 20 * j, 20 * i, this);
					break;
					case 4:
						g.drawImage(player, 20 * j, 20 * i, this);
					break;
					case 5:
						g.drawImage(trap, 20 * j, 20 * i, this);
					break;
					case 6:
						g.drawImage(pigulka, 20 * j, 20 * i, this);
					break; 
					case 7:
						g.drawImage(coin, 20 * j, 20 * i, this);
					break; 
				}
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		switch(arg0.getKeyCode()) {
			case 87:
				zad.poruszaniePostacia('w');
			break;
			case 83:
				zad.poruszaniePostacia('s');
			break;
			case 65:
				zad.poruszaniePostacia('a');
			break;
			case 68:
				zad.poruszaniePostacia('d');
			break;
			default:
				System.out.println(arg0.getKeyCode());
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
