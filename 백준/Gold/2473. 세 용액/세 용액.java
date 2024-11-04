

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long closestSum = Long.MAX_VALUE;
        int[] answer = new int[3];

        // 세 수를 선택하는 방식
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                long sum = (long) arr[i] + arr[left] + arr[right];

                // 현재 세 수의 합이 0에 더 가까우면 갱신
                if (Math.abs(sum) < Math.abs(closestSum)) {
                    closestSum = sum;
                    answer[0] = arr[i];
                    answer[1] = arr[left];
                    answer[2] = arr[right];
                }

                // 합이 0보다 작으면 left 증가, 크면 right 감소
                if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
    }
}
