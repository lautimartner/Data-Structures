package ed.ordenamientos;
public class BubbleSorter<C extends Comparable<C>> implements IOrdenador<C>{
	public C[] ordena(C[] a){
		boolean swapped = true;
		int j = 0;
		C temp;
		while(swapped){
			swapped = false;
			j++;
			for(int i = 0; i<a.length-j;i++){
				if(a[i].compareTo(a[i+1])>0){
					swap(a,i,i+1);
					swapped =true;
				}
			}
		}
		return a;
	}
	@Override
	public int[] peorCaso(int tam){
		int[] a = new int[tam];
		for(int i=tam-1;i>=0;i--){
			a[i]=i;
		}
		return a;
	}
}
