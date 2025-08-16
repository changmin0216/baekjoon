

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int total = (1 << 10) -1;  // 모든 숫자가 등장했을 때의 값
        for (int tc=1;tc<=T;tc++) {
            int N = Integer.parseInt(br.readLine());
//            int visited = 0;
            boolean[] visited = new boolean[10];
            int count = 0;

            for (count = 1; ; count++) {
                char[] arr = String.valueOf(N * count).toCharArray();  // N*count 값을 문자열로 표현한 것  (예: 5 * 13 = 65 -> "65")
                for( char c :arr){
                    int num = c - '0';
//                    visited = visited | (1 << num);  // 각 숫자에 대해 등장했다는 의미로 bit 를 1로 변경

                    visited[num] = true;
                }
                boolean flag = true;
                for (int k=0;k<=9;k++){
                    if (visited[k] == false) flag = false;
                }
                if (flag) break;
            }
            System.out.println("#" + tc + " " + N*count);
        }
    }
}
