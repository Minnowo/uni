

def f(c : int, n : int):

    state = (c, 3*c)

    for i in range(n - 2):

        x = state[0] * state[1]

        state = (state[1], x)

    return state[1]

print(f(1, 5))