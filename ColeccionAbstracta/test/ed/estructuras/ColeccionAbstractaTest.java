/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package ed.estructuras;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

import java.util.Random;
import java.util.LinkedList;

/**
 * Batería de pruebas unitarias para la clase <code>ColeccionAbstracta</code>.
 *
 * @author ricardo
 */
public class ColeccionAbstractaTest {

	private static float points;
    private static float totalPoints;
	private float testValue;

	private Random intGenerator;

	public ColeccionAbstractaTest() {
		intGenerator = new Random();
	}

	@BeforeClass
	public static void setUpClass() {
		totalPoints = points = 0;
	}

	@AfterClass
	public static void tearDownClass() {
		System.out.println("\n==============================");
		System.out.println("Calificación automática: " +
				points * 10 / totalPoints);
		System.out.println("==============================");
	}

	/**
	 * Test of contains method, of class ColeccionAbstracta.
	 */
	@Test
	public void testContains() {
		System.out.print("\nRevisando metodo contains...");
		testValue = 2.0f;
        totalPoints += testValue;
		
		Conjunto<String> ctest = new Conjunto<String>();
		for (int i = 0; i < 1000; i++) {
			ctest.add("" + i);
		}
		int rnd = intGenerator.nextInt(1000);
		assertTrue(ctest.contains("" + rnd));
		assertFalse(ctest.contains(-1));
		System.out.print("Correcto");
		
		points += testValue;
	}

	/**
	 * Test of toArray() method, of class ColeccionAbstracta.
	 */
	@Test
	public void testToArray_0args() {
		System.out.print("\nRevisando metodo toArray sin argumentos...");
		testValue = 1.0f;
        totalPoints += testValue;
		
		Conjunto<String> ctest = new Conjunto<String>();
		for (int i = 0; i < 1000; i++) {
			ctest.add("" + i);
		}
		Object[] ob = ctest.toArray();
		for (int i = 0; i < 1000; i++) {
			assertEquals((String) ob[i], "" + i);
		}
		System.out.print("Correcto");
		
		points += testValue;
	}

	/**
	 * Test of toArray(T) method, of class ColeccionAbstracta.
	 */
	@Test
	public void testToArray_GenericType() {
		System.out.print("\nRevisando metodo toArray con argumentos...");
		testValue = 1.0f;
        totalPoints += testValue;
		
		Conjunto<String> ctest = new Conjunto<String>();
		for (int i = 0; i < 1000; i++) {
			ctest.add("" + i);
		}
		String[] tmp = new String[1000];
		tmp = ctest.toArray(tmp);
		for (int i = 0; i < 1000; i++) {
			assertEquals(tmp[i], "" + i);
		}
		System.out.print("Correcto");
		
		points += testValue;
	}

	/**
	 * Test of containsAll method, of class ColeccionAbstracta.
	 */
	@Test
	public void testContainsAll() {
		System.out.print("\nRevisando metodo containsAll...");
		testValue = 1.0f;
        totalPoints += testValue;
		
		Conjunto<String> ctest = new Conjunto<String>();
		LinkedList<String> tmp = new LinkedList<String>();
		for (int i = 0; i < 1000; i++) {
			ctest.add("" + i);
			tmp.add("" + i);
		}
		assertTrue(ctest.containsAll(tmp));
		System.out.print("Correcto");
		
		points += testValue;
	}

	/**
	 * Test of addAll method, of class ColeccionAbstracta.
	 */
	@Test
	public void testAddAll() {
		System.out.print("\nRevisando metodo addAll...");
		testValue = 1.0f;
        totalPoints += testValue;
		
		Conjunto<String> ctest = new Conjunto<String>();
		LinkedList<String> tmp = new LinkedList<String>();
		for (int i = 0; i < 1000; i++) {
			tmp.add("" + i);
		}
		ctest.addAll(tmp);
		for (String s : tmp) {
			assertTrue(ctest.contains(s));
		}
		System.out.print("Correcto");
		
		points += testValue;
	}

	/**
	 * Test of remove method, of class ColeccionAbstracta.
	 */
	@Test
	public void testRemove() {
		System.out.print("\nRevisando metodo remove...");
		testValue = 1.0f;
        totalPoints += testValue;
		
		Conjunto<String> ctest = new Conjunto<String>();
		for (int i = 0; i < 1000; i++) {
			ctest.add("" + i);
		}
		int rnd = intGenerator.nextInt(1000);
		assertTrue(ctest.remove("" + rnd));
		assertFalse(ctest.contains("" + rnd));
		assertFalse(ctest.remove("" + rnd));
		System.out.print("Correcto");
		
		points += testValue;
	}

	/**
	 * Test of removeAll method, of class ColeccionAbstracta.
	 */
	@Test
	public void testRemoveAll() {
		System.out.print("\nRevisando metodo removeAll...");
		testValue = 1.0f;
        totalPoints += testValue;
		
		Conjunto<String> ctest = new Conjunto<String>();
		LinkedList<String> tmp = new LinkedList<String>();
		for (int i = 0; i < 1000; i++) {
			ctest.add("" + i);
		}
		for (int i = 0; i < 500; i++) {
			int rnd = intGenerator.nextInt(1000);
			tmp.add("" + rnd);
		}
		ctest.removeAll(tmp);
		for (String s : tmp) {
			assertFalse(ctest.contains(s));
		}
		System.out.print("Correcto");
		
		points += testValue;
	}

	/**
	 * Test of retainAll method, of class ColeccionAbstracta.
	 */
	@Test
	public void testRetainAll() {
		System.out.print("\nRevisando metodo retainAll...");
		testValue = 2.0f;
        totalPoints += testValue;
		
		Conjunto<String> ctest = new Conjunto<String>();
		LinkedList<String> tmp = new LinkedList<String>();
		for (int i = 0; i < 1000; i++) {
			ctest.add("" + i);
		}
		for (int i = 0; i < 500; i += 2) {
			tmp.add("" + i);
		}
		ctest.retainAll(tmp);
		for (int i = 0; i < 1000; i++) {
			if (tmp.contains(i + "")) {
				assertTrue(ctest.contains("" + i));
			} else {
				assertFalse(ctest.contains("" + i));
			}
		}
		System.out.print("Correcto");
		
		points += testValue;
	}
	
	/**
	 * Test of retainAll method, of class ColeccionAbstracta.
	 */
	@Test
	public void testRetainAllRandom() {
		System.out.print("\nRevisando metodo retainAll random...");
		testValue = 1.0f;
        totalPoints += testValue;
		final boolean PRINT = true;
		
		int MAX = 20;
		Conjunto<String> ctest = new Conjunto<String>();
		LinkedList<String> tmp = new LinkedList<String>();
		for (int i = 0; i < MAX; i++) {
			ctest.add("" + i);
		}
		for (int i = 0; i < MAX / 2; i++) {
			int rnd = intGenerator.nextInt(MAX);
			tmp.add("" + rnd);
		}
		if (PRINT) System.out.println("Antes: " + ctest.toString());
		if (PRINT) System.out.println("Dejar: " + tmp.toString());
		ctest.retainAll(tmp);
		if (PRINT) System.out.println("Después: " + ctest.toString());
		for (int i = 0; i < 1000; i++) {
			if (tmp.contains("" + i)) {
				if (PRINT) System.out.println("Buscando " + i);
				assertTrue(ctest.contains("" + i));
			} else {
				assertFalse(ctest.contains("" + i));
			}
		}
		System.out.print("Correcto");
		
		points += testValue;
	}

	/**
	 * Test of testClear method, of class ColeccionAbstracta.
	 */
	@Test
	public void testClear() {
		System.out.print("\nRevisando metodo clear...");
		testValue = 1.0f;
        totalPoints += testValue;
		
		Conjunto<String> ctest = new Conjunto<>();
		for (int i = 0; i < 1000; i++) {
			ctest.add("" + i);
		}
		ctest.clear();
		assertEquals(0, ctest.size());
		System.out.print("Correcto");
		
		points += testValue;
	}

}
