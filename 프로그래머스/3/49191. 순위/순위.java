import java.util.*;
import java.io.*;

class Solution {
    public static int solution(int n, int[][] results) {
        int answer = 0;
        int[][] distance = new int[n+1][n+1];
        for (int i=0;i<n+1;i++){
            Arrays.fill(distance[i], 1000000);
        }
        for (int i = 1; i < n + 1; i++) {
            distance[i][i] = 0;
        }

        for (int i = 0; i < results.length; i++) {
            distance[results[i][0]][results[i][1]] = 1;
        }

        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            boolean flag = true;
            for (int j = 1; j < n + 1; j++) {
                if (i!=j && distance[i][j]==1000000 && distance[j][i]==1000000){
                    flag = false;
                    break;
                }
            }
            if (flag) {
                answer+=1;
            }
        }
        return answer;

    }
}