

import java.util.*;
import java.io.*;

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

        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = n-1; i >= 0; i--) {
            answer.add(arr[i], i+1);
        }

        for (int x : answer) {
            System.out.print(x + " ");
        }
    }
}
