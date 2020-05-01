package model;

import java.util.ArrayList;
import java.util.Random;

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
	
	public void agregarNodoArrayList( long numero ) {
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
	
	public void agregarNodoArbolIterativo( long numero ) {
		ArbolBinario nodo = new ArbolBinario(numero);
		if( raiz == null ) {
			raiz = nodo;
		}else {
			ArbolBinario actual = raiz;
			ArbolBinario padre = null;
			boolean agregado = false;
			while( !agregado ) {
				padre = actual;
				if( actual.getNumero() > numero ) {
					actual = actual.getHijoIzquierdo();
					if( actual == null ) {
						padre.setHijoIzquierdo(nodo);
						agregado = true;
					}
				}else if( actual.getNumero() < numero ){
					actual = actual.getHijoDerecho();
					if( actual == null ) {
						padre.setHijoDerecho(nodo);
						agregado = true;
					}
				}
			}
		}
	}
	
	public void agregarNodoListaRecursivo( long numero ) {
		ListaEnlazada nodo = new ListaEnlazada(numero);
		if( primero == null ) {
			primero = nodo;
		}else {
			agregarNodoListaRecursivo(nodo, primero.getSiguiente());
		}
	}
	
	private void agregarNodoListaRecursivo( ListaEnlazada nodo, ListaEnlazada actual ) {
		if( actual == null ) {
			actual = nodo;
		}else {
			agregarNodoListaRecursivo(nodo, actual.getSiguiente());
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
	
	public boolean buscarNodoListaIterativo( long numero ) {
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
	
	public boolean buscarNodoArbolIterativo( long numero ) {
		boolean encontrado = false;
		if( raiz != null ) {
			if( raiz.getNumero() == numero ) {
				encontrado = true;
			}else {
				boolean terminado = false;
				ArbolBinario temporal = raiz;
				while( !( temporal.getNumero() == numero ) && !terminado ) {
					if( temporal.getNumero() < numero ) {
						temporal = temporal.getHijoIzquierdo();
					}else {
						temporal = temporal.getHijoDerecho();
					}
					if( temporal == null ) {
						terminado = true;
					}
				}
				if( temporal != null ) {
					if( temporal.getNumero() == numero ) {
						encontrado = true;
					}
				}
			}
		}
		return encontrado;
	}
	
	public boolean buscarNodoArrayListsRecursivo( long numero, int indice ) throws IndexOutOfBoundsException{
		boolean encontrado = false;
		if( !(vectores.isEmpty()) ) {
			if( indice > vectores.size() ) {
				throw new IndexOutOfBoundsException();
			}else if( indice < vectores.size() ){
				if( vectores.get(indice).getNumero() == numero ) {
					encontrado = true;
				}else {
					encontrado = buscarNodoArrayListsRecursivo(numero, indice++, vectores);
				}
			}
		}
		return encontrado;
	}
	
	private boolean buscarNodoArrayListsRecursivo( long numero, int avance, ArrayList<ArrayLists> buscarAqui ) throws IndexOutOfBoundsException {
		boolean encontrado = false;
		if( !( buscarAqui.isEmpty() ) ) {
			if( avance > vectores.size() ) {
				throw new IndexOutOfBoundsException();
			}else if( avance < buscarAqui.size() ) {
				if( buscarAqui.get(avance).getNumero() == numero ) {
					encontrado = true;
				}else {
					encontrado = buscarNodoArrayListsRecursivo(numero, avance++, buscarAqui);
				}
			}
		}
		return encontrado;
	}
	
	public boolean buscarNodoListaRecursivo( long numero ) {
		boolean encontrado = false;
		if( primero != null ) {
			if( primero.getNumero() == numero ) {
				encontrado = true;
			}else {
				encontrado = buscarNodoListaRecursivo(numero, primero.getSiguiente());
			}
		}
		return encontrado;
	}
	
	private boolean buscarNodoListaRecursivo( long numero, ListaEnlazada actual ) {
		boolean encontrado = false;
		if( actual != null ){
			if( actual.getNumero() == numero ) {
				encontrado = true;
			}else {
				encontrado = buscarNodoListaRecursivo(numero, actual.getSiguiente());
			}
		}
		return encontrado;
	}
	
	public boolean buscarNodoArbolRecursivo( long numero ) {
		boolean encontrado = false;
		if( raiz != null ) {
			if( raiz.getNumero() == numero ) {
				encontrado = true;
			}else if( raiz.getNumero() < numero ) {
				encontrado = buscarNodoArbolRecursivo(numero, raiz.getHijoIzquierdo());
			}else {
				encontrado = buscarNodoArbolRecursivo(numero, raiz.getHijoDerecho());
			}
		}
		return encontrado;
	}
	
	private boolean buscarNodoArbolRecursivo( long numero, ArbolBinario actual ) {
		boolean encontrado = false;
		if( actual != null ) {
			if( actual.getNumero() == numero ) {
				encontrado = true;
			}else if( actual.getNumero() < numero ) {
				encontrado = buscarNodoArbolRecursivo(numero, actual.getHijoIzquierdo());
			}else {
				encontrado = buscarNodoArbolRecursivo(numero, actual.getHijoDerecho());
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
	
	public boolean eliminarNodoListaEnlazadaIterativo( long numero ) {
		boolean eliminado = false;
		if( primero != null ) {
			if( primero.getNumero() == numero ) {
				if( primero.getSiguiente() == null ) {
					primero = null;
					eliminado = true;
				}else if( primero.getSiguiente() != null ) {
					primero = primero.getSiguiente();
					primero.getSiguiente().setAnterior(null);
					eliminado = true;
				}
			}else {
				ListaEnlazada anterior = null;
				ListaEnlazada actual = primero;
				boolean encontrado = false;
				while( actual != null && !encontrado ) {
					if( actual.getNumero() == numero ) {
						encontrado = true;
					}
					anterior = actual;
					actual = actual.getSiguiente();
				}
				if( actual != null ) {
					if( actual.getSiguiente() == null ) {
						anterior.setSiguiente(null);
						eliminado = true;
					}else if( actual.getSiguiente() != null ) {
						actual = actual.getSiguiente();
						anterior.setSiguiente(actual);
						actual.setAnterior(anterior);
						eliminado = true;
					}
				}
			}
		}
		return eliminado;
	}
	
	public boolean eliminarNodoArrayListsRecursivo( long numero, int indice ) throws IndexOutOfBoundsException{
		boolean eliminado = false;
		if( !(vectores.isEmpty()) ) {
			if( indice > vectores.size() ) {
				throw new IndexOutOfBoundsException();
			}else if( indice < vectores.size() ){
				if( vectores.get(indice).getNumero() == numero ) {
					vectores.remove(indice);
					eliminado = true;
				}else {
					eliminado = eliminarNodoArrayListsRecursivo(numero, indice++, vectores);
				}
			}
		}
		return eliminado;
	}
	
	private boolean eliminarNodoArrayListsRecursivo( long numero, int indice, ArrayList<ArrayLists> buscaAqui ) throws IndexOutOfBoundsException{
		boolean eliminado = false;
		if( !( buscaAqui.isEmpty() ) ) {
			if( indice > buscaAqui.size() ) {
				throw new IndexOutOfBoundsException();
			}else if( indice < buscaAqui.size() ){
				if( buscaAqui.get(indice).getNumero() == numero ) {
					buscaAqui.remove(indice);
					eliminado = true;
				}else {
					eliminado = eliminarNodoArrayListsRecursivo(numero, indice++, buscaAqui);
				}
			}
		}
		return eliminado;
	}
	
	public void iniciarAgregarIterativo( int numero ) {
		int iterador = 0;
		Random generador = new Random();
		do {
			agregarNodoArrayList(generador.nextLong());
			agregarNodoListaIterativo(generador.nextLong());
			agregarNodoArbolIterativo(generador.nextLong());
			iterador++;
		}while( iterador != numero );
	}
	
	public void iniciarAgregarRecursivo( int numero ) {
		int iterador = 0;
		Random generador = new Random();
		do {
			agregarNodoArrayList(generador.nextLong());
			agregarNodoListaRecursivo(generador.nextLong());
			agregarNodoArbolRecursivo(generador.nextLong());
			iterador++;
		}while( iterador != numero );
	}
	
	public void iniciarBuscarIterativo( int numero ) {
		int iterador = 0;
		Random generador = new Random();
		do {
			buscarNodoArrayListsIterativo(generador.nextLong());
			buscarNodoListaIterativo(generador.nextLong());
			buscarNodoArbolIterativo(generador.nextLong());
			iterador++;
		}while( iterador != numero );
	}
	
	public void iniciarBuscarRecursivo( int numero ) {
		int iterador = 0;
		Random generador = new Random();
		do {
			buscarNodoArrayListsRecursivo(generador.nextLong(), generador.nextInt(vectores.size()));
			buscarNodoListaRecursivo(generador.nextLong());
			buscarNodoArbolRecursivo(generador.nextLong());
			iterador++;
		}while( iterador != numero );
	}
	
	public void iniciarEliminarIterativo( int numero ) {
		int iterador = 0;
		Random generador = new Random();
		do {
			eliminarNodoArrayListIterativo(generador.nextLong());
			eliminarNodoListaEnlazadaIterativo(generador.nextLong());
			iterador++;
		}while( iterador != numero );
	}
	
	public void iniciarEliminarRecursivo( int numero ) {
		int iterador = 0;
		Random generador = new Random();
		do {
			eliminarNodoArrayListsRecursivo(generador.nextLong(), generador.nextInt(vectores.size()));
			iterador++;
		}while( iterador != numero );
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
