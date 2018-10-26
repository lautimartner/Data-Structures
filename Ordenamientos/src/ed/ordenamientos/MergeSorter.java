package ed.ordenamientos;
import java.util.*;
public class MergeSorter<C extends Comparable<C>> implements IOrdenador<C>{
	int as=0;
	public MergeSorter(){}
	@Override
	public C[] ordena(C[] a){
		C[] tmpArray = (C[])new Comparable[a.length];
        mergeSort(a, tmpArray, 0, a.length - 1);
		return a;
	}
	//Merge sort
	public void mergeSort( C[] a, C[] tmpArray, int left, int right) {
        if( left < right ) {
            int center = ( left + right ) / 2;
            mergeSort( a, tmpArray, left, center );
            mergeSort( a, tmpArray, center + 1, right );
            merge( a, tmpArray, left, center + 1, right );
        }
    }
	//Metodo para unir dos arreglos
	public void merge( C[] a, C[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;
        while(leftPos <= leftEnd && rightPos <= rightEnd)
            if(a[leftPos].compareTo(a[rightPos ]) <= 0)
                tmpArray[tmpPos++] = a[leftPos++];
            else
                tmpArray[tmpPos++] = a[rightPos++];
        
        while(leftPos <= leftEnd)
            tmpArray[tmpPos++] = a[leftPos++];
        
        while( rightPos <= rightEnd)
            tmpArray[tmpPos++] = a[rightPos++];
        
        // Copia tmpArray de vuelta a "a"
        for(int i = 0; i < numElements; i++, rightEnd--)
            a[rightEnd] = tmpArray[rightEnd];
    }
	//La complejidad del peor caso de merge sort es la misma que la del caso promedio entonces no se que poner...
	@Override
	public int[] peorCaso(int tam){
		int[] a = new int[tam];
		for(int i = 0; i<tam;i++){
			a[i]= (int) Math.ceil(Math.random() * 100);
		}
		return a;
    }
}
