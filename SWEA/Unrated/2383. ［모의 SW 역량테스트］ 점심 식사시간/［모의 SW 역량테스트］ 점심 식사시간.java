
import java.io.*;
import java.util.*;
public class Solution{
	static boolean[] selected;
	static int n;
	static int[][] map;
	static int[][] stair;
	static HashMap<Integer, int[]> hmap;
	static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int tc=1;tc<=T;tc++) {
			n = Integer.parseInt(br.readLine());
			
			map = new int[n][n];
			
			stair = new int[2][2];
			hmap = new HashMap<>();
			int p_idx = 0;
			int stair_idx = 0;
			for (int i=0;i<n;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<n;j++) {
					int v = Integer.parseInt(st.nextToken());
					if (v!=0) {
						if (v==1) {
							hmap.put(p_idx++, new int[] {i, j});
						}else {
							stair[stair_idx][0] = i;
							stair[stair_idx][1] = j;	
							stair_idx++;
						}	
					}
					map[i][j] = v;
				}
			}
			result = Integer.MAX_VALUE;
			selected = new boolean[hmap.size()];
			subset(0);
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
	
	static void subset(int idx) {
		if (idx==hmap.size()) {
			sol();
			return;
		}
		
		selected[idx] = true;
		subset(idx+1);
		
		selected[idx] = false;
		subset(idx+1);
	}
	
	static void sol() {
		ArrayList<Integer> g1 = new ArrayList<>();
		ArrayList<Integer> g2 = new ArrayList<>();		
		
		for (int i=0;i<selected.length;i++) {
			if (selected[i]) g1.add(i);
			else g2.add(i);
		}
		
		PriorityQueue<Integer> pq1 = new PriorityQueue<>((o1, o2)->o1-o2);
		PriorityQueue<Integer> pq2 = new PriorityQueue<>((o1, o2)->o1-o2);
		
		for (Integer v:g1) {
			int[] now = hmap.get(v);
			pq1.add(Math.abs(now[0]-stair[0][0]) + Math.abs(now[1]-stair[0][1])+1);
		}
		
		for (Integer v:g2) {
			int[] now = hmap.get(v);
			pq2.add(Math.abs(now[0]-stair[1][0]) + Math.abs(now[1]-stair[1][1])+1);
		}
		int len1 = map[stair[0][0]][stair[0][1]];
		int len2 = map[stair[1][0]][stair[1][1]];
		int time = 0;
		ArrayDeque<Integer> q1 = new ArrayDeque<>();
		ArrayDeque<Integer> q2 = new ArrayDeque<>();
		for (time=1;;time++) {
			
			int qs1 = q1.size();
			for (int i=0;i<qs1;i++) {
				int rem = q1.poll();
				rem-=1;
				if (rem > 0) q1.offer(rem);
			}
			
			int qs2 = q2.size();
			for (int i=0;i<qs2;i++) {
				int rem = q2.poll();
				rem-=1;
				if (rem > 0) q2.offer(rem);
			}
			
			while (q1.size() < 3 && !pq1.isEmpty() && pq1.peek() <= time) {
				pq1.poll();
				q1.offer(len1);
			}
			
			while (q2.size() < 3 && !pq2.isEmpty() && pq2.peek() <= time) {
				pq2.poll();
				q2.offer(len2);
			}
			
			if (pq1.isEmpty() && q1.isEmpty() && pq2.isEmpty() && q2.isEmpty()) {
				break;
			}
		}
		result = Math.min(result, time);
	}

}

/*
 * 아래 층으로 이동하는 시간 = 계단 입구까지 이동 시간 + 계단을 내려가는 시간
 * 
 * 계단 입구까지 이동시간 = 맨해튼 거리
 * 계단을 내려가는 시간
 * 	계단 입구에 도착하면 1분 후 아래 칸으로 내려 갈 수 있다.
 * 	계단 위에는 동시에 최대 3면까지만 올라가 있을 수 있다.
 * 	이미 계단을 3명이 내려가고 있는 경우, 그 중 한명이 계단을 완전히 내려갈 때까지 계단 입구에서 대기(큐)
 * 	계단마다 길이 k가 주어지며, 계단에 올라간 후 완전히 내려가는데 k분이 걸린다.
 * 
 * n*n 크기의 지도
 * 구하는 값 : 모든 사람들이 계단을 내려가 이동이 완료되는 시간이 최소가 되는 경우
 * 
 * 입력 크기
 * 4<=n<=10
 * 1<=사람 수<=10
 * 계단의 입구는 반드시 2개(겹치지X)
 * 계단의 길이는 2이상 10이하의 정수
 * 
 * 내 상각 : 
 * 부분집합으로 2개의 집합을 구성
 * (1, 2, 3), (4, 5, 6)
 * 각 계단까지의 거리 순으로 정렬
 * ((3, 2), (2, 3), (1, 4)), ((6, 2), (4, 3), (5, 3))
 * 
 * 1번 계단은 길이가 3
 * 2번 계단은 길이가 5
 * 
 * q1에다가 다 더하고 시간값을 하나 더해서 add
 * ((6, 3), (7, 3), (8, 3), (9, 3)) --> 3만큼만 pop하고 add??
 * 
 * 큐를 하나 더 만들자 --> size가 3이하인 큐
 * q2((6, 3), (7, 3), (8, 3))   (9,3)
 * (6,2), (7,2), (8, 2)
 * 
 * for (int time=1;time++)
 * 	(3), (4), (5)
 * 	if q.peek.time = time
 * 	if (q.size<=3)
 * 		q.add(계산 길이+1)
 * 	for (int i=0;i<q.size();i++) {
 * 		q.pop
 * 		q.add(now-1)
 * }
 */