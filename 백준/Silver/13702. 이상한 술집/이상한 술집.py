import sys
input = sys.stdin.readline

n, k = map(int,input().split())

li = [int(input()) for _ in range(n)]

start = 1
end = max(li)

res = 0
while(start<=end):
    mid = (start+end)//2
    count = 0
    
    count = sum(i//mid for i in li)
   

    if count >= k:
        res = mid 
        start = mid+1
    else: 
        end = mid-1
        
print(res)