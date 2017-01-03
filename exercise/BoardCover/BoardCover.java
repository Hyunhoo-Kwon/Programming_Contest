import java.io.FileInputStream;
import java.util.Scanner;


public class BoardCover {
	static int N; //y
	static int M; //x
	static int board[][];
	
	final static int[][][] coverType = new int[][][] {
		{ {0,0}, {1,0}, {0,1} },
		{ {0,0}, {0,1}, {1,1} },
		{ {0,0}, {1,0}, {1,1} },
		{ {0,0}, {1,0}, {1,-1} }
	}; //int[4][3][2]
	
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
	
		int T = sc.nextInt(); 
		for(int test_case = 1; test_case <= T; test_case++) {	
			int result=-1;
			
			inputData(sc);
			result = solve();
			printResult(test_case, result);
		}
	}
	
	private static void inputData(Scanner sc) {
		N = sc.nextInt();
		M = sc.nextInt();
		board = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				board[i][j] = sc.nextInt();
			}
		}
	}
	
	private static void printResult(int test_case, int result) {
		System.out.println("Case #" + test_case);
		System.out.println(result);
	}
	
	private static int solve() {
		int white_board=0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(board[i][j] == 0)
					white_board++;
			}
		}
		
		if( white_board%3 == 0) {
			return cover();
		}
		else {
			return 0;
		}
	}
	
	static int cover() {
		int y=-1, x=-1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(board[i][j] == 0) {
					y = i;
					x = j;
					break;
				}
			}
			if(y != -1) break;
		}
		
		//base case
		if(y == -1) return 1;	
		
		int result=0;
		for(int type=0; type<4; type++) {
			if( setBoard(type, y, x, 1) == true ) {
				result = result + cover();
			}
			setBoard(type, y, x, -1);
		}
		
		return result;
	}
	
	
	//boardÀÇ (y,x)¸¦ µ¤°Å³ª, µ¤¾ú´ø ºí·ÏÀ» ¾ø¾Ø´Ù.
	//delta=1 ÀÌ¸é µ¤°í, -1ÀÌ¸é µ¤¾ú´ø ºí·ÏÀ» ¾ø¾Ø´Ù.
	static boolean setBoard(int type, int y, int x, int delta) {
		boolean result = true;
		
		for(int i=0; i<3; i++) {
			int nextY = y + coverType[type][i][0];
			int nextX = x + coverType[type][i][1];
			
			if( nextY<0 || nextY>=N || nextX<0 || nextX>=M ) {
				result = false;
			}
			else {
				board[nextY][nextX] = board[nextY][nextX]+delta;
				if(board[nextY][nextX]>1 ) {
					result = false;
				}
			}
		}
		
		return result;
	}
	
}
