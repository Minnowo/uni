

#include <iostream>
using namespace std;

class Point
{
public:
    int x;
    int y;
    int* z;

    Point()
    {
        this->x = 0;
        this->y = 0;
        this->z = new int(0);
    }
    Point(int x, int y, int z)
    {
        this->x = x;
        this->y = y;
        this->z = new int(z);
    }

    void display()
    {
        cout << "x: " << this->x << " y: " << this->y << " z: " << *this->z << endl;
    }
};

class PointWithDeepCopy
{
public:
    int x;
    int y;
    int* z;

    PointWithDeepCopy()
    {
        this->x = 0;
        this->y = 0;
        this->z = new int(0);
    }
    PointWithDeepCopy(int x, int y, int z)
    {
        this->x = x;
        this->y = y;
        this->z = new int(z);
    }
    PointWithDeepCopy(PointWithDeepCopy& point)
    {
        this->x = point.x;
        this->y = point.y;
        this->z = new int(*point.z);
    }
    void display()
    {
        cout << "x: " << this->x << " y: " << this->y << " z: " << *this->z << endl;
    }
};


Point deepCopyPoint(Point &p1)
{
    Point p2 = Point(p1.x, p1.y, *p1.z);
    return p2;
}

int main()
{
    // shallow copy 
    // x1 -> x2
    // y1 -> y2
    // z1 -> z2  // since this is a pointer, p1 and p2 point to the same location, so modifying the value of z changes it for p1 and p2 
    Point p1 = Point(5, 5, 5);
    Point p2 = p1;
    p2.x = 3;
    p2.y = 3;
    *p2.z = 9; // will change the value of z for p1 aswell 

    p1.display(); // x: 5 y: 5 z: 9
    p2.display(); // x: 3 y: 3 z: 9



    cout << "\n\n";



    // deep copy 
    // x1 -> x2
    // y1 -> y2
    // z1 -> z2  // since this is a deep copy, it will allocate more heap memory and NOT copy the address from the old pointer
    PointWithDeepCopy p3(5, 5, 5);
    PointWithDeepCopy p4 = p3; // has a constructor which deep copies the data, alternatively use the deep copy function above
    p4.x = 3;
    p4.y = 3;
    *p4.z = 9; // will no longeru pdate p3

    p3.display(); // x: 5 y: 5 z: 5
    p4.display(); // x: 3 y: 3 z: 9

}