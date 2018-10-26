package ed.estructuras.nolineales;
import ed.estructuras.lineales.*;
public class NodoAVL<C extends Comparable<C>> extends NodoBOLigado<C> implements NodoBinario<C>{
	private NodoAVL<C> I, D, padre;
	private C elem;
	private	int fb, alt;
	
	public NodoAVL(NodoAVL<C> hijoi, C c, NodoAVL<C> padr, NodoAVL<C> hijod){
		super(hijoi,padr,c,hijod);
		alt = 0;
		fb = 0;
	}

	public void setFB(){
		if(this.esHoja()) fb= 0;
		else{
			if(I != null && D != null) this.fb = I.getAltura()-D.getAltura();
			if(D == null && I != null) this.fb = I.getAltura();
			if(I == null && D != null) this.fb = D.getAltura();
		}
	}
	
	public void actualizaFB(){
		fb = I.alt - D.alt;
		 
	}
	public NodoAVL<C> getPadre(){
		return padre;
	}
	protected NodoAVL<C> rotaDerecha(){
		if(padre != null){
			if(padre.I==this){
				this.padre.I = this.I;
			}else{//derecho
				this.padre.D = this.I;
			}
		}
		
		this.I.padre = this.padre;
		NodoAVL<C> n = this.I;
		this.I = n.D;
		if(n.D != null) n.D.padre = this;
		n.D = this;
		this.padre = n;

		return n;
	}
	protected NodoAVL<C> rotaIzquierda(){
		if(padre!= null){
			if(padre.I==this) this.padre.I = this.D;
		}else{
			this.padre.D = this.D;
		}
		this.D.padre = this.padre;
		NodoAVL<C> n = this.D;
		this.D = n.I;
		this.padre = n;
		n.I = this;
		if(n.D != null) n.D.padre = this;

		return n;
	}
	
	protected NodoAVL<C> balancea(){
		int fab = fb;
		if(fab==2){
			if(I.fb ==-1) I.rotaIzquierda();
			return this.rotaDerecha();
		}else if(fab==-2){
			if(D.fb==1) D.rotaDerecha();
			return this.rotaIzquierda();
		}else{
			return this;
		}
		
	}

}
