import java.io.*;
import java.util.*;

public class Solution {
	//구슬을 쏘아 벽돌을 깨트리는 게임
	//구슬은 N번만 쏠 수 있고 별돌들의 정보는 W x H 배열
	//0은 빈 공간, 그 외 숫자는 벽돌을 의미
	
	//게임의 규칙
	//1. 구슬은 좌, 우로만 움직일 수 있어서 항상 맨 위에 있는 벽돌만 깨트릴 수 있다.
	//2. 벽돌은 숫자 1~9로 표현되며, 구슬이 명중한 벽돌은 상하좌우로 (벽돌에 적힌 숫자 -1)칸 만큼 같이 제거된다.
	//3. 제거되는 범위 내에 있는 벽돌은 동시에 제거된다.
	
	/*
	 * 모든 경우의 수를 다 계산
	 * 
	 */
	static int N, W, H, answer;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	
	static void dfs(int depth, int[][] arr) {
		if(answer == 0) return;
		if(getCnt(arr)==0) {
			answer = 0;
			return;
		}
		if(depth==N) {
			answer = Math.min(answer, getCnt(arr));
			return;
		}
		
		for (int i=0;i<W;i++) {
			boolean[][] visited = new boolean[H][W];
			int[][] temp = copy(arr);
			boolean flag=false;
			for (int j=0;j<H;j++) {
				if(arr[j][i]>0) {
					remove(arr, j, i, temp, visited);
					down(temp);
					flag = true;
					break;
				}
			}
			if(flag) dfs(depth+1, temp);
		}
	}
	
	static void down(int[][] arr) {
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (int j=0;j<W;j++) {
			for (int i=0;i<H;i++) {
				if(arr[i][j]>0) stack.push(arr[i][j]);
				arr[i][j] = 0;
			}
			int index=H-1;
			while(!stack.isEmpty()) {
				arr[index--][j]=stack.pop();
			}
		}
	}
		
	//벽돌을 제거, temp배열에서 제거한 결과를 저장하고, arr에서는 뭘 제거할 지 찾음
	static void remove(int[][]arr,int x,int y,int[][]temp,boolean[][]visited) {
		for(int i=0;i<4;i++) {
			for(int k=0;k<arr[x][y];k++) {
				int nx=x+dx[i]*k;
				int ny=y+dy[i]*k;
				if(nx>=0&&nx<H&&ny>=0&&ny<W&&!visited[nx][ny]) {
					visited[nx][ny]=true;
					temp[nx][ny]--;
					if(arr[nx][ny]>0){
						temp[nx][ny]=0;
						remove(arr, nx, ny,temp,visited);
					}
				}
			}
		}
	}
	
	//벽돌의 수 리턴
	static int getCnt(int[][]arr) {
		int result=0;
		for(int[]a:arr) {
			for(int i:a) {
				if(i>0)result++;
			}
		}
		return result;
	}
	
	//배열 복사
	static int[][]copy(int[][]arr){
		int[][]temp=new int[H][W];
		for(int i=0;i<H;i++)System.arraycopy(arr[i], 0, temp[i], 0, W);
		return temp;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[H][W];
			for (int i=0;i<H;i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<W;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			answer=Integer.MAX_VALUE;
			dfs(0, map);
			
			sb.append("#"+tc+" "+answer+"\n");
		}
		System.out.println(sb);
	}

}
