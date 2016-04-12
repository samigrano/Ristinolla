package Pelilauta;
	
/*
 * Pelilauta luokassa on metodit pelin konsoli gradiikkaa, 
 * nappuloiden lisäämistä ja voittorivien tarkistamista varten.
 * Luokassa on myös pistelasku taulukko.
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import Nappula.Nappula;
import Nappula.Pelaaja;
import Nappula.Tietokone;
public class Pelilauta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	public static ArrayList<Nappula> nappulat = new ArrayList<>();
	
	private static char voittaja = 'T';
	private static int[] taulukko = new int[2]; //Taulukko indeksi 0 = x, 1= O;
	
	//Laudan piirto metodi.
	/**
	 * Method draws a game board.
	 */
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
	// Lisää voittajalle pisteen taulukkoon joka tulostetaan pelin jälkeen näkyviin. 
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
	
	/**
	 * Method clear the board.
	 */
	public static void tyhjennaLauta(){
			nappulat.removeAll(nappulat);
			Tietokone.tyhjennaSiirtoLista();
		
	}
	
	//Ohjaa tietokoneen pelaamista.
	/**
	 * Method add a new button to the board and use the AI calculation method.
	 * @param uusi
	 */
	public static void lisaaLautaan(Nappula uusi){
		if(!Pelaaja.totuus){
		nappulat.add(uusi);
		Tietokone.lisaaSiirtoListaan();
		Tietokone.laske();
		Tietokone.testArvot();
		AiPelaaVuoro();
		piirraLauta();
		}
	}
	/*
	 * Tekee tietokoneen painalluksen vuorolla, jos peli on yhä käynnissä.
	 * Jos peli on päättynyt ehto estää tietokonetta painamasta.
	 */
	/**
	 * Method check if its a computer turn and if it is, do the click. 
	 */
	public static void AiPelaaVuoro(){	
		if(tarkastaLauta()==false){
		if(TicTacToeFrame.getVuoro() % 2 == 1){
			TicTacToeFrame.teePainallus(Tietokone.suurinArvo());
			System.out.println("indeksi: " + Tietokone.suurinArvo());
		}
		else{TicTacToeFrame.setVuoro();}
		}
	}
	
	//Tällä testataan onko jossain koordinaatissa jokin nappula
	/**
	 * Method get the button from the arraylist.
	 * @param x
	 * @param y
	 * @return
	 */
	private static char haeNappula(int x, int y){
	
		for (Nappula nappula : nappulat){
			if (nappula.getX() == x && nappula.getY() == y){
				return nappula.getId();
			}		
		}
		return 'o';
	}
	
	
	//Käy nappula listan läpi ja tarkistaa onko ruutu annetuilla koordinaateilla vapaa
	/**
	 * Method check is the coordinates free
	 * @param x
	 * @param y
	 * @return
	 */
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
	//Tarkastaa onko tasapeli, kun lauta on täynnä.
	/**
	 * Method check is the board full
	 * @return boolean
	 */
	public static boolean onkoTasapeli(){
		if (nappulat.size() == 9){
			return true;
		} 
		return false;
	}
	
	/*
	 * Koko laudan tarkistus kerralla. 
	 * Voi käyttää jokaisen siiron jälkeen tarkistamaan päättyykö peli.
	 * Kutsuu vaaka- ,pysty- ja vinojen- rivien tarkistusmetodeita. 
	 * Palauttaa true jos joltain riviltä löytyy kolme samaa nappulaa.
	*/
	/**
	 * Method check the boards lines if there a winner 
	 * its return that button object
	 * @return
	 */
	public static boolean tarkastaLauta(){

		if(tarkastaYlinVaakarivi()){
			voittaja = haeNappula(1,3);
			return true;
		}
		if(tarkastaKeskimmäinenVaakarivi()){
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
	 * Tarkistaa ensin mikä nappulan id on koordinaattipisteessä (1,3).
	 * Sen jälkeen vertaa löytyykö (2,3) ja (3,3) sama id.
	 * Jos löytyy palautetaan true.
	*/
	/**
	 * Method checks lines if there is winning situation
	 * @return boolean
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
	 * Tarkistaa ensin mikä nappulan id on koordinaattipisteessä (1,1).
	 * Sen jälkeen vertaa löytyykö (2,1) ja (3,1) sama id.
	 * Jos löytyy palautetaan true.
	*/
	/**
	 * Method checks lines if there is winning situation
	 * @return boolean
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
	
	/*Tarkistaa ensin mikä nappulan id on koordinaattipisteessä (1,2).
	 * Sen jälkeen vertaa löytyykö (2,2) ja (3,2) sama id.
	 * Jos löytyy palautetaan true.
	*/
	/**
	 * Method checks lines if there is winning situation
	 * @return boolean
	 */
	public static boolean tarkastaKeskimmäinenVaakarivi(){
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
	 * Tarkistaa ensin mikä nappulan id on koordinaattipisteessä (1,1).
	 * Sen jälkeen vertaa löytyykö (1,2) ja (1,3) sama id.
	 * Jos löytyy palautetaan true.
	*/
	/**
	 * Method checks lines if there is winning situation
	 * @return boolean
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
	 * Tarkistaa ensin mikä nappulan id on koordinaattipisteessä (2,1).
	 * Sen jälkeen vertaa löytyykö (2,2) ja (2,3) sama id.
	 * Jos löytyy palautetaan true.
	*/
	/**
	 * Method checks lines if there is winning situation
	 * @return boolean
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
	 * Tarkistaa ensin mikä nappulan id on koordinaattipisteessä (3,1).
	 * Sen jälkeen vertaa löytyykö (3,2) ja (3,3) sama id.
	 * Jos löytyy palautetaan true.
	*/
	/**
	 * Method checks lines if there is winning situation
	 * @return boolean
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
	 * Tarkistaa ensin mikä nappulan id on koordinaattipisteessä (1,1).
	 * Sen jälkeen vertaa löytyykö (2,2) ja (3,3) sama id.
	 * Jos löytyy palautetaan true.
	*/
	/**
	 * Method checks lines if there is winning situation
	 * @return boolean
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
	 * Tarkistaa ensin mikä nappulan id on koordinaattipisteessä (1,3).
	 * Sen jälkeen vertaa löytyykö (2,2) ja (3,1) sama id.
	 * Jos löytyy palautetaan true.
	*/
	/**
	 * Method checks lines if there is winning situation
	 * @return boolean
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

