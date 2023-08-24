
#include <iostream>
#include <vector>
using namespace std;


// using template class for a felxible stack implementation with vectors 
template <class T>

class Stack
{
private:
    vector<T> stack;

public:

    void pushToStack(T item)
    {
        stack.push_back(item);
    }

    T pop()
    {
        T _ = stack.back();
        stack.pop_back();
        return _;
    }

    void display()
    {
        cout << "stack from top to bottom... \n";

        for(int i = stack.size()-1; i >= 0; i--)
        {
            cout << stack.at(i) << endl;
        }
    }
};


int main()
{
    Stack<int> s = Stack<int>();

    s.pushToStack(5);
    s.pushToStack(3);
    s.pushToStack(2);
    s.pushToStack(1);
    s.pushToStack(0);

    s.display();

    s.pop();
    s.pop();
    s.pop();

    s.display();
    return 0;
}