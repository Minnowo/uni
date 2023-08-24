
#include <iostream>

using namespace std;

class Vehicle
{
protected:
    string name;
    int kms;
    int * sensor;

public:
    Vehicle()
    {
        this->name = "random vehicle";
        this->kms = 20;
        this->sensor = new int(5);
    }

    Vehicle(string name, int kms)
    {
        this->name = name;
        this->kms = kms;
        this->sensor = new int(5);
    }

    // deconstructor cannot have arguments 
    // this is the only type of deconstructor you can make
    ~Vehicle()
    {
        // delete the any used heap memory 
        if(this->sensor != nullptr)
        {
            delete this->sensor;
            this->sensor = nullptr;
        }
    }

    void drive()
    {
        cout << "i can drive\n";
    }

    
};


class Car : public Vehicle
{

public:
    Car()
    {
        // vehicle default constructor is called here 
    }

    Car(string name, int kms) : Vehicle(name, kms)
    {
        // don't need to set this because we're calling the Vehicle constructor above
        // this->name = name;
        // this->kms = kms;
    }

    ~Car()
    {

    }

    void goToPicnic()
    {
        cout << "going to picnic at " << this->kms << "kms\n";
    }

};


int main()
{
    // default constructor called here 
    Vehicle v;
    v.drive();

    Car c = Car("uwU", 50);
    c.drive();
    c.goToPicnic();
    
    // don't have to call deconstructor for v or c because it's done automatically 
    
    return 0;
}