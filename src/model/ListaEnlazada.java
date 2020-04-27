package model;

public class ListaEnlazada extends Nodo{
	
	private ListaEnlazada anterior;
	private ListaEnlazada siguiente;
	
	public ListaEnlazada( long numero ) {
		super(numero);
		anterior = null;
		siguiente = null;
	}
	
	public void setAnterior( ListaEnlazada nodo ) {
		anterior = nodo;
	}
	
	public ListaEnlazada getAnterior() {
		return anterior;
	}
	
	public void setSiguiente( ListaEnlazada nodo ) {
		siguiente = nodo;
	}
	
	public ListaEnlazada getSiguiente() {
		return siguiente;
	}

}
