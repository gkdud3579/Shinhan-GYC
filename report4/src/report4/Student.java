package report4;

public class Student {
	int id;			//학번을 저장하는 변수
	String name;	//성명을 저장하는 변수
	int korean;		//국어 점수를 저장하는 변수
	int english;	//영어 점수를 저장하는 변수 
	int math;		//수학 점수를 저장하는 변수 
	int total;		//총점을 저장하는 변수 
	double average;	//평균을 저장하는 변수 
	int rank;		//순위를 저장하는 변수

	Student(int id, String name, int korean, int english, int math) {
		this.id = id;
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
		this.total = korean + english + math;
		this.average = total / 3.0;
	}
	
	 //성적 정보 출력 메소드
    public String toString() {
        return String.format("%4d\t%s\t%4d\t%4d\t%4d\t%4d\t%5.2f\t%4d", id, name, korean, english, math, total, average, rank);
    }
}





