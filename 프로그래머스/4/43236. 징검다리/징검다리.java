import java.util.*;
import java.io.*;
class Solution {
    public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        int left = 0;
        int right = distance;

        Arrays.sort(rocks);
        while (left <= right) {
            int mid = (left+right)/2; //사이 거리의 최솟값

            int tmp = 0;
            int cnt = 0;
            for (int i = 0; i < rocks.length; i++) {
                if ((rocks[i] - tmp) >= mid) {
                    tmp = rocks[i];
                }
                else{
                    cnt+=1;
                }
            }
            // 마지막 바위에서 도착 지점까지의 거리 확인
            if ((distance - tmp) < mid) {
                cnt += 1; // 도착 지점까지의 거리가 mid보다 작은 경우 바위를 제거하는 것으로 간주
            }

            if (cnt <= n) {
                answer = mid;
                left = mid+1;
            }
            else{
                right = mid - 1;
            }
        }


        return answer;
    }
}