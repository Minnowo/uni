

#include <iostream>

using namespace std;

// define a template class, T is a standard but it can be any variable name
template<class T>

class X
{
private:
    T x;

public:
    X(){}

    X(T x)
    { this->x = x; }

    T getX()
    { return this->x; }
};


template<class T>

class Y
{
private:
    T y;

public:
    Y(){}

    Y(T y)
    { this->y = y; }

    T getY()
    { return this->y; }
};


int sum(X<int> &obj1, Y<int> &obj2)
{
    return obj1.getX() + obj2.getY();
}

double sum(X<double> &obj1, Y<double> &obj2)
{
    return obj1.getX() + obj2.getY();
}

int main()
{
    // set the template to type int, so x and y will hold int values
    X<int> obj1 = X<int>(5);
    Y<int> obj2 = Y<int>(10);

    cout << "x + y = " << sum(obj1, obj2) << endl;

    X<double> obj3 = X<double>(5.5);
    Y<double> obj4 = Y<double>(10.2);

    cout << "x + y = " << sum(obj3, obj4) << endl;


    return 0;
}