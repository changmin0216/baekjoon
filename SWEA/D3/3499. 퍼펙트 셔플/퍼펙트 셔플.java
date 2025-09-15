import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		ArrayDeque<String> q1 = new ArrayDeque<>();
		ArrayDeque<String> q2 = new ArrayDeque<>();
		for (int tc=1;tc<=T;tc++) {
			int n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			if (n%2==0) {
				for (int i=0;i<n;i++) {
					if (i < n/2) q1.offer(st.nextToken());
					else q2.offer(st.nextToken());				
				}
			} 
			else {
				for (int i=0;i<n;i++) {
					if (i <= n/2) q1.offer(st.nextToken());
					else q2.offer(st.nextToken());				
				}
			}
			
			
			sb.append("#").append(tc).append(" ");
			for (int i=0;i<n;i++) {
				if (i%2==0) sb.append(q1.poll()).append(" ");
				else sb.append(q2.poll()).append(" ");				
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
