/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package ed.estructuras.lineales;

import java.util.Iterator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author blackzafiro
 */
public class ColaArregloTest {
	
	private static float points;
    private static float totalPoints;
    private float testValue;
	
	public ColaArregloTest() {
	}
	
	@BeforeClass
	public static void setUpClass() {
		totalPoints = points = 0;
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("==============================");
    	System.out.println("Calificacion automatica: " + points * 10 /totalPoints);
        System.out.println("==============================");
	}
	
	/**
	 * Test of constructor, of class ColaArreglo.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testConstructor(){
		System.out.println("constructor arreglo inválido");
		testValue = 1.0f;
		totalPoints += testValue;
		
		try {
			ColaArreglo<Integer> instance = new ColaArreglo<>(new Integer[5]);
		} catch (IllegalArgumentException e) {
			points += testValue;
			throw e;
		}
	}
	
	/**
	 * Test of size method, of class ColaArreglo.
	 */
	@Test
	public void testSize0(){
		System.out.println("size 0");
		testValue = 1.0f;
		totalPoints += testValue;
		
		ColaArreglo<Integer> instance = new ColaArreglo<>(new Integer[0], 4);
		int expResult = 0;
		int result = instance.size();
		assertEquals(expResult, result);
		
		points += testValue;
	}
	
	/**
	 * Test of size method, of class ColaArreglo.
	 */
	@Test
	public void testSizeNormal1(){
		System.out.println("size normal 1");
		testValue = 1.0f;
		totalPoints += testValue;
		
		ColaArreglo<Integer> instance = new ColaArreglo<>(new Integer[0], 4);
		
		int expResult = 3;
		for (int i = 0; i < expResult; i++) {
			instance.forma(i);
		}
		int result = instance.size();
		assertEquals(expResult, result);
		
		points += testValue;
	}
	
	/**
	 * Test of size method, of class ColaArreglo.
	 */
	@Test
	public void testSizeNormal2(){
		System.out.println("size normal 2");
		testValue = 1.0f;
		totalPoints += testValue;
		
		ColaArreglo<Integer> instance = new ColaArreglo<>(new Integer[0], 4);
		
		int numInserta = 3;
		for (int i = 0; i < numInserta; i++) {
			instance.forma(i);
		}
		instance.atiende();
		int expResult = numInserta - 1;
		int result = instance.size();
		assertEquals(expResult, result);
		
		points += testValue;
	}
	
	/**
	 * Test of size method, of class ColaArreglo.
	 */
	@Test
	public void testSizeAround(){
		System.out.println("size normal arround");
		testValue = 1.0f;
		totalPoints += testValue;
		
		ColaArreglo<Integer> instance = new ColaArreglo<>(new Integer[0], 4);
		
		int numInserta = 3;
		for (int i = 0; i < numInserta; i++) {
			instance.forma(i);
		}
		int numAtiende = 2;
		for (int i = 0; i < numAtiende; i++) {
			instance.atiende();
		}
		numInserta = 3;
		for (int i = 0; i < numInserta; i++) {
			instance.forma(i);
		}
		
		int expResult = 4;
		int result = instance.size();
		assertEquals(expResult, result);
		
		points += testValue;
	}
	
	public void testColaArregloSize() {
		System.out.println("size normal arround");
		testValue = 1.0f;
		totalPoints += testValue;
		
		ColaArreglo<Integer> instance = new ColaArreglo<>(new Integer[0], 4);
		
		int numElementos = 50;
		int elemBorrados = 15;
		int i;
		for (i = 0; i < numElementos; i++) {
			instance.forma(i);
		}
		assertEquals(numElementos, instance.size());
		for (i = 0; i < elemBorrados; i++) {
			instance.atiende();
		}
		assertEquals(numElementos - elemBorrados, instance.size());
		
		points += testValue;
	}

	/**
	 * Test of isEmpty method, of class ColaArreglo.
	 */
	@Test
	public void testIsEmpty() {
		System.out.println("isEmpty");
		testValue = 1.0f;
		totalPoints += testValue;
		
		ColaArreglo<Integer> instance = new ColaArreglo<>(new Integer[0], 3);
		boolean expResult = true;
		boolean result = instance.isEmpty();
		assertEquals(expResult, result);
		
		points += testValue;
	}
	
	/**
	 * Test of isEmpty method, of class ColaArreglo.
	 */
	@Test
	public void testIsEmpty2() {
		System.out.println("isEmpty 2");
		testValue = 1.0f;
		totalPoints += testValue;
		
		ColaArreglo<Integer> instance = new ColaArreglo<>(new Integer[0], 3);
		instance.forma(2);
		instance.forma(1);
		boolean expResult = false;
		boolean result = instance.isEmpty();
		assertEquals(expResult, result);
		
		points += testValue;
	}
	
	/**
	 * Test of isEmpty method, of class ColaArreglo.
	 */
	@Test
	public void testIsEmpty3() {
		System.out.println("isEmpty 3");
		testValue = 1.0f;
		totalPoints += testValue;
		
		ColaArreglo<Integer> instance = new ColaArreglo<>(new Integer[0], 3);
		instance.forma(2);
		instance.forma(1);
		instance.atiende();
		instance.atiende();
		boolean expResult = true;
		boolean result = instance.isEmpty();
		assertEquals(expResult, result);
		
		points += testValue;
	}
	
	@Test
	public void testColaArreglo(){
		System.out.println("general");
		testValue = 1.0f;
		totalPoints += testValue;
		
		ICola<Integer> a = new ColaArreglo<>(new Integer[0]);
		a.forma(42);
		a.forma(3);
		a.forma(17);
		a.forma(8);
		a.forma(3);
		assertEquals(42, a.atiende().intValue());
		assertEquals(3, a.mira().intValue());
		
		points += testValue;
	}

	/**
	 * Test of iterator method, of class ColaArreglo.
	 */
	@Test
	public void testIterator() {
		System.out.println("iterator");
		testValue = 2.0f;
        totalPoints += testValue;
		
		ICola<Integer> instance = new ColaArreglo<>(new Integer[0]);
	    Iterator<Integer> it = instance.iterator();
		int i;
		for (i = 0; i < 20; i++) {
			instance.forma(i);
		}
		i = 0;
		while (it.hasNext()) {
			assertEquals(i, it.next().intValue());
			i++;
		}
		
		points += testValue;
	}

	/**
	 * Test of add method, of class ColaArreglo.
	 */
	@Test
	public void testAdd() {
		System.out.println("add");
		testValue = 2.0f;
        totalPoints += testValue;
		
		ICola<Integer> instance = new ColaArreglo<>(new Integer[0]);
		int numData = 50;
		for (int i=0; i<numData; i++) {
			instance.add(i+20);
		}
		
		// System.out.println("Contenido de la cola:");
		// System.out.println(instance.toString());
		assertEquals(20, instance.mira().intValue());
		
		points += testValue;
	}
	
	/**
	 * Test of add method, of class ColaArreglo.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testAddNull() {
		System.out.println("add");
		testValue = 1.0f;
        totalPoints += testValue;
		
		ICola<Integer> instance = new ColaArreglo<>(new Integer[0]);
		for (int i=0;i<50;i++) {
			instance.add(i+20);
		}
		try {
			instance.add(null);
		} catch (IllegalArgumentException e) {
			points += testValue;
			throw e;
		}
	}
	
	

	/**
	 * Test of mira method, of class ColaArreglo.
	 */
	@Test
	public void testMira() {
		System.out.println("mira vacía");
		testValue = 1.0f;
        totalPoints += testValue;
		
		ICola<Integer> instance = new ColaArreglo<>(new Integer[0]);
		instance.forma(19);
		Integer expResult = 19;
		Integer result = instance.mira();
		assertEquals(expResult, result);
		
		points += testValue;
	}
	
	/**
	 * Test of mira method, of class ColaArreglo.
	 */
	@Test
	public void testMiraVacia() {
		System.out.println("mira vacía");
		testValue = 1.0f;
        totalPoints += testValue;
		
		ICola<Integer> instance = new ColaArreglo<>(new Integer[0]);
		Object result = instance.mira();
		assertNull(result);
		
		points += testValue;
	}

	/**
	 * Test of forma method, of class ColaArreglo.
	 */
	@Test
	public void testForma() {
		System.out.println("forma");
		testValue = 1.0f;
        totalPoints += testValue;
		
		ICola<Integer> instance = new ColaArreglo<>(new Integer[0]);
		instance.forma(10);
		instance.forma(30);
		
		points += testValue;
	}
	
	/**
	 * Test of forma with null method, of class ColaArreglo.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testFormaNull() {
		System.out.println("forma null");
		testValue = 1.0f;
        totalPoints += testValue;
		
		Integer in = null;
		ICola<Integer> instance = new ColaArreglo<>(new Integer[0]);
		
		try {
	        instance.forma(in);
		} catch (IllegalArgumentException e) {
			points += testValue;
			throw e;
		}
	}
	
	/**
	 * Test of forma method, of class ColaArreglo.
	 */
	@Test
	public void testAtiendeVacia() {
		System.out.println("atiende vacía");
		testValue = 1.0f;
        totalPoints += testValue;
		
		ICola<Integer> instance = new ColaArreglo<>(new Integer[0]);
		Object result = instance.atiende();
		assertNull(result);
		
		points += testValue;
	}

	/**
	 * Test of atiende method, of class ColaArreglo.
	 */
	@Test
	public void testAtiende() {
		System.out.println("atiende");
		testValue = 1.0f;
        totalPoints += testValue;
		
		ICola<Integer> instance = new ColaArreglo<>(new Integer[0]);
		instance.forma(10);
		instance.forma(30);
		Integer in = instance.atiende();
		assertEquals(10, in.intValue());
		
		points += testValue;
	}
	
}
