import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] L = new int[n];

        int max=0;

        for (int i=0;i<n;i++) {
            int pos = Arrays.binarySearch(L, 0, max, arr[i]);
            if(pos<0) pos=-(pos+1); // 삽입 위치로 변환
            L[pos]=arr[i];
            if(max==pos) max++;
        }
        System.out.println(max);
    }
}
