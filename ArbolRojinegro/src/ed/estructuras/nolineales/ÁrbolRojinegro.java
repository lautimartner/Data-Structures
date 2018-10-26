package ed.estructuras.nolineales;

public class ÁrbolRojinegro<C extends Comparable<C>> extends ÁrbolBOLigado<C>{
	private NodoRojinegro<C> raiz;
	private int tam;
	public ÁrbolRojinegro(){
		raiz = new NodoRojinegro<C>(null,null,null,null,null);
		raiz.setColor(NodoRojinegro.Color.NEGRO);
		tam=0;
	}
	@Override
	public boolean remove(C c){
		
		return true;
	}
	@Override
	public boolean add(C c){
		if(c== null) throw new IllegalArgumentException();

		NodoRojinegro<C> nuevo= new NodoRojinegro<C>(null,c,NodoRojinegro.Color.NEGRO,null,null);
		boolean b = true;
		if(isEmpty()){
			raiz.setElemento(c);
		}else{
			NodoRojinegro<C> n = raiz;
			int i=0;
			while(b){				
				if(c.compareTo(n.getDato())<0){
					if(n.getHijoI()==null){
						nuevo = new NodoRojinegro<C>(null,c,NodoRojinegro.Color.ROJO,n,null);
						n.setHijoI(nuevo);
						b = false;
					}
					if(n.getHijoI() != null)n = n.getHijoI();
				}
				else if(c.compareTo(n.getDato())>=0){
					if(n.getHijoD()==null){
						nuevo = new NodoRojinegro<C>(null,c,NodoRojinegro.Color.ROJO,n,null);
						n.setHijoD(nuevo);
						b = false;
					}
					if(n.getHijoD() != null) n = n.getHijoD();
				}			
			}
			while(n!=null){
				n.actualizaAltura();
				n=n.getPadre();
			}
			while(nuevo.getPadre()!=null&& nuevo.getPadre().getColor()==NodoRojinegro.Color.ROJO){
				if(nuevo.getPadre() == nuevo.getPadre().getPadre().getHijoI()){
					NodoRojinegro<C> y = nuevo.getPadre().getPadre().getHijoD();
					if(y!= null&& y.getColor()==NodoRojinegro.Color.ROJO){
						nuevo.getPadre().setColor(NodoRojinegro.Color.NEGRO);
						y.setColor(NodoRojinegro.Color.NEGRO);
						nuevo.getPadre().getPadre().setColor(NodoRojinegro.Color.ROJO);
						nuevo=nuevo.getPadre().getPadre();
					}else{
						if(nuevo.getPadre()!= null&& nuevo==nuevo.getPadre().getHijoD()){
							nuevo=nuevo.getPadre();							
							nuevo=nuevo.rotaIzquierda();
						}
						nuevo.getPadre().setColor(NodoRojinegro.Color.NEGRO);
						if(nuevo.getPadre().getPadre()!=null){
							nuevo.getPadre().getPadre().setColor(NodoRojinegro.Color.ROJO);
							nuevo.getPadre().getPadre().rotaDerecha();
						}
					}
				}else{
					NodoRojinegro<C> w = nuevo.getPadre().getPadre().getHijoD();
					if(w.getColor()==NodoRojinegro.Color.ROJO){
						nuevo.getPadre().setColor(NodoRojinegro.Color.NEGRO);
						w.setColor(NodoRojinegro.Color.NEGRO);
						nuevo.getPadre().getPadre().setColor(NodoRojinegro.Color.ROJO);
						nuevo=nuevo.getPadre().getPadre();
					}else{
						if(nuevo==nuevo.getPadre().getHijoI()){
							nuevo=nuevo.getPadre();							
							nuevo=nuevo.rotaDerecha();
						}
						nuevo.getPadre().setColor(NodoRojinegro.Color.NEGRO);
						nuevo.getPadre().getPadre().setColor(NodoRojinegro.Color.ROJO);
						nuevo.getPadre().getPadre().rotaIzquierda();
					}
				}
			}
			if(nuevo!=null){
				while(nuevo.getPadre()!=null) 
					nuevo =nuevo.getPadre();
				raiz=nuevo;
			}
			raiz.setColor(NodoRojinegro.Color.NEGRO);
		}
		tam++;
		return true;
	}
	@Override
	public boolean isEmpty(){
		return tam==0;
	}
	public NodoBinario<C> getRaíz(){
		return raiz;
	}
	public int size(){
		return tam;
	}
}
