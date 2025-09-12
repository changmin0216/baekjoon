import java.io.*;
import java.util.*;
 
public class Solution {
    static int N;
    static long[] X, Y;
    static long totalX, totalY;
    static long answer;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            X = new long[N];
            Y = new long[N];
            totalX = totalY = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                X[i] = Long.parseLong(st.nextToken());
                
                Y[i] = Long.parseLong(st.nextToken());
                totalX += X[i];
                totalY += Y[i];
            }
            answer = Long.MAX_VALUE;
            // 0번 점은 항상 선택해서 중복 제거
            select(1, 1, X[0], Y[0]);
            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }
        System.out.print(sb);
    }
 
    static void select(int idx, int cnt, long sumX, long sumY) {
        if (cnt == N / 2) {
            long dx = totalX - 2 * sumX;
            long dy = totalY - 2 * sumY;
            answer = Math.min(answer, dx * dx + dy * dy);
            return;
        }
        if (idx >= N || cnt + (N - idx) < N / 2) return;
 
        // 1) idx를 이동 그룹에 포함
        select(idx + 1, cnt + 1, sumX + X[idx], sumY + Y[idx]);
        // 2) idx를 포함하지 않음
        select(idx + 1, cnt, sumX, sumY);
    }
}