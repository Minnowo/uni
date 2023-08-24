

#include<iostream>


using namespace std;

// defining a namespace 
namespace space1
{

    class Vehicle
    {
    private: 
        string name;
        int kms;

    public:
        Vehicle()
        {

        }

        void drive()
        {
            cout << "vrrrrr" << endl;
        }
    };



    void space1GlobalMethod()
    {
        cout << "this is a space1 global function" << endl;
    }
}