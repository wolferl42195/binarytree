package at.coderia.binarytree;

public class Person implements Comparable<Person> {
	
	private String name;
	
	public Person (String name){
		this.name=name;
	}

	@Override
	public int compareTo(Person o){
		return name.compareTo(o.getName());
	}

	public String getName() {
		return name;
	}

	public String toString(){
		return name;
	}
	
}
