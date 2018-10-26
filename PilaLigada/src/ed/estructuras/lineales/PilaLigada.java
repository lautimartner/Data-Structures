package ed.estructuras.lineales;
import java.util.*;
public class PilaLigada<E> extends ColeccionAbstracta<E>  implements IPila<E>{
	private Nodo<E> head;
	private int size;
	/**No hice nada raro en esta clase que deba ser explicado en los comentarios,
	todo deberia ser comprensible a simple vista, si no, mis disculpas por no haber hecho comentarios apropiados**/
	public PilaLigada(){
		size=0;
	}
	public Iterator<E> iterator(){
			return new Iterador();
		}
	public E mira(){
		if(size==0) throw new NoSuchElementException();
		E e = head.getDato();
		return e;	
	}
	public E expulsa(){
		size--;
		E e = head.getDato();
		Nodo<E> temp = head.getSiguiente();
		head = temp;
		return e;
	}
	public void empuja(E e){
		if (e == null) throw new IllegalArgumentException("Pon algo valido");
		Nodo<E> nehead = new Nodo<> (e,head);
		head = nehead;
		size++;
	}
	public boolean add(E e){
		empuja(e);
		return true;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public int size(){
		return size;
	}
	private class Iterador implements Iterator<E>{
		private Nodo<E> sig;
		private int contador;	
		private Iterador(){
			sig=head;
			contador = 1;
		}
		public E next(){
			if(!(this.hasNext())) throw new NoSuchElementException("No hay siguiente");
			E result = sig.getDato();
			sig = sig.getSiguiente();
			contador++;
			return result;
		}
		public boolean hasNext(){
			return sig != null;
		}
		
	}


}
