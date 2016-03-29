package Nappula;

import java.util.ArrayList;

public class Tietokone {
	
	// jos tekis laudan tarkistuksen jolla k‰yd‰‰n lista l‰pi miss‰ on id x ja sit
	// sen mukaan laitettais looppi mihin o:n kannattaa laittaa??
	// Numero meinaa kuinka monta suoraa O:lla on mahdollisuus kyseisest‰ paikasta muodostaa.
	// N‰‰ voisi tietysti laittaa suoraan pelilauta tai pelaaja luokkaan.
	// X aloitus.
	public static void ruutu(ArrayList<Nappula> nappulat){
		//t‰h‰n pakko olla joku j‰rkev‰mpi keino.. noit vaihtoehtoi tulee ihan sairaast ja jos lauta suurenee ni sit viel lis‰‰..
		for(int i=0; i<nappulat.size(); i++){
			for(int j=0; j<nappulat.size(); j++){
				for(int k=0; k<nappulat.size(); k++){
					if(nappulat.get(i).getX() == 1 && nappulat.get(i).getY() == 3 && nappulat.get(i).getId() == 'x');{
						if(nappulat.get(j).getX() == 2 && nappulat.get(j).getY() == 3 && nappulat.get(j).getId() == 'x'){
							if(nappulat.get(k).getX() == 3 && nappulat.get(k).getY() == 3 && nappulat.get(k).getId() == ' '){
								//palauttaa O:n 3,3 kohtaan..
							}
						}
						else if(nappulat.get(j).getX() == 2 && nappulat.get(j).getY() == 3 && nappulat.get(j).getId() == ' '){
							if(nappulat.get(k).getX() == 3 && nappulat.get(k).getY() == 3 && nappulat.get(k).getId() == 'x'){
								//palauttaa O:n 2,3 kohtaan..
							}
						}
					}
				}
			}
		}
//		}	
//		if(x==1 && y == 3){		
//			ruutu5 = 3; // t‰m‰ olisi esimerkiksi paras sijoitus O:lle
//		}
//		if(x==2 && y==3 ){
//			ruutu5 = 3; 
//			ruutu7 = 3; 
//			ruutu9 = 3; 
//		}
//		if(x==3 && y==3){
//			ruutu5 = 3;
//		}
//		if(x==1 && y==2){
//			ruutu5 =3;
//		}
//		if(x==2 && y==2){
//			ruutu1 = 2;
//			ruutu3 = 2;
//			ruutu7 = 2;
//			ruutu9 = 2;
//		}
//		if(x==3 && y==2){
//			ruutu5 = 3;
//		}
//		if(x==1 && y==1){
//			ruutu5 = 3;
//		}
//		if(x==2 && y==1){
//			ruutu5 = 3; 
//			ruutu1 = 3; 
//			ruutu3 = 3; 
//		}
//		if(x==3 && y==1){
//			ruutu5 = 3;
		}
	}
	//.....................noihin pit‰‰ teh‰ jonkinlainen looppi 
	//					   et ei tartte kirjoittaa k‰sin koko lautaa :D
	

