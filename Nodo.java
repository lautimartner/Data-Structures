package ed.estructuras.lineales;
class Nodo<E>{
	private Nodo<E> nodo;
	private E dato;
	/**Esta clase contiene la implementacion de los 
	nodos guardados en una lista ligada junto a los getters y setters **/
	public Nodo(E e){
		dato=e;
	}
	public Nodo(E dat, Nodo<E> nod){
		dato = dat;
		nodo = nod;
	}
	public Nodo<E> getSiguiente(){
		return nodo;
	}
	public void setDato(E datito){
		dato = datito;
	}
	public void setSiguiente(Nodo nodito){
		nodo = nodito;
	}
	public E getDato(){
		return dato;
	}
}
