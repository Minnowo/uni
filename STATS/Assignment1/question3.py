

data = """SSSS
SSSF
SSFS
SSFF
SFSS
SFSF
SFFS
SFFF
FSSS
FSSF
FSFS
FSFF
FFSS
FFSF
FFFS
FFFF"""

total = 0
nyah = dict()

print("likely of each combination")
for i in data.split("\n"):

    t = 1

    for j in i:


        if j == "F":
            t *= 0.6

        if j == "S":
            t *= 0.4

    print(i.count("S"), i, t)
    if "".join(sorted(i)) not in nyah:
        nyah["".join(sorted(i))] = [] 

    nyah["".join(sorted(i))].append(t)
    total += t 

print()
print("distribution")

for i, k in nyah.items():
    print(k.count("S"),i, sum(k)*100)