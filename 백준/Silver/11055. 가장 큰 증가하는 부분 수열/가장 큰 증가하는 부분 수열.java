

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int[] dp_sum = new int[n];
        for (int i = 0; i < n; i++) {
            dp_sum[i] = arr[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    dp_sum[i] = Math.max(dp_sum[i], dp_sum[j]+arr[i]);
                }
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            if (dp_sum[i] > max) {
                max = dp_sum[i];
            }
        }
        System.out.println(max);
    }
}
