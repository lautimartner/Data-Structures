/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didacticos en forma personal,
 * pero no esta permitido transferirlo tal cual a estudiantes actuales o potenciales.
 */
package ed.complejidad;
import java.io.*;
/**
 * Interfaz que define los métodos para utilizar con las pruebas unitarias.
 */
public interface IComplejidad{

    /**
     * Pone en cero el contador de operaciones realizadas.
     */
    public void reiniciaContador();

    /**
     * Devuelve el número de operaciones acumuladas desde la última vez
     * que se reinició el contador.
     */
    public int leeContador();

    /**
     * Método para guardar las operaciones cuando sólo se usa un parámetro.
     * @param archivo nombre del archivo en el cual se agrega el reporte
     *                del número de operaciones que tardó en ejecutarse
     *                el método.
     * @param par valor que se usó al llamar al último método ejecutado.
	 * @param ops número de operaciones realizadas.
     */
    public static void escribeOperaciones(String archivo, int par, int ops){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
			writer.write(par + " " + ops);
			writer.close();
		}catch(IOException e){
			System.out.println("Excepcion cachada");
		}	
    	
	}

    /**
     * Método para guardar las operaciones cuando se llamó una función con dos
     * parámetros.
     * @param archivo nombre del archivo en el cual se agrega el reporte
     *                del número de operaciones que tardó en ejecutarse
     *                el método.
     * @param par1 primer valor que se usó al llamar al último método ejecutado.
     * @param par2 segundo valor que se usó al llamar al último método ejecutado.
	 * @param ops número de operaciones realizadas.
     */
    public static void escribeOperaciones(String archivo, int par1, int par2, int ops){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(archivo));
			writer.write(par1 + " " + par2 + " " + ops);
			writer.close();
		}catch(IOException e){
			System.out.println("Excepcion cachada");
		}	
    }


    /**
     * Método para calcular, de forma recursiva, el elemento en la fila
     * <code>i</code>, en la columna <code>j</code> del triangulo de Pascal
     * @param i el numero de fila
     * @param j el numero de columna  Si es <code>null</code> no se realizará
     *                este cálculo.
     * @return El elemento en la <code>i</code>-esima fila y la
     * <code>j</code>-esima columna del triangulo de Pascal.
     * @throws IndexOutOfBoundsException Si los indices <code>i</code> o
     * <code>j</code> son inválidos
     */
    public int tPascalRec(int i, int j);

    /**
     * Metodo para calcular, iterativamente, el elemento en la fila
     * <code>i</code> y la columna <code>j</code> del triangulo de Pascal
     * @param i el numero de fila
     * @param j el numero de columna
     * @return El elemento en la i-esima fila y la j-esima columna del triangulo
     * de Pascal.
     * @throws IndexOutOfBoundsException Si los indices <code>i</code> o
     * <code>j</code> son inválidos
     */
    public int tPascalIt(int i,int j);

    /**
     * Devuelve el n-esimo elemento, calculado de forma recursiva,
     * de la sucesion de Fibonacci
     * @param n el indice del elemento que se desea calcular
     * @return el n-esimo elemento de la sucesion de Fibonacci
     * @throws IndexOutOfBoundsException Si el valor de <code>n</code>es inválido
     */
    public int fibonacciRec(int n);

    /**
     * Devuelve el n-esimo elemento, calculado de forma iterativa,
     * de la sucesion de Fibonacci
     * @param n el indice del elemento que se desea calcular
     * @return el n-esimo elemento de la sucesiond de Fibonacci
     * @throws IndexOutOfBoundsException Si el valor de <code>n</code>es inválido
     */
    public int fibonacciIt(int n);

}
