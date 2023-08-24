

#include <iostream>
using namespace std;

int powerIter(int x, int exp)
{
    int result = 1;
    for(int i = 0; i < exp; i++)
    {
        result = result * x;
    }
    return result;
}

int powerRec(int x, int exp)
{
    if(exp == 0)
        return 1;

    return x * powerRec(x, exp - 1);
}


int main()
{
    cout << powerIter(2, 3) << endl;
    cout << powerRec(2, 3) << endl;
    return 0;
}