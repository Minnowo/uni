
#include <iostream>

using namespace std;



class Vehicle
{
protected:
    int kms = 0;

public:

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

    void setKMS(int value)
    {
        this->kms = value;
    }
};


class Truck : public Vehicle
{

public:

    void carryGoods()
    {
        cout << "carrying stuff" << endl;
        drive();
    }

    void showKMS()
    {
        cout << "i am truck, i drove " << this->kms << endl;
    }
};

class Car : public Vehicle
{

public:

    void goToPicnic()
    {
        cout << "going to picnic" << endl;
        drive();
    }

    void showKMS()
    {
        cout << "i am car, i drove " << this->kms << endl;
    }

    void setKMS(int value)
    {
        this->kms = value * 2;
    }
};



int main()
{
    Car c;
    Truck t;

    Vehicle * vehicle;

    // polymorphism, the car is still a vehicle, so this is allowed
    vehicle = &c;

    vehicle->setKMS(30);

    // shows the car drove 30 kms, even though the car class overrides the setKMS method
    c.showKMS(); 
    return 0;
}