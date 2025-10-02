
import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<int[]> arr = new ArrayList<>();
		for (int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr.add(new int[] {x, y});
		}
		
		arr.sort((o1, o2)->{
			if (o1[0]!=o2[0]) return o1[0]-o2[0];
			return o1[1]-o2[1];
		});
		
		for (int[] p : arr) {
			System.out.println(p[0]+" "+p[1]);
		}
	}

}
