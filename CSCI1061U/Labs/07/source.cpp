
// import stuff 
#include <iostream>
#include <array>

// use these things
using std::array;
using std::cout; // putting on multiple lines so clang++ stops giving me warnings (putting on 1 line works just fine)
using std::cin;

// template function to allow more flexible use of std::array
// returns true if the item is found in the array, otherwise false
template<class T, std::size_t N>
bool inArray(const array<T, N> &array, const T &item) // define as const because we're not changing them
{
    // simple linear search
    for(T _ : array)
    {
        if(item == _)
            return true;
    }

    return false;
}

// entry point
int main()
{
    // constant SIZE, and define the array
    const int SIZE = 10;
    array<int, SIZE> arry{};

    // let the user know what they're doing
    cout << "Enter 10 integers between 10 and 100.\n";

    // loop 
    int input;
    for(int i = 0; i < SIZE; i++)
    {
        // get user input
        cout << "Enter a number: ";
        cin >> input;

        // check if the input is valid, if not, try again
        if(input > 100 || input < 10)
        {
            cout << "Invalid number. Please enter a number between 10 and 100.\n\n";
            i--;
            continue;
        }

        // woah, readable code?!?!?! at the cost of more lines??? cannot believe it's not that big lambda anymore ;w;
        if(inArray(arry, input))
        {
            cout << "Duplicate number.\n\n";
            input = -1; // -1 means ignore this when printing 
        }

        // add the input to the array
        arry[i] = input;
    }

    // display the array
    for(int num : arry)
    {
        // from line 56, ignore -1
        if(num == -1)
            continue;

        cout << num << " ";
    }

    return 0;
}