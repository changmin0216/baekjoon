

import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<N;i++) {
			int v = Integer.parseInt(st.nextToken());
			if (!map.containsKey(v)) {
				map.put(v, 1);
			} else {
//				map.
				map.put(v, map.get(v)+1);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<M;i++) {
			int v = Integer.parseInt(st.nextToken());
			if(map.get(v)!=null) {
				sb.append(map.get(v)).append(" ");
			} else {
				sb.append(0).append(" ");
			}
			
		}
		System.out.println(sb);
	}

}
