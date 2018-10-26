package ed.estructuras.nolineales;
import java.util.*;
import ed.estructuras.lineales.*;
public class ÁrbolBOLigado<C extends Comparable<C>> extends ColeccionAbstracta<C> implements ÁrbolBinarioOrdenado<C>{
	private NodoBOLigado<C> raiz, hijoI, hijoD;
	private int size;
	public ÁrbolBOLigado(){
		size=0;	
		raiz = null;
	}
	protected NodoBinario<C> creaNodo (C dato, NodoBinario<C> padre, NodoBinario<C> hijoI, NodoBinario<C> hijoD){
		NodoBOLigado<C> c = new NodoBOLigado<C>((NodoBOLigado<C>)hijoI,(NodoBOLigado<C>)padre,dato,(NodoBOLigado<C>)hijoD);
		NodoBinario<C> nodo = (NodoBinario<C>) c;
		return c;
	}
	public NodoBOLigado<C> getRaíz(){
		return raiz;
	}
    public Iterator<C> getIteradorInorden(){
		return null;
	}
    public Iterator<C> getIteradorPreorden(){
		return null;
	}
    public Iterator<C> getIteradorPostorden(){
		ListaDoblementeLigada<C> l = (ListaDoblementeLigada<C>) recorridoPostorden();
		return l.iterator();
		
	}
    public List<C> recorridoPostorden(){
		List <C> l = new ListaDoblementeLigada<>();
		boolean bajan = true;
		Nodo<C> actual,hermano;
		actual = raiz;
		while (actual != null) {
			if(bajan) {
			// Llegar al fondo de la rama
				while (!actual.esHoja()){
					actual = actual.getHijo(0);
				}
			}
			l.add(actual.getElemento()); // Visita
			if(actual.getPadre()!= null && // Hermano siguiente
			(hermano = actual.getPadre().getHermanoSiguiente(actual))!= null ){
				actual = hermano ;
				bajan = true ;
			}else{ // Regresa al padre
				actual = actual.getPadre();
				bajan = false ; // Avisar que vamos regresando
			}
		}
		return l;
	}
    public int getAltura(){
		if(raiz ==null) return -1;
		else{
			return raiz.getAltura();
		}
	}
	public boolean add(C c){
		addNode(c);
		size++;
		System.out.println("Todo bien");
		
		return true;
	}
	protected NodoBOLigado<C> addNode(C e){
		NodoBOLigado<C> nuevo=null;		
		if(raiz==null){
			raiz = new NodoBOLigado(null,null,e,null);
			nuevo = raiz;
			System.out.println("Todo bien");
			return nuevo;
		}
		NodoBOLigado<C> n = raiz;
		boolean b = true;
		while(b){
			if(e.compareTo(n.getDato())<0){
				n.actualizaAltura();
				if(n.getHijoI() != null) n = (NodoBOLigado<C>) n.getHijoI();
				else{
					b = false;
				}
			}
			else if(e.compareTo(n.getDato())>=0){
				n.actualizaAltura();
				if(n.getHijoD() != null) n = (NodoBOLigado<C>)n.getHijoD();
				else{
					b = false;
				}
			}
		nuevo = new NodoBOLigado<C>(null,n,e,null);	

		}
		return nuevo;
	}//Regresa nodo que tiene de dato al parametro, o null si no lo encuentra.
	public NodoBOLigado<C> buscaDato(C c){
		NodoBOLigado<C> n = raiz;
		NodoBOLigado<C> res=null;
		boolean b = true;
		while(b){
			if(c.compareTo(n.getDato())<0){
				if(n.getHijoI() != null) n = (NodoBOLigado<C>)n.getHijoI();
				else{
					break;
				}
			}
			else if(c.compareTo(n.getDato())>=0){
				if(n.getHijoD() != null) n = (NodoBOLigado<C>) n.getHijoD();
				else{
					break;
				}
			}
			if(c.equals(n.getDato())){
				res = n;
				break;
			}
		}
		return res;
	}
	public NodoBinario<C> nodoARemover(C c){
		NodoBOLigado<C> r = (NodoBOLigado<C>)buscaDato(c);
		if(r!=null && !r.equals(raiz)) r.getPadre().remueveHijo(r);
		return r;
	}
	@Override
	public Iterator<C> iterator(){
		return null ;
	}
	@Override
	public boolean isEmpty(){
		return raiz == null;
	}
	@Override
	public int size(){
		return size;
	}
	@Override
	public boolean remove(C c){
		if(c==null) throw new IllegalArgumentException();
		NodoBOLigado<C> rem = buscaDato(c);
		if(rem!= null){
			if(c.equals(raiz.getDato())) raiz=null;
			if(rem.esHoja()){
				rem.getPadre().remueveHijo(rem);
			}else if(rem.getGrado() == 1){
				if(rem.getHijoI()!=null && rem.getPadre().getHijoI().equals(rem)){
					rem.getHijoI().setPadre(rem.getPadre());
					rem.getPadre().setHijoI(rem.getHijoI());
				}else if(rem.getHijoD() != null && rem.getPadre().getHijoD().equals(rem)){
					rem.getHijoD().setPadre(rem.getPadre());
					rem.getPadre().setHijoD(rem.getHijoD());
				}else if(rem.getHijoI() != null && rem.getPadre().getHijoD().equals(rem)){
					rem.getHijoI().setPadre(rem.getPadre());
					rem.getPadre().setHijoD(rem.getHijoI());
				}else if(rem.getHijoD() != null && rem.getPadre().getHijoI().equals(rem)){
					rem.getHijoD().setPadre(rem.getPadre());
					rem.getPadre().setHijoI(rem.getHijoD());
				}
			}else if(rem.getGrado()==2){
				NodoBOLigado<C> sucesor = rem.encuentraSucesor();
				C datsuc = sucesor.getDato();
				C datrem = rem.getDato();
				sucesor.setElemento(datrem);
				rem.setElemento(datsuc);
				remove(datrem);
			}
		}else{
			throw new IllegalArgumentException("El elemento que quiere remover no esta en el arbol");
		}
		return true;
	}
	@Override
	public boolean contains(C c) throws NullPointerException{
		return buscaDato(c)!=null;
	}
	
}
