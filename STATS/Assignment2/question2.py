import math 

data_seconds = [ 
 32.5 , 32.5 ,
 33.4 , 33.9 ,
 35.6 , 35.6 , 35.9 , 35.9,
 36.3 , 36.4 , 36.4 , 36.6 , 36.9,
 37.0 , 37.3 , 37.3 , 37.4 , 37.5,
 38.9,
 39.2 , 39.3 , 39.4 , 39.7,
 40.2 , 40.3 ,
 42.4,
]

data_in_mins = [i / 60 for i in data_seconds]

def median(data):

    if len(data) % 2 == 0:

        _ = (len(data) // 2 ) - 1
        return (data[_] + data[_ + 1]) /  2
        # print(f"median {}")
    else:
        
        _ = (len(data) // 2 )
        return data[_] 
        # print(f"median {data[_]}")

def mean(data):
    return sum(data) / len(data)
    # print(f"mean {}")
    

def sample_variance(x):

    x_sum = sum(x)
    x_squared = sum([i*i for i in x])

    n = len(x)

    return (x_squared - ((x_sum**2) / n)) / (n - 1)

print(f"a) Mean   {mean(data_seconds)}")
print(f"a) Median {median(data_seconds)}")

print("b) an infinite amount")

print("c) can be decreased until 37")


print(f"d) Mean   {mean(data_in_mins)} ")
print(f"d) Median {median(data_in_mins)} ")

lower_half = data_seconds[0 : len(data_in_mins)//2 ]
upper_half = data_seconds[len(data_in_mins)//2 : ]
print(f"e) Q1 {median(lower_half)}")
print(f"e) Standard deviation {math.sqrt(sample_variance(data_seconds))}")
print(f"e) Q3 {median(upper_half)}")

