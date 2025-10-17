
import java.io.*;
import java.util.*;
public class Main{
	static int n, k;
	static int[] belt;
	static boolean[] hasRobot;
	static ArrayDeque<Integer> q;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		belt = new int[n*2];
		hasRobot = new boolean[n];
		q = new ArrayDeque<>();
		st = new StringTokenizer(br.readLine());
		for (int i=0;i<n*2;i++) {
			belt[i] = Integer.parseInt(st.nextToken());
		}
		int cnt;
		for (cnt=1;;cnt++) {
			moveBelt();
			moveRobot();
			putRobot();
			if (check()) break;
		}
		System.out.println(cnt);
		
	}
	
	static boolean check() {
		int cnt = 0;
		for (int i=0;i<n*2;i++) {
			if (belt[i]==0) cnt++;
		}
		if (cnt>=k) return true;
		return false;
	}
	
	static void moveBelt() {
		int last = belt[n*2-1];
		int prev = belt[0];
		for (int i=1;i<n*2;i++) {
			int k = belt[i];
			belt[i] = prev;
			prev = k;
		}
		belt[0] = last;
		
		hasRobot = new boolean[n];
		int size = q.size();
		for (int i=0;i<size;i++) {
			int now = q.poll();
			
			int next_idx = now+1;
			
			if (next_idx==n-1) {
				continue;
			} else {
				q.add(next_idx);
				hasRobot[next_idx] = true;
			}
		}
	}
	
	static void moveRobot() {
		int size = q.size();
		for (int i=0;i<size;i++) {
			int now = q.poll();
			
			int next_idx = now+1;
			
			//이미 로봇이 있는 경우
			if (hasRobot[next_idx]) {
				q.add(now);
				continue;
			}
			//내구도가 0인 경우
			if (belt[next_idx]==0) {
				q.add(now);
				continue;
			}
			
			hasRobot[next_idx] = true;
			belt[next_idx]-=1;
			hasRobot[now] = false;
			
			if (next_idx==n-1) {
				hasRobot[next_idx] = false;
			} else {
				q.add(next_idx);
			}
		}
	}
	
	static void putRobot() {
		if(belt[0]!=0 && !hasRobot[0]) {
			q.add(0);
			belt[0]-=1;
			hasRobot[0] = true;
		}
	}
}

/*
 * 1 2 1
 * 2 1 2
 * 
 * 1번째 타임
 * 1-1 벨트 이동
 * 2 1 2
 * 1 2 1
 * 
 * 1-2 로봇 올림
 * 1(로봇) 1 2
 * 1 2 1
 * 
 * 2번째 타임
 * 2-1 벨트 이동
 * 1 1(로봇) 1
 * 2 1 2
 * 
 * 2-2 로봇 이동
 * 1 1 0
 * 2 1 2
 * 
 * 2-3 로봇 올림
 * 0 1 0
 * 2 1 2
 * 
 * 
 * k = 2
 */
