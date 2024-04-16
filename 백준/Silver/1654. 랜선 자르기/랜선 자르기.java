import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] line = new int[k];
        for (int i = 0; i < k; i++) {
            line[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(line);

        long left = 1;
        long right = line[k - 1];

        long cnt, mid;
        while (left <= right) {
            cnt = 0;
            mid = (left + right) / 2;

            for (int i = 0; i < k; i++) {
                cnt+=line[i]/mid;
            }

            if (cnt < n) {
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        System.out.println(right);
    }
}
