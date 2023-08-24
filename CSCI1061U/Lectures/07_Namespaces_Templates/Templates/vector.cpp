

#include <iostream>
using namespace std;


// template with really bad vector implementation 
template<class T>

class Vector
{
private:
    T *numbers;
    int size;

public:
    Vector(int size)
    {
        this->size = size;
        this->numbers = new T[size]();
    }

    void fill()
    {
        cout << "enter " << this->size << " elements" << endl;
        
        for(int i = 0; i < size; i++)
        {
            cout << "enter: " << endl;
            cin >> numbers[i];
        }
    }

    T sum()
    {
        T s = 0;
        for(int i = 0; i < size; i++)
        {
            s += numbers[i];
        }

        return s;
    }
};




int main()
{
    Vector<int> v1 = Vector<int>(4);
    v1.fill();
    cout << "sum " << v1.sum() << endl;
    

    Vector<double> v2 = Vector<double>(4);
    v2.fill();
    cout << "sum " << v2.sum() << endl;

    return 0;
}
