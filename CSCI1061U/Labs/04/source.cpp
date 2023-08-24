
// You are required to write a C++ program that would perform calculations on complex numbers. A
// complex number is a number of the form a + bi, where a and b are real numbers, and i is an
// indeterminate satisfying i2 = −1. For example, 2 + 3i is a complex number. You can read more about
// complex numbers at this link.
//
// You are required to perform the following tasks:
// - Create a Complex class with at least followings:
//   - Private data members
//     - double real
//     - double imaginary
//
//   - Corresponding Getters and Setters along with a Default Constructor and a
//     parameterized constructor.
//
//   - Overload the + operator using member function (should be overloaded inside the class) for
//     adding two complex numbers. Function for overloading this operator should have this
//     signature: Complex operator+(Complex& operand)
//   
//   - Overload the - operator using member function (should be overloaded inside the class) for
//     subtracting two complex numbers. Function for overloading this operator should have this
//     signature: Complex operator-(Complex& operand)
//
//   - Overload the * operator using member function (should be overloaded inside the class) for
//     multiplying two complex numbers. Function for overloading this operator should have this
//     signature: Complex operator*(Complex& operand)
//
//   - Overload the == operator using member function (should be overloaded inside the class) for
//     checking the equivalence of two complex numbers. Function for overloading this operator
//     should have this signature: Complex operator==(Complex& operand)
//
//   - You should also overload << operator for displaying the complex numbers on the console.
//     Make sure to overload this operator using a non-member function (using global function).
//     Signature of the function should be : ostream& operator<<(ostream& output, Complex&
//     complex)
//
// Your program should start by asking user to provide two complex numbers in the form of (a,b)
// where ‘a’ is real number and ‘b’ is the imaginary number. Create two functions below to extract
// from the user input real and imaginary numbers:
//  - double extractReal(string str)
//
//  - double extractImaginary(string str)
//
//  - Finally perform the addition, subtraction, multiplication and equivalence of the two complex
//    numbers provided by the user using overloaded operators and show the results on the
//    console.
//
// - Make sure to put Complex class in a separate header file and submit both Complex.h and
//   Source.cpp files on Canvas.
//
// - You can only use #include<iostream>, and #include<string> libraries.


#include<iostream>
#include<string>

// import the complex number class 
// this also uses namespace std so we don't need that in this file
#include "complex.h"

// overload the << operator to allow cout << Complex 
ostream& operator<<(ostream& stream, Complex& complex)
{
    stream << "(" << complex.getReal() << " , " << complex.getImaginary() << ")";
    return stream;
}

// a function that grabs an int at the specified index given
// *number is the int that was found
// returns true if the int was found
// returns false if the int was not found
//
// this function is kinda overkill but i was having some fun and it works for even the worst user input
// are we gonna learn regex in cpp cause it's probably like 3 lines of code for the same thing in regex
bool extractDouble(string str, double *number, int foundIndex = 0)
{
    if(foundIndex < 0)            // force 0 or higher
        foundIndex = 0;

    int intNumber = -1;           // the number of the int ex -> abc12hello55 (number 12 would be 0, and number 55 would be 1)
    int intIndex  = -1;           // the starting index of the number being searched for ^(12 would be 3)
    int intLength = 0;            // the length of the number
    int index     = 0;            // counting index
    int length    = str.length(); // length of string

    while(intNumber != foundIndex)
    {
        if(index + 1 >= length)   // out of bounds check / no number found
        {
            number = nullptr;   // no number found nullptr
            return false;       // return false
        }

        for(; index < length; index++)                // loop through the string
        { 
            if('0' > str[index] || str[index] > '9')  // check if we found an int char
                continue;
            
            intIndex  = index;      // set the int index
            intLength = 0;          // set the length
            intNumber++;            // increase the number

            bool foundDecimal = false;

            do
            {
                index++;       // advance the index
                intLength++;   // increase int length

                if(!foundDecimal && str[index] == '.')  // if a . has not been found yet check for it
                {
                    foundDecimal = true;    // . found
                    index++;                // 'skip' over it

                    if(index < length && '0' <= str[index] && str[index] <= '9') // check if out of bounds or number
                    {
                        intLength++;  // if in bounds increase length and continue as normal
                    }
                    else
                    {
                        index--; // if out of bounds or not int reset the index and end the loop
                        break;
                    }
                }
            }
            while(index < length && '0' <= str[index] && str[index] <= '9');  // while not out of bounds and is still an int

            // break forloop to check if we found the right index
            break;
        }        
    }

    // grab the number and convert to double, then set the output 
    *number = stod(str.substr(intIndex, intLength));
    
    // return true 
    return true;
}

double extractReal(string str)
{
    double number;

    // parse the first occurance of a int / double
    if(extractDouble(str, &number, 0))
    {
        return number;
    }

    // if it cannot parse the second number there is no second number
    // so the user input is invalid
    throw exception("Given string could not be parsed");

    return -1;
}

double extractImaginary(string str)
{
    double number;

    // parse the second occurance of a int / double
    if(extractDouble(str, &number, 1))
    {
        return number;
    }

    // if it cannot parse the second number there is no second number
    // so the user input is invalid
    throw exception("Given string could not be parsed");

    return -1;
}

int main()
{
    // input
    string input;

    // complex numbers 
    Complex number1 = Complex();
    Complex number2 = Complex();


    // get input for complex number 1
    cout << "Enter First complex number in the format (a,b) : ";
    getline(cin, input);

    number1.setReal(extractReal(input));
    number1.setImaginary(extractImaginary(input));
    

    // get input for complex number 2
    cout << "Enter Second complex number in the format (a,b): ";
    getline(cin, input);
    
    number2.setReal(extractReal(input));
    number2.setImaginary(extractImaginary(input));


    // cool looking display 
    cout << "\n" + string(32, '*') << endl;
    cout << string(5, ' ') << "Result of Calculations" << string(5, ' ') << endl;
    cout << string(32, '*') << endl << endl;

    // results 
    Complex result;
    
    result = number1 + number2;
    cout << number1 << " + " << number2 << " = " << result << endl << endl;;

    result = number1 - number2;
    cout << number1 << " - " << number2 << " = " << result << endl << endl;;

    result = number1 * number2;
    cout << number1 << " * " << number2 << " = " << result << endl << endl;;

    if(number1 == number2)
    {
        cout << number1 << " == " << number2 << endl << endl;;
    }
    else 
    {
        cout << number1 << " != " << number2 << endl << endl;;
    }

    cout << string(32, '*') << endl;

    return 0;
}