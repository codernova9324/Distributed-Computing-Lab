n = int(input())
cp = list(map(int, input().split()))
critical = 0
d = {}
for i in range(n):
    d[i] = [0, []]
i = 0
while(i < len(cp)):
    '''
    l=d[cp[i]]
    replies=l[0]
    waiting=l[1]
    '''
    replies = n-len(cp[:i+1])
    waiting = cp[i+1:].copy()
    d[cp[i]] = [replies, waiting]
    for j in range(n):
        if(j != cp[i]):
            print("P"+str(cp[i])+" sent request message to "+"P"+str(j))
    print()
    for j in range(n):
        if(j != cp[i] and j not in cp[:i+1]):
            print("P"+str(cp[i])+" got reply message from "+"P"+str(j))
    print()
    print()
    i += 1
print()
for i in range(len(cp)):
    critical = cp[i]
    l = d[critical].copy()
    l1 = l[1].copy()
    print("Queue of P"+str(critical)+":", end="")
    print(l1)
    print()

    print("P"+str(critical)+" enters critical section")
    print(".")

    print(".")
    print("P"+str(critical)+" leaves critical section")
    print()
    for j in range(len(l1)):
        temp = l1[j]
        queue = d[temp].copy()
        replies = queue[0]
        queue[0] = replies+1
        d[temp] = queue
        print("P"+str(critical)+" replies to "+"P"+str(temp))
    print()
    print()
    d[critical] = [0, []]