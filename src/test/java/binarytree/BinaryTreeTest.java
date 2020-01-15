package binarytree;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BinaryTreeTest {

	private static String[] testdata = {"Mike","Hotel","Delta","Romeo","Victor","Foxtrot","Bravo","Kilo","India","Papa","Alpha","Yankee","Tango","Echo","Charlie","Oscar","Xray","Zulu","November","Juliet","Lima","Golf","Uniform","Quebec","Sierra","Whiskey"};
	
	private BinaryTree<Person> tree = null;
	private List<Comparable<Person>> persons = null;

	
	@BeforeEach
	public void setUp() {
		tree = new BinaryTree<>();
		persons = new ArrayList<>();
		for(String name : testdata){
			Comparable<Person> c = new Person(name);
			persons.add(c);
		}
	}
	
	@Test
	public void testInsertElement() {
		assertFalse(tree.insertElement(null));
		
		for(Comparable<Person> p : persons) {
			assertTrue(tree.insertElement(p));
			Comparable<Person> actual  = tree.getCurrentElement();
			assertEquals(p, actual);
		}
	}

	@Test
	public void testClear() {
		for(Comparable<Person> p : persons) {
			tree.insertElement(p);
		}
		assertNotNull(tree.getRootNode());
		tree.clear();
		assertNull(tree.getRootNode());
			
	}

	@Test
	public void testCountElements() {
		int count = 0; 
		int expected;
		int actual   = tree.countElements();
		assertEquals(count , actual);
		for(Comparable<Person> p : persons) {
			tree.insertElement(p);
			count++;
			actual  = tree.countElements();
			expected  = count;
			assertEquals(expected, actual);
		}
		actual   = tree.countElements();
		expected  = persons.size();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetFirstElement() {
		
		assertNull(tree.getFirstElement());
		
		for(Comparable<Person> p : persons) {
			tree.insertElement(p);
		}
		Comparable<Person> actual  = tree.getFirstElement();
		Person expected  = new Person("Alpha");
		assert actual != null;
		assertEquals(0,actual.compareTo( expected));
		
		tree.remove();
		actual  = tree.getFirstElement();
		expected  = new Person("Bravo");
		assertEquals(0,actual.compareTo( expected));
		
		tree.remove();
		actual  = tree.getFirstElement();
		expected  = new Person("Charlie");
		assertEquals(0,actual.compareTo( expected));
		
		tree.remove();
		actual  = tree.getFirstElement();
		expected  = new Person("Delta");
		assertEquals(0,actual.compareTo( expected));
		
		tree.remove();
		actual  = tree.getFirstElement();
		expected  = new Person("Echo");
		assertEquals(0,actual.compareTo( expected));
		
		tree.remove();
		actual  = tree.getFirstElement();
		expected  = new Person("Foxtrot");
		assertEquals(0,actual.compareTo( expected));
		
		tree.remove();
		actual  = tree.getFirstElement();
		expected  = new Person("Golf");
		assertEquals(0,actual.compareTo( expected));
		
	}

	@Test
	public void testGetLastElement() {
		
		assertNull(tree.getLastElement());
		
		for(Comparable<Person> p : persons) {
			tree.insertElement(p);
		}
		Comparable<Person> actual  = tree.getLastElement();
		Comparable<Person> expected  = new Person("Zulu");
		assertEquals(0,actual.compareTo((Person) expected));
		
		tree.remove();
		actual  = tree.getLastElement();
		expected  = new Person("Yankee");
		assertEquals(0,actual.compareTo((Person) expected));
		
		tree.remove();
		actual  = tree.getLastElement();
		expected  = new Person("Xray");
		assertEquals(0,actual.compareTo((Person) expected));
		
		tree.remove();
		actual  = tree.getLastElement();
		expected  = new Person("Whiskey");
		assertEquals(0,actual.compareTo((Person) expected));
		
		tree.remove();
		actual  = tree.getLastElement();
		expected  = new Person("Victor");
		assertEquals(0,actual.compareTo((Person) expected));
		
		tree.remove();
		actual  = tree.getLastElement();
		expected  = new Person("Uniform");
		assertEquals(0,actual.compareTo((Person) expected));
	}

	@Test
	public void testGetNextElement() {
		for(Comparable<Person> p : persons) {
			tree.insertElement(p);
		}
		Comparable<Person> actual  = tree.getFirstElement();
		Person expected  = new Person("Alpha");
		assertEquals(0,actual.compareTo(expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("Bravo");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("Charlie");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("Delta");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("Echo");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("Foxtrot");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("Golf");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("Hotel");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("India");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("Juliet");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("Kilo");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("Lima");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("Mike");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("November");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("Oscar");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("Papa");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("Quebec");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("Romeo");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("Sierra");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("Tango");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("Uniform");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("Victor");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("Whiskey");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("Xray");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("Yankee");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		expected  = new Person("Zulu");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getNextElement();
		assertEquals(0,actual.compareTo( expected));
	}


	@Test
	public void testGetPreviousElement() {
		for(Comparable<Person> p : persons) {
			tree.insertElement(p);
		}
		Comparable<Person> actual  = tree.getLastElement();
		
		Person expected  = new Person("Zulu");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("Yankee");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("Xray");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("Whiskey");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("Victor");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("Uniform");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("Tango");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("Sierra");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("Romeo");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("Quebec");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("Papa");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("Oscar");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("November");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("Mike");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("Lima");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("Kilo");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("Juliet");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("India");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("Hotel");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("Golf");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("Foxtrot");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("Echo");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("Delta");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("Charlie");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("Bravo");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		expected  = new Person("Alpha");
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		assertEquals(0,actual.compareTo( expected));
		
		actual  = tree.getPreviousElement();
		assertEquals(0,actual.compareTo( expected));
	}
		
	

	@Test
	public void testRemove() {
		assertFalse(tree.remove());
		
		for(Comparable<Person> p : persons) {
			tree.insertElement(p);
		}
		
		Comparable<Person> o  = new Person("Hotel");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("Alpha");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("Bravo");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("Victor");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("Xray");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("India");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("Whiskey");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("Golf");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("Kilo");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("Mike");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("Charlie");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("Delta");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("Lima");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("Echo");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("Foxtrot");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("November");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("Juliet");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("Yankee");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("Zulu");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("Uniform");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("Sierra");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("Quebec");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("Oscar");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("Tango");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("Romeo");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		o  = new Person("Papa");
		assertTrue(tree.findElement(o));
		tree.remove();
		assertFalse(tree.findElement(o));
		
		assertNull(tree.getRootNode());
		tree.remove();
		assertNull(tree.getRootNode());
		
	}

	@Test
	public void testGetTotalTreeDepth() {
		 Collections.sort(persons, (a, b) -> a.compareTo((Person)b));
		 for(Comparable<Person> p : persons) {
			 tree.insertElement(p);
		 }
		 int actual = tree.getTotalTreeDepth();
		 int expected = persons.size();
		 assertEquals(expected, actual);
	}
	
	@Test
	public void testGetDepth() {
		 Collections.sort(persons, (a, b) -> a.compareTo((Person)b));
		 for(Comparable<Person> p : persons) {
			 tree.insertElement(p);
		 }
		 tree.getFirstElement();
		 int actual = tree.getDepth();
		 int expected = persons.size();
		 assertEquals(expected, actual);
		 
		 tree.clear();
		 Collections.sort(persons, (a, b) -> b.compareTo((Person)a));
		 for(Comparable<Person> p : persons) {
			 tree.insertElement(p);
		 }
		 tree.getLastElement();
		 actual = tree.getDepth();
		 expected = persons.size();
		 assertEquals(expected, actual);
		 
	}

	@Test
	public void testFindElement() {
		for(Comparable<Person> p : persons) {
			tree.insertElement(p);
		}
		
		for(Comparable<Person> p : persons) {
			assertTrue(tree.findElement(p));
		}
		
		assertFalse(tree.findElement(new Person("Sepp")));
		assertFalse(tree.findElement(null));
	}
	
	@Test
	public void testPrint() {
		for(Comparable<Person> p : persons) {
			tree.insertElement(p);
		}
		String actual = tree.print();
		String expected =
"                         /----- Zulu\n"+
"                 /----- Yankee\n"+
"                 |       \\----- Xray\n"+
"                 |               \\----- Whiskey\n"+
"         /----- Victor\n"+
"         |       |       /----- Uniform\n"+
"         |       \\----- Tango\n"+
"         |               \\----- Sierra\n"+
" /----- Romeo\n"+
" |       |       /----- Quebec\n"+
" |       \\----- Papa\n"+
" |               \\----- Oscar\n"+
" |                       \\----- November\n"+
"Mike\n"+
" |               /----- Lima\n"+
" |       /----- Kilo\n"+
" |       |       |       /----- Juliet\n"+
" |       |       \\----- India\n"+
" \\----- Hotel\n"+
"         |               /----- Golf\n"+
"         |       /----- Foxtrot\n"+
"         |       |       \\----- Echo\n"+
"         \\----- Delta\n"+
"                 |       /----- Charlie\n"+
"                 \\----- Bravo\n"+
"                         \\----- Alpha\n";
		assertEquals(expected, actual);
	}

}
