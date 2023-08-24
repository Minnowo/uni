


#include <iostream>
#include <vector>

using std::string, std::endl, std::vector, std::cin, std::cout;


// student class definition 
class Student
{
protected:
    // define genders vector
    vector<string> genders;

public:
    // default constructor
    Student()
    {
        genders = vector<string>();
    }

    // add function
    void addToVector(string gender)
    {
        this->genders.push_back(gender);
    }

    // getter for protected member
    vector<string>& getGenders()
    {
        return this->genders;
    }
};


// create a child from the Student class
class Male : public Student
{
public:
    Male()
    {
        addToVector("male");
    }
};

// create a child form the Student class 
class Female : public Student
{
public:
    Female()
    {
        addToVector("female");
    }
};


void assignStudents(vector<Student*>& v)
{
    // counter for gneders, 0 = male, 1 = female
    int genderCount[2] = {0, 0};

    // input string
    string input;

    // loop 10 times
    for(int i = 0; i < 10; i++)
    {
        // ask for a gender
        cout << "Enter a gender: ";
        cin >> input;

        // if the gender is male, 
        // make new male and add it
        if(input == "male")
        {
            v.push_back(new Male());
            continue;
        }

        // if the gender is female,
        // make new female and add it
        if(input == "female")
        {
            v.push_back(new Female());
            continue;
        }

        // invalid gender, reduce the count by 1 and try again
        cout << "Invalid gender try again\n";
        i--;
    }


    // loop through all the students,
    // then loop through all the genders for that student
    for(Student* s : v)
    for(string gender : s->getGenders())
    {
        // if the gender is male increase the male count, 
        // if the gender is female increase the female count.
        if(gender == "male")
        {
            genderCount[0]++;
        }
        else if(gender == "female")
        {
            genderCount[1]++;
        }
    }

    // display the count to the user
    cout << "Males: " << genderCount[0] << "\n";
    cout << "Females: " << genderCount[1] << "\n" << endl;
}



int main()
{
    // init vector of students
    vector<Student*> v;
    
    // get and count the genders for the user
    assignStudents(v);
 
    return 0;
}