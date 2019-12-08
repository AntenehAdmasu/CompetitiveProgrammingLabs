/******************************************************************************

Computes addition of numbers from user input. 
Inputs can be negative or positive.

*******************************************************************************/

#include <iostream> 
#include<bits/stdc++.h> 

using namespace std; 

string adder(string firstNum, string secondNum, string sign) 
{ 
    if (firstNum.length() > secondNum.length()) 
        swap(firstNum, secondNum); 

    string res = ""; 

    int num1Length = firstNum.length(), num2Length = secondNum.length(); 

    reverse(firstNum.begin(), firstNum.end()); 
    reverse(secondNum.begin(), secondNum.end());   

    int carry = 0; 

    for (int i = 0; i < num1Length; i++) 
    {
        int sum = ((firstNum[i]-'0')+(secondNum[i]-'0')+carry); 
        res.push_back(sum%10 + '0');
        carry = sum > 9? 1: 0; 
    } 

    for (int i=num1Length; i<num2Length; i++)
    { 
        int sum = ((secondNum[i]-'0')+carry); 
        res.push_back(sum%10 + '0'); 
        carry = sum > 9? 1 : 0; 
    } 

    if (carry > 0){
        res.push_back(carry+'0'); 
    }

    reverse(res.begin(), res.end()); 
    
    cout << sign + res << endl;
    return sign + res;
} 


string subtractor(string firstNum, string secondNum, string sign)
{

    reverse(firstNum.begin(), firstNum.end());
    reverse(secondNum.begin(), secondNum.end());
    
    string result = "";

    for (int i = 0; i < secondNum.length(); i++)
    {
        int dif = (firstNum[i] - '0') - (secondNum[i] - '0');

        if (dif < 0)
        {
            dif += 10;
            result[i] = (dif + '0');

            if ((firstNum[i + 1] - '0') != 0)
            {
                firstNum[i + 1] = ((firstNum[i + 1] - '0') - 1) + '0';
            }
            else
            {
                int counter = i + 1;
                while (counter < firstNum.length())
                {
                    if ((firstNum[counter] - '0') == 0)
                    {
                        firstNum[counter] = (9 + '0');
                        counter++;
                    }
                    else
                    {
                        firstNum[counter] = ((firstNum[counter] - '0') - 1) + '0';
                        break;
                    }
                }
            }
        }

        result.push_back(dif + '0');
    }

    for (int i = secondNum.length(); i < firstNum.length(); i++)
    {
        result.push_back(firstNum[i]);
    }

    reverse(result.begin(), result.end());

    cout << sign + result << endl;
    return sign + result;
}

int main() 
{ 
    string firstNum, secondNum;
    std::cin >> firstNum;
    std::cin >> secondNum;
    
    if((firstNum[0] == *"-") && (secondNum[0] == *"-")){         // Same sign - both negative
       adder(firstNum.substr(1, firstNum.length() - 1), secondNum.substr(1, firstNum.length() - 1), "-");
    } 
    
    else if ((firstNum[0] != *"-") && (secondNum[0]!= *"-")){  // Same sign - both positive
       adder(firstNum, secondNum, "+");
    }
        
    else if ((firstNum[0] == *"-") && (secondNum[0] != *"-")){        // Different Signs - firstNum negative secondNum positive
    
      string firstN = firstNum.substr(1, firstNum.length() - 1);

      if(firstN.length() > secondNum.length()) {
            subtractor(firstN, secondNum, "-");
      }else if (firstN.length() < secondNum.length()){
            subtractor(secondNum, firstN, "+");
      }else{
          for(int i = 0; i < firstNum.size();i++){
              if(firstN[i] + '0' > secondNum[i] + '0'){
                    subtractor(firstN, secondNum, "-");
                    return 0;
              }else if(secondNum[i] + '0' > firstNum[i] + '0') {
                    subtractor(secondNum, firstN, "+");
                    return 0;
              }
          }

          subtractor(firstNum, secondNum, "+");

      }
    }
    
    else if ((firstNum[0] != *"-") && (secondNum[0] == *"-")){        // Different Signs - firstNum positive secondNum negative
       string secondN = secondNum.substr(1, secondNum.length() - 1);

       if(firstNum.length() > secondN.length()) {
            subtractor(firstNum, secondN, "+");
            
       }else if (firstNum.length() < secondN.length()){
            subtractor(secondN, firstNum, "-");
       
            
      }else{          

          for(int i = 0; i < firstNum.length();i++){
              if(firstNum[i] + '0' > secondN[i] + '0'){
                    subtractor(firstNum, secondN, "+");
                    return 0;
              }else if(secondN[i] + '0' > firstNum[i] + '0') {
                    subtractor(secondN, firstNum, "-");
                    return 0;
              }
          }

          subtractor(firstNum, secondN, "+");
      }
       
    }
    
    return 0; 
}