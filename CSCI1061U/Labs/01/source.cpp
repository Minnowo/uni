

// PROBLEM:
// You are required to write a C++ program that would serve as a word count. Word count is used quite 
// a  lot  in  Natural  Language  Processing  (NLP)  and  is  pretty  interesting  concept  that  is  used  in  various 
// applications today like spam detection, sentiment analysis and etc.
// You are provided a text file (data.txt) with this lab which is an excerpt from Ontario Tech University’s 
// history. All the punctuations except the apostrophe are intentionally removed from the text. You are 
// required to perform the following tasks:
// 
// -- Read the text file word by word.
// 
// -- Create  a  collection  of  words  in  such  a  way  that  your  program  can  distinguish  between 
//    different words, e.g., store each different word in a vector.
// 
// -- Every time a word appears your program is required to count the occurrence of that word in 
//    the file.
// 
// -- Finally print a report with each word and number of times it occurred in the text file provided.
// 
// -- You can only use #include<iostream>, #include<fstream>, #include<string>, include<vector> libraries.

// Your program should at least have the following methods:
//
// -- bool isFound(vector<string> v, string word) which takes a vector and a word to make a search of that 
//    word in that vector. If the word is found, return true else false.
// 
// -- void  printReport(vector<string>  words,  vector<int>  counts)  which  contains  two  vectors;  one  with 
//    unique words and other with count of those unique words. This method should simply have 
//    a cout statement that tells how many times a word has appeared in the file.


#include "iostream"
#include "vector"
#include "string"
#include "fstream"
using namespace std;

// prints all the words and their count to the console
void printReport(vector<string> &words, vector<int> &counts)
{
    int size = words.size();

    if(size != counts.size())
    {
        throw exception("the vector size must be the same");
    }

    for(int i = 0; i < size; i++)
    {
        cout << words[i] << " : " << counts[i] << endl;
    }
}

// returns the first index of a word in the given vector or -1 if not found
int findFirstOf(vector<string> &v, string word)
{
    for(int i = 0; i < v.size(); i++)
    {
        if(v.at(i) == word)
            return i;
    }

    return -1;
}

// checks if a word is in a string vector
bool isFound(vector<string> &v, string word)
{
    return findFirstOf(v, word) != -1;
}

int main()
{
    // init word and count vector
    vector<string> words = vector<string>();
    vector<int> count = vector<int>();
    
    // init reading stream
    ifstream reader = ifstream();

    // open the file
    reader.open("data.txt");

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
                count[i]++;
            }
            continue;
        }

        // otherwise add it and add to the count vector
        words.push_back(word);
        count.push_back(1);
    }

    // close the file
    reader.close();

    // print the report
    printReport(words, count);
    return 0;
}