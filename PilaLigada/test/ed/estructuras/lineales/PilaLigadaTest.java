/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.estructuras.lineales;

import java.util.Iterator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author julio, blackzafiro
 */
public class PilaLigadaTest {
	
	private static float points;
    private static float totalPoints;
    private float testValue;
	
	public PilaLigadaTest() {
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
	 * Test of empuja method, of class PilaLigada.
	 */
	@Test
	public void testEmpuja() {
		System.out.println("empuja");
		testValue = 1.0f;
        totalPoints += testValue;
		
		IPila<Integer> p=new PilaLigada<>();
        p.empuja(10);
        assertEquals(10, p.expulsa().intValue());
		
		points += testValue;
	}
	
	/**
	 * Test of empuja method, of class PilaLigada with null.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testEmpujaNull() {
		System.out.println("empuja null");
		testValue = 1.0f;
        totalPoints += testValue;
		
		IPila<Integer> p=new PilaLigada<>();
		try {
	        p.empuja(null);
		} catch (IllegalArgumentException e) {
			points += testValue;
			throw e;
		}
	}

	/**
	 * Test of mira method, of class PilaLigada.
	 */
	@Test
	public void testMira() {
		System.out.println("mira");
		testValue = 2.0f;
        totalPoints += testValue;
		
		IPila<Integer> p=new PilaLigada<>();
        p.empuja(1);
        p.empuja(2);
        p.empuja(5);
        p.empuja(10);
        assertEquals(10, p.mira().intValue());
		
		points += testValue;
	}

	/**
	 * Test of expulsa method, of class PilaLigada.
	 */
	@Test
	public void testExpulsa() {
		System.out.println("expulsa");
		testValue = 2.0f;
        totalPoints += testValue;
		
		IPila<Integer> p=new PilaLigada<>();
        p.empuja(2);
        p.empuja(3);
        p.empuja(5);
        p.empuja(7);
        assertEquals(7, p.expulsa().intValue());
		
		points += testValue;
	}
	
    public void testPilaLigadaMiraVacia(){
		System.out.println("Mira vacía");
		testValue = 1.0f;
        totalPoints += testValue;
		
		IPila<Integer> p=new PilaLigada<>();
		Integer temp = p.mira();
		assertNull(temp);
		
		points += testValue;
    }
	
	public void testPilaLigadaExpulsaVacia(){
		System.out.println("Mira vacía");
		testValue = 1.0f;
        totalPoints += testValue;
		
		IPila<Integer> p=new PilaLigada<>();
		Integer temp = p.expulsa();
		assertNull(temp);
		
		points += testValue;
	}

	/**
	 * Test of size method, of class PilaLigada.
	 */
	@Test
	public void testSize() {
		System.out.println("size");
		testValue = 1.0f;
        totalPoints += testValue;
		
		IPila<Integer> p=new PilaLigada<>();
        int numElementos = 20;
        int elemBorrados = 15;
        for(int i = 0; i < numElementos; i++){
            p.empuja(50+i);
        }
        assertEquals(numElementos, p.size());
        for(int i = 0; i < elemBorrados; i++){
            p.expulsa();
        }
        assertEquals(numElementos-elemBorrados, p.size());
        p.mira();
        p.mira();
        assertEquals(numElementos-elemBorrados, p.size());        
        
		points += testValue;
	}

	/**
	 * Test of isEmpty method, of class PilaLigada.
	 */
	@Test
	public void testIsEmpty() {
		System.out.println("isEmpty");
		testValue = 1.0f;
        totalPoints += testValue;
		
		IPila<Integer> p=new PilaLigada<>();
		
        assertTrue(p.isEmpty());
		points += testValue/4;
		
        p.empuja(1);
        p.empuja(2);
        assertFalse(p.isEmpty());
		points += testValue/4;
		
        p.expulsa();
        p.expulsa();
        assertTrue(p.isEmpty());
		points += testValue/4;
		
		p.empuja(10);
		assertFalse(p.isEmpty());
		points += testValue/4;
	}

	/**
	 * Test of iterator method, of class PilaLigada.
	 */
	@Test
	public void testIterator() {
		System.out.println("iterator");
		testValue = 2.0f;
        totalPoints += testValue;
		
		IPila<Integer> p=new PilaLigada<>();
		Iterator<Integer> it=p.iterator();
        int i;
        for(i=0;i<10;i++){
            p.empuja(i);
        }
        while(it.hasNext()){
            assertEquals(--i, it.next().intValue());
        }
		
        points += testValue;
	}

	/**
	 * Test of add method, of class PilaLigada.
	 */
	@Test
	public void testAdd() {
		System.out.println("add");
		testValue = 1.0f;
        totalPoints += testValue;
		
		IPila<Integer> p=new PilaLigada<>();
        for(int i=0;i<40;i++){
            assertTrue(p.add(i+20));
        }
        assertEquals(59, p.mira().intValue());
        
		points += testValue;
	}
	
}
