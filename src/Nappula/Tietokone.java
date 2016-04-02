package Nappula;

import java.util.ArrayList;

import Pelilauta.*;
import Nappula.*;

public class Tietokone{
	
	
	

	static ArrayList<Nappula> siirrot = new ArrayList<>();
	
	public static void lisaaSiirtoListaan(){

		siirrot.add(Pelilauta.nappulat.get(Pelilauta.nappulat.size()-1));
		//System.out.println(siirrot.size()+"vuoro");
	}

	public static void tyhjennaSiirtoLista(){

		siirrot.removeAll(siirrot);
	}

	public static void testArvot(){
		laske();
		for (int y = 3; y >= 1; y--){
			for (int x = 1; x <= 3; x++){
				System.out.print(haeSiirrot(x ,y)+" ");
				
			}
			System.out.println("");
		}
	}

	private static int haeSiirrot(int x, int y){

		for (Nappula nappula : siirrot){
			if (nappula.getX() == x && nappula.getY() == y){

				return nappula.getArvo();

			}
		}
		return 0;
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
	
	
	public static void asetaSiirronArvo(int x, int y, int arvo){
		for (Nappula nappula : siirrot){
			if (nappula.getX() == x && nappula.getY() == y){
				nappula.setArvo(arvo);
			}
		}

	}
	
	
	
	//this is where the magic happens
	public static void laske(){
		
		

		//1
		if(onkoRuutuVapaa(1,3)){
			int arvo = 0;
			if(   (onkoRuutuVapaa(2,3) || haeSiirrotId(2,3) == 'X')   &&   (onkoRuutuVapaa(3,3) || haeSiirrotId(3,3) == 'X')) arvo++;
			if(   (onkoRuutuVapaa(1,2) || haeSiirrotId(1,2) == 'X')   &&   (onkoRuutuVapaa(1,1) || haeSiirrotId(1,1) == 'X')) arvo++;
			asetaSiirronArvo(1,3,arvo);
			System.out.println("yolo");
		}
	}

	
}