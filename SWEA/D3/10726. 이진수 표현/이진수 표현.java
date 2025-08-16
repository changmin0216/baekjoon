

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int x = (1 << n) - 1;
            if ((x & m) == x) {
                sb.append("#").append(tc).append(" ").append("ON").append("\n");
            } else
                sb.append("#").append(tc).append(" ").append("OFF").append("\n");

        }
        System.out.println(sb);
    }
}
