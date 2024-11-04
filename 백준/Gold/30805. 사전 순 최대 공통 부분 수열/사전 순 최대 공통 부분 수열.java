

import java.util.*;
import java.io.*;
public class Main {
    static int n;
    static int m;
    static List<Integer> arr_1;
    static List<Integer> arr_2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr_1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr_1.add(Integer.parseInt(st.nextToken()));
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr_2 = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            arr_2.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> result = new ArrayList<>();

        result = recur(arr_1, arr_2, result);
        System.out.println(result.size());
        for (int x : result) {
            System.out.print(x+" ");
        }
    }

    private static List<Integer> recur(List<Integer> arr1, List<Integer> arr2, List<Integer> result) {
        if (arr1.size() == 0 || arr2.size() == 0) {
            return result;
        }
        int max1 = Collections.max(arr1);
        int max2 = Collections.max(arr2);

        int idx1 = arr1.indexOf(max1);
        int idx2 = arr2.indexOf(max2);

        if (max1 == max2) {
            result.add(max1);
            return recur(arr1.subList(idx1+1, arr1.size()), arr2.subList(idx2+1, arr2.size()), result);
        } else if (max1 > max2) {
            arr1.remove(idx1);
            return recur(arr1, arr2, result);
        }
        else{
            arr2.remove(idx2);
            return recur(arr1, arr2, result);
        }
    }
}
