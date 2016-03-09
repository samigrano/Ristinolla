package Testi;
import Nappula.*;
import Pelilauta.*;
public class Testi {
	public static void main(String [] args){
		
		Pelilauta lauta = new Pelilauta();
		
		
		Nappula x1 = new Nappula('X',1,1);
		Nappula o1 = new Nappula('0',2,3);
		
		lauta.lisaaLautaan(x1);
		lauta.lisaaLautaan(o1);
		
		lauta.piirraLauta();
	}
}

