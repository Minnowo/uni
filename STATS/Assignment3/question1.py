import math 
from stats_eq import * 


data = { 
#weight : orders
    216 : 6.1,
    283 : 9.1,
    237 : 7.2,
    203 : 7.5,
    259 : 6.9,
    374 : 11.5,
    342 : 10.3,
    301 : 9.5,
    365 : 9.2,
    384 : 10.6,
    404 : 12.5,
    426 : 12.9,
    482 : 14.5,
    432 : 13.6,
    409 : 12.8,
    553 : 16.5,
    572 : 17.1,
    506 : 15,
    528 : 16.2,
    501 : 15.8,
    628 : 19,
    677 : 19.4,
    602 : 19.1,
    630 : 18,
    652 : 20.2
}

a = get_a(data)
b = get_b(data)
r = get_r(data)

print(f"b. pearsons coef r = {r}")
print(f"c. least squares regression line: y = {round(a, 4)} + {round(b, 4)} X")
print(f"d. the y-intercept is the amount of mail, so when there is 0 weight about 0 mail")

prediction_1 = a + b*315
prediction_2 = a + b*680
print(f"e. weight=315 = {prediction_1}, weight=680 = {prediction_2}")

import matplotlib.pyplot as mpl

res = get_residuals(data)
mpl.scatter(list(data.keys()), list(data.values()), color="red", label='data')
mpl.scatter(list(res.keys()), list(res.values()), color="blue", label='residuals')
mpl.ylabel("orders")
mpl.xlabel("weight")
mpl.legend()
mpl.show()