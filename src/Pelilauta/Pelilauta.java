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

}