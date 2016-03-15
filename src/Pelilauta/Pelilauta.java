package Pelilauta;

/*
 * Luokka on t�ll� hetkell� erroris, kun nappi ei toimi en�� n�in.
 * Mutta pit�� koittaa kytkee n�� s��nn�t tohon uuteen grafiikkaan.
 */

import Nappula.Apu;
import java.util.ArrayList;
import java.util.Collection;

import Nappula.*;
public class Pelilauta {
	
	
	private Apu apu;
	
	static ArrayList<Apu> nappulat = new ArrayList<>();
	
	//Tulostus kopioitu suoraan shakkiprojektista
	public static void piirraLauta(){
		int riviNumero = 3;
		for (int y = 3; y >= 1; y--){
			System.out.print(riviNumero + "|");
			riviNumero--;
			for (int x = 1; x <= 3; x++){
				System.out.print(" "+piirraNappula(x ,y)+ " ");
			}
			System.out.println("");
		}
		
		System.out.println("  ---------");
		System.out.println("   1  2  3");
	
	}
	
	public static void lisaaLautaan(Apu uusi){
		nappulat.add(uusi);
		piirraLauta();
	}
	
	//T�ll� testataan onko jossain koordinaatissa jokin nappula
	private static char piirraNappula(int x, int y){
	
		for (Apu nappula : nappulat){
			if (nappula.getX() == x && nappula.getY() == y){
				
				return nappula.getId();
				
			}
			
		}
		return 'o';
	}
	
	
	//K�y nappula listan l�pi ja tarkistaa onko ruutu annetuilla koordinaateilla vapaa
	public boolean ruutuVapaa(int x, int y){
		for (Apu nappula : nappulat){
			if (nappula.getX() == x && nappula.getY() == y){
				return false;
			}
		}
		return true;
	}
	
	//Tarkastaa onko annetut koordinaatit laillisia.
	public boolean laillisetKoordinaatit(int x, int y){
		if (x >= 1 && x <= 3 && y >= 1 && y <= 3 ){
			return true;
		}
		return false;
	}
	
	/*
	 * Koko laudan tarkistus kerralla. 
	 * Voi k�ytt�� jokaisen siiron j�lkeen tarkistamaan p��ttyyk� peli.
	 * Kutsuu vaaka- ,pysty- ja vinojen- rivien tarkistusmetodeita. 
	 * Palauttaa true jos joltain rivilt� l�ytyy kolme samaa nappulaa.
	*/
	public boolean tarkastaLauta(){
		if(tarkastaYlinVaakarivi()){
			return true;
		}
		if(tarkastaKeskimm�inenVaakarivi()){
			return true;
		}
		if(tarkastaAlinVaakarivi()){
			return true;
		}
		if(tarkastaVasenPystyrivi()){
			return true;
		}
		if(tarkastaKeskiPystyrivi()){
			return true;
		}
		if(tarkastaOikeaPystyrivi()){
			return true;
		}
		if(tarkastaVinoVasenalaOikeayla()){
			return true;
		}
		if(tarkastaVinoVasenylaOikeaala()){
			return true;
		}
		
		return false;
	}
	
	/*
	 * Tarkistaa ensin mik� nappulan id on koordinaattipisteess� (1,3).
	 * Sen j�lkeen vertaa l�ytyyk� (2,3) ja (3,3) sama id.
	 * Jos l�ytyy palautetaan true.
	*/
	public boolean tarkastaYlinVaakarivi(){
		int laskuri = 0;
		char id = 'e'; // 'e' empty aluksi
		for (Apu nappula : nappulat){
			
			if (nappula.getX() == 1 && nappula.getY() == 3){
				id = nappula.getId();
			}
		}
		
		for (Apu nappula : nappulat){
			if ((nappula.getX() == 1 && nappula.getY() == 3 && nappula.getId() == id) || 
				(nappula.getX() == 2 && nappula.getY() == 3 && nappula.getId() == id) || 
				(nappula.getX() == 3 && nappula.getY() == 3 && nappula.getId() == id) ){
				laskuri++;
			}
		}
		
		if (laskuri == 3){
			return true;
		}
		
		return false;
	}
	
	/*
	 * Tarkistaa ensin mik� nappulan id on koordinaattipisteess� (1,1).
	 * Sen j�lkeen vertaa l�ytyyk� (2,1) ja (3,1) sama id.
	 * Jos l�ytyy palautetaan true.
	*/
	public boolean tarkastaAlinVaakarivi(){
		int laskuri = 0;
		char id = 'e';
		
		for (Apu nappula : nappulat){
			if (nappula.getX() == 1 && nappula.getY() == 1){
				id = nappula.getId();
			}
		}
		
		for (Apu nappula : nappulat){
			if ((nappula.getX() == 1 && nappula.getY() == 1 && nappula.getId() == id) || 
				(nappula.getX() == 2 && nappula.getY() == 1 && nappula.getId() == id) || 
				(nappula.getX() == 3 && nappula.getY() == 1 && nappula.getId() == id) ){
				laskuri++;
			}
		}
		
		if (laskuri == 3){
			return true;
		}
		
		return false;
	}
	
	/*Tarkistaa ensin mik� nappulan id on koordinaattipisteess� (1,2).
	 * Sen j�lkeen vertaa l�ytyyk� (2,2) ja (3,2) sama id.
	 * Jos l�ytyy palautetaan true.
	*/
	public boolean tarkastaKeskimm�inenVaakarivi(){
		int laskuri = 0;
		char id = 'e';
		
		for (Apu nappula : nappulat){
			if (nappula.getX() == 1 && nappula.getY() == 2){
				id = nappula.getId();
			}
		}
		
		for (Apu nappula : nappulat){
			if ((nappula.getX() == 1 && nappula.getY() == 2 && nappula.getId() == id) || 
				(nappula.getX() == 2 && nappula.getY() == 2 && nappula.getId() == id) || 
				(nappula.getX() == 3 && nappula.getY() == 2 && nappula.getId() == id) ){
				laskuri++;
			}
		}
		
		if (laskuri == 3){
			return true;
		}
		
		return false;
	}
	/*
	 * Tarkistaa ensin mik� nappulan id on koordinaattipisteess� (1,1).
	 * Sen j�lkeen vertaa l�ytyyk� (1,2) ja (1,3) sama id.
	 * Jos l�ytyy palautetaan true.
	*/
	public boolean tarkastaVasenPystyrivi(){
		int laskuri = 0;
		char id = 'e'; // 'e' empty aluksi
		for (Apu nappula : nappulat){
			
			if (nappula.getX() == 1 && nappula.getY() == 1){
				id = nappula.getId();
			}
		}
		
		for (Apu nappula : nappulat){
			if ((nappula.getX() == 1 && nappula.getY() == 1 && nappula.getId() == id) || 
				(nappula.getX() == 1 && nappula.getY() == 2 && nappula.getId() == id) || 
				(nappula.getX() == 1 && nappula.getY() == 3 && nappula.getId() == id) ){
				laskuri++;
			}
		}
		
		if (laskuri == 3){
			return true;
		}
		
		return false;
	}
	/*
	 * Tarkistaa ensin mik� nappulan id on koordinaattipisteess� (2,1).
	 * Sen j�lkeen vertaa l�ytyyk� (2,2) ja (2,3) sama id.
	 * Jos l�ytyy palautetaan true.
	*/
	public boolean tarkastaKeskiPystyrivi(){
		int laskuri = 0;
		char id = 'e'; // 'e' empty aluksi
		for (Apu nappula : nappulat){
			
			if (nappula.getX() == 2 && nappula.getY() == 1){
				id = nappula.getId();
			}
		}
		
		for (Apu nappula : nappulat){
			if ((nappula.getX() == 2 && nappula.getY() == 1 && nappula.getId() == id) || 
				(nappula.getX() == 2 && nappula.getY() == 2 && nappula.getId() == id) || 
				(nappula.getX() == 2 && nappula.getY() == 3 && nappula.getId() == id) ){
				laskuri++;
			}
		}
		
		if (laskuri == 3){
			return true;
		}
		
		return false;
	}
	/*
	 * Tarkistaa ensin mik� nappulan id on koordinaattipisteess� (3,1).
	 * Sen j�lkeen vertaa l�ytyyk� (3,2) ja (3,3) sama id.
	 * Jos l�ytyy palautetaan true.
	*/
	public boolean tarkastaOikeaPystyrivi(){
		int laskuri = 0;
		char id = 'e'; // 'e' empty aluksi
		for (Apu nappula : nappulat){
			
			if (nappula.getX() == 3 && nappula.getY() == 1){
				id = nappula.getId();
			}
		}
		
		for (Apu nappula : nappulat){
			if ((nappula.getX() == 3 && nappula.getY() == 1 && nappula.getId() == id) || 
				(nappula.getX() == 3 && nappula.getY() == 2 && nappula.getId() == id) || 
				(nappula.getX() == 3 && nappula.getY() == 3 && nappula.getId() == id) ){
				laskuri++;
			}
		}
		
		if (laskuri == 3){
			return true;
		}
		
		return false;
	}
	/*
	 * Tarkistaa ensin mik� nappulan id on koordinaattipisteess� (1,1).
	 * Sen j�lkeen vertaa l�ytyyk� (2,2) ja (3,3) sama id.
	 * Jos l�ytyy palautetaan true.
	*/
	public boolean tarkastaVinoVasenalaOikeayla(){
		int laskuri = 0;
		char id = 'e'; // 'e' empty aluksi
		for (Apu nappula : nappulat){
			
			if (nappula.getX() == 1 && nappula.getY() == 1){
				id = nappula.getId();
			}
		}
		
		for (Apu nappula : nappulat){
			if ((nappula.getX() == 1 && nappula.getY() == 1 && nappula.getId() == id) || 
				(nappula.getX() == 2 && nappula.getY() == 2 && nappula.getId() == id) || 
				(nappula.getX() == 3 && nappula.getY() == 3 && nappula.getId() == id) ){
				laskuri++;
			}
		}
		
		if (laskuri == 3){
			return true;
		}
		
		return false;
	}
	/*
	 * Tarkistaa ensin mik� nappulan id on koordinaattipisteess� (1,3).
	 * Sen j�lkeen vertaa l�ytyyk� (2,2) ja (3,1) sama id.
	 * Jos l�ytyy palautetaan true.
	*/
	public boolean tarkastaVinoVasenylaOikeaala(){
		int laskuri = 0;
		char id = 'e'; // 'e' empty aluksi
		for (Apu nappula : nappulat){
			
			if (nappula.getX() == 1 && nappula.getY() == 3){
				id = nappula.getId();
			}
		}
		
		for (Apu nappula : nappulat){
			if ((nappula.getX() == 1 && nappula.getY() == 3 && nappula.getId() == id) || 
				(nappula.getX() == 2 && nappula.getY() == 2 && nappula.getId() == id) || 
				(nappula.getX() == 3 && nappula.getY() == 1 && nappula.getId() == id) ){
				laskuri++;
			}
		}
		
		if (laskuri == 3){
			return true;
		}
		
		return false;
	}

}