package Pelilauta;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * Luokka on t‰ll‰ hetkell‰ erroris, kun nappi ei toimi en‰‰ n‰in.
 * Mutta pit‰‰ koittaa kytkee n‰‰ s‰‰nnˆt tohon uuteen grafiikkaan.
 */

import Nappula.Nappula;
import Nappula.Tietokone;
public class Pelilauta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	public static ArrayList<Nappula> nappulat = new ArrayList<>();
	
	private static char voittaja = 'T';
	private static int[] taulukko = new int[2]; //Taulukko indeksi 0 = x, 1= O;
	
	//Tulostus kopioitu suoraan shakkiprojektista
	public static void piirraLauta(){
		int riviNumero = 3;
		for (int y = 3; y >= 1; y--){
			System.out.print(riviNumero + "|");
			riviNumero--;
			for (int x = 1; x <= 3; x++){
				System.out.print(" "+haeNappula(x ,y)+ " ");
			}
			System.out.println("");
		}
		
		System.out.println("  ---------");
		System.out.println("   1  2  3");
	
	}
	public static void voittajanPisteet(){
		if(Pelilauta.annaVoittaja() == 'X')
		{taulukko[0]++;}
		
		if(Pelilauta.annaVoittaja() == 'O')
		{taulukko[1]++;}
	}
	
	public static int getVoittajaX(){
		return taulukko[0];
	}
	
	public static int getVoittajaO(){
		return taulukko[1];
	}
	
	public static void tyhjennaLauta(){
			nappulat.removeAll(nappulat);
			Tietokone.tyhjennaSiirtoLista();
		
	}
	public static void lisaaLautaan(Nappula uusi){
		nappulat.add(uusi);
		Tietokone.lisaaSiirtoListaan();
		Tietokone.laske();
		Tietokone.testArvot();
		AiPelaaVuoro();
		piirraLauta();
		
	}
	public static void AiPelaaVuoro(){	
		if(tarkastaLauta()==false){
		if(TicTacToeFrame.getVuoro() % 2 == 1){
			TicTacToeFrame.teePainallus(Tietokone.suurinArvo());
			System.out.println("indeksi: " + Tietokone.suurinArvo());
		}
		}
	}
	
	//T‰ll‰ testataan onko jossain koordinaatissa jokin nappula
	private static char haeNappula(int x, int y){
	
		for (Nappula nappula : nappulat){
			if (nappula.getX() == x && nappula.getY() == y){
				
				return nappula.getId();
				
			}
			
		}
		return 'o';
	}
	
	
	//K‰y nappula listan l‰pi ja tarkistaa onko ruutu annetuilla koordinaateilla vapaa
	public static boolean ruutuVapaa(int x, int y){
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
	
	public static char annaVoittaja(){
		return voittaja;
	}
	
	public static boolean onkoTasapeli(){
		if (nappulat.size() == 9){
			return true;
		} 
		return false;
	}
	
	/*
	 * Koko laudan tarkistus kerralla. 
	 * Voi k‰ytt‰‰ jokaisen siiron j‰lkeen tarkistamaan p‰‰ttyykˆ peli.
	 * Kutsuu vaaka- ,pysty- ja vinojen- rivien tarkistusmetodeita. 
	 * Palauttaa true jos joltain rivilt‰ lˆytyy kolme samaa nappulaa.
	*/
	public static boolean tarkastaLauta(){

		if(tarkastaYlinVaakarivi()){
			voittaja = haeNappula(1,3);
			return true;
		}
		if(tarkastaKeskimm‰inenVaakarivi()){
			voittaja = haeNappula(1,2);
			return true;
		}
		if(tarkastaAlinVaakarivi()){
			voittaja = haeNappula(1,1);
			return true;
		}
		if(tarkastaVasenPystyrivi()){
			voittaja = haeNappula(1,3);
			return true;
		}
		if(tarkastaKeskiPystyrivi()){
			voittaja = haeNappula(2,3);
			return true;
		}
		if(tarkastaOikeaPystyrivi()){
			voittaja = haeNappula(3,3);
			return true;
		}
		if(tarkastaVinoVasenalaOikeayla()){
			voittaja = haeNappula(3,3);
			return true;
		}
		if(tarkastaVinoVasenylaOikeaala()){
			voittaja = haeNappula(1,3);
			return true;
		}
		
		return false;
	}
	
	/*
	 * Tarkistaa ensin mik‰ nappulan id on koordinaattipisteess‰ (1,3).
	 * Sen j‰lkeen vertaa lˆytyykˆ (2,3) ja (3,3) sama id.
	 * Jos lˆytyy palautetaan true.
	*/
	public static boolean tarkastaYlinVaakarivi(){
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
	
	/*
	 * Tarkistaa ensin mik‰ nappulan id on koordinaattipisteess‰ (1,1).
	 * Sen j‰lkeen vertaa lˆytyykˆ (2,1) ja (3,1) sama id.
	 * Jos lˆytyy palautetaan true.
	*/
	public static boolean tarkastaAlinVaakarivi(){
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
	
	/*Tarkistaa ensin mik‰ nappulan id on koordinaattipisteess‰ (1,2).
	 * Sen j‰lkeen vertaa lˆytyykˆ (2,2) ja (3,2) sama id.
	 * Jos lˆytyy palautetaan true.
	*/
	public static boolean tarkastaKeskimm‰inenVaakarivi(){
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
	/*
	 * Tarkistaa ensin mik‰ nappulan id on koordinaattipisteess‰ (1,1).
	 * Sen j‰lkeen vertaa lˆytyykˆ (1,2) ja (1,3) sama id.
	 * Jos lˆytyy palautetaan true.
	*/
	public static boolean tarkastaVasenPystyrivi(){
		int laskuri = 0;
		char id = 'e'; // 'e' empty aluksi
		for (Nappula nappula : nappulat){
			
			if (nappula.getX() == 1 && nappula.getY() == 1){
				id = nappula.getId();
			}
		}
		
		for (Nappula nappula : nappulat){
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
	 * Tarkistaa ensin mik‰ nappulan id on koordinaattipisteess‰ (2,1).
	 * Sen j‰lkeen vertaa lˆytyykˆ (2,2) ja (2,3) sama id.
	 * Jos lˆytyy palautetaan true.
	*/
	public static boolean tarkastaKeskiPystyrivi(){
		int laskuri = 0;
		char id = 'e'; // 'e' empty aluksi
		for (Nappula nappula : nappulat){
			
			if (nappula.getX() == 2 && nappula.getY() == 1){
				id = nappula.getId();
			}
		}
		
		for (Nappula nappula : nappulat){
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
	 * Tarkistaa ensin mik‰ nappulan id on koordinaattipisteess‰ (3,1).
	 * Sen j‰lkeen vertaa lˆytyykˆ (3,2) ja (3,3) sama id.
	 * Jos lˆytyy palautetaan true.
	*/
	public static boolean tarkastaOikeaPystyrivi(){
		int laskuri = 0;
		char id = 'e'; // 'e' empty aluksi
		for (Nappula nappula : nappulat){
			
			if (nappula.getX() == 3 && nappula.getY() == 1){
				id = nappula.getId();
			}
		}
		
		for (Nappula nappula : nappulat){
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
	 * Tarkistaa ensin mik‰ nappulan id on koordinaattipisteess‰ (1,1).
	 * Sen j‰lkeen vertaa lˆytyykˆ (2,2) ja (3,3) sama id.
	 * Jos lˆytyy palautetaan true.
	*/
	public static boolean tarkastaVinoVasenalaOikeayla(){
		int laskuri = 0;
		char id = 'e'; // 'e' empty aluksi
		for (Nappula nappula : nappulat){
			
			if (nappula.getX() == 1 && nappula.getY() == 1){
				id = nappula.getId();
			}
		}
		
		for (Nappula nappula : nappulat){
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
	 * Tarkistaa ensin mik‰ nappulan id on koordinaattipisteess‰ (1,3).
	 * Sen j‰lkeen vertaa lˆytyykˆ (2,2) ja (3,1) sama id.
	 * Jos lˆytyy palautetaan true.
	*/
	public static boolean tarkastaVinoVasenylaOikeaala(){
		int laskuri = 0;
		char id = 'e'; // 'e' empty aluksi
		for (Nappula nappula : nappulat){
			
			if (nappula.getX() == 1 && nappula.getY() == 3){
				id = nappula.getId();
			}
		}
		
		for (Nappula nappula : nappulat){
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
	public static void save(){
		saveGame(taulukko);
	}
	public static void load(){
		taulukko = loadGame();
	}
	/**
	 * Method uses a serializable interface to save the pieces from the ArrayList to file.
	 * Method has an IOException.
	 * @param object
	 */
	public static void saveGame(int [] taulukko) {
	
		try {
			FileOutputStream fos = new FileOutputStream("Test.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(taulukko);
			oos.flush();
			oos.close();
			fos.close();
			System.out.println("Chessboard is saved in Test.ser");
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	/**
	 * Method uses a serializable interface to load the pieces from the file.
	 * Method has an IOException and a ClassNotFoundException. 
	 * @return object
	 */
	public static int[] loadGame() {
		int[] taulukko = new int[2];
		try {
			FileInputStream fis = new FileInputStream("Test.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			taulukko = (int[]) ois.readObject();
			ois.close();
			fis.close();
			return taulukko;
		}
		catch (IOException i) {
			i.printStackTrace();
			return null;
		}
		catch (ClassNotFoundException c) {
			System.out.println("Class not found");
			c.printStackTrace();
			return null;
		}
	}	
}

