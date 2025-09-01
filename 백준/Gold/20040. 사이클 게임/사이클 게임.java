//import java.io.*;
//import java.util.*;
//public class Test3_이창민 {
//	static int find_parent(int[] parent, int x) {
//		if(parent[x]!=x) {
//			parent[x] = find_parent(parent, parent[x]);
//		}
//		return parent[x];
//	}
//	
//	static void union_parent(int[] parent, int a, int b) {
//		a = find_parent(parent, a);
//		b = find_parent(parent, b);
//		
//		if (a<b) {
//			parent[b] = a;
//		} else parent[a] = b;
//	}
//	public static void main(String[] args) throws Exception {
//		//--------------솔루션 코드를 작성하세요.---------------------------
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		
//		st = new StringTokenizer(br.readLine());
//		int n = Integer.parseInt(st.nextToken());
//		int m = Integer.parseInt(st.nextToken());
//		
//		int[] parent = new int[n];
//		for(int i=0;i<n;i++) parent[i] = i;
//		
//		int cnt=0;
//		boolean flag = false;
//		for (int i=0;i<m;i++) {
//			st = new StringTokenizer(br.readLine());
//			int a = Integer.parseInt(st.nextToken());
//			int b = Integer.parseInt(st.nextToken());
//			
//			if (!flag) {
//				cnt++;
//				if(find_parent(parent, a)!=find_parent(parent, b)) {
//					union_parent(parent, a, b);
//				} else {
//					flag=true;
//				}
//			}
//		}
//		
//		if (!flag) System.out.println(0);
//		else System.out.println(cnt);
//	}
//}
import java.io.*;
import java.util.*;
public class Main {
	static int find_parent(int[] parent, int x) {
		if(parent[x]!=x) {
			parent[x] = find_parent(parent, parent[x]);
		}
		return parent[x];
	}
	
	static void union_parent(int[] parent, int a, int b) {
		a = find_parent(parent, a);
		b = find_parent(parent, b);
		
		if (a<b) {
			parent[b] = a;
		} else parent[a] = b;
	}
	public static void main(String[] args) throws Exception {
		//--------------솔루션 코드를 작성하세요.---------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] parent = new int[n];
		for(int i=0;i<n;i++) parent[i] = i;
		
		int cnt=0;
		boolean flag = false;
		for (int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (!flag) {
				if(find_parent(parent, a)!=find_parent(parent, b)) {
					cnt++;
					union_parent(parent, a, b);
				} else {
					cnt++;
					flag=true;
				}
			}
		}
		
		if (!flag) System.out.println(0);
		else System.out.println(cnt);
	}
}

