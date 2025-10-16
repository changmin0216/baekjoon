
import java.io.*;
import java.util.*;
public class Main {
	static int R;
	static int N;
	static int[] a, b;
	static boolean[] v;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		//combination 문제
		a = new int[N];
		for (int i=1;i<=N;i++) {
			a[i-1] = i; 
		}
		
		b = new int[R];
		v = new boolean[N];
		
		perm(0);
	}
	
	static void perm(int cnt) {
		if (cnt == R) {
			for (int i=0;i<R;i++) {
				System.out.print(b[i]+" ");
			}
			System.out.println();
//			System.out.println(Arrays.toString(b));
			return;
		}
		for (int i = 0; i < N; i++) {
			if (v[i]) continue;
			v[i] = true;
			b[cnt] = a[i];
			perm(cnt+1);
			v[i] = false;
		}
	}
}
