import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            String[] cards = new String[n];

            // 카드 n개 안전하게 읽기(줄바꿈 섞여도 OK)
            int idx = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (idx < n) {
                while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
                cards[idx++] = st.nextToken();
            }

            int L = (n + 1) / 2; // 왼쪽 덱 크기
            sb.append("#").append(tc).append(" ");

            int i = 0;     // 왼쪽 인덱스 [0 .. L-1]
            int j = L;     // 오른쪽 인덱스 [L .. n-1]
            for (int k = 0; k < n; k++) {
                if ((k & 1) == 0) sb.append(cards[i++]).append(" ");
                else               sb.append(cards[j++]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
