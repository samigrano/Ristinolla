package Nappula;

public class Tietokone {
	
	static int ruutu1 = 0;
	private static int ruutu2 = 0;
	private static int ruutu3 = 0;
	private static int ruutu4 = 0;
	private static int ruutu5 = 0;
	private static int ruutu6 = 0;
	private static int ruutu7 = 0;
	private static int ruutu8 = 0;
	private static int ruutu9 = 0;
	
	public static int kasvata(int ruutu){
		ruutu++;
		return ruutu;
	}
	// Testausta varten
	public static void moi(){
		ruutu1 = kasvata(ruutu1);
		System.out.println("kasvoiko" + " " + ruutu1);
		ruutu1 = kasvata(ruutu1);
		System.out.println("kasvoiko" + " " + ruutu1);
	}
	// jos X on ruudussa 1. vasen yläkulma.
	public static void ruutu1(){
		ruutu2 = 1; // kuinka monta suoraan on mahdollista O:n saada
		ruutu3 = 2;
		ruutu4 = 1;
		ruutu5 = 3; // tämä olisi esimerkiksi paras sijoitus O:lle
		ruutu6 = 2;
		ruutu7 = 2;
		ruutu8 = 2;
		ruutu9 = 2;
	}
	// jos X on ruudussa 2.
	public static void ruutu2(){
		ruutu1 = 1;
		ruutu3 = 1;
		ruutu4 = 2;
		ruutu5 = 3;
		ruutu6 = 2;
		ruutu7 = 3;
		ruutu8 = 1;
		ruutu9 = 3;
	}
	// jos X on ruudussa 3.
	public static void ruutu3(){
		ruutu1 = 2;
		ruutu2 = 1;
		ruutu4 = 2;
		ruutu5 = 3;
		ruutu6 = 1;
		ruutu7 = 2;
		ruutu8 = 2;
		ruutu9 = 2;
	}
	//.....................noihin pitää tehä jonkinlainen looppi 
	//					   et ei tartte kirjoittaa käsin koko lautaa :D
	
}
