package report4;

import java.util.*;

public class StudentManager {
	List<Student> students = new ArrayList<>();
	
	void addStudent(int id, String name, int korean, int english, int math) {
        Student student = new Student(id, name, korean, english, math);
        students.add(student);
        updateRank();
	}
	void updateRank() {
        Collections.sort(students, (s1, s2) -> s2.total - s1.total);
        int rank = 1;
        for (Student student : students) {
            student.rank = rank++;
        }
    }

    void printStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}