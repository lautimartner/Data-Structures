package ed.estructuras.nolineales;
import java.util.*;
import ed.estructuras.lineales.*;
public class NodoBOLigado<C extends Comparable<C>> implements NodoBinario<C>{
	private NodoBOLigado<C> hijoI, hijoD, padre;
	private C c;
	private int alt;
	public NodoBOLigado(NodoBOLigado<C> hijoi, NodoBOLigado<C> padr, C ce, NodoBOLigado<C> hijod){
		hijoI = hijoi;
		hijoD = hijod;
		padre = padr;
		c = ce;
		alt = 0;
	}
	@Override
    public NodoBOLigado<C> getPadre(){
		return padre;
	}
	public C getDato(){
		return c;
	}
	@Override
    public NodoBOLigado<C> getHijoI(){
		return hijoI;
	}
	@Override
    public NodoBOLigado<C> getHijoD(){
		return hijoD;
	}
	public void setHijoI(NodoBOLigado<C> hijoi){
		hijoI = hijoi;
	}
	public void setHijoD(NodoBOLigado<C> hijod){
		hijoD = hijod;
	}
	@Override
	public C getElemento(){
		return c;
	}
	@Override
    public void setElemento(C dato){
		c = dato;
	}
	@Override
    public void setPadre(Nodo<C> padr){
		padre = (NodoBOLigado<C>)padr;
	}
	@Override
	public boolean esHoja(){
		return hijoD == null && hijoI == null;
	}
	@Override
    public int getAltura(){
		if(this.esHoja()) return 0;
		return alt;
	}
	@Override
    public NodoBOLigado<C> getHijo(int indice) throws IndexOutOfBoundsException{
		if(indice == 1) return hijoI;
		if(indice ==2) return hijoD;
		else{
			throw new IndexOutOfBoundsException();
		}
	}
	@Override
	public NodoBOLigado<C> getHermanoSiguiente(Nodo<C> hijo) throws IllegalArgumentException{
		if(this.hijoI != hijo && this.hijoD !=hijo) throw new IllegalArgumentException();
		if(hijoD != null && hijoI == hijo) return hijoD;
		if(hijoD != null && hijoD == hijo) return hijoI;
		else{
			return null;
		}		
	}
	@Override
    public int getGrado(){
		int res=0;
		if(hijoI !=null) res++;
		if(hijoD != null) res++;
		return res;
	}
	@Override
    public List<Nodo<C>> getListaHijos(){
		List<Nodo<C>> l = new ListaDoblementeLigada<>();
		l.add(this.hijoI);
		l.add(this.hijoD);
		return l;
	}
	@Override
    public boolean remueveHijo(Nodo<C> hijo){
		if(hijo.equals(hijoI)) this.hijoI = null;
		if(hijo.equals(hijoD)) this.hijoD = null;
		return true;
	}

	//Metodo que encuentra el menor elemento del subarbol derecho de un nodo
	public NodoBOLigado<C> encuentraSucesor(){
		NodoBOLigado<C> it = hijoD;
		while(it.hijoI!= null){
			it = it.hijoI;
		}
		return it;
	}
	protected int actualizaAltura(){
		int altI = (hijoI==null)? 0:1+hijoI.getAltura();
		int altD = (hijoD==null)? 0:1+hijoD.getAltura();
		return (this.alt = (altI>=altD)? altI:altD);
	}












}
