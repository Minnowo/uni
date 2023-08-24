
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


class SmartPhone : public Phone
{
public:
    void browseInternet()
    {
        cout << "interneting \n";
    }

    // overrides the parent method
    void makeCalls()
    {
        cout << "making call from smartphone" << endl;
    }
};

// inherit from a class which inherits from another class
class Android : public SmartPhone
{
public:
    void UpdateAndroid()
    {
        cout << "updating phone\n";
    }

    // overrides the parent method
    void makeCalls()
    {
        cout << "making call from android" << endl;
    }
};

int main()
{
    Android a;
    a.makeCalls();
    a.browseInternet();
    a.UpdateAndroid();

    return 0;
}