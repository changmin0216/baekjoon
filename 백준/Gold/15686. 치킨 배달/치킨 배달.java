import java.io.*;
import java.util.*;

class Point {
    int y, x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d)", y, x);
    }
}
public class Main {
    static int N, M;
    static int[][] map;
    static ArrayList<Point> home = new ArrayList<>();
    static ArrayList<Point> chicken = new ArrayList<>();
    static ArrayList<Point[]> survive = new ArrayList<>();
    static Point[] p;
    static void comb(int cnt, int start) {
        if (cnt == M) {
            survive.add(Arrays.copyOf(p, M));
            return;
        }

        for (int i=start;i<chicken.size();i++){
            p[cnt] = chicken.get(i);
            comb(cnt + 1, i + 1);
        }
    }

    static void calChickenDist() {
        int result = Integer.MAX_VALUE;
        for (Point[] points : survive) {
            int dist_sum = 0;
            for (Point point : home) {
                int k = Integer.MAX_VALUE;
                for (Point p : points) {
                    k = Math.min(Math.abs(p.y - point.y) + Math.abs(p.x - point.x), k);
                }
                dist_sum+=k;
            }
            result = Math.min(result, dist_sum);
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (v == 1) {
                    home.add(new Point(i, j));
                } else if (v == 2) {
                    chicken.add(new Point(i, j));
                }
                map[i][j] = v;
            }
        }
        p = new Point[M];
        comb(0, 0);
        calChickenDist();
    }
}
