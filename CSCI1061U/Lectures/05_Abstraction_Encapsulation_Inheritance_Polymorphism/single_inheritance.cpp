
#include <iostream>

using namespace std;



class Vehicle
{
private:

    // cannot be accessed by children class, this is because it's private
    int secret = 0;

protected:

    int someVariable = 2;

public:

    int known = 0;

    void drive()
    {
        cout << "vrrrrrrrrrrrrrrrrr" << endl;
    }

    void engineStart()
    {
        cout << "engine started" << endl;
    }

    void engineStop()
    {
        cout << "engine stopped" << endl;
    }
};


// public single inheritance
// this is because Truck has only 1 parent class, which uses the public modifier
class Truck : public Vehicle
{

public:

    // 
    // Car and Truck class are very similar and share a few functions
    // this is dumb, so instead we should make a parent class -> Vehicle
    // 

    // void drive()
    // {
    //     cout << "vrrrrrrrrrrrrrrrrr" << endl;
    // }
    // void engineStart()
    // {
    //     cout << "engine started" << endl;
    // }
    // void engineStop()
    // {
    //     cout << "engine stopped" << endl;
    // }
    void carryGoods()
    {
        cout << "carrying stuff" << endl;

        // since 'someVariable' is protected, can be accessed only in the parent or its children
        someVariable = 5;

        // can use this syntax to refer to parent member,
        Vehicle::known = 5;
        // this->known = 5; // this also works
        // known = 5; // this also works

        drive();
    }
};

// public single inheritance
class Car : public Vehicle
{

public:

    // 
    // Car and Truck class are very similar and share a few functions
    // this is dumb, so instead we should make a parent class -> Vehicle
    // 

    // void drive()
    // {
    //     cout << "vrrrrrrrrrrrrrrrrr" << endl;
    // }
    // void engineStart()
    // {
    //     cout << "engine started" << endl;
    // }
    // void engineStop()
    // {
    //     cout << "engine stopped" << endl;
    // }
    void goToPicnic()
    {
        cout << "going to picnic" << endl;
        drive();
    }
};



int main()
{
    Car c;
    Truck t;

    cout << "car:" << endl;
    c.engineStart();
    c.goToPicnic();
    c.engineStop();

    cout << "\ntruck:" << endl;
    t.engineStart();
    t.carryGoods();
    t.engineStop();
    

    return 0;
}