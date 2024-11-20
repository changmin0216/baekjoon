import sys
from itertools import permutations
input = sys.stdin.readline
#
# n = int(input())
# arr = list(map(int, input().split()))
# op = list(map(int, input().split()))
#
# tmp = []
#
# o = ['+', '-', '*', '/']
# for i in range(4):
#     if op[i]!=0:
#         for _ in range(op[i]):
#             tmp.append(o[i])
#
# result = []
# for l in permutations(tmp, len(tmp)):
#     answer = 0
#     for i in range(len(l)):
#         if i==0:
#             if l[i] == '+':
#                 answer += arr[i]+arr[i+1]
#             elif l[i] == '-':
#                 answer += arr[i] - arr[i + 1]
#             elif l[i] == '*':
#                 answer += arr[i] * arr[i + 1]
#             else:
#                 if arr[i] < 0 and arr[i+1] > 0:
#                     answer += -(-arr[i] // arr[i+1])
#                 else:
#                     answer += arr[i] // arr[i + 1]
#         else:
#             if l[i] == '+':
#                 answer += arr[i+1]
#             elif l[i] == '-':
#                 answer -= arr[i+1]
#             elif l[i] == '*':
#                 answer *= arr[i+1]
#             else:
#                 if answer < 0 and arr[i+1] > 0:
#                     answer = -(-answer // arr[i+1])
#                 else:
#                     answer //= arr[i+1]
#     result.append(answer)
#
# print(max(result))
# print(min(result))

n = int(input())
arr = list(map(int, input().split()))
add, sub, mul, div = map(int, input().split())

result = []
def cal(add, sub, mul, div, answer, depth):
    global result

    if depth == n-1:
        result.append(answer)
        return

    if add > 0:
        cal(add-1, sub, mul, div, answer+arr[depth+1], depth+1)
    if sub > 0:
        cal(add, sub-1, mul, div, answer - arr[depth + 1], depth + 1)
    if mul > 0:
        cal(add, sub, mul-1, div, answer * arr[depth + 1], depth + 1)
    if div > 0:
        cal(add, sub, mul, div-1, int(answer / arr[depth + 1]), depth + 1)

cal(add, sub, mul, div, arr[0], 0)

print(max(result))
print(min(result))