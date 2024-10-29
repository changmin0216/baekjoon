

import java.util.*;
import java.io.*;

public class Main {
    static int n; //짝수
    static int[][] list;
    static ArrayList<Integer> result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        list = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ArrayList<Integer> tmp = new ArrayList<>();
        result = new ArrayList<>();
        recur(tmp, 0);
        System.out.println(Collections.min(result));
    }
    static void recur(ArrayList<Integer> list1, int index){
        if (list1.size() == n / 2) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i+1; j < n;j++) {
                    if ((list1.contains(i)) && (list1.contains(j))){
                        sum+=(list[i][j]+list[j][i]);
                    }
                    else if((!list1.contains(i)) && (!list1.contains(j))){
                        sum-=(list[i][j]+list[j][i]);
                    }
                }
            }
            result.add(Math.abs(sum));
            return;
        }
        for (int i = index; i < n; i++) {
            list1.add(i);
            recur(list1, i+1);
            list1.remove(list1.size()-1);
        }
    }
}
