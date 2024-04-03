
import java.io.*;
import java.util.*;
public class Main {
    static ArrayList<Integer>[] map;
    static boolean[] visited;
    static boolean[] isCycle;
    static int n;
    static int[] distance;

    public static void main(String[] args) throws IOException{
        input();
        checkCycle();
        getDistance();
    }
    static void getDistance(){
        distance = new int[n+1];
        visited = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            if (isCycle[i] && map[i].size() > 2) {
                searchRoute(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(distance[i]+" ");
        }
        System.out.println(sb);
    }

    static void searchRoute(int i){
        for (int next : map[i]) {
            if (isCycle[next] || distance[next] > 0) {
                continue;
            }
            distance[next] = distance[i]+1;
            searchRoute(next);
        }
    }

    static void checkCycle(){
        isCycle = new boolean[n+1];
        for (int i = 1; i <= n; i++) {
            if (!isCycle[i]) {
                visited = new boolean[n+1];
                dfs(i, i, 0);
            }
        }
    }

    public static boolean dfs(int start, int i, int cnt){
        for (int next: map[i]){
            if (next == start) {
                if (cnt > 1)
                    return isCycle[i]=true;
                else continue;
            }

            if (isCycle[next] || isCycle[i] || visited[next]) {
                continue;
            }
            visited[next] = true;
            isCycle[i] = dfs(start, next, cnt+1);
        }
        return isCycle[i];
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        map = new ArrayList[n+1];

        for(int i = 1; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }
    }
}

