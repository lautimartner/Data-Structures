/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal,
 * pero no está permitido transferirlo tal cual a estudiantes actuales o potenciales.
 */
package ed.aplicaciones.calculadora;

import ed.estructuras.lineales.*;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Clase para evaluar expresiones en notaciones prefija y postfija.
 *
 * @author blackzafiro
 */
public class Fija {

	/**
	 * Evalúa la operación indicada por <code>operador</code>.
	 */
	private static double evalua(char operador, double operando1, double operando2) {
		 
		if(operador== '+') return operando1 +  operando2;
		if(operador== '-') return operando1 - operando2;
		if(operador== '*') return operando1 * operando2;
		if(operador== '/') return operando1 / operando2;
		if(operador == '%') return operando1 % operando2;			
		else{ 
			throw new IllegalArgumentException();
		}
	}

	/**
	 * Recibe la secuencia de símbolos de una expresión matemática en notación
	 * prefija y calcula el resultado de evaluarla.
	 *
	 * @param tokens Lista de símbolos: operadores y números.
	 * @return resultado de la operación.
	 */
	public static double evaluaPrefija(String[] tokens) {
		PilaLigada<Double> p = new PilaLigada<>();
		
		for(int i = tokens.length-1; i>=0; i--){
			double o,o1,o2;
			String s = tokens[i];
			try{
				o = Double.parseDouble(s);
				p.empuja(o);
			}catch(Exception e){
				o1 = p.expulsa();
				o2 = p.expulsa();
				p.empuja(evalua(s.charAt(0),o1,o2));

			}
		}
		return p.expulsa();
	}

	/**
	 * Recibe la secuencia de símbolos de una expresión matemática en notación
	 * postfija y calcula el resultado de evaluarla.
	 *
	 * @param tokens Lista de símbolos: operadores y números.
	 * @return resultado de la operación.
	 */
	public static double evaluaPostfija(String[] tokens) {
		PilaLigada<Double> n = new PilaLigada();
		for(int i = 0; i<tokens.length; i++){
			double o;
			String s = tokens[i];
			if(s==null) continue;
			try{
				o = Double.parseDouble(s);
				n.empuja(o);
			}catch(Exception e){
				double o2 = n.expulsa();
				double o1 = n.expulsa();
				n.empuja(evalua(s.charAt(0),o1,o2));
			}
		}
		return n.expulsa();
	}

	/**
	 * Interfaz de texto para la calculadora.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String sentence;
		String method = "prefija";
		String delims = "\\s+|(?<=\\()|(?=\\))";
		String[] tokens;
		while (true) {
			sentence = scanner.nextLine();
			switch (sentence) {
				case "exit":
					return;
				case "prefija":
				case "postfija":
					System.out.println("Cambiando a notación " + sentence);
					method = sentence;
					continue;
				default:
					break;
			}
			tokens = sentence.split(delims);
			System.out.println(Arrays.toString(tokens));
			if (method.equals("postfija")) {
				System.out.println("= " + evaluaPostfija(tokens));
			} else {
				System.out.println("= " + evaluaPrefija(tokens));
			}

		}
	}
}
