import math 



f = {
    0 : 0.1 ,
    1 : 0.15,
    2 : 0.20,
    3 : 0.25,
    4 : 0.20,
    5 : 0.05,
    6 : 0.05,
}

def mean(x):

    return sum(i * x for i, x in f.items())

def standard_deviation(x):

    m = mean(x)

    return math.sqrt(sum( ((i - m)**2) * x for i, x in f.items()))

        
print("a) Missing prob 0.05")
print(f"b) Mean {mean(f)}")
print(f"c) Standard {standard_deviation(f)}")
print(f"d) At least 3   {sum(x for i, x in f.items() if i >= 3)}")
print(f"e) At most 5    {sum(x for i, x in f.items() if i <= 5)}")

men = mean(f)
std = standard_deviation(f)
within1 = int(men + std )
within2 = int(men - std ) + 1
print(f"f) Within 1 std {sum(x for i, x in f.items() if int(within2) <= i <= int(within1))}")
