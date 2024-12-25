import sys
input = sys.stdin.readline
def recur(n):
  if n==1:
    return ['*']

  arr=recur(n//3)
  list_=[]

  for x in arr:
    list_.append(x*3)
  for x in arr:
    list_.append(x+' '*(n//3)+x)
  for x in arr:
    list_.append(x*3)

  return list_

n=int(input())
print('\n'.join(recur(n)))