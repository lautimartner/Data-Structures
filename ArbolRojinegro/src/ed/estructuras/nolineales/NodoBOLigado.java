package ed.estructuras.nolineales;
import java.util.*;
import ed.estructuras.lineales.*;
public class NodoBOLigado<C extends Comparable<C>> implements NodoBinario<C>{
	private NodoBOLigado<C> I, D, padres;
	private C c;
	private int alt;
	public NodoBOLigado(NodoBOLigado<C> hijoi, NodoBOLigado<C> padr, C ce, NodoBOLigado<C> hijod){
		I = hijoi;
		D = hijod;
		padres = padr;
		c = ce;
		alt = 0;
	}
	@Override
    public NodoBOLigado<C> getPadre(){
		System.out.println("Padre");
		return padres;
	}
	public C getDato(){
		return c;
	}
	@Override
    public NodoBOLigado<C> getHijoI(){
		return I;
	}
	@Override
    public NodoBOLigado<C> getHijoD(){
		return D;
	}
	public void setHijoI(NodoBOLigado<C> hijoi){
		I = hijoi;
	}
	public void setHijoD(NodoBOLigado<C> hijod){
		D = hijod;
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
		padres = (NodoBOLigado<C>)padr;
	}
	@Override
	public boolean esHoja(){
		return getGrado()==0;
	}
	@Override
    public int getAltura(){
		if(this.esHoja()) return 0;
		return alt;
	}
	@Override
    public NodoBOLigado<C> getHijo(int indice) throws IndexOutOfBoundsException{
		if(indice == 1) return I;
		if(indice ==2) return D;
		else{
			throw new IndexOutOfBoundsException();
		}
	}
	@Override
	public NodoBOLigado<C> getHermanoSiguiente(Nodo<C> hijo) throws IllegalArgumentException{
		if(this.I != hijo && this.D !=hijo) throw new IllegalArgumentException();
		if(D != null && I == hijo) return D;
		if(D != null && D == hijo) return I;
		else{
			return null;
		}		
	}
	@Override
    public int getGrado(){
		int res=0;
		if(I !=null) res++;
		if(D != null) res++;
		return res;
	}
	@Override
    public List<Nodo<C>> getListaHijos(){
		List<Nodo<C>> l = new ListaDoblementeLigada<>();
		l.add(this.I);
		l.add(this.D);
		return l;
	}
	@Override
    public boolean remueveHijo(Nodo<C> hijo){
		hijo = (NodoBOLigado<C>) hijo;
		if(hijo.equals(I)){
			System.out.println("Se ha encontrado el puto");
			this.I = null;
			I.padres = null;
		}
		if(hijo.equals(D)){
			System.out.println("Se ha encontrado el puto");
			this.D = null;
			I.padres=null;
		}
		return true;
	}

	//Metodo que encuentra el menor elemento del subarbol derecho de un nodo
	public NodoBOLigado<C> encuentraSucesor(){
		NodoBOLigado<C> it = D;
		while(it.I!= null){
			it = it.I;
		}
		return it;
	}
	protected int actualizaAltura(){
		int altI = (I==null)? 0:1+I.getAltura();
		int altD = (D==null)? 0:1+D.getAltura();
		return (this.alt = (altI>=altD)? altI:altD);
	}












}
