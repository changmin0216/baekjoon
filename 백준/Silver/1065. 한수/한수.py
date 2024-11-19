import sys
input = sys.stdin.readline

n = int(input())

answer = 0
for i in range(1, n+1):
    if len(str(i)) <= 2:
        answer+=1
    else:
        str_ = str(i)
        diff = int(str_[1]) - int(str_[0])
        for i in range(1, len(str_)-1):
            if int(str_[i+1]) - int(str_[i]) != diff:
                break
        else:
            answer+=1
print(answer)