package report3;

import java.util.Random;
import java.util.Scanner;

public class insertion {
	public static void main(String[] args) {
		//1. 사용자에게 입력값 받기
		Scanner scan = new Scanner(System.in);
		
		//1.1 최대값 입력받기
		System.out.print("최대값을 입력해주세요: ");
		int maxNum = scan.nextInt();
		//1.2 배열크기 입력받기
		System.out.print("배열의 크기를 입력해주세요: ");
		int arraySize = scan.nextInt();
		
		//2. 랜덤 배열 생성하기
		int[] array = new int[arraySize];
		Random random = new Random();
		
		//2.1 랜덤값을 생성한 배열에 채우기
		for(int i = 0; i < (arraySize); i++) {
			array[i] = random.nextInt(maxNum + 1); //nextInt메소드는 bound -1까지만 생성하기때문에 +1을 해줘야함
		}
		
		//2.2 랜덤값이 들어간 배열 출력
		System.out.print("삽입정렬 적용 전 배열: ");
		userMethod.printArray(array);
		
		//3. 삽입정렬 적용
		insertionSort(array);
		
		//4. 출력값 도출
		System.out.print("삽입정렬 적용 후 배열: ");
		userMethod.printArray(array);
		
		scan.close();
	}
	
	//삽입정렬 메소드
	public static void insertionSort(int[] array) {
		for(int i = 0; i < array.length; i++) {
			int key = array[i];
			int j = i - 1;
			
			while(j >= 0 && array[j] > key) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}
	}
}