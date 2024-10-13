s=input()
set_=set()
for i in range(len(s)):
    for j in range(i,len(s)):
        set_.add(s[i:j+1])
print(len(set_))