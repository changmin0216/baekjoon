

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int one;
    static int zero;
    static Integer[][] dp = new Integer[41][2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        dp[0][0] = 1;	
        dp[0][1] = 0;	
        dp[1][0] = 0;	
        dp[1][1] = 1;	

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            fibonacci(n);
            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }

    static Integer[] fibonacci(int N) {
        if(dp[N][0] == null || dp[N][1] == null) {
            dp[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
            dp[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
        }
        return dp[N];

    }
}
