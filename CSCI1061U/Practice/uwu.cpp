
#include <iostream>
#include <fstream>
#include <string>

using namespace std; 



class Word
{
    string word;

public:

    Word()
    {
        this->word = "";
    }

    Word(string value)
    {
        this->word = value;
    }

    void setWord(string value)
    {
        this->word = value;
    }

    string getWord()
    {
        return this->word;
    }
};



ostream& operator <<(ostream &stream, Word &word)
{
    stream << word.getWord();
    return stream;
}



void resizeArray(Word *&array, int currentSize, int newSize)
{
    Word *newArray = new Word[newSize];

    for(int i = 0; i < currentSize; i++)
    {
        newArray[i] = array[i];
    }

    delete[] array;

    array = newArray;
}



int main()
{
    fstream reader;
    reader.open("words.txt");

    int wordSize = 0;
    Word * words = new Word[0];

    for(string line; getline(reader, line);)
    {
        resizeArray(words, wordSize, wordSize + 1);
        words[wordSize++] = Word(line);
    }
    
    reader.close();

    for(int i = 0; i < wordSize; i++)
    {
        cout << words[i] << endl;
    }
    return 0;
}