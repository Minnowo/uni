
// import the .h file containing the vehicle class
#include "vehicle.h"


using namespace std;

class X
{
    int x;

public:

    int getX()
    {
        return this->x;
    }

    void setX(int x)
    {
        // set instance variable 'x' to the value of the local variable 'x'
        // 'this' keyword to specify the instance variable 'x' for the current class
        this->x = x;
    }
};

int addObjects(X obj1, X obj2)
{
    return obj1.getX() + obj2.getX();
}

int main()
{
    // make a instance of the class (have not gotten to memory / the 'new' keyword yet)
    Vehicle myCar = Vehicle("nyah", "uwu", 500);

    // call sample functions 
    cout << "carDetails:" << endl;
    myCar.carDetails();

    cout << endl << "drive:" << endl; 
    myCar.drive();

    // testing get / set functions 
    myCar.setKMS(177013);
    myCar.setName("not a h ;3c");
    myCar.setType("pp");

    cout << endl << "getKMS():  " << myCar.getKMS() << endl;
    cout << "getName(): " << myCar.getName() << endl;
    cout << "getType(): " << myCar.getType() << endl << endl;

    // two different objects 
    // the value of the instance variable 'x' is different for each object
    X obj1 = X(); 
    obj1.setX(5);

    X obj2 = X();
    obj2.setX(10);

    cout << "obj1.getX(): " << obj1.getX() << endl;
    cout << "obj2.getX(): " << obj2.getX() << endl << endl;

    cout << "addObjects(obj1, obj2): " << addObjects(obj1, obj2) << endl;

    return 0;
}