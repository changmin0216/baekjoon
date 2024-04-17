// 뒷 사람 or 앞 사람 에게 체육복을 빌려 줄 수 있다.

// n = 전체 학생 수
// lost = 체육복 도둑맞은 얘들 번호
// reseve = 여벌의 체육복을 가져온 얘들
// 여벌 가져온 얘들 도 도둑맞을 수 있다. 
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
         int[] student = new int[n+1];
        for(int i=0;i<lost.length;i++){
            student[lost[i]] = -1;
        }
        for(int i=0;i<reserve.length;i++){
            student[reserve[i]]+=1;
        }

        for(int i=1;i<n+1;i++){
            if (student[i] == -1){
                if (student[i-1]>0){
                    student[i]+=1;
                    student[i-1]-=1;
                    continue;
                }
                if (i!=n) {
                    if (student[i + 1] > 0) {
                        student[i] += 1;
                        student[i + 1] -= 1;
                    }
                }
            }
        }
        int answer = 0;
        for (int i=1;i<n+1;i++){
            if (student[i]>=0){
                answer++;
            }
        }
        return answer;
    }
}