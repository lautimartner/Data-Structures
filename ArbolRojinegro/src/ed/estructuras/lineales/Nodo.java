package ed.estructuras.lineales;
import java.util.*;
class Nodo<E>{
	private Nodo<E> siguiente, anterior;
	private E dato;
	/**Esta clase contiene la implementacion de los 
	nodos guardados en una lista ligada junto a los getters y setters **/
	public Nodo(E e){
		dato=e;
	}
	public Nodo(E dat, Nodo<E> nod){
		dato = dat;
		siguiente = nod;
	}
	public Nodo(Nodo<E> ant, E dat, Nodo<E> sig){
		siguiente = sig;
		anterior = ant;
		dato = dat;
	}
	public Nodo<E> getSiguiente(){
		return siguiente;
	}
	public void setDato(E datito){
		dato = datito;
	}
	public void setSiguiente(Nodo<E> nodito){
		siguiente = nodito;
	}
	public E getDato(){
		return dato;
	}
	public Nodo<E> getAnterior(){
		return anterior;
	}
	public void setAnterior(Nodo<E> ant){
		anterior = ant;
	}
}
