import sys
input = sys.stdin.readline

n, m = map(int, input().split())

dictionary = {}
for _ in range(n):
    url, password = input().rstrip().split(' ')
    dictionary[url] = password

for _ in range(m):
    print(dictionary[input().rstrip()])