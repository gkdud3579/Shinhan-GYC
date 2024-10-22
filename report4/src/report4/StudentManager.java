package report4;

import java.util.*;

public class StudentManager {
	List<Student> students = new ArrayList<>();
	
	/***********************************************************************
	 * addStudent : 성적 데이터를 입력하는 함수
	 * @param id : 학번, name : 학생 이름, korean : 국어 성적, english : 영어 성적, math : 수학 성적
	 * @return void : none | Desc
	 ***********************************************************************/
	void addStudent(int id, String name, int korean, int english, int math) {
        Student student = new Student(id, name, korean, english, math);
        students.add(student);
        updateRank();
	}
	
	/***********************************************************************
	 * updateRank() : 순위를 업데이트하는 함수
	 * @param void : None | Desc
	 * @return void : None
		 ***********************************************************************/
	void updateRank() {
        Collections.sort(students, (s1, s2) -> s2.total - s1.total);
        int rank = 1;
        for (Student student : students) {
            student.rank = rank++;
        }
    }

    /***********************************************************************
     * printStudents() : 학생 정보를 출력하는 함수
     * @param void : None | Desc
     * @return void : None | Desc
    	 ***********************************************************************/
    void printStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}