import java.io.FileInputStream;
import java.util.Scanner;


public class JumpGame {
	static int N; //y
	static int M; //x
	static int board[][];
	
	static int cache[][] = new int[100][100];
	
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int T = sc.nextInt(); 
		for(int test_case = 1; test_case <= T; test_case++) {
			int result=-1;
			
			inputData(sc);
			initialize_cache();
			result = jump(0, 0);
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
	
	private static void initialize_cache() {
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				cache[i][j]=-1;
			}
		}
	}
	
	private static void printResult(int test_case, int result) {
		System.out.println("Case #" + test_case);
		if(result == 0) {
			System.out.println("False");
		}
		else {
			System.out.println("True");
		}
	}
	
	static int jump(int y, int x) {
		//base case1
		if(y>=N || x>=M) return 0;
		//base case2
		if(y==N-1 && x==M-1) return 1;
		
		if(cache[y][x] != -1) return cache[y][x];
		
		int jumpSize = board[y][x];
		return cache[y][x] = jump(y+jumpSize, x)+jump(y, x+jumpSize);
	}
}
