package report3;

public class userMethod {
	// 배열 출력 메소드
		public static void printArray(int[] array) {
			for(int i = 0; i < array.length; i++) {
				int num = array[i];
				System.out.print(num + " "); //출력값 가독성을 위한 공백 추가
			}
		}
}
