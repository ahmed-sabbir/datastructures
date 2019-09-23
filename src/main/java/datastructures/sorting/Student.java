package datastructures.sorting;

import java.util.Comparator;

public class Student implements Comparable<Student>{
	
	private final short iq;
	private final String name;
	
	public Student(short iq, String name) {
		this.iq=iq;
		this.name=name;
	}
	
	private short getIq() {
		return iq;
	}

	private String getName() {
		return name;
	}
	
	public static final Comparator<Student> NATURAL_ORDER = 
			Comparator.comparingInt(Student::getIq)
						.reversed()
						.thenComparing(Student::getName);
	
	@Override
	public int compareTo(Student o) {
		return NATURAL_ORDER.compare(this, o);
	}

	@Override
	public String toString() {
		return "Student [iq=" + iq + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + iq;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (iq != other.iq)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
