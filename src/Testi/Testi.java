package Testi;
import javax.swing.plaf.synth.SynthSeparatorUI;

import Nappula.*;
import Pelilauta.*;
public class Testi {
	public static void main(String [] args){
		
		Pelilauta lauta = new Pelilauta();
		
		
		Nappula x1 = new Nappula('X',6,1);
		Nappula o1 = new Nappula('X',1,2);
		Nappula o2 = new Nappula('X',3,2);
		Nappula o4 = new Nappula('X',2,2);
		
		lauta.lisaaLautaan(x1);
		lauta.lisaaLautaan(o1);
		lauta.lisaaLautaan(o2);
		lauta.lisaaLautaan(o4);
		
		lauta.piirraLauta();
		
		System.out.println(lauta.tarkastaLauta());
		
	}
}

