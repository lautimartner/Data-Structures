/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal,
 * pero no está permitido transferirlo tal cual a estudiantes actuales o potenciales.
 */
package ed.aplicaciones.calculadora;

import ed.estructuras.lineales.*;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

/**
 * Clase para evaluar expresiones en notación infija.
 *
 * @author blackzafiro
 */
public class Infija {

	/**
	 * Devuelve la precedencia de cada operador. Entre mayor es la precedencia,
	 * más pronto deverá ejecutarse la operación.
	 *
	 * @operador Símbolo que representa a las operaciones: +,-,*,/ y '('.
	 * @throws UnsupportedOperationException para cualquier otro símbolo.
	 */
	private static int precedencia(char operador){
		if(operador== '+' || operador == '-') return 0;
		if(operador== '*' || operador == '%' || operador== '/' ) return 1;
		if(operador == '(') return 2;
		else{
			throw new UnsupportedOperationException();
		}
	}

	/**
	 * Pasa las operaciones indicadas en notación infija a notación sufija o
	 * postfija.
	 *
	 * @param tokens Arreglo con símbolos de operaciones (incluyendo paréntesis)
	 * y números (según la definición aceptada por
	 * <code>Double.parseDouble(token)</code> en orden infijo.
	 * @return Arreglo con símbolos de operaciones (sin incluir paréntesis) y
	 * números en orden postfijo.
	 */
	public static String[] infijaASufija(String[] tokens) {
		PilaLigada<String> p = new PilaLigada<>();
		ColaArreglo<String> c = new ColaArreglo<>(new String[0],tokens.length);
		for(int i =0;i<tokens.length;i++){
			String s = tokens[i];
			try{
				double o1 = Double.parseDouble(s);
				c.forma(String.valueOf(o1));
			}catch(Exception e){
				if(s.charAt(0) == ')'){
					while(!p.isEmpty()&&p.mira().charAt(0) != '('){
						String exp = p.expulsa();
						c.forma(exp);
					}
				p.expulsa();
				}else{
					int prec = precedencia(s.charAt(0));
					while(!p.isEmpty()&&precedencia(p.mira().charAt(0))>=prec){	
						String ex = p.expulsa();
						if(!ex.equals("("))c.forma(ex);
					}
					p.empuja(s);
				}
			}
		}
		while(!p.isEmpty()){
			c.forma(p.expulsa());
		}
		return c.getBuffer();
	}

	/**
	 * Recibe la secuencia de símbolos de una expresión matemática en notación
	 * infija y calcula el resultado de evaluarla.
	 *
	 * @param tokens Lista de símbolos: operadores, paréntesis y números.
	 * @return resultado de la operación.
	 */
	public static double evaluaInfija(String[] tokens) {
		String[] suf = infijaASufija(tokens);
		System.out.println("Sufija: " + Arrays.toString(suf));
		return Fija.evaluaPostfija(suf);
	}

	/**
	 * Interfaz de texto para la calculadora.
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String sentence;
		String method = "infija";
		String delims = "\\s+|(?<=\\()|(?=\\))";
		String[] tokens;
		System.out.println("El modo de notacion por defecto es infijo, para cambiar entre opciones escriba alguna de las opciones que se muestran a continuacion. Puede cambiar entre opciones en cualquier momento");
		System.out.println("postfija");
		System.out.println("prefija");
		System.out.println("infija");
		System.out.println("Calculadora en modo notación " + method);
		while (true) {
			sentence = scanner.nextLine();
			switch (sentence) {
				case "exit":
					return;
				case "infija":
				case "prefija":
				case "postfija":
					System.out.println("Cambiando a notación " + sentence);
					method = sentence;
					continue;
				default:
					break;
			}
			tokens = sentence.split(delims);
			System.out.println("Tokens: " + Arrays.toString(tokens));
			double resultado;
			switch (method) {
				case "infija":
					resultado = evaluaInfija(tokens);
					break;
				case "prefija":
					resultado = Fija.evaluaPrefija(tokens);
					break;
				case "postfija":
					resultado = Fija.evaluaPostfija(tokens);
					break;
				default:
					System.out.println("Método inválido <" + method
							+ "> seleccione alguno de:\n"
							+ "\tinfija\n"
							+ "\tprefija\n"
							+ "\tpostfija\n");
					continue;
			}
			System.out.println("= " + resultado);
		}
	}
}
