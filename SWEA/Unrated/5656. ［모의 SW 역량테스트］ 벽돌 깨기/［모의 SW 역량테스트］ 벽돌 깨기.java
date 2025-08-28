import java.io.*;
import java.util.*;

public class Solution {

	static int N, W, H, answer;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};

	static void dfs(int depth, int[][] arr) {
		
	    // 이미 최소값이 0이면 더 이상 탐색할 필요 없음
	    if (answer == 0) return;

	    // 남은 벽돌이 없으면 answer를 0으로 갱신하고 종료
	    if (getCnt(arr) == 0) {
	        answer = 0;
	        return;
	    }

	    // 구슬을 N번 모두 쐈으면 남은 벽돌 개수를 최소값과 비교해 갱신
	    if (depth == N) {
	        answer = Math.min(answer, getCnt(arr));
	        return;
	    }

	    // 모든 열에 대해 구슬을 떨어뜨려 시뮬레이션
	    for (int i = 0; i < W; i++) {
	        boolean[][] visited = new boolean[H][W]; // 폭발 처리 중 방문 체크
	        int[][] temp = copy(arr);                // 현재 보드 상태 복사
	        boolean flag = false;                    // 해당 열에 벽돌이 있는지 여부

	        // 해당 열의 가장 위쪽 벽돌 찾기
	        for (int j = 0; j < H; j++) {
	            if (arr[j][i] > 0) {
	                // 벽돌 폭발 처리
	                boom(arr, j, i, temp, visited);
	                // 중력으로 벽돌 떨어뜨리기
	                down(temp);
	                flag = true; // 해당 열에 벽돌이 있었음
	                break;       // 맨 위 벽돌만 처리하므로 반복 중단
	            }
	        }

	        // 벽돌이 있었다면 다음 깊이로 탐색
	        if (flag) dfs(depth + 1, temp);
	    }
	}
	
	// 중력 효과를 적용하는 함수
	// arr : 폭발 후 보드 상태, 벽돌들을 아래로 떨어뜨림
	static void down(int[][] arr) {
	    ArrayDeque<Integer> stack = new ArrayDeque<>(); // 한 열의 벽돌을 임시로 저장

	    // 모든 열에 대해 처리
	    for (int j = 0; j < W; j++) {
	        // 현재 열에서 벽돌을 위에서부터 탐색
	        for (int i = 0; i < H; i++) {
	            if (arr[i][j] > 0) stack.push(arr[i][j]); // 벽돌이 있으면 스택에 저장
	            arr[i][j] = 0; // 해당 위치는 일단 빈 칸으로 초기화
	        }

	        // 스택에서 벽돌을 하나씩 꺼내며 아래쪽부터 채워 넣음
	        int index = H - 1; // 가장 아래 행부터 채우기 시작
	        while (!stack.isEmpty()) {
	            arr[index--][j] = stack.pop();
	        }
	    }
	}
		
	// 벽돌 폭발을 처리하는 함수
	// arr   : 원본 보드 상태
	// x, y  : 현재 폭발이 발생한 벽돌 위치
	// temp  : 폭발 후의 보드 상태를 반영할 배열
	// visited : 이미 폭발 처리한 위치를 체크하기 위한 배열
	static void boom(int[][] arr, int x, int y, int[][] temp, boolean[][] visited) {
	    // 4방향(상, 하, 좌, 우) 탐색
	    for (int i = 0; i < 4; i++) {
	        // 현재 벽돌의 숫자만큼 범위 확장
	        for (int k = 0; k < arr[x][y]; k++) {
	            int nx = x + dx[i] * k; 
	            int ny = y + dy[i] * k; 

	            // 보드 범위 안이고 아직 방문하지 않은 위치인 경우
	            if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny]) {
	                visited[nx][ny] = true;  // 방문 처리
	                temp[nx][ny]--;          // 벽돌 카운트를 감소 (중간 표시)

	                // 해당 위치에 벽돌이 남아 있다면 재귀로 연쇄 폭발 처리
	                if (arr[nx][ny] > 0) {
	                    temp[nx][ny] = 0;    // 해당 벽돌 제거
	                    boom(arr, nx, ny, temp, visited);
	                }
	            }
	        }
	    }
	}
	
	static int getCnt(int[][]arr) {
		int result=0;
		for(int[]a:arr) {
			for(int v:a) {
				if(v>0)result++;
			}
		}
		return result;
	}
	
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
