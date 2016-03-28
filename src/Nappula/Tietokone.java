package Nappula;

public class Tietokone {
	
	private static int ruutu1 = 0; //x=1 ja y=3
	private static int ruutu2 = 0; //x=2 ja y=3
	private static int ruutu3 = 0; //x=3 ja y=3
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
	// jos tekis laudan tarkistuksen jolla käydään lista läpi missä on id x ja sit
	// sen mukaan laitettais looppi mihin o:n kannattaa laittaa??
	// Numero meinaa kuinka monta suoraa O:lla on mahdollisuus kyseisestä paikasta muodostaa.
	// Nää voisi tietysti laittaa suoraan pelilauta tai pelaaja luokkaan.
	// X aloitus.
	public static void ruutu(int x, int y){
		if(x== 1 && y==3){
			ruutu5 = 3; // tämä olisi esimerkiksi paras sijoitus O:lle
		}
		if(x==2 && y==3 ){
			ruutu5 = 3; 
			ruutu7 = 3; 
			ruutu9 = 3; 
		}
		if(x==3 && y==3){
			ruutu5 = 3;
		}
		if(x==1 && y==2){
			ruutu5 =3;
		}
		if(x==2 && y==2){
			ruutu1 = 2;
			ruutu3 = 2;
			ruutu7 = 2;
			ruutu9 = 2;
		}
		if(x==3 && y==2){
			ruutu5 = 3;
		}
		if(x==1 && y==1){
			ruutu5 = 3;
		}
		if(x==2 && y==1){
			ruutu5 = 3; 
			ruutu1 = 3; 
			ruutu3 = 3; 
		}
		if(x==3 && y==1){
			ruutu5 = 3;
		}
	}
	//.....................noihin pitää tehä jonkinlainen looppi 
	//					   et ei tartte kirjoittaa käsin koko lautaa :D
	
}
