import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Knapsack {
	static int N, W;
	static String name[];
	static int volume[];
	static int need[];
	
	static int[][] cache = new int[100][100];	
	static List<String> picked = new LinkedList<String>();
	
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		int T = sc.nextInt(); 
		for(int test_case = 1; test_case <= T; test_case++) {
			int result=0;
			
			inputData(sc);
			initialize_cache();
			result = pack(W, 0);
			reconstruct(W, 0);
			printResult(test_case, result);
		}
	}
	
	
	private static void inputData(Scanner sc) {
		N = sc.nextInt();
		W = sc.nextInt();
		name = new String[N];
		volume = new int[N];
		need = new int[N];

		for(int i=0; i<N; i++) {
			name[i] = sc.next();
			volume[i] = sc.nextInt();
			need[i] = sc.nextInt();
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
		System.out.println(result + " " + picked.size());
		for(int i=0; i<picked.size(); i++) {
			System.out.println(picked.get(i));
		}
	}
	
	static int pack(int capacity, int item) {
		//base case
		if(item == N) return 0;
		
		if(cache[capacity][item] != -1) return cache[capacity][item];
		
		int result = pack(capacity, item+1);
		if(capacity >= volume[item]) {
			result = Math.max( result, pack(capacity-volume[item], item+1)+need[item] );
		}
		
		return result;
	}
	
	static void reconstruct(int capacity, int item) {
		//base case
		if(item == N) return;
		
		if( pack(capacity, item) == pack(capacity, item+1) ) {
			reconstruct(capacity, item+1);
		}
		else {
			picked.add(name[item]);
			reconstruct(capacity-volume[item], item+1);
		}
	}
}
