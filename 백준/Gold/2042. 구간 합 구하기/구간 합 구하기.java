
import java.io.*;
import java.util.*;
public class Main {
    static int n, m, k;
    static long[] arr;
    static long[] seg;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new long[n];
        seg = new long[4*n];
        for (int i=0;i<n;i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        init(1, 0, n-1);
        for (int i=0;i<m+k;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a==1) {
                update(1, 0, n-1, c-arr[b-1], b-1);
            } else {
                System.out.println(query(1, 0, n-1, b-1, ((int)c) - 1));
            }
        }
    }
    static long init(int n, int l, int r){
        if(l==r) return seg[n] = arr[l];
        int mid = (l + r) / 2;
        return seg[n] = init(n*2, l, mid) + init(n*2+1, mid+1, r);
    }

    static long query(int n, int seg_s, int seg_e, int arr_s, int arr_e) {
        if (seg_e < arr_s || seg_s > arr_e) {
            return 0;
        }
        if (arr_s <= seg_s && seg_e <= arr_e) {
            return seg[n];
        }
        int mid = (seg_s + seg_e) / 2;
        return query(n*2, seg_s, mid, arr_s, arr_e) + query(n*2+1, mid+1, seg_e, arr_s, arr_e);
    }

    static void update(int n, int l, int r, long diff, int index) {
        if (index < l || index > r) return;;
        if (l==r) {
            arr[l]+=diff;
            seg[n]+=diff;
            return;
        }
        int mid = (l+r)/2;
        update(n*2, l, mid, diff, index);
        update(n*2+1, mid+1, r, diff, index);
        seg[n] = seg[n*2] + seg[n*2+1];
    }
}
