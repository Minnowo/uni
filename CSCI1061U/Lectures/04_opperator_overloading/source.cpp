
#include <vector>
#include <iostream>
#include <string>

using namespace std;



class Vehicle
{
private:
    string name;
    int kms;

    // want only specific functions to be able to access this variable
    // we will create a 'friend' function
    int obu;

public:

    Vehicle(string name, int kms)
    {
        this->name = name;
        this->kms = kms;
        this->obu = 1337;
    }

    string getName()
    {
        return this->name;
    }

    int getKMS()
    {
        return this->kms;
    }


    // define the friend function allowing the getOBU function to access the private member obu
    friend int getOBU(Vehicle &vehicle);
};

// define the body of the friend function defined in the class
int getOBU(Vehicle &vehicle)
{
    return vehicle.obu;
}


class Collection
{
public:
    vector<Vehicle> vehicles;

    void operator+=(Vehicle &vehicle)
    {
        this->vehicles.push_back(vehicle);
    }
};



class Point
{
private:
    int x, y;

public:
    Point()
    {
        this->x = 0;
        this->y = 0;
    }

    Point(int x, int y)
    {
        this->x = x;
        this->y = y;
    }

    int getX()
    {
        return this->x;
    }

    void setX(int x)
    {
        this->x = x;
    }

    int getY()
    {
        return this->y;
    }

    void setY(int y)
    {
        this->y = y;
    }

    Point operator+(Point &right)
    {
        return Point(this->x + right.getX(), 
                     this->y + right.getY());
    }

    
};



// overload allowing for cout << Vehicle
ostream& operator<<(ostream &stream, Vehicle &v)
{
    stream << v.getName() << ": " << v.getKMS();
    return stream;
}



// overload allowing for cout << Collection
ostream& operator<<(ostream &stream, Collection& collection)
{
    int size = collection.vehicles.size();

    if(size == 0)
    {
        stream << "[]";
        return stream;
    }
    
    stream << "[";

    int i = 1;
    for(Vehicle v : collection.vehicles)
    {
        stream << v;

        if(i++ < size)
            stream << ", ";
    }

    stream << "]";

    return stream;
}



// overload allowing for cout << Point
ostream& operator<<(ostream& stream, Point &p)
{
    stream << '(' << p.getX() << ", " << p.getY() << ')';
    return stream;
}



int main()
{

    double number1 = 7.3;
    double number2 = 10.5;

    // plus operator on doubles
    cout << "result: " << number1 + number2 << endl;

    string s1 = "hello ";
    string s2 = "world";

    // plus operator is overloaded to work with strings aswell
    cout << "result: " << s1 + s2 << endl;


    // can overload most operators, but you cannot overload . * ; ?

    // rules on overloading:
    //  - they still follow BEDMAS
    //  - works from left -> right
    //  - arity will not change (i++ i-- etc)
    //  - cannot create new operators 
    //  - you *can* swap functionality, (ie make + the same as -), but you shouldn't 
    //  - related operators, like + and += must be overloaded separetely
    //  - when overloading () [] -> or and of the assignment operators, it must be declared as a class member




    Vehicle v1 = Vehicle("Ravd", 123);

    // << works with a string just fine
    cout << v1.getName() << endl;

    // so we can overload the << operator to work with the class
    cout << v1 << endl;




    // overloading operators inside objects 
    Collection collect;

    // don't want to do this each time, so we will overload the += operator 
    collect.vehicles.push_back(v1);

    // this now does the same thing as above
    collect += v1;

    // overload << for Collection class aswell
    cout << collect << endl;




    // overloading the + operator for the Point class 
    Point p1 = Point(0, 0);
    Point p2 = Point(5, 5);

    Point result = p1 + p2;

    // overloading the << operator
    cout << result << endl;




    // calling the friend function
    cout << getOBU(v1) << endl;
    
    return 0;
}