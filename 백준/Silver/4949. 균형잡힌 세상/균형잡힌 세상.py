import sys
input =  sys.stdin.readline

while True:
    line = input().rstrip()
    if line=='.':
        break

    stack = []
    for x in line:
        if x=='(' or x=='[':
            stack.append(x)
        elif x==')':
            if len(stack)==0:
                break
            tmp = stack.pop()
            if tmp == '[':
                break
        elif x==']':
            if len(stack)==0:
                break
            tmp = stack.pop()
            if tmp == '(':
                break
    else: #break 안했으면
        if len(stack)==0:
            print("yes")
        else:
            print("no")
        continue
    print("no")