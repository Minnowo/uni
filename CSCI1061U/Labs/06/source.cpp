


#include <iostream>
#include <cstring>
using namespace std;


class Cd
{
    // private members
private:
    const char *performers;
    const char *label;
    int selections;
    double playtime;

public:

    // default constructor
    Cd()
    {
        // heap storage of Unknown
        this->performers = new char[8]{ "Unknown" }; // weird this doesn't work in some compilers

        // so an alternative to the above is 
        // this->performers = new char[8]();
        // this->performers = "Unknown";

        this->label = this->performers;

        this->selections = 0;
        this->playtime   = 0;
    }

    Cd(const char *performers, const char *label, int selections, double playtime)
    {
        this->selections = selections;
        this->playtime  = playtime;

        // copy the given string and increase its size by 1
        this->performers = new char[strlen(performers) + 1]();
        this->performers = performers;

        this->label = new char[strlen(label) + 1]();
        this->label = label;
    }

    // deconstructor
    ~Cd()
    {
        // null check before delete
        if(this->performers != nullptr)
            delete[] this->performers;

        if(this->label != nullptr)
            delete[] this->label;

        this->performers = nullptr;
        this->label      = nullptr;
    }

    // prints data members
    virtual void Report()
    {
        cout << "Performer(s): " << this->performers << "\n";
        cout << "Label: " << this->label << "\n";
        cout << "Number of selections: " << this->selections << "\n";
        cout << "Play time: " << this->playtime << endl;
    }
};


// single public inheritance
class Classic : public Cd
{
    // define private member
private:
    const char *primaryWork;

public:
    // default constructor
    Classic()
    {
        this->primaryWork = new char[8]{ "Unknown" };
    }

    // pass values into parent constructor to handle, then deal with the new stuff
    Classic(const char* primaryWork, 
            const char* performers, 
            const char* label, int selections, double playtime) : Cd(performers, label, selections, playtime)
    {
        // copy and increase size by 1
        this->primaryWork = new char[strlen(primaryWork) + 1]();
        this->primaryWork = primaryWork;
    }

    // deconstructor
    ~Classic()
    {
        // null check before cleanup
        if(this->primaryWork != nullptr)
            delete[] this->primaryWork;
        
        this->primaryWork = nullptr;
    }

    // print data members
    virtual void Report() override
    {
        cout << "Primary work: " << this->primaryWork << "\n";

        // call base function to print private members
        Cd::Report();
    }
};



int main() 
{ 
    // create child and parent instances
    Cd c1("Beatles", "Capitol", 14, 35.5); 
    
    Classic c2 = Classic("Piano Sonata in B flat, Fantasia in C", "Alfred Brendel", "Philips", 2, 57.17); 
    
    // Create a parent pointer and make it point to Cd object 
    Cd *cdPointer = &c1;

    
    // print stuff to console 
    cout << "\nUsing object directly:\n"; 
    cout << "***************************" << endl; 
    
    // Call Report() using Cd object 
    c1.Report();

    cout << endl;
    
    // Call Report() using Classic object 
    c2.Report();

    cout << "\nUsing type cd * pointer to objects:\n"; 
    cout << "***************************" << endl; 
    
    // Call Report() using Cd type pointer created above 
    cdPointer->Report();

    cout << endl;

    // Make ptr point to Classic Object 
    cdPointer = &c2;

    // Call Report() using Cd type pointer containing Classic object address 
    cdPointer->Report();

    cout << endl;

    return 0; 
} 
 