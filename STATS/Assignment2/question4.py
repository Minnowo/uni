import math 
data = [3, 5, 18, 19, 19, 19, 20, 21, 22, 22, 22, 22, 22, 23, 24, 25, 26, 27, 28, 29, 30, 33, 37, 38, 38, 38, 38, 39, 39, 39, 40]

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

def get_q1(x):
    return median(data[0 : len(data)//2 +1])

def get_q3(x):
    return median(data[len(data)//2 : ] )

def mild_out_coutn(x):

    iqr = abs(get_q1(data) - get_q3(data))
    med = median(x)

    less_ = med - iqr*1.5
    great_ = med + iqr*1.5

    a = [i for i in x if less_ > i > great_]
    return len(a)

def extreme_out_coutn(x):

    iqr = abs(get_q1(data) - get_q3(data))
    med = median(x)

    less_ = med - iqr*3
    great_ = med + iqr*3

    a = [i for i in x if less_ > i > great_]
    return len(a)

print(f"a) Mean   {mean(data)}")
print(f"a) Median {median(data)}")
print(f"b) Left Skewed because median is less than mean")
print(f"c) variance      {sample_variance(data)}")
print(f"c) std deviation {math.sqrt(sample_variance(data))}")
print(f"d) q1  {get_q1(data)}")
print(f"d) q3  {get_q3(data)}")
print(f"d) IQR {abs(get_q1(data) - get_q3(data))}")
print(f"e) Mild {mild_out_coutn(data)}")
print(f"f) IQR  {extreme_out_coutn(data)}")



