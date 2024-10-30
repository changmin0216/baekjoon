class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        long l = n;

        long max = -1;
        for (int i = 0; i < times.length; i++) {
            max = Math.max(max, times[i]);
        }

        long left = 1;
        long right = l*max;

        while (left <= right) {
            long mid = (left+right)/2;
            long count = 0;
            for (int i = 0; i < times.length; i++) {
                count += mid / times[i];
            }
            if (count >= n) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}