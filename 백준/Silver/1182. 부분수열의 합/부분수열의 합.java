
import java.io.*;
import java.util.*;
public class Main {
	static int n, s;
	static int[] arr, b;
	static int result;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		b = new int[n];
		result = 0;
		for (int i=1;i<=n;i++) {
			comb(0, 0, i);
		}
		System.out.println(result);
	}
	
	static void comb(int cnt, int start, int r) {
		if (cnt==r) {
			int sum = 0;
			for (int i=0;i<r;i++) {
				sum+=b[i];
			}
			if (sum == s) {
//				System.out.println(Arrays.toString(b));
				result++;
			}
			return;
		}
		
		for (int i=start;i<n;i++) {
			b[cnt] = arr[i];
			comb(cnt+1, i+1, r);
		}
	}
}
