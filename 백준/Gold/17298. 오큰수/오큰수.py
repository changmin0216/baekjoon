# 1<=N<=1,000,000
# 지금 시간 복잡도 O(N^2)
# 시간 복잡도는 O(N)으로 풀어야함
# 어떻게 풀어야 할까ㅏ까ㅏㅏㅏㅏㅏㅏㅏㅏㅏㅏ
# 한번 돌면 이게 다 알아야 한다.
import sys
input = sys.stdin.readline

N = int(input())
ary = list(map(int, input().split()))

answer = [-1]*N
stack = [0]
for i in range(1, N):
    while stack and ary[stack[-1]] < ary[i]:
        answer[stack.pop()] = ary[i]
    stack.append(i)

print(*answer)