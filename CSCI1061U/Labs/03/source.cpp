
// You are required to write a C++ program that would serve as a Bit Stuffing which is a mechanism of 
// inserting one or more non-information bits into a message to be transmitted, to break up the message 
// sequence, for synchronization purpose in computer networking.
// 
// You are provided a text file (bits.txt) with this lab which contains the Packet number and sequence of 
// bits for each packet. Ask User to provide a sequence of 0’s and 1’s, e.g., 1100 and search for it in the 
// 
// file. You are required to perform the following tasks:
// - Read the text file line by line
// 
// - Create a Bits class with at least followings:
//   - Private data members:
//     - string sequence
//     - string packet
// 
//   - Corresponding Getters and Setters along with a Default Constructor
//   - A void toString() method that would simply cout sequence : packet
//   - A bool isEmpty() method that checks to see if any value of sequence or packet is empty 
//     and returns true if any of them is empty else returns false. This is an optional method 
//     and you are free to ignore it but can be helpful in not displaying the null values.  
// 
// - Create a Bits getBitsObject(string word, string user_sequence) method that creates a Bits object for 
//   the above class by searching whether a word read from a file contains the user entered bit 
//   sequence or not. If it does, it should set the sequence and packet for that particular object 
//   using setter methods and returns the object.
// 
// - Every time a sequence entered by the user is found in the read file, you are required to create 
//   an array of Bits object in the heap. It means that you are constantly increasing the size of the 
//   array in the heap on each found of the sequence. For this purpose, use a method that can 
//   resize the array in the heap that would return a Bits object pointer by taking in as a parameter, 
//   a Bits object pointer and address of size variable from the main method. The definition of this 
//   function should be Bits* resize(Bits* arr, int* size). Make sure to delete any space occupied 
//   programmatically when it’s not required. You are free to google for “C++ resize dynamic 
//   array”. 
// 
// - Finally create a void display(Bits *arr, int size)  function to display the report shown below in the 
//   expected output.
// 
// - You can only use #include<iostream>, #include<fstream>, #include<string> libraries.

#include <iostream>
#include <string>
#include <fstream>

using namespace std;

// bits class as defined above 
class Bits
{
private:
    string sequence;
    string packet;

public:

    // default constructor
    Bits()
    {
        this->sequence = "";
        this->packet   = "";
    }

    // parameterized constructor
    Bits(string packet, string sequence)
    {
        this->sequence = sequence;
        this->packet   = packet;
    }

    // getters / setters 
    void setSequence(string sequence)
    {
        this->sequence = sequence;
    }

    string getSequence()
    {
        return this->sequence;
    }

    void setPacket(string packet)
    {
        this->packet = packet;
    }

    string getPacket()
    {
        return this->packet;
    }

    // other required functions 
    void toString()
    {
        cout << this->packet << ": " << this->sequence << endl;
    }

    bool isEmpty()
    {
        return this->packet.length() == 0 && this->sequence.length() == 0;
    }
};


// increase the given array size by 1
Bits* resize(Bits* arr, int* size)
{
    // create a new array of 1 + the given array size
    Bits* newArr = new Bits[(*size) + 1]();

    // copy the old array into the new array
    for(int i = 0; i < (*size); i++)
    {
        *(newArr  + i) = *(arr + i);
    }
    
    // increase the size by 1
    *size = *size + 1;

    // delete the old array
    delete[] arr;

    // return pointer to the new array
    return newArr;
}


// gets a bit object if the 'user_sequence' is found in the bits
// othersise returns an empty bit
Bits getBitsObject(string word, string user_sequence)
{
    int length  = word.length();
    int sLength = user_sequence.length();
    
    // find the comma separating the packet from the bits
    int comma = word.find_first_of(',');

    for(int i = comma + 1; i < length; i++)
    {
        // check if the user sequence is in the bits
        if(user_sequence != word.substr(i, sLength))
            continue;

        // create a new bit setting the packet and the bits
        return Bits(word.substr(0, comma), 
                    word.substr(comma + 1, length - comma));
    }

    // the given user sequence was not in the bits
    return Bits();
}


// prints the given Bits array
 void display(Bits *arr, int size)
 {
    // get loop through the array and display the items
    for(int i = 0; i < size; i++)
    {
        // get the Bits object and print it
        // ((Bits)*(arr + i)).toString(); // ugly method to call toString
        arr[i].toString();
    }
}



int main()
{
    // open file
    ifstream reader = ifstream();
    reader.open("bits.txt");

    // get the bit sequence from the user
    string input;
    cout << "Enter a bit sequence: ";
    getline(cin, input);

    // visual effect / display of *****
    cout << endl << string(32, '*') << " Bit Sequences Found " << string(32, '*') << endl << endl;

    // define the matches and the length
    int matchesLength = 0;
    Bits *matches;

    // read each line from the file
    for (string line; getline(reader, line); )
    {
        // get the bit object
        Bits b = getBitsObject(line, input);

        // if the bit object is empty, the user sequence was not found
        if(b.isEmpty())
            continue;

        // if the matches is not defined yet
        // define it and add the Bits
        if(matchesLength == 0)
        {
            matches = new Bits[1]();
            matches[matchesLength++] = b;
        }
        // resize the existing array and add the new item
        else
        {
            matches = resize(matches, &matchesLength);
            matches[matchesLength - 1] = b;
        }
    }

    // display any matches found
    display(matches, matchesLength);

    // visual effect / display to copy the example output
    cout << endl << "Total Occurrences: " << matchesLength << endl << endl << string(85, '*') << endl << endl;

    return 0;
}