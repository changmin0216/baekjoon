import sys
input = sys.stdin.readline
from itertools import combinations

n = int(input())
stats = [list(map(int, input().split())) for _ in range(n)]
person = [i for i in range(n)]

result = sys.maxsize
for i in range(1, (n//2)+1):
    for team1 in combinations(person, i):
        team2 = []
        for j in range(n):
            if j not in team1:
                team2.append(j)
        start = 0
        link = 0
        for q in combinations(team1, 2):
            start += stats[q[0]][q[1]] + stats[q[1]][q[0]]

        for w in combinations(team2, 2):
            link += stats[w[0]][w[1]] + stats[w[1]][w[0]]

        result = min(result, abs(start-link))
print(result)