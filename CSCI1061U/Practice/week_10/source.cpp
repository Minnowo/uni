
// Question 2 (Intermediate)           
// This exercise tests your knowledge of copying the pointers in C++. 
// You are required to write a C++ program that creates a Student class with the following details: 
// • private 
// o char * name; 
// o int age; 
// • public: 
// o A default constructor that makes the name pointer point to a memory location of 25 
// characters in the heap and also sets the value of age to 0. 
// o A setter for name with the following signature void setName(const char *name) 
// o A getter for name with the following signature char* getName() 
// o A setter for age with the following signature void setAge(int age) 
// o A getter for age with the following signature int getAge() 
// o A display function that simply displays the name and age of the student 
// o A  destructor  that  simply  deallocates  the  memory  from  the  heap  used  by  the  name 
// pointer and also makes name pointer a null pointer. 
 
// Use the following main method to run your Student class int main() 
// { 
//  Student student; 
//  student.setName("Steve Jobs"); 
//  student.setAge(55); 
//  student.display(); 
 
//  return 0; 
// }  
// Does your program work as expected? Is your program crashing? Do you have to make some 
// changes to the definition of the class to make your program run? Research and fix your program to 
// make it run as expected. Below is the screenshot of the expected output of this program: 

#include <iostream>
#include <cstring>

char* copyCStr(const char* string)
{
    int len = strlen(string);

    char* copy = new char[len + 1]();

    for(int i = 0; i < len; i++)
    {
        copy[i] = string[i];
    }

    return copy;
}

class Student
{
private:
    char *name;
    int age;

public:
    Student()
    {
        this->name = new char[25];
        this->age = 0;
    }

    ~Student()
    {
        if(this->name != nullptr)
            delete[] this->name;
        
        this->name = nullptr;
    }

    void setName(const char *name)
    {
        if(this->name != nullptr)
            delete[] this->name;

        // copy the string using a deep copy to prevent error later
        this->name = copyCStr(name);

        // alternatively to using the copyCStr function above
        // int len = strlen(name) + 1;
        // this->name = new char[len];
        // // strcpy(this->name, name); // since this throws an error cause it's depricated use the line below
        // strcpy_s(this->name, len, name);


    }

    char* getName()
    {
        return this->name;
    }

    void setAge(int age)
    {this->age = age;}

    int getAge(){return this->age;}

    void display()
    {
        std::cout << "Age: " << this->age << " Name: " << this->name << std::endl;
    }
};


int main() 
{ 
    Student student; 
    student.setName("Steve Jobs"); 
    student.setAge(55); 
    student.display(); 
 
 return 0; 
} 