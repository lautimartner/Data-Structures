package ed.estructuras.lineales;
import java.lang.IndexOutOfBoundsException;
public class Arreglo implements IArreglo{
	//Nueva variable global para especificar el tamaño del arreglo multidimensional que se va a convertir en unidimensional	
	private int[] global;

	private int[] dims;
	public Arreglo(int[] dims){
		int c=1;	
		for(int i = 0;i<dims.length;i++){
			 c= c*dims[i];
		}
		global = dims;
		this.dims=new int[c];
	}

	public int obtenerElemento(int [] indices){
		 return dims[obtenerIndice(indices)];
	}
	public void almacenarElemento(int [] indices, int elem){	
		dims[obtenerIndice(indices)]=elem;	
	}
	public int obtenerIndice(int [] indices){
		if(indices.length != global.length) throw new IndexOutOfBoundsException("La dimension de los indices no es correcta");
		for (int i=0; i<indices.length;i++){
			if (indices[i] < 0) throw new IndexOutOfBoundsException("Pon una posicion valida");
			if(global[i]<indices[i]) throw new IndexOutOfBoundsException("Pon una posicion valida");	
		}
		int indice = 0;
		int n = indices.length;
		for (int j=1; j<n;j++){
			int dimTam = 1;
			for (int k = j+1; k<n; k++){
				dimTam*=global[k];
			}
			indice += indices[j]*dimTam;
		}
		return indice;
	}
	public static void main(String[] args){
	}
}
