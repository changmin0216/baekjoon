import java.util.*;
import java.io.*;

public class Solution {
    static char[][] map;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static char[] d = {'^','v','<','>'};
    static int cur_y, cur_x;
    static int h, w;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc=1;tc<=T;tc++) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            cur_y = -1;
            cur_x = -1;
            for (int i=0;i<h;i++) {
                char[] list = br.readLine().toCharArray();
                for (int j=0;j<w;j++) {
                    if (list[j] == '<' || list[j] == '>' || list[j] == 'v' || list[j] == '^') {
                        cur_y = i;
                        cur_x = j;
                    }
                    map[i][j] = list[j];
                }
            }
            
            int cmd_cnt = Integer.parseInt(br.readLine());
            char[] cmd = br.readLine().toCharArray();
            for (int i=0;i<cmd_cnt;i++) {
                switch(cmd[i]) {
                case 'U':
                	map[cur_y][cur_x] = '^';
                    if(0<=cur_y-1&&cur_y-1<h && map[cur_y-1][cur_x]=='.') {
                        map[cur_y][cur_x] = '.';
                        map[cur_y-1][cur_x] = '^';
                        cur_y-=1;
                    }
                    break;
                case 'D':
                	map[cur_y][cur_x] = 'v';
                    if(0<=cur_y+1&&cur_y+1<h && map[cur_y+1][cur_x]=='.') {
                        map[cur_y][cur_x] = '.';
                        map[cur_y+1][cur_x] = 'v';
                        cur_y+=1;
                    }
                    break;
                case 'L':
                	map[cur_y][cur_x] = '<';
                    if(0<=cur_x-1&&cur_x-1<w && map[cur_y][cur_x-1]=='.') {
                        map[cur_y][cur_x] = '.';
                        map[cur_y][cur_x-1] = '<';
                        cur_x-=1;
                    }
                    break;
                case 'R':
                	map[cur_y][cur_x] = '>';
                	if(0<=cur_x+1&&cur_x+1<w && map[cur_y][cur_x+1]=='.') {
                        map[cur_y][cur_x] = '.';
                        map[cur_y][cur_x+1] = '>';
                        cur_x+=1;
                	}
                    break;
                case 'S':
                	shoot();
                    break;
                }
//                System.out.println("cmd : "+cmd[i]);
//                for(char[] a:map) System.out.println(Arrays.toString(a));
//                System.out.println();
        	}
            System.out.print("#"+tc+" ");
            for (int i=0;i<h;i++) {
            	for (int j=0;j<w;j++) {
            		System.out.print(map[i][j]);
            	}
        		System.out.println();
            }
        }
    }
    static void shoot() {
//    	for(char[] a:map) System.out.println(Arrays.toString(a));
    	int direction = -1;
    	for(int i=0;i<4;i++) {
    		if (d[i]==map[cur_y][cur_x]) {
    			direction = i;
    		}
    	}
    	int po_y = cur_y;
    	int po_x = cur_x;    	
    	while(true) {
    		int ny = po_y + dy[direction];
    		int nx = po_x + dx[direction];
    		
    		if (ny<0 || ny>=h || nx<0 || nx>=w) break;
    		if (map[ny][nx]=='#') break;
    		if (map[ny][nx]=='*') {
    			map[ny][nx] = '.';
    			break;
    		}
    		po_y = ny;
    		po_x = nx;
    	}
    }
}
