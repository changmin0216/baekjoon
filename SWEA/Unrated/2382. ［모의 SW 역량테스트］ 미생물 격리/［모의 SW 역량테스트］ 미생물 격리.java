
import java.io.*;
import java.util.*;
class Micro {
	int y;
	int x;
	int dir;
	int cnt;
	int prev_cnt;
	
	public Micro(int y, int x, int dir, int cnt, int prev_cnt) {
		super();
		this.y = y;
		this.x = x;
		this.dir = dir;
		this.cnt = cnt;
		this.prev_cnt = prev_cnt;
	}

	@Override
	public String toString() {
		return "Micro [y=" + y + ", x=" + x + ", dir=" + dir + ", cnt=" + cnt + ", prev_cnt=" + prev_cnt + "]";
	}
	
	
}
public class Solution {
	static int n, m, k;
	static Micro[][] map;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static boolean[][] visited;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		// 입력
		int T = Integer.parseInt(br.readLine());
		for (int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
//			map = new Micro[n][n];
			ArrayDeque<Micro> q = new ArrayDeque<>();
			for (int i=0;i<k;i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				q.offer(new Micro(y, x, dir-1, cnt, -1));
			}
			
			HashMap<Integer, Micro> map = new HashMap<>();
			//시뮬레이션
			for(int t=0;t<m;t++) {
				while(!q.isEmpty()) {
					Micro cur = q.poll();
					
					int ny = cur.y + dy[cur.dir];
					int nx = cur.x +dx[cur.dir];
					
					if (ny==0 || ny== n-1 || nx == 0 || nx == n-1) {
						cur.y = ny;
						cur.x = nx;
						//군집 개수 절반으로 죽여
						cur.cnt/=2;
						//방향 바꿔
						if (cur.dir==0) cur.dir=1;
						else if (cur.dir==1) cur.dir=0;
						else if (cur.dir==2) cur.dir=3;
						else cur.dir=2;
					} 
					
					
					int key = ny*n + nx;
					
					cur.y = ny; cur.x = nx;
					
	
					if (!map.containsKey(key)) {
						cur.prev_cnt = cur.cnt;
						map.put(key, cur);
					} else {
						Micro origin = map.get(key);

						if(origin.prev_cnt > cur.cnt) {
							origin.cnt+=cur.cnt;
						} else {
							cur.prev_cnt = cur.cnt;
							cur.cnt+=origin.cnt;
							map.put(key, cur);
						}
					}
				}
				for (Micro nm : map.values()) {
                    nm.prev_cnt = -1;
                    q.offer(nm);
                }
				map.clear();
			}
			int result=0;
			while(!q.isEmpty()) {
				Micro m = q.poll();
//				System.out.println(q.toString());
				result+=m.cnt;
			}
//			for (int t = 0; t < m; t++) { // 1. 시간의 흐름
//			    // 2. 매 시간마다 다음 상태를 기록할 새로운 맵 생성
//			    HashMap<Integer, ArrayList<Micro>> nextStateMap = new HashMap<>();
//
//			    // 3. [이동 단계]
//			    while (!q.isEmpty()) {
//			        Micro current = q.poll();
//			        
//			        // 다음 위치 계산
//			        int ny = current.y + dy[current.dir];
//			        int nx = current.x + dx[current.dir];
//			        
//			        // 약품 셀 처리
//			        if (ny == 0 || ny == n - 1 || nx == 0 || nx == n - 1) {
//			            current.cnt /= 2;
//			            // 방향 전환 (예: dir % 2 == 0 ? dir+1 : dir-1)
//			            if (current.dir == 0) current.dir = 1;
//			            else if (current.dir == 1) current.dir = 0;
//			            else if (current.dir == 2) current.dir = 3;
//			            else current.dir = 2;
//			        }
//			        
//			        current.y = ny;
//			        current.x = nx;
//			        
//			        // 미생물이 살아있으면 nextStateMap에 추가
//			        if (current.cnt > 0) {
//			            int key = ny * n + nx;
//			            if (!nextStateMap.containsKey(key)) {
//			                nextStateMap.put(key, new ArrayList<>());
//			            }
//			            nextStateMap.get(key).add(current);
//			        }
//			    }
//
//			    // 4. [병합 단계]
//			    for (ArrayList<Micro> list : nextStateMap.values()) {
//			        if (list.size() == 1) {
//			            q.offer(list.get(0)); // 군집이 하나면 그대로 q에 추가
//			        } else {
//			            // 여러 군집이 모였으면 병합
//			            int totalCnt = 0;
//			            int maxCnt = 0;
//			            int finalDir = -1;
//			            
//			            for (Micro micro : list) {
//			                totalCnt += micro.cnt;
//			                if (micro.cnt > maxCnt) {
//			                    maxCnt = micro.cnt;
//			                    finalDir = micro.dir;
//			                }
//			            }
//			            // 병합된 새로운 군집을 q에 추가
//			            q.offer(new Micro(list.get(0).y, list.get(0).x, finalDir, totalCnt, 0));
//			        }
//			    }
//			}

//			// 5. 최종 결과 계산
//			int result = 0;
//			while(!q.isEmpty()) {
//			    result += q.poll().cnt;
//			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
	}
}

/*
 * k개의 미생물 군집
 * N*N 구역
 * 바깥쪽에는 갈 수 없는 공간
 * 
 * 입력 :
 * 1. 미생물 군집의 위치, 미생물 수, 이동 방향
 * 2. 1시간마다 이동한다.
 * 3. 이동 후 약품이 칠해진 셀에 도착하면 미생물의 절반이 죽고, 이동방향이 반대로 바뀐다.
 * 4. 이동 후 두 개 이상의 군집이 한 셀에 모이는 경우 군집들이 합쳐지게 된다.
 * 	  미생물 수는 더해지고 이동방향은 군집 수가 가장 많은 군집의 이동방향(같은 경우는 없다)
 * 5. M 시간 후 남아 있는 미생물 수의 총합
 * 
 * 시간복잡도 :
 * 5<=N<=100, M<=1000, 최초 배치되어 있는 군집의 개수 k <=1000
 * 
 * 알고리즘 : 
 * 그냥 구현 인듯????
 * 미생물 클래스 만들자
 * 1초마다 미생물들 움직인다.
 * 	약품에 도착하면 절반 죽이고 이동 방향 반대로
 * 	두 개 이상의 군집이 한 셀에 모이는 경우는??? 
 * 		만약에 이동을 했어. 근데 이동한 곳에 미생물이 있어!! --> 일단 움직이고 나중에 처리를 하고 싶은데 --> 이동한 미생물들을 어디에 넣어둘까 --> map 자료구조??? 키 값은 유니크 값....
 * 매 초마다 prev_cnt는 초기화 해줘야 할듯하다.
 */