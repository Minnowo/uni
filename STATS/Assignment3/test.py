


N = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}

A = { 1, 2, 3 }
B = { 2, 5, 6 }


A_COMP = N - A 
B_COMP = N - B 

# A_COMP_U_B_COMP = A_COMP | B_COMP

print(A & (B_COMP))
print(A - B )
print((A | B) - B)



