import sys
import math
input = sys.stdin.readline

# n = int(input())

def check_prime(num):
    if num==1:
        return False
    for i in range(2, int(math.sqrt(num))+1):
        if num%i==0:
            return False
    return True

# result = []
# for i in range(10**(n-1), 10**n):
#     for j in range(n-1, 0, -1):
#         if not check_prime(i//10**j): # 소수가 아니면
#             break
#     else:
#         if check_prime(i):
#             result.append(i)
# print('\n'.join(map(str, result)))

def dfs(depth):
    if depth == n:
        print(''.join(map(str, result)))
        return
    for i in range(1, 10):
        result.append(i)
        if check_prime(int(''.join(map(str, result)))):
            dfs(depth+1)
        result.pop()

    return

n = int(input())
result = []

dfs(0)