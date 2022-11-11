import pandas as pd 


data = pd.read_csv("..\\..\\CSCI3055U\\docker_workspace\\assignment-2\\my_bankerchurners.csv")



print(type(data))

want_f = 26917811
want_m = 60497984
want_me_f = 26918094
want_me_m = 60498056
want_total = want_f + want_m
want_my_total = want_me_f + want_me_m
print(data.columns)

limit = data['Credit_Limit']
gender = data['Gender']
import math 

res = { 
    "F" : {
        'count' : 0,
        'limit' : 0,
        'mean'  : 0,
    },
    "M" : {
        'count' : 0,
        'limit' : 0,
        'mean'  : 0,
    },
}
sf = 0
sm = 0
for g, v in zip(gender, limit):

    res[g]['count'] += 1
    res[g]['limit'] += v
    res[g]['mean']  += v

res['F']['mean'] = res['F']['mean'] / res['F']['count']
res['M']['mean'] = res['M']['mean'] / res['M']['count']
print(res)