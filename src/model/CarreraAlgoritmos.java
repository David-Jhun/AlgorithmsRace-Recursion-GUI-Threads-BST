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
	
	public void agregarNodoArrayListIterativo( long numero ) {
		ArrayLists nodo = new ArrayLists(numero);
		vectores.add(nodo);
	}
	
	public void agregarNodoListaIterativo( long numero ) {
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
	
	public void agregarNodoArbolRecursivo( long numero ) {
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
	
	public boolean buscarNodoArrayListsIterativo( long numero ) {
		boolean encontrado = false;
		if( !(vectores.isEmpty()) ) {
			for( int i = 0 ; i < vectores.size() && !encontrado ; i++ ) {
				if( vectores.get(i).getNumero() == numero ) {
					encontrado = true;
				}
			}
		}
		return encontrado;
	}
	
	public boolean buscarNodoListaEnlazadaIterativo( long numero ) {
		boolean encontrado = false;
		if( primero != null ) {
			if( primero.getNumero() == numero ) {
				encontrado = true;
			}else {
				ListaEnlazada temporal = primero;
				while( temporal != null && !encontrado ) {
					if( temporal.getNumero() == numero ) {
						encontrado = true;
					}
					temporal = temporal.getSiguiente();
				}
			}
		}
		return encontrado;
	}
	
	public boolean eliminarNodoArrayListIterativo( long numero ) {
		boolean eliminado = false;
		if( !(vectores.isEmpty()) ) {
			for( int i = 0 ; i < vectores.size() && !eliminado ; i++ ) {
				if( vectores.get(i).getNumero() == numero ) {
					vectores.remove(i);
					eliminado = true;
				}
			}
		}
		return eliminado;
	}
	
	public void iniciarAgregar( int numero ) {
		
	}
	
	public void iniciarBuscar( int numero ) {
		
	}
	
	public void iniciarEliminar( int numero ) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
