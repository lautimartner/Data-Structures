package ed.estructuras.lineales;
import java.util.*;
public class ListaDoblementeLigada<E> extends ColeccionAbstracta<E> implements List<E>{
	private int size;
	private Nodo<E> head, last;
	private E dato;
	public ListaDoblementeLigada(){
		size = 0;
	}
	//Regresa el tamaño
	public int size(){
		return size;
	}
	//regresa si esta vacia o no
	public boolean isEmpty(){
		return size==0;
	}
	@Override
	public boolean add(E e){
		//Si la lista esta vacia se agrega la cabeza/cola
		if(last==null || head == null){
			head = new Nodo<>(null, e, null);
			last = head;
			size++;
		}else{//Si no esta vacia, se agrega un nuevo nodo al final de la lista
			Nodo<E> cab = new Nodo<>(last,e,null);
			last.setSiguiente(cab);
			last= cab;
			size++;
		}
		return true;	
	}
	@Override
	public void add(int index, E element){
		//Si el indice no es valido se manda una excepcion
		if(index<0 || index >size+1) throw new IllegalArgumentException();	
		if(index == 0 && !isEmpty()){//Si se intenta agregar al inicio y la lista no esta vacia
			Nodo<E> nuevo = new Nodo<>(null,element,head);
			head=nuevo;
			size++;
		}
		Nodo <E> temp = head;
		if(index==size || (index==0 && isEmpty())){//si se intenta agregar al final o al inicio y la lista esta vacia usamos al metodo anterior
			add(element);
		}else{
			//Si se intenta agregar en medio de la lista, ponemos a un nodo temporal en la posicion que se intenta agregar al otro
			//nodo en insertamos otro nodo enfrente.
			for(int i = 1; i <=index; i++){
				temp = temp.getSiguiente();
			}
			Nodo<E> tempo = temp;
			Nodo<E> nuevo = new Nodo<>(temp,element,temp.getSiguiente());
			temp.setSiguiente(nuevo);
			tempo.getSiguiente().setAnterior(nuevo);
			size++;
		}
	}
	@Override
	public List<E> subList(int fromIndex, int toIndex){
		if(toIndex>size || fromIndex < 0) throw new NoSuchElementException();
		Nodo<E> temp =head;
		int i = 0;		
		ListaDoblementeLigada<E> l = new ListaDoblementeLigada<>();
		while(i<fromIndex){//Se posiciona una variable temporal en la posicion donde comenzara la sublista
			temp = temp.getSiguiente();
			i++;
		}
		while(i>fromIndex && i <toIndex){//Se agregan los elementos correspondientes a la sublista
			l.add(temp.getDato());
			temp = temp.getSiguiente();
			i++;
		}
		return l;
	}
	@Override
	public Iterador iterator(){
		return new Iterador();
	}
	@Override
	public ListIterator<E> listIterator(){
		ListIterator<E> it = iterator();
		return it;
	}
	@Override
	public ListIterator<E> listIterator(int e){
		Iterador it = new Iterador();
		int i = 0;
		ListIterator<E> ite = it;
		while(i < e){
			ite.next();
			i++;
		}
		return ite;
	}
	@Override
	public int lastIndexOf(Object o){
		Nodo<E> temp =head;
		int res = -1;
		int i = 0;
		while (i<size){//Itera sobre toda la lista y va guardando en la misma variable la ultima ocurrencia del objeto
			if(temp.getDato() == o) res = i;
			if(i==size+1) return -1;
			temp = temp.getSiguiente();
			i++;
		}
		return res;
	}
	@Override
	public int indexOf(Object o){
		Nodo<E> temp =head;
		int i = 0;
		while (i<size){//Itera sobre toda la lista hasta encontrar el objeto
			if(temp.getDato().equals(o)) break;
			i++;
			temp = temp.getSiguiente();
		}
		if(i==size) return -1;
		return i;
	}
	@Override
	public E remove(int index){
		if(isEmpty()) throw new NoSuchElementException();
		Nodo<E> temp = head;
		if(index==0){//Si el elemento es la cabeza
			E dato = head.getDato();
			head.getSiguiente().setAnterior(null);
			head = temp.getSiguiente();
		}else if(index==size-1){//Si el elemento es el ultimo
			E dato = last.getDato();
			last.getAnterior().setSiguiente(null);
			last = last.getAnterior();
		}else{// si el elemento esta en medio
			for(int i = 1;i<=index;i++){
				if (i==index){
					E dato = temp.getDato();
					temp.getAnterior().setSiguiente(temp.getSiguiente());
					temp.getSiguiente().setAnterior(temp.getAnterior());
					
				}
				temp = temp.getSiguiente();
			}
		}
		size--;
		return dato;
	}
	@Override
	public boolean remove(Object o){
		if(o == null) throw new IllegalArgumentException();
		boolean en = false;
		Nodo<E> temp = head;
		int i = 1;
		while(i<=size){//Este while es para iterar sobre la lista hasta encontrar el objeto a remover
			
			if(head.getDato().equals(o) && !head.equals(last)){
				en = true;
				head.getSiguiente().setAnterior(null);
				head = temp.getSiguiente();
				break;
			}else if(last.getDato().equals(o) && !head.equals(last)){
				en = true;
				last.getAnterior().setSiguiente(null);
				last = temp.getAnterior();
				break;
			}else if(temp.getDato().equals(o)){
				en = true;
				if (size==1){
					head = null;
					last = null;
					return true;
				}
				temp.getAnterior().setSiguiente(temp.getSiguiente());
				temp.getSiguiente().setAnterior(temp.getAnterior());
				break;
				
			}
			i++;
			if(temp.getSiguiente()!= null){
				temp = temp.getSiguiente();
			}
		}

		size--;
		return en;
	}
	@Override
	public E set(int index, E element){
		if(index>size || index < 0) throw new NoSuchElementException();
		Nodo<E> temp =head;
		for(int i = 1; i<=index; i++){
			temp = temp.getSiguiente();
		}
		E dato = get(index);
		temp.setDato(element);
		return dato;
	}
	@Override
	public E get(int index){
		if(index>size || index < 0) throw new NoSuchElementException();
		Nodo<E> temp =head;
		for(int i = 1; i<=index; i++){
			temp = temp.getSiguiente();
		}
		return temp.getDato();
	}
	@Override
	public boolean addAll(int index, Collection<? extends E> c){
		if(index>size || index < 0) throw new NoSuchElementException();
		Nodo<E> temp =head;
		for(int i = 0; i<=index; i++){
			temp = temp.getSiguiente();
		}
		for(E e:c){
			add(e);
		}
		return true;
	}
	



	//Clase que tiene la implementacion de un Iterador que itera sobre la lista
	private class Iterador implements ListIterator<E>{
		private int estado, iAnterior;
		private Nodo<E> ant,sig;
		//Iterador que empieza desde el principio y va al final
		public Iterador(){
			iAnterior = -1;
			ant = null;
			sig = head;
			estado = 0;
		}
		//Iterador  que empieza desde el final y va hacia el principio
		public Iterador(boolean reversa){			
			iAnterior = size-1;
			ant = last;
			sig = null;
			estado = 0;
		}
		@Override
		//Agrega un elemento en la posicion del iterador
		public void add(E e){
			if (isEmpty()){
				head = new Nodo<>(null, e, null);
				last = head;
				ant = head;
				size++;
			}else if(ant == null){//El iterador está al inicio
				Nodo<E> temp = new Nodo<>(e,head);
				head.setAnterior(temp);
				head = temp;
				ant = temp;	
				size++;			
			}else if(sig == null){ //El iterador esta al final
				Nodo<E> temp = new Nodo<>(last,e,null);
				last.setSiguiente(temp);
				last = temp;
				sig = temp;
				size++;
			}else{
				Nodo<E> temp = new Nodo<>(ant,e,sig);
				ant.setSiguiente(temp);
				sig.setAnterior(temp);
				ant = temp;
				size++;
			}
		}
		@Override
		public E next(){
			if (!this.hasNext()) throw new NoSuchElementException();
			E ret = sig.getDato();
			ant = sig;
			sig = sig.getSiguiente();
			iAnterior++;
			estado = 1;
			return ret;
		}
		@Override
		public E previous(){
			if(!this.hasPrevious()) throw new NoSuchElementException();
			E ret = ant.getDato();
			sig = ant;
			ant = ant.getAnterior();
			iAnterior --;
			estado = -1;
			return ret;
		}
		@Override
		public boolean hasNext(){
			return sig!=null; 
		}
		@Override
		public boolean hasPrevious(){
			return ant!=null;
		}
		@Override
		public void set(E e){
			switch(estado){
				case 0:
					throw new IllegalStateException();
				case -1:
					sig.setDato(e);
					return;
				case 1:
					ant.setDato(e);
					return;
			}
		}
		@Override
		public void remove(){
			switch(estado){
				case 0:
					throw new IllegalStateException();
				case -1://elimina a ant
					Nodo<E> tempo = ant;
					ant.getAnterior().setSiguiente(sig);
					sig.setAnterior(ant.getAnterior());
					ant = tempo.getAnterior();
					size--;
				case 1://elimina a sig
					Nodo<E> temp = sig;
					ant.setSiguiente(temp.getSiguiente());
					sig.getSiguiente().setAnterior(ant);
					sig = temp.getSiguiente();
					size--;
			}
		}
		@Override
		public int nextIndex(){
			return iAnterior + 1;
		}
		@Override
		public int previousIndex(){
			return iAnterior;
		}
	}
}
