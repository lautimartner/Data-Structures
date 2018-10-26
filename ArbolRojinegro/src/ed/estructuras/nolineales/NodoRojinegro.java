package ed.estructuras.nolineales;
import ed.estructuras.lineales.*;
import java.util.*;
public class NodoRojinegro<C extends Comparable<C>> implements NodoBinario<C>{
	public enum Color{
		ROJO, NEGRO
	}
	private int h;
	private Color color;
	private C elem;
	private NodoRojinegro<C> hijoI, hijoD, padre;
	public NodoRojinegro(NodoRojinegro<C> hi, C c, Color colo, NodoRojinegro<C> padre, NodoRojinegro<C> hd){
		hijoI = hi;
		elem = c;
		this.padre = padre;
		hijoD =hd;
		color = colo;
		h = 0;
	} 

	public Color getColor(){
		return color;
	}
	public void setColor(Color c){
		color = c;
	}
	public NodoRojinegro<C> getPadre(){
		return padre;
	}
	protected NodoRojinegro<C> rotaDerecha(){

		if(padre != null){
			if(padre.hijoI==this){
				this.padre.hijoI = this.hijoI;
			}else{//derecho
				this.padre.hijoD = this.hijoI;
			}
		}
		this.hijoI.padre = this.padre;
		NodoRojinegro<C> n = this.hijoI;
		this.hijoI = n.hijoD;
		if(n.hijoD != null) n.hijoD.padre = this;
		n.hijoD = this;
		this.padre = n;
		h--;
		n.h = h+1;
		return n;
	}
	protected NodoRojinegro<C> rotaIzquierda(){

		if(padre!= null){
			if(padre.hijoI==this){
				this.padre.hijoI = this.hijoD;
			}else{
				this.padre.hijoD = this.hijoD;
			}
		}
		this.hijoD.padre = this.padre;
		NodoRojinegro<C> n = this.hijoD;
		this.hijoD = n.hijoI;
		if(n.hijoI != null) n.hijoI.padre = this;
		n.hijoI = this;
		this.padre = n;
		h--;
		n.h = h+1;
		return n;
	}
	
	@Override
    public void setElemento(C dato){
		elem = dato;
	}
	
	public C getDato(){
		return elem;
	}
	@Override
    public NodoRojinegro<C> getHijoI(){
		return hijoI;
	}
	@Override
    public NodoRojinegro<C> getHijoD(){
		return hijoD;
	}
	public void setHijoI(NodoRojinegro<C> hijoi){
		hijoI = hijoi;
	}
	public void setHijoD(NodoRojinegro<C> hijod){
		hijoD = hijod;
	}
	@Override
	public C getElemento(){
		return elem;
	}
	
    public void setPadre(Nodo<C> padr){
		padre = (NodoRojinegro<C>)padr;
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
	public NodoRojinegro<C> encuentraSucesor(){
		NodoRojinegro<C> it = hijoD;
		while(it.hijoI!= null){
			it = it.hijoI;
		}
		return it;
	}
	public boolean remueveHijo(Nodo<C> hijo){
		hijo = (NodoRojinegro<C>)hijo;
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

	@Override
    public List<Nodo<C>> getListaHijos(){
		List<Nodo<C>> l = new ListaDoblementeLigada<>();
		l.add(hijoI);
		l.add(hijoD);
		return l;
	}
	@Override
	public int getGrado(){
		int res=0;
		if(hijoI !=null) res++;
		if(hijoD != null) res++;
		return res;
	}
	@Override
	public NodoRojinegro<C> getHermanoSiguiente(Nodo<C> hijo) throws IllegalArgumentException{
		if(hijoI != hijo && hijoD !=hijo) throw new IllegalArgumentException();
		if(hijoD != null && hijoI == hijo) return hijoD;
		if(hijoD != null && hijoD == hijo) return hijoI;
		else{
			return null;
		}
	}

	@Override
    public NodoRojinegro<C> getHijo(int indice) throws IndexOutOfBoundsException{
		if(indice == 1) return hijoI;
		if(indice ==2) return hijoD;
		else{
			throw new IndexOutOfBoundsException();
		}
	}	

}
