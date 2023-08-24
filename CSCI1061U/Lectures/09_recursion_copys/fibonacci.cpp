

#include <iostream>
using namespace std;

int fibIter(int x)
{
    int a = 0;
    int b = 1;

    for(int i = 0; i < x; i++)
    {
        int c = a + b;
        a = b;
        b = c;
    }

    return a;
}

int fibRec(int x)
{
    if(x - 2 < 0)
        return x;

    return fibRec(x - 1) + fibRec(x - 2);
}


int main()
{
    // cout << powerIter(2, 3) << endl;
    for(int i = 0; i < 10; i++)
    {
        cout << i << endl;
    cout <<"  rec : " << fibRec(i) << endl;
    cout << "  iter: " << fibIter(i) << endl << endl;

    }
    return 0;
}