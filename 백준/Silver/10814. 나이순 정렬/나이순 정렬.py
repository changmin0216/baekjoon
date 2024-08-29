import sys

n = int(input())
members = []

for _ in range(n):
    age, name = map(str, sys.stdin.readline().rstrip().split())
    members.append((int(age), name))

sorted_members = sorted(members, key=lambda x: x[0])

for i in sorted_members:
    print(i[0], i[1])