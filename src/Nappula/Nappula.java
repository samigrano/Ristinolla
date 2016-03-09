package Nappula;

public class Nappula {
	
	private char id; // X tai 0
	private int x;
	private int y;
	
	
	public Nappula (char id, int x, int y){
		this.id = id;
		this.x =  x;
		this.y = y;
	}
	
	public Nappula (char id){
		this.id = id;
	}
	
	public char getId() {
		return id;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setId(char id) {
		this.id = id;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	

}

