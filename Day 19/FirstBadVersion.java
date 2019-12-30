// Question : https://leetcode.com/problems/first-bad-version/

import java.sql.SQLOutput;

public class FirstBadVersion {
    public static void main(String[] args) {
        int firstbad = new FirstBadVersion().firstBadVersion2(3,3,1);
        System.out.println("FBD is " + firstbad);
    }


    public int firstBadVersion2(int n,int max,int numofCalls) {

            if(isBad(n) == true){
                if(isBad(n-1) == false){
                    return n;
                }else{
                    double d = Math.ceil(((double)max/(double)(2*numofCalls)));
                    n = n - (int)(d);
                    return firstBadVersion2(n, max,numofCalls+1);
                }

            }else{
                if(isBad((n+1)) == true){
                    return (n+1);
                }else{
                    double d = Math.ceil(((double)max/(2*numofCalls)));
                    n = n + (int)(d);
                    return firstBadVersion2(n,max,numofCalls+1);
                }
            }
    }

    
    public boolean isBad(int n){
        if(n >= 4 ) return true;  // Sample code for test
        return false;
    }
}
