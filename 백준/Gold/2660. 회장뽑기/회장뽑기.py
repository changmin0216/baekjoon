import sys
input = sys.stdin.readline
INF = int(1e9)

def floyd():
    global distance

    for k in range(n):
        for i in range(n):
            for j in range(n):
                if distance[i][j] > distance[i][k] + distance[k][j]:
                    distance[i][j] = distance[i][k] + distance[k][j]


n = int(input())

distance = [[INF] * (n) for _ in range(n)]

for i in range(n):
    distance[i][i] = 0

while True:
    a, b = map(int, input().split())
    if a==-1 and b==-1:
        break
    distance[a-1][b-1] = 1
    distance[b-1][a-1] = 1

floyd()
p_cand_score_list = []
for i in range(n):
    max_num = max(distance[i])
    p_cand_score_list.append(max_num)

    # if max_num == INF:
    #
    #
    # for j in range(1, n+1):
    #     if distance[i][j]!=0 and distance[i][j]!=INF:
    #         max_num = max(max_num, distance[i][j])

p_cand_score = min(p_cand_score_list)

cnt = 0
p_cand_list = []
for i in range(len(p_cand_score_list)):
    if p_cand_score_list[i]==p_cand_score:
        cnt+=1
        p_cand_list.append(i+1)

print(p_cand_score, cnt)
print(' '.join(map(str, p_cand_list)))