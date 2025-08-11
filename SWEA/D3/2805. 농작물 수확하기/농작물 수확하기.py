import java.io.*;
import java.util.*;

public class Solution {
	static int n;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			n = Integer.parseInt(br.readLine());
			
			int[][] map = new int[n][n];
			for(int i=0;i<n;i++) {
				String s = br.readLine();
				for (int j=0;j<n;j++) {
					map[i][j] = s.charAt(j) - '0';
				}
			}
			int blank = n/2;
			int sum = 0;
			for (int i=0;i<n/2+1;i++) {
				for (int j=blank;j<blank+(i*2+1);j++) {
					sum+=map[i][j];
				}
				blank-=1;
			}
			blank = n/2;
			for(int i=n-1;i>n/2;i--) {
				for (int j=blank;j<blank+((n-1-i)*2+1);j++) {
					sum+=map[i][j];
				}
				blank-=1;
			}
			sb.append("#").append(tc+1).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}

}
