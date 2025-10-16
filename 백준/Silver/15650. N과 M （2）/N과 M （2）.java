
import java.io.*;
import java.util.*;
public class Main{
	static int N, R;
	static int[] b;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		b = new int[R];
		comb(0, 0);
	}
	
	static void comb(int cnt, int start) {
		if (cnt == R) {
			for (int i=0;i<R;i++) {
				System.out.print(b[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for (int i=start;i<N;i++) {
			b[cnt] = i+1;
			comb(cnt+1, i+1);
		}
	}
}
