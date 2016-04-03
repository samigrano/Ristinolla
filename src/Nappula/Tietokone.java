package Nappula;

import java.util.ArrayList;

import Pelilauta.*;

public class Tietokone{
	
	static ArrayList<Nappula> siirrot = new ArrayList<>();
	
	private static int [] r = new int [10];
	
	
	public static void lisaaSiirtoListaan(){

		siirrot.add(Pelilauta.nappulat.get(Pelilauta.nappulat.size()-1));
		
	}

	public static void tyhjennaSiirtoLista(){

		siirrot.removeAll(siirrot);
		for (int i = 0; i < r.length; i++){
			r[i] = 0;
			
		}
		
	}
	
	public static int suurinArvo(){
		int suurin = 0;
		int indeksi = 0;
		
		for (int i = 0; i < r.length; i++){
			if(r[i] >= suurin){
				suurin = r[i];
				if(suurin == 0){
					indeksi = 1;
					for (int y = 3; y >=1; y--){
						for (int x = 1; x <= 3; x++){
							if(onkoRuutuVapaa(x,y)== false){
								indeksi++;
							}
						}
						
					}
				}
				else{
					indeksi = i;
				}
			}
		}
		for (int i = 0; i < r.length; i++){
			r[i] = 0;
		}
		return indeksi;
	}

	public static void testArvot(){
		
		for (int i = 1; i < r.length; i++){
			System.out.print(r[i] + " ");
			if(i%3==0){
				System.out.println("");
			}
			
		}
		System.out.println("");
		
		
			
		}
	
	public static boolean onkoRuutuVapaa(int x, int y){
		for (Nappula nappula : siirrot){
			if (nappula.getX() == x && nappula.getY() == y){
				return false;
			}
		}
		return true;
	}
	
	
	
	private static char haeSiirrotId(int x, int y){

		for (Nappula nappula : siirrot){
			if (nappula.getX() == x && nappula.getY() == y){

				return nappula.getId();

			}
		}
		return 'e';
	}
	
	
	public static void asetaSiirronArvo(int x, int y, int luku){
		for (Nappula nappula : siirrot){
			if (nappula.getX() == x && nappula.getY() == y){
				nappula.setArvo(luku);
			}
		}

	}
	
	//this is where the magic happens
	public static void laske(){


		//1
		if(onkoRuutuVapaa(1,3)){
			int luku = 0;
			if(   (onkoRuutuVapaa(2,3) || haeSiirrotId(2,3) == 'O')   &&   (onkoRuutuVapaa(3,3) || haeSiirrotId(3,3) == 'O')) luku++;
			if(   (onkoRuutuVapaa(1,2) || haeSiirrotId(1,2) == 'O')   &&   (onkoRuutuVapaa(1,1) || haeSiirrotId(1,1) == 'O')) luku++;
			if(   (onkoRuutuVapaa(2,2) || haeSiirrotId(2,2) == 'O')   &&   (onkoRuutuVapaa(3,1) || haeSiirrotId(3,1) == 'O')) luku++;

			

			r[1] = luku;
		}

		//2
		if(onkoRuutuVapaa(2,3)){
			int luku = 0;
			if(   (onkoRuutuVapaa(1,3) || haeSiirrotId(1,3) == 'O')   &&   (onkoRuutuVapaa(3,3) || haeSiirrotId(3,3) == 'O')) luku++;
			if(   (onkoRuutuVapaa(2,2) || haeSiirrotId(2,2) == 'O')   &&   (onkoRuutuVapaa(2,1) || haeSiirrotId(2,1) == 'O')) luku++;
			
			

			r[2] = luku;
		}

		//3
		if(onkoRuutuVapaa(3,3)){
			int luku = 0;
			if(   (onkoRuutuVapaa(2,3) || haeSiirrotId(2,3) == 'O')   &&   (onkoRuutuVapaa(1,3) || haeSiirrotId(1,3) == 'O')) luku++;
			if(   (onkoRuutuVapaa(3,2) || haeSiirrotId(3,2) == 'O')   &&   (onkoRuutuVapaa(3,1) || haeSiirrotId(3,1) == 'O')) luku++;
			if(   (onkoRuutuVapaa(2,2) || haeSiirrotId(2,2) == 'O')   &&   (onkoRuutuVapaa(1,1) || haeSiirrotId(1,1) == 'O')) luku++;

			

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
			int luku = 0;
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
			if(   (onkoRuutuVapaa(1,2) || haeSiirrotId(1,2) == 'O')   &&   (onkoRuutuVapaa(1,3) || haeSiirrotId(1,3) == 'O')) luku++;
			if(   (onkoRuutuVapaa(2,1) || haeSiirrotId(2,1) == 'O')   &&   (onkoRuutuVapaa(3,1) || haeSiirrotId(3,1) == 'O')) luku++;
			if(   (onkoRuutuVapaa(2,2) || haeSiirrotId(2,2) == 'O')   &&   (onkoRuutuVapaa(3,3) || haeSiirrotId(3,3) == 'O')) luku++;

			

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

			

			r[9] = luku;
		}
		
		
		//vastustajan testaus
		
		
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