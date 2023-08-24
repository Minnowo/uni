
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

void helloWorld()
{
    cout << "hello world" << endl;
}

int product(int x, int y)
{
    return x * y;
}

int subtract(int x, int y)
{
    return x - y;
}

int add(int x, int y)
{
    return x + y;
}

int main()
{
    // auto will inffer the datatype, so you must give it an initial value
    // auto a;

    auto a = 6;

    // print out the type name of a 
    cout << typeid(a).name() << endl;



    // lambda funcitons
    // this is the most simple lambda you can have
    // they are made of 3 parts 
    // capture list []
    // param list   ()
    // body         {}
    []() {};

    // you need to store lambda functions in auto 
    auto hee = []()
            {
                cout << "hello world" << endl;
            };

    // run the function
    hee();


    // if you want to access i inside a lambda, it won't let you by default
    int i = 3;

    // by adding the variables you want to acces in the lambda to the [] 
    // it will allow them to be accessed
    // NOTE: anything passed using capture list is READ ONLY, it cannot be changed inside 
    auto sum = [i](int a, int b)
    { 
        // i = 5; // this is not allowed 
        return a + b + i; 
    };

    cout << sum(5, 5) << endl; // gives 5 + 5 + 3 = 13

    // if you want to change the value of stuff passed using the capture list
    // you need to pass it by ref
    auto sum2 = [&i](int a, int b)
    { 
        i = 5; // this is valid
        return a + b + i; 
    };

    // if you want all variables to be accessable in the lambda
    // you can use a '=' in the capture list, this means pass all by value
    // use '&' for pass by ref
    auto sum3 = [&](int a, int b)
    { 
        i = 5; // this is valid
        return a + b + i; 
    };


    // a sum funciton using lambda and for_each
    vector<int> v = {1,2,3,4,5,6};
    int s = 0;
    for_each(v.begin(), v.end(), [&s](int e){ s = s + e; });

    cout << "the sum of the list is: " << s << endl;


    vector<int> to_display = {4,6,1,6,6,29,294,14,1,56,0};

    // display
    for_each(to_display.begin(), to_display.end(), [](int e) { cout << e << ", "; });

    // sort ascending using lambda 
    sort(to_display.begin(), to_display.end(), [](int a, int b) { return a < b; });
    cout << endl;

    // display
    for_each(to_display.begin(), to_display.end(), [](int e) { cout << e << ", "; });






    // a function pointer to an existing function
    auto func_pointer = helloWorld;

    // another way of getting a function pointer
    void (*funcPtr)() = helloWorld;
    funcPtr();

    // funciton pointer with parameters 
    int (*productPtr)(int, int) = product;
    cout << productPtr(5, 5) << endl;



    // list of function pointers
    int (*opPtr[3])(int, int) = {add, subtract, product};

    int choice;
    cout << "1 : add\n2 : subtract\n3 : multiply\n";
    cin >> choice;

    // call the number from the user 
    cout << opPtr[choice - 1](5, 6) << endl;

    return 0;
}
