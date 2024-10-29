
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            ArrayList<Integer> ary1 = new ArrayList<>();
            ArrayList<Integer> ary2 = new ArrayList<>();

            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                ary1.add(Integer.parseInt(st.nextToken()));
            }

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                ary2.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(ary1);
            for (int j = 0; j < m; j++) {
                if (binarySearch(ary1, ary2.get(j))){
                    bw.write("1\n");
//                    System.out.println(1);
                }
                else{
                    bw.write("0\n");
//                    System.out.println(0);
                }
            }
            bw.flush();
        }
    }

    static boolean binarySearch(ArrayList<Integer> ary, int num) {
        int left = 0;
        int right = ary.size()-1;

        while (left <= right) {
            int mid = (left+right)/2;
            if (ary.get(mid) == num){
                return true;
            }
            else if (ary.get(mid) > num) {
                right = mid-1;
            }
            else {
                left = mid + 1;
            }
        }
        return false;
    }
}