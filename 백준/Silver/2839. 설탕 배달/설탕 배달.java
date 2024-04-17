

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int cnt = 0;
        while (n > 0) {
            if (n % 5 == 0) {
                cnt+=n/5;
                System.out.println(cnt);
                return;
            }
            if (n < 3) {
                System.out.println(-1);
                return;
            }
            n-=3;
            cnt++;
        }
        System.out.println(cnt);
    }
}
