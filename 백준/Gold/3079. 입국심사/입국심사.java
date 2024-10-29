
import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static long result = Long.MAX_VALUE;
    static long max = 0;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);  //입국 심사 개수
        m = Integer.parseInt(s[1]);  //사람 수

        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        Arrays.sort(arr);

        binarySearch();

        System.out.println(result);
    }

    static void binarySearch() {
        long left = 0;
        long right = m*max;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;

            for (long val : arr) {
                long p = mid / val;

                if (sum >= m) {
                    break;
                }
                sum+=p;
            }
            if(sum>=m){
                right = mid-1;
                result = Math.min(mid, result);
            }
            else{
                left = mid+1;
            }
        }
    }
}