

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[]  s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]); // 동전의 가지수
        int k = Integer.parseInt(s[1]); // 내가 만들어야 하는 금액

        int[] arr = new int[n+1];
        int[] dp = new int[k + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            for (int j = arr[i]; j <= k; j++) //현재 돈의 가치부터 내가 구해야하는 금액까지
                dp[j] = dp[j] + dp[j - arr[i]];
        }
        System.out.println(dp[k]);
    }
}
