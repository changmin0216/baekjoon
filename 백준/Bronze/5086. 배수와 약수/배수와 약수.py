import sys
input = sys.stdin.readline

while True:
    A, B = map(int, input().split())
    
    # 0 0을 입력받으면 break
    if A == 0:
        break
    
    if A % B == 0:
        print('multiple')
    elif B % A == 0:
        print('factor')
    else:
        print('neither')