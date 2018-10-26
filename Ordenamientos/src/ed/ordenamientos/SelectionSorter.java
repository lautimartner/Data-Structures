package ed.ordenamientos;
public class SelectionSorter<C extends Comparable<C>> implements IOrdenador<C>{
	public SelectionSorter(){}
	@Override
	public C[] ordena(C[] arr){
		for (int i = 0; i < arr.length - 1; i++){
            int index = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j].compareTo(arr[index])<0){
                    index = j;
				}
			}
			swap(arr,index,i);
		}		
        return arr;		
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



