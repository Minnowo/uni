

#include <iostream>

using namespace std;

class Vehicle
{
public:

    // tf is this 
    // makes class abstract 
    virtual void drive() = 0; // '= 0' means abstract class 

    virtual void uwu() = 0 // without ; you can define a body
    {

    }
};

class Car : public Vehicle
{
public:

    // must override this because its abtract
    virtual void drive() override
    {
        cout << "driving\n";
    }

    // must override this because its abtract
    virtual void uwu() override
    {

    }
};

int main()
{
    Car c;
    c.drive();

    return 0;
}