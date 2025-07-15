

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n, m, mid;
		long answer = 0;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		int left = 0;
		int right = Collections.max(list);
		while (left<=right) {
			mid = (left + right)/2;
			long sum = 0;
			for (int i=0;i<n;i++) {
				int tmp = list.get(i)-mid;
				if (tmp>0) {
					sum+=tmp;
				}
			}
			
			if (sum<m) {
				right = mid-1;
			}
			else {
				answer = mid;
				left = mid+1;
			}
		}
		System.out.println(answer);
	}
}