
#include <iostream>

using namespace std;

class Phone
{
protected:
    int speed;

public:
    Phone()
    {
        this->speed = 0;
        cout << "phone constructor\n";
    }

    Phone(int speed)
    {
        this->speed = speed;
        cout << "phone constructor\n";
    }


    ~Phone()
    {
        cout << "phone deconstructor\n";
    }

    void makeCall()
    {
        cout << "making a phone call with speed " << this->speed << "\n";
    }
};

class SmartPhone
{
protected:
    int wifiSpeed;

public:
    SmartPhone()
    {
        this->wifiSpeed = 0;
        cout << "smartphone constructor\n";
    }

    SmartPhone(int wifiSpeed)
    {
        this->wifiSpeed = wifiSpeed;
        cout << "smartphone constructor\n";
    }

    ~SmartPhone()
    {
        cout << "smartphone deconstructor\n";
    }

    void connectInternet()
    {
        cout << "browsing internet with speed " << this->wifiSpeed << "\n";
    }
};

class Android : public SmartPhone, public Phone
{
public:

    // calls SmartPhone constructor
    // then calls Phone constructor
    Android()
    {
        cout << "android constructor\n";
    }

    // call both the phone and smartphone constructor with parameters 
    Android(int speed, int wifiSpeed) : SmartPhone(wifiSpeed), Phone(speed)
    {
        
    }

    ~Android()
    {
        cout << "android deconstructor\n";
    }

    void iAmAndroid()
    {
        cout << "i am android\n";
    }
};

int main()
{
    Android a;
    a.makeCall();
    a.connectInternet();
    a.iAmAndroid();
    
    cout << endl;
    
    Android aa = Android(5, 10);
    aa.makeCall();
    aa.connectInternet();
    aa.iAmAndroid();

    return 0;
}