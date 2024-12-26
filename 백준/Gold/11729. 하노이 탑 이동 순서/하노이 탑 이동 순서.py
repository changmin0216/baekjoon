import sys
input = sys.stdin.readline

def recur(n, start, end) :
    if n == 1 :
        print(start, end)
        return
       
    recur(n-1, start, 6-start-end)
    print(start, end) 
    recur(n-1, 6-start-end, end)
    
n = int(input())
print(2**n-1)
recur(n, 1, 3)