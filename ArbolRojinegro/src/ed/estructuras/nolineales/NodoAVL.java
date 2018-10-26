package ed.estructuras.nolineales;
import ed.estructuras.lineales.*;
public class NodoAVL<C extends Comparable<C>> extends NodoBOLigado<C> implements NodoBinario<C>{
	private NodoAVL<C> hijoI, hijoD, padre;
	private C elem;
	private	int fb, h;
	
	public NodoAVL(NodoAVL<C> hijoi, NodoAVL<C> padr, C c, NodoAVL<C> hijod){
		super(hijoi,padr,c,hijod);
		hijoI = hijoi;
		hijoD = hijod;
		padre=padr;
		elem =c;
		h = 0;
		fb = 0;
	}

	public int setFB(){
		if(this.esHoja()) fb= 0;
		else{
			if(hijoI != null && hijoD != null) fb = hijoI.h-hijoD.h;
			if(hijoD == null && hijoI != null) fb = h;
			if(hijoI == null && hijoD != null) fb = -h;
		}
		return fb;
	}
	
	
	public NodoAVL<C> getPadre(){
		return padre;
	}
	protected NodoAVL<C> rotaDerecha(){

		if(padre != null){
			if(padre.hijoI==this){
				this.padre.hijoI = this.hijoI;
			}else{//derecho
				this.padre.hijoD = this.hijoI;
			}
		}
		this.hijoI.padre = this.padre;
		NodoAVL<C> n = this.hijoI;
		this.hijoI = n.hijoD;
		if(n.hijoD != null) n.hijoD.padre = this;
		n.hijoD = this;
		this.padre = n;
		h--;
		n.h = h+1;
		return n;
	}
	protected NodoAVL<C> rotaIzquierda(){

		if(padre!= null){
			if(padre.hijoI==this){
				this.padre.hijoI = this.hijoD;
			}else{
				this.padre.hijoD = this.hijoD;
			}
		}
		this.hijoD.padre = this.padre;
		NodoAVL<C> n = this.hijoD;
		this.hijoD = n.hijoI;
		if(n.hijoI != null) n.hijoI.padre = this;
		n.hijoI = this;
		this.padre = n;
		h--;
		n.h = h+1;
		return n;
	}
	
	protected NodoAVL<C> balancea(){
		int fab = fb;
		if(fab==2){
			if(hijoI.fb ==-1) hijoI.rotaIzquierda();
			return rotaDerecha();
		}else if(fab==-2){
			if(hijoD.fb==1) hijoD.rotaDerecha();
			return rotaIzquierda();
		}else{
			return this;
		}
		
	}
	@Override
    public void setElemento(C dato){
		elem = dato;
	}
	
	public C getDato(){
		return elem;
	}
	@Override
    public NodoAVL<C> getHijoI(){
		return hijoI;
	}
	@Override
    public NodoAVL<C> getHijoD(){
		return hijoD;
	}
	public void setHijoI(NodoAVL<C> hijoi){
		hijoI = hijoi;
	}
	public void setHijoD(NodoAVL<C> hijod){
		hijoD = hijod;
	}
	@Override
	public C getElemento(){
		return elem;
	}
	
    public void setPadre(NodoAVL<C> padr){
		padre = padr;
	}
	@Override
	public boolean esHoja(){
		return (hijoD == null && hijoI == null);
	}
	@Override
    public int getAltura(){
		if(this.esHoja()) return 0;
		return h;
	}
	protected int actualizaAltura(){
		int altI = (hijoI==null)? 0:1+hijoI.getAltura();
		int altD = (hijoD==null)? 0:1+hijoD.getAltura();
		return (this.h = (altI>=altD)? altI:altD);
	}
	public NodoAVL<C> encuentraSucesor(){
		NodoAVL<C> it = hijoD;
		while(it.hijoI!= null){
			it = it.hijoI;
		}
		return it;
	}
	public boolean remueveHijo(Nodo<C> hijo){
		hijo = (NodoAVL<C>)hijo;
		if(hijo.equals(hijoI)){
			hijoI.padre = null;
			hijoI = null;
		}
		if(hijo.equals(hijoD)){
			hijoD.padre=null;
			hijoD = null;
		}
		return true;
	}
}
