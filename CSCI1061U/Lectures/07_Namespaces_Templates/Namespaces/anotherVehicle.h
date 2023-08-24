
#include <iostream>

using namespace std;

// creating a namespace
namespace space2
{
    class Vehicle
    {
    private:
        string name;
        int kms;

    public:
        void startEngine()
        {

        }
    };

    

    void space2GlobalMethod()
    {
        cout << "this is a space2 global function" << endl;
    }
}