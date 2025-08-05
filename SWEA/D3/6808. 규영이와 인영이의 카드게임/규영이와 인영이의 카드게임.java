import java.io.*;
import java.util.*;

public class Solution {
	static int[] arr;
	static ArrayList<Integer> card;
	static boolean[] v;
	static int[] b;
	static boolean[] visited;
	static int win;
	static int loose;
	static void perm(int cnt) {
//		System.out.println(cnt);
		if (cnt==9) {
			int op_sum = 0;
			int me_sum = 0;
			for (int i=0;i<9;i++) {
				if (arr[i] > b[i]) {
					op_sum+=(arr[i]+b[i]);
				}
				else if (arr[i] < b[i]) {
					me_sum+=(arr[i]+b[i]);
				}
			}
//			System.out.println(op_sum);
//			System.out.println(me_sum);
			if (op_sum>me_sum) loose+=1;
			else if (op_sum<me_sum) win+=1;
			return;
		}
//		System.out.println(Arrays.toString(visited));
		for (int i=0;i<9;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			b[cnt] = card.get(i);
			perm(cnt+1);
			visited[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			win=0;
			loose=0;
			arr = new int[9];
			b = new int[9];
			card = new ArrayList<>();
			v = new boolean[19];
			
			for (int i=0;i<9;i++) {
				int k = Integer.parseInt(st.nextToken());
				arr[i] = k;
				v[k] = true;
			}
			
			for (int i=1;i<=18;i++) {
				if (!v[i]) {
					card.add(i);
				}
			}
//			System.out.println(card);
			visited = new boolean[9];
			perm(0);
			sb.append("#").append(tc).append(" ").append(loose).append(" ").append(win).append("\n");
		}
		System.out.println(sb);
	}

}
