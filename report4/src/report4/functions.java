package report4;

public class functions {
	/***********************************************************************
	 * ClearScreen() : 콘솔 창 지우기
	 * @param void : None
	 * @return void : None
	 * @throws Exception
	 ***********************************************************************/
	public static void ClearScreen() {
	    try {
	        if (System.getProperty("os.name").contains("Windows")) {
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        } else {
	            // Unix 및 MacOS 시스템을 위한 ANSI escape 코드 사용
	            System.out.print("\033[H\033[2J");
	            System.out.flush();  // 버퍼를 비워 콘솔 창을 확실히 지웁니다.
	        }
	    } catch (Exception ex) {
	        ex.printStackTrace();  // 에러 발생 시 에러 메시지 출력
	    }
	}
}