

using namespace std;

// class definition
class Complex
{
    // private members
private:
    double real;
    double imaginary;

    // public methods 
public:

    // default constructor 
    Complex()
    {
        this->real = 0;
        this->imaginary = 0;
    }

    // parameterized constructor
    Complex(double real, double imaginary)
    {
        this->real = real;
        this->imaginary = imaginary;
    }

    // getter / setter methods 
    void setReal(double real)
    {
        this->real = real;
    }

    void setImaginary(double imaginary)
    {
        this->imaginary = imaginary;
    }

    double getReal()
    {
        return this->real;
    }

    double getImaginary()
    {
        return this->imaginary;
    }


    // operator overloads 
    Complex operator+(Complex &operand)
    {
        return Complex(this->real      + operand.getReal(),
                       this->imaginary + operand.getImaginary());
    }

    Complex operator-(Complex &operand)
    {
        return Complex(this->real      - operand.getReal(),
                       this->imaginary - operand.getImaginary());
    }

    Complex operator*(Complex &operand)
    {
        return Complex((this->real * operand.getReal())      - (this->imaginary   * operand.getImaginary()),
                       (this->real * operand.getImaginary()) + (operand.getReal() * this->imaginary));
    }

    bool operator==(Complex &operand)
    {
        return this->real      == operand.getReal() &&
               this->imaginary == operand.getImaginary();
    }

    // Complex operator==(Complex &operand)
    // {
    //     if (this->real == operand.getReal() &&
    //         this->imaginary == operand.getImaginary())
    //     {
    //         return Complex(1, 1);
    //     }
    //     return Complex(0, 0);
    // }
};
