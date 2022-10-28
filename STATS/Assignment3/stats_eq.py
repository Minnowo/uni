import math 


def sum_x(dat : dict):
    return sum(x for x, y in dat.items())

def sum_y(dat : dict):
    return sum(y for x, y in dat.items())

def sum_xx(dat : dict):
    return sum(x**2 for x, y in dat.items())

def sum_yy(dat :dict):
    return sum(y**2 for x, y in dat.items())

def sum_xy(dat :dict):
    return sum(x*y for x, y in dat.items())

def get_sxx(dat :dict):

    x_squared_sum = sum_xx(dat)
    x_sum         = sum_x(dat)

    n = len(dat)

    return x_squared_sum - (x_sum**2)/n

def get_syy(dat :dict):

    y_squared_sum = sum_yy(dat)
    y_sum         = sum_y(dat)

    n = len(dat)

    return y_squared_sum - (y_sum**2)/n

def get_sxy(dat :dict):

    yx_sum = sum_xy(dat)
    x_sum = sum_x(dat)
    y_sum = sum_y(dat)
    n = len(dat)

    return yx_sum - (x_sum*y_sum)/n

def get_r(dat :dict):

    sxy = get_sxy(dat)
    sxx = get_sxx(dat)
    syy = get_syy(dat)

    return sxy / (math.sqrt(sxx) * math.sqrt(syy))

def get_b(dat: dict):

    sxy = get_sxy(dat)
    sxx = get_sxx(dat)

    return sxy / sxx 

def get_a(dat : dict):

    n = len(dat)
    b = get_b(dat)
    avy = sum_y(dat) / n 
    avx = sum_x(dat) / n 

    return avy - b*avx 

def get_residuals(dat :dict):

    a = get_a(dat)
    b = get_b(dat)

    res = dict()

    for x, y in dat.items():

        predict = a + b * x 

        res[x] = y - predict 

    return res 
