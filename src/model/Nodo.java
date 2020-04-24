package model;

public abstract class Nodo {
	
	private int numero;
	
	public Nodo( int numero ) {
		this.numero = numero;
	}
	
	public Nodo() {
		numero = 0;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void setNumero( int numero ) {
		this.numero = numero;
	}
	
}
