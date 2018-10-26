package ed.estructuras.nolineales;

public class ÁrbolAVL<C extends Comparable<C>> extends ÁrbolBOLigado<C>{
	private NodoAVL<C> root;
	private int tam;
	public ÁrbolAVL(){
		tam = 0;
		root = new NodoAVL<C>(null,null,null,null);
	}
	@Override
	public boolean isEmpty(){
		return tam==0;
	}
	public NodoAVL<C> getRaíz(){
		return root;
	}
	@Override
	public boolean add(C c){
		if(c== null) throw new IllegalArgumentException();

		NodoAVL<C> nuevo;
		boolean b = true;
		if(isEmpty()){
			root.setElemento(c);			
		}else{
			NodoAVL<C> n = root;
			int i=0;
			while(b){				
				if(c.compareTo(n.getElemento())<0){
						
					if(n.getHijoI()==null){
						nuevo = new NodoAVL<C>(null,n,c,null);
						n.setHijoI(nuevo);
						
						b = false;
					}
					if(n.getHijoI() != null)n = n.getHijoI();
				}
				else if(c.compareTo(n.getElemento())>=0){
				
					if(n.getHijoD()==null){
						nuevo = new NodoAVL<C>(null,n,c,null);
						n.setHijoD(nuevo);
						b = false;
					}
					if(n.getHijoD() != null) n = n.getHijoD();
				}			
			}
			while(n!=null){
				n.actualizaAltura();
				n.setFB();
				NodoAVL<C> nodo=n.balancea();
				
				if(nodo.getPadre()== null) root = nodo;
				n = n.getPadre();
			}
		}
		tam++;
		return true;
	}
	@Override	
	public boolean remove(C c){
	if(c==null) throw new IllegalArgumentException();
		NodoAVL<C> rem = buscaDato(c);	
		NodoAVL<C> temp = rem;	
		if(rem!= null){
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
				NodoAVL<C> sucesor = rem.encuentraSucesor();
				C datsuc = sucesor.getDato();
				C datrem = rem.getDato();
				sucesor.setElemento(datrem);
				rem.setElemento(datsuc);
				remove(datrem);
			}
		}else{
			throw new IllegalArgumentException("El elemento que quiere remover no esta en el arbol");
		}
		
		tam--;
		return true;
	}
	//Regresa nodo que tiene de dato al parametro, o null si no lo encuentra.
	public NodoAVL<C> buscaDato(C c){
		if(isEmpty()) throw new IllegalStateException();
		if(c==null) throw new IllegalArgumentException();
		NodoAVL<C> n = this.getRaíz();
		boolean b = true;
		while(b){
		
			if(n.getDato().compareTo(c)>0){
				if(n.getHijoI() != null) n = n.getHijoI();
				else{
					break;
				}
			}
			else if(n.getDato().compareTo(c)<0){
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
	
}
