/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ed.estructuras.lineales;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author julio, blackzafiro
 */
public class ListaDoblementeLigadaTest extends ListaTest {
	
	@Override
	protected List<Integer> creaListaVacia() {
		return new ListaDoblementeLigada<>();
	}
	
	@Override
	protected List<String> creaListaVaciaCad() {
		return new ListaDoblementeLigada<>();
	}

}
