package model;

import java.util.ArrayList;

public class CarreraAlgoritmos {
	
	private ArrayList<ArrayLists> vectores;
	private ListaEnlazada primero;
	private ArbolBinario raiz;
	
	public CarreraAlgoritmos() {
		vectores = new ArrayList<ArrayLists>();
		primero = null;
		raiz = null;
	}
	
	public ArrayList<ArrayLists> getVectores(){
		return vectores;
	}
	
	public ListaEnlazada getPrimero() {
		return primero;
	}
	
	public ArbolBinario getRaiz() {
		return raiz;
	}
	
	public void agregarNodoArrayListIterativo( int numero ) {
		ArrayLists nodo = new ArrayLists(numero);
		vectores.add(nodo);
	}
	
	public void agregarNodoListaIterativo( int numero ) {
		ListaEnlazada nodo = new ListaEnlazada(numero);
		if( primero == null ) {
			primero = nodo;
		}else {
			ListaEnlazada temporal = primero;
			while( temporal.getSiguiente() != null ) {
				temporal = temporal.getSiguiente();
			}
			temporal.setSiguiente(nodo);
			nodo.setAnterior(temporal);
		}
	}
	
	public void agregarNodoArbolRecursivo( int numero ) {
		ArbolBinario nodo = new ArbolBinario(numero);
		if( raiz == null ) {
			raiz = nodo;
		}else if( raiz.compareTo(nodo) < 0 ) {
			if( raiz.getHijoIzquierdo() == null ) {
				raiz.setHijoIzquierdo(nodo);
			}else {
				agregarNodoArbolRecursivo(raiz.getHijoIzquierdo(), nodo);
			}
		}else {
			if( raiz.getHijoDerecho() == null ) {
				raiz.setHijoDerecho(nodo);
			}else {
				agregarNodoArbolRecursivo(raiz.getHijoDerecho(), nodo);
			}
		}
	}
	
	private void agregarNodoArbolRecursivo( ArbolBinario actual, ArbolBinario nuevo ) {
		if( actual == null )
			actual = nuevo;
		else if( actual.compareTo(nuevo) < 0 ) {
			if( actual.getHijoIzquierdo() == null )
				actual.setHijoIzquierdo(nuevo);
			else
				agregarNodoArbolRecursivo(actual.getHijoIzquierdo(), nuevo);
		}else {
			if( actual.getHijoDerecho() == null )
				actual.setHijoDerecho(nuevo);
			else
				agregarNodoArbolRecursivo(actual.getHijoDerecho(), nuevo);
		}
	}
	
	public ArrayLists buscarNodoArrayListsIterativo( int numero ) {
		ArrayLists nodoBuscado = null;
		boolean encontrado = false;
		if( !(vectores.isEmpty()) ) {
			for( int i = 0 ; i < vectores.size() && !encontrado ; i++ ) {
				if( vectores.get(i).getNumero() == numero ) {
					nodoBuscado = vectores.get(i);
					encontrado = true;
				}
			}
		}
		return nodoBuscado;
	}
	
	public ListaEnlazada buscarNodoListaEnlazadaIterativo( int numero ) {
		ListaEnlazada nodoBuscado = null;
		if( primero != null ) {
			if( primero.getNumero() == numero ) {
				nodoBuscado = primero;
			}else {
				ListaEnlazada temporal = primero;
				boolean encontrado = false;
				while( temporal != null && !encontrado ) {
					if( temporal.getNumero() == numero ) {
						nodoBuscado = temporal;
						encontrado = true;
					}
					temporal = temporal.getSiguiente();
				}
			}
		}
		return nodoBuscado;
	}

}
