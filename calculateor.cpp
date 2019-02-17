#include <iostream>
using namespace std;
class calculator
{
	int a,b;
	public:
	calculator(int x,int y)
	{
		a=x;
		b=y;
	}
	
	int addition(int x,int y)
	{
		return (x+y);
	}
	
	int subtraction(int x,int y)
	{
		return (x-y);
	}
	
	int product(int x,int y)
	{
		return (x*y);
	}
	
	int quotient(int x,int y)
	{
		return (x/y);
	}
	
	int remainder(int x,int y)
	{
		return (x%y);
	}
	
	void calculate()
	{
		cout<<"The sum is "<<addition(a,b)<<endl;
		cout<<"The difference is "<<subtraction(a,b)<<endl;
		cout<<"The product is "<<product(a,b)<<endl;
		cout<<"The quotient is "<<quotient(a,b)<<endl;
		cout<<"The remainder is "<<remainder(a,b)<<endl;
	}
};

int main()
{
	cout<<"Enter 2 numbers"<<endl;
	int a,b;
	cin>>a>>b;
	calculator obj(a,b);
	obj.calculate();
	return 0;
}
