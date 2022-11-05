combs = 0
allcombs = {()}
for i in range(1,5):
    for j in range(1,5):
        if j == i: continue
        for k in range(1,5):
            if k == i or k == j: continue
            for l in range(1,5):
                if l == k or l == i or l == j: continue
                allcombs.add((i,j,k,l))

combs = len(allcombs)
print(combs)
print()
l = []
counter = 0
for i in allcombs:
    l.append(i)
    # counter += 1
    # if counter > 5:
    #     print(i)
    #     counter = 0
    # else:
    #     print(i, end=" || ")

l.sort()
print(l)

"""
(1, 2, 3, 4), (2, 1, 3, 4), (3, 1, 2, 4), (4, 1, 2, 3)
(1, 2, 4, 3), (2, 1, 4, 3), (3, 1, 4, 2), (4, 1, 3, 2)
(1, 3, 2, 4), (2, 3, 1, 4), (3, 2, 1, 4), (4, 2, 1, 3)
(1, 3, 4, 2), (2, 3, 4, 1), (3, 2, 4, 1), (4, 2, 3, 1)
(1, 4, 2, 3), (2, 4, 1, 3), (3, 4, 1, 2), (4, 3, 1, 2)
(1, 4, 3, 2), (2, 4, 3, 1), (3, 4, 2, 1), (4, 3, 2, 1)
"""