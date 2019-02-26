#include<iostream>

using namespace std;

class my
{
    int a,b;
public:
    my()
    {
       a=0;
       b=0;
    }
    my(int x,int y)
    {
        a=x;
        b=y;
    }
    my(const my &t)
    {
        a=t.a;
        b=t.b;
    }
    void show()
    {
        cout<<a<<"\t"<<b<<endl;
    }
};
int main()
{
    my t1;
    my t2(2,4);
    my t3=t1;
    t3.show();
    t2.show();
    t1.show();
}
