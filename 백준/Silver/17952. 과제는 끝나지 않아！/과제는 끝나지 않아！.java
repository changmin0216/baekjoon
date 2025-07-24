

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<int[]> stack = new ArrayDeque<>();

        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (!stack.isEmpty()) {
                int[] a = stack.pop();
                if (a[1] == 0) {
                    sum += a[0];
                } else {
                    stack.push(a);
                }
            }

            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 0) {
                if (!stack.isEmpty()) {
                    int[] a = stack.pop();
                    a[1]-=1;
                    stack.push(a);
                }
            } else {
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                stack.push(new int[]{score, time - 1});
            }
        }
        if (!stack.isEmpty()) {
            if (stack.peek()[1] == 0) {
                sum+=stack.peek()[0];
            }
        }
        System.out.println(sum);
    }
}
