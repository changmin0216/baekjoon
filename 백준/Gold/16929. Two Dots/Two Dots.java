
import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int m;
    static char[][] maps;
    static boolean[][] visited;

    static int firstX;
    static int firstY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maps = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                maps[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited = new boolean[n][m];
                firstY = i;
                firstX = j;
                if (dfs(i, j, 1)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }

    public static boolean dfs(int y, int x, int count) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if ((0 <= ny && ny < n) && (0 <= nx && nx < m) && (maps[y][x] == maps[ny][nx])) {
                if (!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    if (dfs(ny, nx, count + 1)) return true;
                }
                else {
                    if (count >= 4 && firstY == ny && firstX == nx) return true;
                }
            }
        }
        return false;
    }
}
