import sys
input = sys.stdin.readline

n = int(input())

dic_ = {}

for _ in range(n):
    book = input().rstrip()

    if book not in dic_:
        dic_[book] = 1
    else:
        dic_[book]+=1

sorted_dic_ = sorted(dic_.items(), key=lambda x:(-x[1], x[0]))
print(sorted_dic_[0][0])