package datastructures.sorting;

public class StudentTester {

	public static void main(String[] args) {
		Student[] students = {
				new Student((short)120, "John"),
				new Student((short)80, "Dirk"),
				new Student((short)70, "Heinz"),
				new Student((short)70, "Heinz"),
				new Student((short)70, "Peter"),
				new Student((short)110, "Anton")
		};
		
		CompareTester.test(students);

	}

}
