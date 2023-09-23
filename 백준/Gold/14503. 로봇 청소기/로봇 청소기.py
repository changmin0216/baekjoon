import sys
input = sys.stdin.readline

N, M = map(int, input().split())
rbt = list(map(int, input().split()))

room = [[0]*M for _ in range(N)]

for i in range(N):
    room[i] = list(map(int, input().split()))

cnt = 0

dy = [-1, 0, 1, 0]  #북, 동, 남, 서
dx = [0, 1, 0, -1]


def defa(a, b, d):
    global cnt

    if room[a][b]==0:
        room[a][b]=2
        cnt+=1
    for k in range(4):
        nd = (d+3)%4
        if room[a+dy[nd]][b+dx[nd]]==0:
            defa(a+dy[nd], b+dx[nd], nd)
            return
        d = nd

    if room[a-dy[d]][b-dx[d]]==1:
        return
    defa(a-dy[d], b-dx[d], d)

defa(rbt[0], rbt[1], rbt[2])
print(cnt)