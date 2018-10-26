package ed.ordenamientos;
public class QuickSorter<C extends Comparable<C>> implements IOrdenador<C>{
	public QuickSorter(){}	
	@Override
	public C[] ordena(C[] a){
		quickSort(a,0,a.length-1);
		return a;
	}//Este metodo parte el arreglo y compara los elementos en ambos lados con el pivote y los pone en dos arreglos, uno a la derecha y otro a la izq
	public int partition(C[] arr, int left, int right){
      int i = left, j = right;
      C pivote = arr[(left + right) / 2];
      while (i <= j){
            while (arr[i].compareTo(pivote)<0){
                  i++;
			}
            while (arr[j].compareTo(pivote)>0)
                j--;
			if(i <= j){
				swap(arr,i,j);
				i++;
				j--;
			}
      }
      return i;
	}
	public void quickSort(C[] arr, int left, int right) {
		int index = partition(arr, left, right);
		if(left<index-1) quickSort(arr, left, index - 1);
		if(index < right)quickSort(arr, index, right);
	}	
	//El peor caso es cuando el arreglo ya esta ordenado y se elige como pivote al ultimo o primer elemento. Para que esto funcione con mi implementacion tendria que cambiar la eleccion del pivote al ultimo o primero elemento.
	@Override
	public int[] peorCaso(int tam){
		int[] a = new int[tam];
		for(int i=0;i<tam-1;i++){
			a[i]=i;
		}
		return a;
	}
}
