package Pelilauta;


import java.util.ArrayList;
import Nappula.*;
public class Pelilauta {
	
	private Nappula nappula;
	
	ArrayList<Nappula> nappulat = new ArrayList<>();
	
	//Tulostus kopioitu suoraan shakkiprojektista
	public void piirraLauta(){
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
	
	public void lisaaLautaan(Nappula nappula){
		nappulat.add(nappula);
	}
	
	//Tällä testataan onko jossain koordinaatissa jokin nappula
	private char piirraNappula(int x, int y){
	
		for (Nappula nappula : nappulat){
			if (nappula.getX() == x && nappula.getY() == y){
				
				return nappula.getId();
				
			}
			
		}
		return 'o';
	}
	
	
	//Käy nappula listan läpi ja tarkistaa onko ruutu annetuilla koordinaateilla vapaa
	public boolean ruutuVapaa(int x, int y){
		for (Nappula nappula : nappulat){
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
	
	//Koko laudan tarkistus kerralla. 
	//Voi käyttää jokaisen siiron jälkeen tarkistamaan päättyykö peli.
	//Kutsuu vaaka- ,pysty- ja vinojen- rivien tarkistusmetodeita. 
	//Palauttaa true jos joltain riviltä löytyy kolme samaa nappulaa.
	public boolean tarkastaLauta(){
		if(tarkastaYlinVaakarivi()){
			return true;
		}
		if(tarkastaKeskimmäinenVaakarivi()){
			return true;
		}
		if(tarkastaAlinVaakarivi()){
			return true;
		}
		
		return false;
	}
	
	//Tarkistaa ensin mikä nappulan id on koordinaattipisteessä (1,3).
	//Sen jälkeen vertaa löytyykö (2,3) ja (3,3) sama id.
	//Jos löytyy palautetaan true.
	public boolean tarkastaYlinVaakarivi(){
		int laskuri = 0;
		char id = 'e'; // 'e' empty aluksi
		for (Nappula nappula : nappulat){
			
			if (nappula.getX() == 1 && nappula.getY() == 3){
				id = nappula.getId();
			}
		}
		
		for (Nappula nappula : nappulat){
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
	
	//Tarkistaa ensin mikä nappulan id on koordinaattipisteessä (1,1).
	//Sen jälkeen vertaa löytyykö (2,1) ja (3,1) sama id.
	//Jos löytyy palautetaan true.
	public boolean tarkastaAlinVaakarivi(){
		int laskuri = 0;
		char id = 'e';
		
		for (Nappula nappula : nappulat){
			if (nappula.getX() == 1 && nappula.getY() == 1){
				id = nappula.getId();
			}
		}
		
		for (Nappula nappula : nappulat){
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
	
	//Tarkistaa ensin mikä nappulan id on koordinaattipisteessä (1,2).
	//Sen jälkeen vertaa löytyykö (2,2) ja (3,2) sama id.
	//Jos löytyy palautetaan true.
	public boolean tarkastaKeskimmäinenVaakarivi(){
		int laskuri = 0;
		char id = 'e';
		
		for (Nappula nappula : nappulat){
			if (nappula.getX() == 1 && nappula.getY() == 2){
				id = nappula.getId();
			}
		}
		
		for (Nappula nappula : nappulat){
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

}