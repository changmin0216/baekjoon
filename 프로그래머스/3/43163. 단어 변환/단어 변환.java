class Solution {
    static int result;
    public int solution(String begin, String target, String[] words) {
        result = Integer.MAX_VALUE;
        
        // 만약 타겟 단어가 words 배열에 없다면
        if(!check(words, target)) return 0;
        
        dfs(0, words, begin, target, new boolean[words.length]);
        
        if (result==Integer.MAX_VALUE) result=0;
        return result;
    }
    
    static boolean check(String[] words, String target) {
        for (int i=0;i<words.length;i++) {
            if (words[i].equals(target)) return true;
        }
        return false;
    }
    
    static boolean checkOne(String begin, String target) {
        int cnt = 0;
        for (int i=0;i<begin.length();i++) {
            if (begin.charAt(i)!=target.charAt(i)) cnt++;
        }
        if(cnt==1) return true;
        else return false;
    }
    
    static void dfs(int cnt, String[] words, String now, String target, boolean[] visited) {
        if (now.equals(target)) {
            result = Math.min(result, cnt);
            return;
        }
        
        if (cnt==words.length) return;
        for (int i=0;i<words.length;i++) {
            if (!visited[i]) {
                if (checkOne(now, words[i])) {
                    visited[i] = true;
                    dfs(cnt+1, words, words[i], target, visited);
                    visited[i] = false;
                }
            }
        }
    }
}