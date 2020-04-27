package model;

public abstract class Nodo {
	
	private long numero;
	
	public Nodo( long numero ) {
		this.numero = numero;
	}
	
	public Nodo() {
		numero = 0;
	}
	
	public long getNumero() {
		return numero;
	}
	
	public void setNumero( long numero ) {
		this.numero = numero;
	}
	
}
