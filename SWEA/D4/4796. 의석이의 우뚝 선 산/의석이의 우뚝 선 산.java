import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;tc++) {
			int N = sc.nextInt();
			int[] h = new int[N];
			for(int i=0;i<N;i++) {
				h[i] = sc.nextInt();
				
			}
			int cnt = 0;
			int up = 0, down = 0;
			for(int i=1;i<N;i++) {
				if(h[i]>h[i-1]) {
					if(down>0) {
						cnt+=up*down;
						down = 0;
						up = 1;
					} else up++;
				} else {
					if(up>0) down++;
				}
			}
			if (down > 0) cnt+=up*down;
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
}