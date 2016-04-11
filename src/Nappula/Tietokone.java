package Nappula;

import java.util.ArrayList;
import java.util.Random;

import Pelilauta.*;
/*
 * Luokka sis‰lt‰‰ metodit teko‰lyn toiminnaksi. 
 * Teko‰ly toimii arvoperiaatteella. Jokaisen siirron j‰lkeen lasketaan 
 * jokaiselle ruudulle arvo, ja n‰iden perusteella painetaan seuraavalla kierroksella nappia.
 */
public class Tietokone{
	
	static ArrayList<Nappula> siirrot = new ArrayList<>();
	
	private static int [] r = new int [10];
	static Random rnd = new Random();
	
	/**
	 * Method adds nappula object in the ArrayList.
	 */
	public static void lisaaSiirtoListaan(){

		siirrot.add(Pelilauta.nappulat.get(Pelilauta.nappulat.size()-1));
		
	}
// Siirto listan tyhjennys on t‰rke‰ asia, jotta voidaan aloittaa uusipeli
	/**
	 * Removes every index of the siirrot ArrayList.
	 */
	public static void tyhjennaSiirtoLista(){

		siirrot.removeAll(siirrot);
		for (int i = 1; i < r.length; i++){
			r[i] = 0;
			
		}
		
	}
// Suurin arvo on metodi joka palauttaa suurimman arvon napin painamista varten.	
	/**
	 * Method finds the highest value from r[] and returns the index number of that value.
	 * @return
	 */
	public static int suurinArvo(){
		int suurin = 0;
		int indeksi = 0;
		
		for (int i = 1; i < r.length; i++){
			if(r[i] >= suurin){
				suurin = r[i];
				indeksi = i;
				}
			}
		
		
			if(suurin == 0){
				indeksi = 0;
				for (int y = 3; y >=1; y--){
					for (int x = 1; x <= 3; x++){
						indeksi++;
						if(onkoRuutuVapaa(x,y)== true){
							return indeksi;
					}
					
				}
			}
		}
			for (int i = 1; i < r.length; i++){
			r[i] = 0;
		}
		return indeksi;
	}
	/**
	 * Method draws a values which r[] holds in the IDE console
	 */
	public static void testArvot(){
		
		for (int i = 1; i < r.length; i++){
			System.out.print(r[i] + " ");
			if(i%3==0){
				System.out.println("");
			}
			
		}
		System.out.println("");
		
		
			
		}
	
	// Metodilla testataan onko ruutuvapaa, jota tarvitaan lasketaan.
	/**
	 * Method checks if the siirrot ArrayList holds a nappula object with given x and y coordinates and returns boolean.
	 * @param x
	 * @param y
	 * @return
	 */
	public static boolean onkoRuutuVapaa(int x, int y){
		for (Nappula nappula : siirrot){
			if (nappula.getX() == x && nappula.getY() == y){
				return false;
			}
		}
		return true;
	}
	
	
	/**
	 * Method finds the id of the nappula object from the siirrot ArrayList with given coordinates. Returns id or char 'e' if the object is not found.
	 * @param x
	 * @param y
	 * @return
	 */
	private static char haeSiirrotId(int x, int y){

		for (Nappula nappula : siirrot){
			if (nappula.getX() == x && nappula.getY() == y){

				return nappula.getId();

			}
		}
		return 'e';
	}
	
	/**
	 * Method sets arvo parameter for nappula object with given coordinates.
	 * @param x
	 * @param y
	 * @param luku
	 */
	public static void asetaSiirronArvo(int x, int y, int luku){
		for (Nappula nappula : siirrot){
			if (nappula.getX() == x && nappula.getY() == y){
				nappula.setArvo(luku);
			}
		}

	}
	
	/*this is where the magic happens
	 *Jokaisen ruudun kohdalla testataan onko ruutuvapaa, jos ruutu on vapaa lasketaan ruudulle arvo,
	 *sen perusteella miten omat nappulat on viereisiss‰ ruuduissa.
	 *Jotkin ruudut sis‰lt‰v‰t random generaattorin, jotta teko‰lu olisi myˆs mahdollista voittaa.
	 */
	/**
	 * Method calculates the values of for each game tiles which are free.
	 */
	public static void laske(){


		//1
		if(onkoRuutuVapaa(1,3)){
			int luku = 0;
			if(   (onkoRuutuVapaa(2,3) || haeSiirrotId(2,3) == 'O')   &&   (onkoRuutuVapaa(3,3) || haeSiirrotId(3,3) == 'O')) luku++;
			if(   (onkoRuutuVapaa(1,2) || haeSiirrotId(1,2) == 'O')   &&   (onkoRuutuVapaa(1,1) || haeSiirrotId(1,1) == 'O')) luku++;
			if(   (onkoRuutuVapaa(2,2) || haeSiirrotId(2,2) == 'O')   &&   (onkoRuutuVapaa(3,1) || haeSiirrotId(3,1) == 'O')) luku++;
			if(	  (haeSiirrotId(1,2) == 'X') && (haeSiirrotId(2,3) == 'X'))luku = luku + rnd.nextInt(4);
			

			r[1] = luku;
		}

		//2
		if(onkoRuutuVapaa(2,3)){
			int luku = 0;
			if(   (onkoRuutuVapaa(1,3) || haeSiirrotId(1,3) == 'O')   &&   (onkoRuutuVapaa(3,3) || haeSiirrotId(3,3) == 'O')) luku++;
			if(   (onkoRuutuVapaa(2,2) || haeSiirrotId(2,2) == 'O')   &&   (onkoRuutuVapaa(2,1) || haeSiirrotId(2,1) == 'O')) luku++;
			if(   (haeSiirrotId(3,3) == 'X') && (haeSiirrotId(1,1) == 'X' || haeSiirrotId(1,2) == 'X')) luku = luku + rnd.nextInt(4);
			

			r[2] = luku;
		}

		//3
		if(onkoRuutuVapaa(3,3)){
			int luku = 0;
			if(   (onkoRuutuVapaa(2,3) || haeSiirrotId(2,3) == 'O')   &&   (onkoRuutuVapaa(1,3) || haeSiirrotId(1,3) == 'O')) luku++;
			if(   (onkoRuutuVapaa(3,2) || haeSiirrotId(3,2) == 'O')   &&   (onkoRuutuVapaa(3,1) || haeSiirrotId(3,1) == 'O')) luku++;
			if(   (onkoRuutuVapaa(2,2) || haeSiirrotId(2,2) == 'O')   &&   (onkoRuutuVapaa(1,1) || haeSiirrotId(1,1) == 'O')) luku++;
			if(   (haeSiirrotId(3,2) == 'X') && (haeSiirrotId(2,3) == 'X')) luku = luku + rnd.nextInt(4);
			

			r[3] = luku;
		}


		//4
		if(onkoRuutuVapaa(1,2)){
			int luku = 0;
			if(   (onkoRuutuVapaa(1,3) || haeSiirrotId(1,3) == 'O')   &&   (onkoRuutuVapaa(1,1) || haeSiirrotId(1,1) == 'O')) luku++;
			if(   (onkoRuutuVapaa(2,2) || haeSiirrotId(2,2) == 'O')   &&   (onkoRuutuVapaa(3,2) || haeSiirrotId(3,2) == 'O')) luku++;
			

			

			r[4] = luku;
		}


		//5
		if(onkoRuutuVapaa(2,2)){
			int luku = rnd.nextInt(5);
			if(   (onkoRuutuVapaa(2,3) || haeSiirrotId(2,3) == 'O')   &&   (onkoRuutuVapaa(2,1) || haeSiirrotId(2,1) == 'O')) luku++;
			if(   (onkoRuutuVapaa(1,2) || haeSiirrotId(1,2) == 'O')   &&   (onkoRuutuVapaa(3,2) || haeSiirrotId(3,2) == 'O')) luku++;
			if(   (onkoRuutuVapaa(1,1) || haeSiirrotId(1,1) == 'O')   &&   (onkoRuutuVapaa(3,3) || haeSiirrotId(3,3) == 'O')) luku++;
			if(   (onkoRuutuVapaa(1,3) || haeSiirrotId(1,3) == 'O')   &&   (onkoRuutuVapaa(3,1) || haeSiirrotId(3,1) == 'O')) luku++;

			

			r[5] = luku;
		}



		//6
		if(onkoRuutuVapaa(3,2)){
			int luku = 0;
			if(   (onkoRuutuVapaa(1,2) || haeSiirrotId(1,2) == 'O')   &&   (onkoRuutuVapaa(2,2) || haeSiirrotId(2,2) == 'O')) luku++;
			if(   (onkoRuutuVapaa(3,1) || haeSiirrotId(3,1) == 'O')   &&   (onkoRuutuVapaa(3,3) || haeSiirrotId(3,3) == 'O')) luku++;
			

			

			r[6] = luku;
		}


		//7
		if(onkoRuutuVapaa(1,1)){
			int luku = 0;
			if(   (haeSiirrotId(2,2) == 'X') && (haeSiirrotId(1,3) == 'X')) luku = luku + 15;
			if(   (onkoRuutuVapaa(1,2) || haeSiirrotId(1,2) == 'O')   &&   (onkoRuutuVapaa(1,3) || haeSiirrotId(1,3) == 'O')) luku++;
			if(   (onkoRuutuVapaa(2,1) || haeSiirrotId(2,1) == 'O')   &&   (onkoRuutuVapaa(3,1) || haeSiirrotId(3,1) == 'O')) luku++;
			if(   (onkoRuutuVapaa(2,2) || haeSiirrotId(2,2) == 'O')   &&   (onkoRuutuVapaa(3,3) || haeSiirrotId(3,3) == 'O')) luku++;
			if(	  (haeSiirrotId(2,1) == 'X') && (haeSiirrotId(1,2) == 'X'))luku = luku +rnd.nextInt(4);

			r[7] = luku;
		}


		//8
		if(onkoRuutuVapaa(2,1)){
			int luku = 0;
			if(   (onkoRuutuVapaa(1,1) || haeSiirrotId(1,1) == 'O')   &&   (onkoRuutuVapaa(3,1) || haeSiirrotId(3,1) == 'O')) luku++;
			if(   (onkoRuutuVapaa(2,2) || haeSiirrotId(2,2) == 'O')   &&   (onkoRuutuVapaa(2,3) || haeSiirrotId(2,3) == 'O')) luku++;
			

			

			r[8] = luku;
		}

		//9
		if(onkoRuutuVapaa(3,1)){
			int luku = 0;
			if(   (onkoRuutuVapaa(1,1) || haeSiirrotId(1,1) == 'O')   &&   (onkoRuutuVapaa(2,1) || haeSiirrotId(2,1) == 'O')) luku++;
			if(   (onkoRuutuVapaa(3,2) || haeSiirrotId(3,2) == 'O')   &&   (onkoRuutuVapaa(3,3) || haeSiirrotId(3,3) == 'O')) luku++;
			if(   (onkoRuutuVapaa(2,2) || haeSiirrotId(2,2) == 'O')   &&   (onkoRuutuVapaa(1,3) || haeSiirrotId(1,3) == 'O')) luku++;
			if(	  (haeSiirrotId(2,1) == 'X') && (haeSiirrotId(3,2) == 'X'))luku = luku + rnd.nextInt(4);
			

			r[9] = luku;
		}
		
		
		/*
		 * T‰st‰ eteenp‰in lasketaan aikaisempiin arvoihin muutokset, miten vastustajan nappulat ovat sijoittuneet.
		 * Ja jos esimerkiksi vastustaja on saamassa voittosuoran seuraavalla vuorolla, kasvaa t‰m‰n ruudunarvo muita enemm‰n.
		 */
		
		//1
		if(onkoRuutuVapaa(1,3)){
			int luku = r[1];
			
			if(   (haeSiirrotId(2,3) == 'X')   &&   (haeSiirrotId(3,3) == 'X')) luku = luku + 5;
			if(   (haeSiirrotId(1,2) == 'X')   &&   (haeSiirrotId(1,1) == 'X')) luku = luku + 5;
			if(   (haeSiirrotId(2,2) == 'X')   &&   (haeSiirrotId(3,1) == 'X')) luku = luku + 5;
			
			if(   (haeSiirrotId(2,3) == 'O')   &&   (haeSiirrotId(3,3) == 'O')) luku = luku + 15;
			if(   (haeSiirrotId(1,2) == 'O')   &&   (haeSiirrotId(1,1) == 'O')) luku = luku + 15;
			if(   (haeSiirrotId(2,2) == 'O')   &&   (haeSiirrotId(3,1) == 'O')) luku = luku + 15;
			
		
			r[1] = luku;
		}

		//2
		if(onkoRuutuVapaa(2,3)){
			int luku = r[2];

			if(   (haeSiirrotId(1,3) == 'X')   &&   (haeSiirrotId(3,3) == 'X')) luku = luku + 5;
			if(   (haeSiirrotId(2,2) == 'X')   &&   (haeSiirrotId(2,1) == 'X')) luku = luku + 5;
			

			if(   (haeSiirrotId(1,3) == 'O')   &&   (haeSiirrotId(3,3) == 'O')) luku = luku + 15;
			if(   (haeSiirrotId(2,2) == 'O')   &&   (haeSiirrotId(2,1) == 'O')) luku = luku + 15;
				
			r[2] = luku;
		}

		//3
		if(onkoRuutuVapaa(3,3)){
			
			int luku = r[3];

			if(   (haeSiirrotId(1,3) == 'X')   &&   (haeSiirrotId(2,3) == 'X')) luku = luku + 5;
			if(   (haeSiirrotId(2,2) == 'X')   &&   (haeSiirrotId(1,1) == 'X')) luku = luku + 5;
			if(   (haeSiirrotId(3,2) == 'X')   &&   (haeSiirrotId(3,1) == 'X')) luku = luku + 5;

			if(   (haeSiirrotId(1,3) == 'O')   &&   (haeSiirrotId(2,3) == 'O')) luku = luku + 15;
			if(   (haeSiirrotId(2,2) == 'O')   &&   (haeSiirrotId(1,1) == 'O')) luku = luku + 15;
			if(   (haeSiirrotId(3,2) == 'O')   &&   (haeSiirrotId(3,1) == 'O')) luku = luku + 15;


			r[3] = luku;
			
		}


		//4
		if(onkoRuutuVapaa(1,2)){
			int luku = r[4];

			if(   (haeSiirrotId(1,1) == 'X')   &&   (haeSiirrotId(1,3) == 'X')) luku = luku + 5;
			if(   (haeSiirrotId(2,2) == 'X')   &&   (haeSiirrotId(3,2) == 'X')) luku = luku + 5;
			

			if(   (haeSiirrotId(1,1) == 'O')   &&   (haeSiirrotId(1,3) == 'O')) luku = luku + 15;
			if(   (haeSiirrotId(2,2) == 'O')   &&   (haeSiirrotId(3,2) == 'O')) luku = luku + 15;
			


			r[4] = luku;
		}


		//5
		if(onkoRuutuVapaa(2,2)){
			int luku = r[5];

			if(   (haeSiirrotId(1,2) == 'X')   &&   (haeSiirrotId(3,2) == 'X')) luku = luku + 5;
			if(   (haeSiirrotId(2,1) == 'X')   &&   (haeSiirrotId(2,3) == 'X')) luku = luku + 5;
			if(   (haeSiirrotId(1,1) == 'X')   &&   (haeSiirrotId(3,3) == 'X')) luku = luku + 5;
			if(   (haeSiirrotId(1,3) == 'X')   &&   (haeSiirrotId(3,1) == 'X')) luku = luku + 5;
			
			if(   (haeSiirrotId(1,2) == 'O')   &&   (haeSiirrotId(3,2) == 'O')) luku = luku + 15;
			if(   (haeSiirrotId(2,1) == 'O')   &&   (haeSiirrotId(2,3) == 'O')) luku = luku + 15;
			if(   (haeSiirrotId(1,1) == 'O')   &&   (haeSiirrotId(3,3) == 'O')) luku = luku + 15;
			if(   (haeSiirrotId(1,3) == 'O')   &&   (haeSiirrotId(3,1) == 'O')) luku = luku + 15;

			


			r[5] = luku;
		}



		//6
		if(onkoRuutuVapaa(3,2)){
			
			int luku = r[6];

			if(   (haeSiirrotId(2,2) == 'X')   &&   (haeSiirrotId(1,2) == 'X')) luku = luku + 5;
			if(   (haeSiirrotId(3,1) == 'X')   &&   (haeSiirrotId(3,3) == 'X')) luku = luku + 5;
			

			if(   (haeSiirrotId(2,2) == 'O')   &&   (haeSiirrotId(1,2) == 'O')) luku = luku + 15;
			if(   (haeSiirrotId(3,1) == 'O')   &&   (haeSiirrotId(3,3) == 'O')) luku = luku + 15;
			


			r[6] = luku;
			
		}


		//7
		if(onkoRuutuVapaa(1,1)){

			int luku = r[7];

			if(   (haeSiirrotId(1,2) == 'X')   &&   (haeSiirrotId(1,3) == 'X')) luku = luku + 5;
			if(   (haeSiirrotId(2,1) == 'X')   &&   (haeSiirrotId(3,1) == 'X')) luku = luku + 5;
			if(   (haeSiirrotId(2,2) == 'X')   &&   (haeSiirrotId(3,3) == 'X')) luku = luku + 5;

			if(   (haeSiirrotId(1,2) == 'O')   &&   (haeSiirrotId(1,3) == 'O')) luku = luku + 15;
			if(   (haeSiirrotId(2,1) == 'O')   &&   (haeSiirrotId(3,1) == 'O')) luku = luku + 15;
			if(   (haeSiirrotId(2,2) == 'O')   &&   (haeSiirrotId(3,3) == 'O')) luku = luku + 15;


			r[7] = luku;
		}


		//8
		if(onkoRuutuVapaa(2,1)){
			int luku = r[8];

			if(   (haeSiirrotId(2,2) == 'X')   &&   (haeSiirrotId(2,3) == 'X')) luku = luku + 5;
			if(   (haeSiirrotId(1,1) == 'X')   &&   (haeSiirrotId(3,1) == 'X')) luku = luku + 5;
			

			if(   (haeSiirrotId(2,2) == 'O')   &&   (haeSiirrotId(2,3) == 'O')) luku = luku + 15;
			if(   (haeSiirrotId(1,1) == 'O')   &&   (haeSiirrotId(3,1) == 'O')) luku = luku + 15;
			


			r[8] = luku;
		}

		//9
		if(onkoRuutuVapaa(3,1)){
			int luku = r[9];

			if(   (haeSiirrotId(1,1) == 'X')   &&   (haeSiirrotId(2,1) == 'X')) luku = luku + 5;
			if(   (haeSiirrotId(3,2) == 'X')   &&   (haeSiirrotId(3,3) == 'X')) luku = luku + 5;
			if(   (haeSiirrotId(2,2) == 'X')   &&   (haeSiirrotId(1,3) == 'X')) luku = luku + 5;

			if(   (haeSiirrotId(1,1) == 'O')   &&   (haeSiirrotId(2,1) == 'O')) luku = luku + 15;
			if(   (haeSiirrotId(3,2) == 'O')   &&   (haeSiirrotId(3,3) == 'O')) luku = luku + 15;
			if(   (haeSiirrotId(2,2) == 'O')   &&   (haeSiirrotId(1,3) == 'O')) luku = luku + 15;


			r[9] = luku;
		}





	}


}