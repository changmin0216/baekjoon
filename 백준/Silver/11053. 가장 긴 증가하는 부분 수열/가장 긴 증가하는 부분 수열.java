import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] lis = new int[n];
		for (int i=0;i<n;i++) {
			lis[i] = 1;
			for (int j=0;j<i;j++) {
				if (arr[j] < arr[i] && lis[i]<lis[j]+1) {
					lis[i] = lis[j]+1;
				}
			}
		}
		int max = -1;
		for (int v:lis) {
			max = Math.max(max, v);
		}
		System.out.println(max);
	}

}
