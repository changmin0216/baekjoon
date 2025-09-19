class Solution {
    public long solution(int n, int[] times) {
        long max = 0;
        for (int t : times) max = Math.max(max, t);

        long left = 1;                  // 최소 1분
        long right = max * (long) n;    // 최댓값 * 인원수 (long 캐스팅!)
        long answer = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;  // 오버플로우 방지
            long cnt = 0;

            for (int t : times) {
                cnt += mid / t;
                if (cnt >= n) {        // 포화 합산으로 오버플로우 방지
                    break;
                }
            }

            if (cnt < n) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        return answer;
    }
}
