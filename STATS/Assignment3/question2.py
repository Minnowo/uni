
import math


n = 15 

x = 1425 
y = 10.68 
xx = 139_037.25
yy = 7.8518
xy = 987.645 

sxy = xy - (x * y) / n
sxx = xx - (math.pow(x,2) / n)
syy = yy - (math.pow(y,2) / n)

r = sxy / (math.sqrt(sxx) * math.sqrt(syy))

b = sxy / sxx 
avg_y = y / n
avg_x = x / n 

a = avg_y - b*avg_x

print(f"a. line = {a} + {b} X")
print(f"a. sxx {sxx}")
print(f"a. syy {syy}")
print(f"a. sxy {sxy}")

b_celc = b * (9/5)
a_celc = a + (32 * b)
print(f"c. line = {a_celc} {b_celc} X")
print(f"d. {b_celc * 5}")
