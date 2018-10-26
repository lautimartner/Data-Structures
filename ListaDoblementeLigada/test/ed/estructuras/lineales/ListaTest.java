/*
 * Código utilizado para el curso de Estructuras de Datos.
 * Se permite consultarlo para fines didácticos en forma personal.
 */
package ed.estructuras.lineales;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author julio, blackzafiro
 */
public abstract class ListaTest extends Calificador {
	protected abstract List<Integer> creaListaVacia();
	protected abstract List<String> creaListaVaciaCad();
	
	@Test
    public void getTest() {
		System.out.println("get");
        testValue = 1.0f;
        totalPoints += testValue;
		
        List<Integer> ldl = creaListaVacia();
        ldl.add(2);
        ldl.add(1);
        ldl.add(0);
        assertEquals(0, ldl.get(2).intValue());
        assertEquals(1, ldl.get(1).intValue());
        assertEquals(2, ldl.get(0).intValue());
        
		points += testValue;
    }
	
	@Test
    public void addAllTest() {
		System.out.println("addAll");
        testValue = 1.0f;
        totalPoints += testValue;
		
        List<Integer> ldl = creaListaVacia();
        LinkedList c = new LinkedList();
        c.add(10);
        c.add(20);
        c.add(30);
        ldl.addAll(c);
        assertEquals(10, ldl.get(0).intValue());
        assertEquals(20, ldl.get(1).intValue());
        assertEquals(30, ldl.get(2).intValue());
        
		points += testValue;
    }
	
	@Test
    public void sizeTest() {
		System.out.println("size");
        testValue = 0.25f;
        totalPoints += testValue;
		
        List<Integer> ldl = creaListaVacia();
        assertEquals(0, ldl.size());
        ldl.add(3);
        ldl.add(4);
        assertEquals(2, ldl.size());
		
        points += testValue;
    }
	
	@Test
    public void isEmptyTest() {
		System.out.println("isEmpty");
        testValue = 0.25f;
        totalPoints += testValue;
		
        List<Integer> ldl = creaListaVacia();
        assertTrue(ldl.isEmpty());
        ldl.add(3);
        ldl.add(4);
        assertFalse(ldl.isEmpty());
        
		points += testValue;
    }

    @Test
    public void addIndexTest() {
        System.out.println("addIndex");
        testValue = 1.0f;
        totalPoints += testValue;
		
        List<String> ldl = creaListaVaciaCad();
        ldl.add(0, "hola");
        ldl.add(1, "mundo");
        assertEquals("hola", ldl.get(0));
        assertEquals("mundo", ldl.get(1));
        
		points += testValue;
    }

    @Test
    public void setTest() {
        System.out.println("setTest");
        testValue = 1.0f;
        totalPoints += testValue;
		
        List<Integer> ldl = creaListaVacia();
        ldl.add(5);
        ldl.add(10);
        ldl.add(15);
        ldl.add(20);
        ldl.add(25);
        ldl.set(2, 12);
        assertEquals(12, ldl.get(2).intValue());
        assertEquals(10, ldl.get(1).intValue());
        assertEquals(20, ldl.get(3).intValue());
        
		points += testValue;
    }

    @Test
    public void removeTest() {
        System.out.println("remove");
        testValue = 1.0f;
        totalPoints += testValue;
		
        List<String> ldl = creaListaVaciaCad();
        ldl.add("cad1");
        ldl.add("cad2");
        ldl.add("cad3");
        assertFalse(ldl.remove("cad4"));
        assertTrue(ldl.remove("cad2"));
        
		points += testValue;
    }

    @Test
    public void iteratorTest() {
        System.out.println("iteratorTest");
        testValue = 1.0f;
        totalPoints += testValue;
		
        List<Integer> ldl = creaListaVacia();
        int i;
        for (i = 0; i < 10; i++) {
            ldl.add(i + 10);
        }
        Iterator<Integer> it = ldl.iterator();
        i = 0;
        while (it.hasNext()) {
            assertEquals(i + 10, it.next().intValue());
            i++;
        }
        
		points += testValue;
    }

    @Test
    public void indexOfTest() {
        System.out.println("indexOfTest");
        testValue = 0.25f;
        totalPoints += testValue;
		
        List<Integer> ldl = creaListaVacia();
        ldl.add(10);
        ldl.add(11);
        ldl.add(12);
        ldl.add(13);
        assertEquals(2, ldl.indexOf(12));
        
		points += testValue;
    }

    @Test
    public void lastIndexOfTest() {
        System.out.println("lastIndexOfTest");
        testValue = 0.25f;
        totalPoints += testValue;
		
        List<Integer> ldl = creaListaVacia();
        ldl.add(10);
        ldl.add(11);
        ldl.add(12);
        ldl.add(13);
        ldl.add(12);
        ldl.add(15);
        ldl.add(11);
        assertEquals(4, ldl.lastIndexOf(12));
        assertEquals(6, ldl.lastIndexOf(11));
        
		points += testValue;
    }

    @Test
    public void listIteratorTest() {
        System.out.println("listIteratorTest");
        testValue = 1.0f;
        totalPoints += testValue;
		
        List<Integer> ldl = creaListaVacia();
        int i;
        for (i = 0; i < 20; i++) {
            ldl.add(20 + i);
        }

        ListIterator<Integer> lit = ldl.listIterator();
        i = 0;
        while (lit.hasNext()) {
            assertEquals(20 + i, lit.next().intValue());
            i++;
        }

        while (lit.hasPrevious()) {
            i--;
            assertEquals(20 + i, lit.previous().intValue());

        }
        
		points += testValue;
    }

    @Test
    public void listIteratorIndexTest() {
		System.out.println("listIteratorIndexTest");
        testValue = 1.0f;
        totalPoints += testValue;
		
        List<Integer> ldl = creaListaVacia();
        int i;
        for (i = 0; i < 20; i++) {
            ldl.add(20 + i);
        }
        i = 0;
        ListIterator lit = ldl.listIterator(++i);

        while (lit.hasNext()) {
            assertEquals(20 + i, lit.next());
            i++;
        }

        while (lit.hasPrevious()) {
            i--;
            assertEquals(20 + i, lit.previous());

        }
        
		points += testValue;
    }

	
    @Test
    public void subListTest() {
        System.out.println("subListTest");
        testValue = 1.0f;
		
		// Esta función da puntos extra
        // totalPoints += testValue;
		
        List<Integer> ldl = creaListaVacia();
        int i;
        for (i = 0; i < 10; i++) {
            ldl.add(10 + i);
        }
        i = 3;
		
		try {
			List subL=ldl.subList(i, i + 5);
			for (Object e : subL) {
				assertEquals(10 + i, e);
				i++;
			}

			points += testValue;
		} catch (UnsupportedOperationException e) {
			System.out.println("  <sin implementar>");
		}
    }
	

    @Test
    public void removeAll() {
		System.out.println("removeAll");
        testValue = 0.25f;
        totalPoints += testValue;
		
        //List<Integer> ldl = creaListaVacia();
		
        LinkedList l = new LinkedList();
        int i;
        for (i = 0; i < 20; i++) {
            l.add(i + 10);
        }
        ListaDoblementeLigada<Integer> ldl = new ListaDoblementeLigada<>();
        for (i = 0; i < 20; i += 2) {
            ldl.add(i + 10);
        }

        ldl.removeAll(l);
        i = 1;
        for (int e : ldl) {
			//System.out.println(e + " " + i);
            assertEquals(i + 10, e);
            i += 2;
        }
        
		points += testValue;
    }

    @Test
    public void retainAllTest() {
		System.out.println("retainAllTest");
        testValue = 0.25f;
        totalPoints += testValue;
		
        //List<Integer> ldl = creaListaVacia();
        LinkedList<Integer> l = new LinkedList<>();
        int i;
        for (i = 0; i < 20; i+=2) {
            l.add(i + 10);
        }
        ListaDoblementeLigada<Integer> ldl=new ListaDoblementeLigada<>();
        for (i = 0; i < 20; i++) {
            l.add(i + 10);
        }
        
        ldl.retainAll(l);
        i=0;
        for(Integer e:ldl){
            assertEquals(i+10, (long)e);
            i+=2;
        }
        
		points += testValue;
    }

    @Test
    public void toArrayTest() {
		System.out.println("toArrayTest");
        testValue = 0.25f;
        totalPoints += testValue;
		
        List<Integer> ldl = creaListaVacia();
        int i;
        for(i=0;i<10;i++){
            ldl.add(20+i);
        }
        Object[] array=ldl.toArray();
        i=0;
        if(array.length!=10){
            fail("el arreglo no es del tamaño adecuado ");
        }
        for(Object e:array){
            assertEquals(20+i, e);
            i++;
        }    
        
		points += testValue;
    }
}
