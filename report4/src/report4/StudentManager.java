package report4;

import java.util.*;

public class StudentManager {
	List<Student> students = new ArrayList<>();
	
	 /***********************************************************************
     * isDuplicateId : 중복 학번을 검사하는 함수
     * @param id : 학번
     * @return boolean : true(중복) / false(중복 아님) | Desc
     ***********************************************************************/
    public boolean isDuplicateId(int id) {
        for (Student student : students) {
            if (student.id == id) {
                return true; 
            }
        }
        return false;
    }
	
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
	    students.sort((s1, s2) -> Double.compare(s2.average, s1.average));

	    int rank = 1;  // 첫 번째 순위
	    int previousRank = 1;  // 직전 부여된 순위
	    double previousAverage = -1;  // 직전 학생의 평균 (초기값: 불가능한 평균)

	    for (int i = 0; i < students.size(); i++) {
	        Student currentStudent = students.get(i);

	        if (currentStudent.average == previousAverage) {
	            currentStudent.rank = previousRank;
	        } else {
	            currentStudent.rank = rank;
	            previousRank = rank;  // 현재 순위를 이전 순위로 저장
	        }

	        previousAverage = currentStudent.average; 
	        rank++;
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