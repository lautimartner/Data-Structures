package ed.complejidad;
import java.util.*;
public class Complejidad implements IComplejidad{

	private static int counter;




	public void reiniciaContador(){
		counter = 0;
	}

    public int leeContador(){
		return counter;
	}

    public int tPascalRec(int i, int j){
		counter++;
		if(i<0 || j<0 || j>i) throw new IndexOutOfBoundsException("Pon un parametro valido");
		if(j==0 || j==i){
			return 1;
		}else{
			return tPascalRec(i-1,j-1)+tPascalRec(i-1,j);
		}
		
	}

    public int tPascalIt(int n,int k){
		if(n<0 || k<0 || k>n) throw new IndexOutOfBoundsException("Pon un parametro valido");
		int[][] h= new int[n+1][n+1];
		for(int i=0; i<=n; i++){
			counter++;
			h[i][0]=h[i][i]=1;    
		}
		for(int i=1;i<=n;i++){
			for(int j=0; j<=i; j++){
				counter++;		
				h[i][j] = (j==0 ? 0: h[i-1][j-1]) + (i == j ? 0 : h[i-1][j]);
			}
		}
     return h[n][k];
	}

    public int fibonacciRec(int n){
		counter++;
		if(n < 0) throw new IndexOutOfBoundsException("Pon un parametro valido");		
		if(n==0) return 0;
		if(n==1) return 1;
		else{
			return fibonacciRec(n-1)+fibonacciRec(n-2);
		}
		
	}
	

    public int fibonacciIt(int n){
		int it = 0;
		int res = 1;
		int ant = 1;
		int antant = 0;
		if(n < 0) throw new IndexOutOfBoundsException("Pon un parametro valido");
		if(n==0) return 0;
		while(n-it>1){
			res = ant+antant;
			antant = ant;
			ant = res;
			it++;
			counter++;
		}
		
		return res;
	}	

	public static void main(String[] args){
		Complejidad c = new Complejidad();
		System.out.println(c.tPascalRec(20,10));
		System.out.println("Contador = " + c.leeContador());
		c.reiniciaContador();
	
	}
}
