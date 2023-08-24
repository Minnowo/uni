
#include <iostream>

using namespace std;

class Vehicle
{
public:
    
    virtual void drive()
    {
        cout << "driving\n";
    }
};

class Car : public Vehicle
{
public:
    void goToPicnic()
    {
        cout << "going to picnic\n";
    }

    // override the parent method 
    virtual void drive() override
    {
        cout << "car is driving\n";
    }
};

class Truck : public Vehicle
{
public:
    void carryGood()
    {
        cout << "carrying goods\n";
    }

    // override the parent method 
    virtual void drive() override
    {
        cout << "truck is driving\n";
    }
};


int main()
{
    Car car;
    Truck truck;

    Vehicle* vehicle[2];
    
    vehicle[0] = &car;
    vehicle[1] = &truck;

    // without the virtual accessor on the drive function it
    // calls the Vehicle drive function, not the car function
    // with the virtual accessor on the drive function, it will call the child class which overrides it 
    vehicle[0]->drive();

    // this is not valid because the Vehicle class doesn't implement this function
    // vehicle[0]->goToPicnic();

    return 0;
}
