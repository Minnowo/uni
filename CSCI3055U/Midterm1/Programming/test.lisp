



init = (pair c (mult 3 c))

update = \x. (
                pair
                  (x false)
                  (mult (x true) (x false))
                )

f = \c. \n. (
    iszero (pred (pred n))
    (mult 3 c)
    (((pred (pred n)) update init) false )
)

\c. \n. ( iszero (pred (pred n)) (mult 3 c) (((pred (pred n)) update init) false ) )


\c. \n. ( ( (pred (pred n)) update init ) false)
