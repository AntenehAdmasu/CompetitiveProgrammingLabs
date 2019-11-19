/******************************************************************************

                            Online C Compiler.
                Code, Compile, Run and Debug C program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <stdio.h>

void printSpace(int numOfSpaces){
    for(int i = 0; i < numOfSpaces; i++){
        printf(" ");
    }
}


void printAsterisk(int numOfAsterisks){
    for(int i = 0; i < numOfAsterisks; i++){
        printf("*");
    }
}

void question2(int rows){
    
    for(int i = 0; i <= rows; i++){
        printAsterisk(i);
        printf("\n");
    }
    
}


int main()
{
    int rows;
    
    printf("Enter a number:");
    scanf("%d", &rows);
    
    for(int i = 0; i <= rows; i++){
        printSpace(rows - i);
        printAsterisk((2*i)-1);
        printf("\n");
    }
    
    question2(rows);
    
    return 0;
}