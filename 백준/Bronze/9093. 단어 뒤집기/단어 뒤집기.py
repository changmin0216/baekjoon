import sys
input = sys.stdin.readline

T = int(input())

for _ in range(T):
    sentence = list(map(str, input().split()))
    for word in sentence:
        print(''.join(reversed(word)), end=' ')