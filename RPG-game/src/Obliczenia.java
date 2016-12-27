import java.util.TimerTask;

public class Obliczenia extends TimerTask{

	static int pozycjaNapisuX = 700;
	static int pozycjaNapisuY = 20;
	int kierunek = 1;
	int przebytaDrogaNapisu = 0;
	int mapa1[][] = new int [20][20];
	int pPostaciY = 2, pPostaciX = 2;
	int zyciePostaci = 100;
	String komunikatWKonsoli, komunikatSmierci;
	int punkty = 0;
	
	public void run() {
		if(zyciePostaci > 100) {
			zyciePostaci = 100;
		}
		else if (zyciePostaci <= 0) {
			smiercGracza(true, 0, false, 100, 10);
		}
		Start.applet.repaint();
	}
	
	public void tworzenieMapy() {
		
	pPostaciY = 2;
	pPostaciX = 2;
	
		int mapa12[][] = {
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,0,0,0,1,1,1,1,1,1,1,1,7,0,0,0,0,0,0,1},
				{1,0,4,0,1,0,0,0,1,1,1,1,7,0,0,0,0,0,0,1},
				{1,0,0,0,1,0,0,0,0,1,1,2,2,2,2,2,2,2,0,1},
				{1,0,0,0,1,0,0,0,0,0,1,2,2,2,2,2,2,2,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,2,2,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,2,3,2,2,2,2,2,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,5,0,0,5,0,0,0,0,0,0,6,6,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,6,6,0,0,0,0,0,1},
				{1,0,5,0,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
		};
		
		for(int i = 0; i < mapa1.length; i++) {
			for(int j = 0; j < mapa1[0].length; j++) {
				mapa1[i][j] = mapa12[i][j];
			}
		}
	}
	
	public void poruszaniePostacia(char klawisz) {
		switch(klawisz) {
			case 'w':
				if(mapa1[pPostaciY - 1][pPostaciX] == 0) {
					mapa1[pPostaciY - 1][pPostaciX] = 4;
					mapa1[pPostaciY][pPostaciX] = 0;
					pPostaciY--;
				}
				else if(mapa1[pPostaciY - 1][pPostaciX] == 5) {
					zyciePostaci -= 10;
				}
				else if(mapa1[pPostaciY - 1][pPostaciX] == 6) {
					zyciePostaci += 10;
					mapa1[pPostaciY - 1][pPostaciX] = 4;
					mapa1[pPostaciY][pPostaciX] = 0;
					pPostaciY--;
				}
				else if(mapa1[pPostaciY - 1][pPostaciX] == 7) {
					punkty += 10;
					mapa1[pPostaciY - 1][pPostaciX] = 4;
					mapa1[pPostaciY][pPostaciX] = 0;
					pPostaciY--;
					komunikatWKonsoli = "Punkty + 10";
				}
			break;
			case 's':
				if(mapa1[pPostaciY + 1][pPostaciX] == 0) {
					mapa1[pPostaciY + 1][pPostaciX] = 4;
					mapa1[pPostaciY][pPostaciX] = 0;
					pPostaciY++;
				}
				else if(mapa1[pPostaciY + 1][pPostaciX] == 5) {
					zyciePostaci -= 10;
				}
				else if(mapa1[pPostaciY + 1][pPostaciX] == 6) {
					zyciePostaci += 10;
					mapa1[pPostaciY + 1][pPostaciX] = 4;
					mapa1[pPostaciY][pPostaciX] = 0;
					pPostaciY++;
				}
				else if(mapa1[pPostaciY + 1][pPostaciX] == 7) {
					punkty += 10;
					mapa1[pPostaciY + 1][pPostaciX] = 4;
					mapa1[pPostaciY][pPostaciX] = 0;
					pPostaciY++;
					komunikatWKonsoli = "Punkty + 10";
				}
			break;
			case 'a':
				if(mapa1[pPostaciY][pPostaciX - 1] == 0) {
					mapa1[pPostaciY][pPostaciX - 1] = 4;
					mapa1[pPostaciY][pPostaciX] = 0;
					pPostaciX--;
				}
				else if(mapa1[pPostaciY][pPostaciX - 1] == 5) {
					zyciePostaci -= 10;
				}
				else if(mapa1[pPostaciY][pPostaciX - 1] == 6) {
					zyciePostaci += 10;
					mapa1[pPostaciY][pPostaciX - 1] = 4;
					mapa1[pPostaciY][pPostaciX] = 0;
					pPostaciX--;
				}
				else if(mapa1[pPostaciY][pPostaciX - 1] == 7) {
					punkty += 10;
					mapa1[pPostaciY][pPostaciX - 1] = 4;
					mapa1[pPostaciY][pPostaciX] = 0;
					pPostaciX--;
					komunikatWKonsoli = "Punkty + 10";
				}
			break;
			case 'd':
				if(mapa1[pPostaciY][pPostaciX + 1] == 0) {
					mapa1[pPostaciY][pPostaciX + 1] = 4;
					mapa1[pPostaciY][pPostaciX] = 0;
					pPostaciX++;
				}
				else if(mapa1[pPostaciY][pPostaciX + 1] == 5) {
					zyciePostaci -= 10;
				}
				else if(mapa1[pPostaciY][pPostaciX + 1] == 6) {
					zyciePostaci += 10;
					mapa1[pPostaciY][pPostaciX + 1] = 4;
					mapa1[pPostaciY][pPostaciX] = 0;
					pPostaciX++;
				}
				else if(mapa1[pPostaciY][pPostaciX + 1] == 7) {
					punkty += 10;
					mapa1[pPostaciY][pPostaciX + 1] = 4;
					mapa1[pPostaciY][pPostaciX] = 0;
					pPostaciX++;
					komunikatWKonsoli = "Punkty + 10";
				}
			break;
		}
	}
	
	public void smiercGracza(boolean resetMapy, int mapaOdrodzenia, boolean resetEQ,
			int iloscZyciaPoOdrodzeniu, int iloscMinusowychPunktow) {
		if(resetMapy == true) {
			tworzenieMapy();
		}
		else{}
		//if(resteEQ == true) {}else()
		//switch(mapaOdrodzenia){}
		
		punkty -= iloscMinusowychPunktow;
		
		if(punkty < 0) {
			punkty = 0;
		}
		
		komunikatWKonsoli = komunikatSmierci;		
		zyciePostaci = iloscZyciaPoOdrodzeniu;
	}
}
