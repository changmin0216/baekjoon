
import java.io.*;
import java.util.*;
public class Solution {
	static int n, s_y, s_x, e_y, e_x;
	static int[] perm;
	static boolean[] visited;
	static int[][] points;
	static int result;
	
	static void cal() {
		int dist = Math.abs(s_y - points[perm[0]][0]) + Math.abs(s_x - points[perm[0]][1]);
		for (int i=1;i<n;i++) {
			dist += Math.abs(points[perm[i]][0] - points[perm[i-1]][0]) 
					+ Math.abs(points[perm[i]][1] - points[perm[i-1]][1]);
		}
		dist += Math.abs(e_y - points[perm[n-1]][0]) + Math.abs(e_x - points[perm[n-1]][1]);
		
		result = Math.min(result, dist);
		return;
	}
	static void perm(int depth) {
		if (depth == n) {
			cal();
			return;
		}
		
		for(int i=0;i<n;i++) {
			if(visited[i]) continue;
			perm[depth] = i;
			visited[i]=true;
			perm(depth+1);
			visited[i]=false;
		}
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=t;tc++) {
			n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			s_y = Integer.parseInt(st.nextToken());
			s_x = Integer.parseInt(st.nextToken());
			
			e_y = Integer.parseInt(st.nextToken());
			e_x = Integer.parseInt(st.nextToken());
			
			points = new int[n][2];
			for (int i=0;i<n;i++) {
				points[i][0] = Integer.parseInt(st.nextToken());
				points[i][1] = Integer.parseInt(st.nextToken());
			}
			
			
			
			visited = new boolean[n];
			result = Integer.MAX_VALUE;
			perm = new int[n];
			perm(0);
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}

/*
 *회사에서 출발, n명의 고객을 방문하고 집으로 돌아간다.
 * 각 위치는 좌표로 주어진다.
 * 회사에서 출발하여 n명의 고객을 모두 방문하고 집으로 돌아오는 경로 중 가장 짧은 경로
 * MST 문제 --> 크루스칼, 프림
 * 
 * 
 * 2<=n<=10
 * 크루스칼 알고리즘 시간복잡도 : O(ElogE) --> 모든 간선을 정렬하는 과정
 * 프림 알고리즘 시간 복잡도 : O(ElogV)
 * 
 * 각 좌표값은 주어진다. ---> 연결이 어떻게 되어 있다고 가정할까 --> 
 * 그리디 하게 해볼까. --> 현재 위치에서 가장 가까운 고객의 좌표를 찾는다(채택) --> union find?
 * 그리고 마지막 좌표에서 집까지 거리를 더한다.
 * 이게 가장 최적의 방법인 이유가 뭘까
 * 굳이 순환하지 않아야 할까? 한번 왔던 곳을 굳이 다시 갈 필요가 없다!!!!
 * 내 풀이가 틀린 이유 : 주어진 문제의 조건은 출발점이 정해져 있고 도착점이 정해져 있는 문제이다. --> 이런 case는 최소 신장 트리 문제가 아니다
 * 그럼 어떻게 풀어야 할까?
 * 이 문제는 n의 범위가 작다. n<=10 --> 10!은 얼마일까 --> 3000000 ㄱㄱ
 */