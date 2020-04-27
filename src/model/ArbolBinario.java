package model;

public class ArbolBinario extends Nodo implements Comparable<ArbolBinario>{
	
	private ArbolBinario hijoIzquierdo;
	private ArbolBinario hijoDerecho;
	
	public ArbolBinario( long numero ) {
		super(numero);
		hijoIzquierdo = null;
		hijoDerecho = null;
	}
	
	public void setHijoIzquierdo( ArbolBinario otroArbol ) {
		hijoIzquierdo = otroArbol;
	}
	
	public void setHijoDerecho( ArbolBinario otroArbol ) {
		hijoDerecho = otroArbol;
	}
	
	public ArbolBinario getHijoIzquierdo() {
		return hijoIzquierdo;
	}
	
	public ArbolBinario getHijoDerecho() {
		return hijoDerecho;
	}

	@Override
	public int compareTo(ArbolBinario otroArbol) {
		int resultado = 0;
		if( getNumero() < otroArbol.getNumero() ) {
			resultado = -1;
		}else if( getNumero() > otroArbol.getNumero() ) {
			resultado = 1;
		}
		return resultado;
	}
	
}
