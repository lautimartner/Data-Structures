package ed.estructuras.nolineales;

public class ÁrbolAVL<C extends Comparable<C>> extends ÁrbolBOLigado<C>{
	private NodoAVL<C> raiz;
	private int size;
	public ÁrbolAVL(){
		size = 0;
		raiz = null;
	}
	
	@Override
	public boolean add(C c){
		NodoAVL<C> n = raiz;
		NodoAVL<C> nuevo=null;
		boolean b = true;
		if(raiz==null){
			raiz = new NodoAVL(null,c,null,null);
	System.out.println("Raiz agregada");		
			
		}else{
			
			while(b){
				if(c.compareTo(n.getDato())<0){
					if(n.getHijoI() != null) n = (NodoAVL<C>) n.getHijoI();
					else{
						b = false;
					}
				}
				else if(c.compareTo(n.getDato())>=0){
					if(n.getHijoD() != null) n = (NodoAVL<C>)n.getHijoD();
					else{
						b = false;
					}
				}
			nuevo = new NodoAVL<C>(null,c,n,null);	
			}
		}
		while(n!=null){
			n.actualizaAltura();
			n.actualizaFB();
			n.balancea();
			n = n.getPadre();
		}
		return true;
	}
	
}
