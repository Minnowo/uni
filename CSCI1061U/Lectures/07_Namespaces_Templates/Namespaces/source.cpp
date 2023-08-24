
#include "vehicle.h"
#include "anotherVehicle.h"


// this would import the global method instead of using the whole namespace
// using space1::space1GlobalMethod;

// this does the same as above but imports everything from it
// using namespace space1;

// the problem with the above is that you cannot import both space1 and space2
// this is because they have the same class Vehicle, so the compiler cannot tell which is which

int main()
{
    // tell the compiler to use namespace 'space1' 'Vehicle' class
    // this allows it to tell the difference between 'space2' 'Vehicle' class 
    space1::Vehicle v;
    v.drive();

    space2::Vehicle v2;
    v2.startEngine();

    // access the namespace global methods
    space1::space1GlobalMethod();
    space2::space2GlobalMethod();

    return 0;
}