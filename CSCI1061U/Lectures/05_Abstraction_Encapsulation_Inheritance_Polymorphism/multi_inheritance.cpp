
#include <iostream>

using namespace std;

class Phone
{
public:
    void makeCalls()
    {
        cout << "making call\n";
    }
};

class SmartPhone
{
public:
    void browseInternet()
    {
        cout << "interneting \n";
    }

    void makeCalls()
    {
        cout << "making call from smartphone" << endl;
    }
};

// inherit from more than 1 parent class 

class Android : public SmartPhone, public Phone
{
public:
    void UpdateAndroid()
    {
        cout << "updating phone\n";
    }
};

int main()
{
    Android a;

    // since both parents have the make call method, compiler doesn't know 
    // which function to use
    // a.makeCalls();
    a.browseInternet();
    a.UpdateAndroid();

    return 0;
}