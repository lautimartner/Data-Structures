package ed.estructuras.lineales;
import java.util.*;
public class ColaArreglo<E> extends ColeccionAbstracta<E> implements ICola<E>{
	private int tail=0, head=-1,size=0;
	private E[] buffer;
	private final int DEFAULT_INITIAL_SIZE = 49;
	public ColaArreglo(E[] a, int tamInicial){
		if (a.length !=0 || tamInicial == 0) throw new IllegalArgumentException();
		buffer = Arrays.copyOf(a, tamInicial);
		size = 0;
	}
	public ColaArreglo(E[] a){
		if (a.length != 0) throw new IllegalArgumentException();
		buffer = Arrays.copyOf(a, DEFAULT_INITIAL_SIZE);
		size =0;
	}
	public Iterator<E> iterator(){
		return new Iterador();
	}
	public E mira(){
		if(isEmpty()) return null;
		return buffer[head];	
	}
	public E atiende(){
		if(isEmpty()) return null;
		E elem = buffer[head];
		buffer[head] = null;
		head = (head + 1)%buffer.length;
		size--;
		System.out.println(elem);
		return elem;
	}
	public void forma(E e){
		if(e==null) throw new IllegalArgumentException("pon algo valido");
		if(isEmpty()){

			buffer[tail]=e;
			tail = (tail+1)%buffer.length;
			head = 0;
			size++;
		}else if(tail-1==head){
			agranda();
			buffer[tail] = e;
			tail = (tail + 1) % buffer.length;
			size++;
		}else{
			buffer[tail] = e;
			tail = (tail + 1)%buffer.length;
			size++;
		}
	}
	public E[] getBuffer(){
		return buffer;
	}
	public boolean add(E e){
		forma(e);
		return true;
	}
	public boolean isEmpty(){
		return size==0;
	}
	public int size(){
		return size;
	}
	public void agranda(){
		E[] temp = Arrays.copyOf(buffer, 2*buffer.length);
		for(int j = 0, i = head; j < buffer.length; j++, i = (i+1)%(buffer.length)){
			temp[j] = buffer[i];
		}
		buffer = temp;	
	}
	public void p(){
		for(E e : buffer){
			System.out.print(String.valueOf(e) + " ");
		}
	}
	private class Iterador implements Iterator<E>{
		private int sig;	
		private Iterador(){
			sig=head;
		}
		public E next(){
			if(!(this.hasNext())) throw new NoSuchElementException("No hay siguiente");
			E result = buffer[sig];
			sig = (sig + 1) % buffer.length;
			return result;
		}
		public boolean hasNext(){
			return (tail==head);
		}
		
	}
}	
