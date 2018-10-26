package ed.ordenamientos;
public class InsertionSorter<C extends Comparable<C>> implements IOrdenador<C>{
	public InsertionSorter(){}
	@Override
	public C[] ordena(C[] a){
		 for (int i = 1; i < a.length; i++){
            for(int j = i ; j > 0 ; j--){
                if(a[j].compareTo(a[j-1])<0) swap(a,j,j-1);
			}
		}
		return a;
	}	
	//El peor caso es cuando esta ordenado en orden opuesto
	@Override
	public int[] peorCaso(int tam){
		int[] a = new int[tam];
		for(int i=tam-1;i>=0;i--){
			a[i]=i;
		}
		return a;
	}
}
