

// You are required to write a C++ program that would serve as a word count. Word count is used quite 
// a lot in Natural Language Processing (NLP) and is pretty interesting concept that is used in various 
// applications today like spam detection, sentiment analysis and etc.
// You are provided a text file (data.txt) with this lab which is an excerpt from Ontario Tech University’s 
// history. All the punctuations except the apostrophe are intentionally removed from the text. You are 

// required to perform the following tasks:
// - Read the text file word by word.
// - Create a class called WordCounter that 
// - Has 2 data members, e.g., string word, int count.
// - Has appropriate getters and setters
// - At least one constructor
// - Uses this keyword to help distinguish between data members and local variables
// - Create a collection of words in such a way that your program can distinguish between different 
//   words, e.g., store each different word in an object of WordCounter class.
// - Every time a word appears your program is required to count the occurrence of that word in 
//   the file.
// - Finally print a report with each word and number of times it occurred in the text file provided.
// - You can only use #include<iostream>, #include<fstream>, #include<string>, include<vector> 
//   libraries.
// 
// Your program should at least have the following methods:
// - bool isFound(vector<WordCounter> &v, string word) which takes a vector of WordCounter objects 
//   and a word to make a search of that word in that vector. If the word is found, return true else 
//   false.
// - void  incrementWordCount(????)  function  that  counts  the  occurrences  of  the  word.  It  is  your 
//   responsibility to find out which arguments should be provided to this function.
// - void  printReport(vector<WordCounter>  &v)  which  should  simply  have  a  cout  statement  that  tells 
//   how many times a word has appeared in the file.

#include <iostream>
#include <vector>
#include <string>
#include <fstream>

using namespace std;

// define class for counting words
class WordCounter
{
// private members
    string word;
    int count;

// public methods
public:

    // default constructor
    WordCounter()
    {    
        this->word = "";
        this->count = 1;
    }

    // constructor that takes word
    WordCounter(string word)
    {
        this->word = word;
        this->count = 1;
    }


    // setter for the private member 'word'
    void setWord(string word)
    {
        this->word = word;
    }

    // getter for the private member 'word'
    string getWord()
    { 
        return this->word; 
    }


    // setter for the private member 'count'
    void setCount(int count)
    {
        this->count = count;
    }

    // getter for the private member 'count'
    int getCount() 
    { 
        return this->count; 
    }


    // increment function to increase the count by 1
    void incrementWordCount()
    {
        this->count++;
    }
};


// prints all the words and their count to the console
void printReport(vector<WordCounter> &words)
{
    // loop through the vector and print each item
    for(int i = 0; i < words.size(); i++)
    {
        // use the getters to access the private members
        cout << words[i].getWord() << " : " << words[i].getCount() << endl;
    }
}

// returns the first index of a word in the given vector or -1 if not found
int findFirstOf(vector<WordCounter> &v, string word)
{
    // loop through vector
    for(int i = 0; i < v.size(); i++)
    {
        // check the if the words are the same using the getter
        if(v.at(i).getWord() == word)
            return i;
    }

    return -1;
}

// checks if a word is in a string vector
bool isFound(vector<WordCounter> &v, string word)
{
    return findFirstOf(v, word) != -1;
}


int main()
{
     // init word and count vector
    vector<WordCounter> words = vector<WordCounter>();
    
    // init reading stream
    ifstream reader = ifstream();

    // open the file
    reader.open("data-1.txt");

    // process the counting
    
    int i;
    string word;
    while(reader >> word)
    {
        // if the word is found
        // find the index and increase the count vector
        if(isFound(words, word))
        {
            if((i = findFirstOf(words, word)) != -1)
            {
                words[i].incrementWordCount();
            }
            continue;
        }

        // otherwise add it and add to the count vector
        words.push_back(WordCounter(word));
    }

    // close the file
    reader.close();

    // print the report
    printReport(words);
    return 0;
}