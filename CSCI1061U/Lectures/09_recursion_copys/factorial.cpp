
#include <iostream>
#include <string>
using namespace std;

int factorialIter(int x)
{
    int result = x;

    for(int i = 1; i < x; i++)
    {
        result = result * i;
    }

    return result;
}

int factorialRec(int x)
{
    if (x == 1)
        return x;

    return factorialRec(x - 1) * x;
}


int main()
{
    cout << factorialRec(5) << endl;
    cout << factorialIter(5);

    return 0;
}