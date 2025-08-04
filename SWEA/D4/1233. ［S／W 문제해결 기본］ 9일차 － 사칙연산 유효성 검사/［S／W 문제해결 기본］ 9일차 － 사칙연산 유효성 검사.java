import java.io.*;
import java.util.*;

public class Solution {
	static int n;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1;tc<=10;tc++) {
			n = Integer.parseInt(br.readLine());	
			
			int answer = 1;
			for (int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				
				String s = st.nextToken();
				if (st.hasMoreTokens()) {
					if (!s.equals("/") && !s.equals("*") && !s.equals("+") && !s.equals("-")) {
						answer = 0;
					}
				}
				else {
					if (s.equals("/") && s.equals("*") && s.equals("+") && s.equals("-")) {
						answer = 0;
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
