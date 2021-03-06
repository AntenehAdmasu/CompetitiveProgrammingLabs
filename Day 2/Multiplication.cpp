/******************************************************************************

Computes Multiplication of numbers from user input.
Inputs can be negative or positive.

*******************************************************************************/

#include <iostream>
#include <bits/stdc++.h>
#include <string>

using namespace std;

string adder(string firstNum, string secondNum, string sign)
{
    if (firstNum.length() > secondNum.length())
        swap(firstNum, secondNum);

    string res = "";

    int num1Length = firstNum.length(), num2Length = secondNum.length();
    int carry = 0;

    for (int i = 0; i < num1Length; i++)
    {
        int sum = ((firstNum[i] - '0') + (secondNum[i] - '0') + carry);
        res.push_back(sum % 10 + '0');
        carry = sum > 9 ? 1 : 0;
    }

    for (int i = num1Length; i < num2Length; i++)
    {
        int sum = ((secondNum[i] - '0') + carry);
        res.push_back(sum % 10 + '0');
        carry = sum > 9 ? 1 : 0;
    }

    if (carry > 0)
    {
        res.push_back(carry + '0');
    }
    return res;
}

<<<<<<< HEAD
string multiply(string firstNum, string secondNum, string sign)
{
    reverse(firstNum.begin(), firstNum.end());
    reverse(secondNum.begin(), secondNum.end());

=======
string multiply(string firstNum, string secondNum, string sign){
    reverse(firstNum.begin(), firstNum.end());
    reverse(secondNum.begin(), secondNum.end());
    
>>>>>>> 83573348d97345b3848ddb0414182bea7edd7ebc
    if (secondNum.length() > firstNum.length())
        swap(firstNum, secondNum);

    string product = "";
    string sumOfRows = "";

    for (int i = 0; i < secondNum.length(); i++)
    {

        string offset = "";
        int carry = 0;
        string rowSum = "";

        for (int x = 0; x < i; x++)
        {
            offset += '0';
        }

        for (int j = 0; j < firstNum.length(); j++)
        {
            string prod = to_string(((secondNum[i] - '0') * (firstNum[j] - '0')) + carry);
            carry = 0;
            if (prod.length() > 1)
            {
                carry = prod[0] - '0';
                rowSum.push_back(prod[1]);
            }
            else
            {
                rowSum.push_back(prod[0]);
            }
        }

        if (carry != 0)
        {
            rowSum.push_back(carry + '0');
        }

        rowSum = offset + rowSum;

        sumOfRows = adder(sumOfRows, rowSum, "+");
    }
    reverse(sumOfRows.begin(), sumOfRows.end());
    std::cout << sign + sumOfRows << std::endl;
    return sumOfRows;
}

int main()
{
    string firstNum, secondNum;
    cin >> firstNum;
    cin >> secondNum;

    string positive = "+";
    string negative = "-";

    string sign = (((firstNum[0] == *"-") && (secondNum[0] != *"-")) || ((firstNum[0] != *"-") && (secondNum[0] == *"-"))) ? negative
                                                                                                                           : positive;

    if ((firstNum[0] == *"-"))
    {
        string firstN = firstNum.substr(1, firstNum.length() - 1);
        multiply(firstN, secondNum, sign);
    }
    else if ((secondNum[0] == *"-"))
    {
        string secondN = firstNum.substr(1, firstNum.length() - 1);
        multiply(firstNum, secondN, sign);
    }
    else
    {
        multiply(firstNum, secondNum, sign);
    }

    return 0;
}
