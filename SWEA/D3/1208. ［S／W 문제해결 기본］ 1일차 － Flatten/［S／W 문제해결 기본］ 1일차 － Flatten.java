import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int tc=1;tc<=10;tc++) {
			int n = Integer.parseInt(br.readLine());
			
			int[] arr = new int[100];
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<100;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			
			for (int i=0;i<n;i++) {
				int max_index = 0;
				int min_index = 0;
				
				for (int j=0;j<100;j++) {
					if (arr[j]>arr[max_index]) {
						max_index = j;
					}
					
					else if(arr[j]<arr[min_index]) {
						min_index = j;
					}
				}
				
				arr[max_index]-=1;
				arr[min_index]+=1;
				
			}
			int result = Arrays.stream(arr).max().getAsInt() - Arrays.stream(arr).min().getAsInt();
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}

}
