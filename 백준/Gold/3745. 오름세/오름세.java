
import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();		
		
		String line;
		while(true) {
			line = br.readLine();
			if (line==null) break;
			
			int n = Integer.parseInt(line.trim());
			int[] arr = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
			
			int[] L = new int[n];
			int max=0;
			for (int i=0;i<n;i++) {
				// 이진탐색???
				int pos = Arrays.binarySearch(L, 0, max, arr[i]);
				if(pos<0) pos=-(pos+1); //음수면 못 찾았다는 뜻
				L[pos]=arr[i];
				if(max==pos) max++;
			}
			System.out.println(max);
		}
	}
}