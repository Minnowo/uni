
import numpy as np 
 


arr = [i for i in range(10)]

narr = np.array( arr )

print(narr)

print(3.1415 * narr ** 2)


arr2d = [ 
    [1, 2, 3],
    [1, 2, 3],
    [1, 2, 3]
]

narr2d = np.array(arr2d)

print(narr2d.ndim)
print(narr2d.shape)
print(narr2d.dtype)
print(narr2d)

zeros = np.zeros((5,))
print(zeros)