package ed.estructuras.nolineales;
import java.util.*;
import ed.estructuras.lineales.*;
public class ÁrbolBOLigado<C extends Comparable<C>> extends ColeccionAbstracta<C> implements ÁrbolBinarioOrdenado<C>{
	private NodoBOLigado<C> raiz, hijoI, hijoD;
	protected int size;
	private ListaDoblementeLigada<C> lpre,lin;
	public ÁrbolBOLigado(){
		size=0;	
		raiz = new NodoBOLigado<C>(null,null,null,null);
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
		recorridoInorden(raiz);
		return lin.iterator();
	}
	public void recorridoInorden(NodoBOLigado<C> n){
		lin = new ListaDoblementeLigada<C>();
		if(n==null) return;
		recorridoInorden(n.getHijoI());
		lin.add(n.getDato());
		recorridoInorden(n.getHijoD());
		
	}
    public Iterator<C> getIteradorPreorden(){
		recorridoPreorden(raiz);
		return lpre.iterator();
	}
	public void recorridoPreorden(NodoBOLigado<C> n){
		lpre = new ListaDoblementeLigada<C>();
		if(n==null) return;
		lpre.add(n.getDato());
		recorridoPreorden(n.getHijoI());
		recorridoPreorden(n.getHijoD());
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
	protected NodoBOLigado<C> addNode(C c){
		if(c== null) throw new IllegalArgumentException();

		NodoBOLigado<C> nuevo=null;
		boolean b = true;
		if(isEmpty()){
			raiz.setElemento(c);			
		}else{
			NodoBOLigado<C> n = raiz;
			int i=0;
			while(b){				
				if(c.compareTo(n.getElemento())<0){
						
					if(n.getHijoI()==null){
						nuevo = new NodoBOLigado<C>(null,n,c,null);
						n.setHijoI(nuevo);
						
						b = false;
					}
					if(n.getHijoI() != null)n = n.getHijoI();
				}
				else if(c.compareTo(n.getElemento())>=0){
					System.out.println(c +" es mayor o igual que "+ n.getElemento() );
					if(n.getHijoD()==null){
						nuevo = new NodoBOLigado<C>(null,n,c,null);
						n.setHijoD(nuevo);
						b = false;
					}
					if(n.getHijoD() != null) n = n.getHijoD();
				}			
			}
		}
		return nuevo;
	}//Regresa nodo que tiene de dato al parametro, o null si no lo encuentra.
	public NodoBOLigado<C> buscaDato(C c){
		if(isEmpty()) throw new IllegalStateException();
		if(c==null) throw new IllegalArgumentException();
		NodoBOLigado<C> n = this.getRaíz();
		boolean b = true;
		while(b){
		
			if(n.getDato().compareTo(c)>0){
System.out.println("Todo bien izq");
				if(n.getHijoI() != null) n = n.getHijoI();
				else{
					break;
				}
			}
			else if(n.getDato().compareTo(c)<0){
				System.out.println("Todo bien der");
				if(n.getHijoD() != null) n = n.getHijoD();
				else{
					break;
				}
			}else if(c.equals(n.getDato())){
				
				return n;
			}
		}
		return n;
	}
	public NodoBinario<C> nodoARemover(C c){
		NodoBOLigado<C> r = (NodoBOLigado<C>)buscaDato(c);
		if(r!=null && !r.equals(raiz)) r.getPadre().remueveHijo(r);
		return r;
	}
	@Override
	public Iterator<C> iterator(){
		return getIteradorInorden();
	}
	@Override
	public boolean isEmpty(){
		return size==0;
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
			if(rem.esHoja()){
				rem.getPadre().remueveHijo(rem);
				System.out.println("Se ha removido " + rem.getDato());
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
