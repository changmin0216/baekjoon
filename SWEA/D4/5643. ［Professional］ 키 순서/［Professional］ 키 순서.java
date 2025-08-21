
import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			int n = Integer.parseInt(br.readLine());
			int m = Integer.parseInt(br.readLine());
			
			int[][] dist = new int[n+1][n+1];
			for (int i=1;i<n+1;i++) Arrays.fill(dist[i], 10000);
			for (int i=1;i<n+1;i++) {
				dist[i][i] = 0;
			}
			
			for (int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				dist[a][b] = 1;
//				dist[b][a] = 1;
			}
			
			for (int k=1;k<n+1;k++) {
				for (int i=1;i<n+1;i++) {
					for (int j=1;j<n+1;j++) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
					}
				}
			}

			
			
			for (int i=1;i<n+1;i++) {
				for (int j=1;j<n+1;j++) {
					if (dist[i][j] == 10000) {
						if (dist[j][i]!=10000) dist[i][j] = dist[j][i];
					}
				}
			}
			
			int cnt = 0;
			for (int i=1;i<n+1;i++) {
				boolean flag = false;
				for (int j=1;j<n+1;j++) {
					if (dist[i][j] == 10000) {
						flag = true;
						break;
					}
				}
				if(!flag) cnt++;
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}

}
