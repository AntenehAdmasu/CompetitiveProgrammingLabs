import java.util.Arrays;

public class Radix {


        public static void main(String arg[]){

            // Sample input
            int a[] = {209,3,48,91,66,101,30,795};

            Radix rs= new Radix();
            int[] b = rs.radixSort(a);

        }

        // Main Radix Sort sort function
        public int[] radixSort(int A[])
        {
            int digitPlace = 1;
            int n=A.length;
            int result[]=new int[n]; // resulting array

            int largestNum = getMax(A);
            while(largestNum/digitPlace >0){

                int count[]=new int[10];

                //Store the count of "keys" or digits in count[]
                for (int i = 0; i < n; i++){
                   count[ (A[i]/digitPlace)%10 ]++;
                }

                //Finding actual indices
                for (int i = 1; i < 10; i++)
                    count[i] += count[i - 1];

                // Build the resulting array
                for (int i = n - 1; i >= 0; i--)
                {
                    result[count[ (A[i]/digitPlace)%10 ] - 1] = A[i]; //Putting the number in its exact position
                    count[ (A[i]/digitPlace)%10 ]--;  //Updating index if there is another element with the same digit
                }

                //Copying the result array to the main array
                for (int i = 0; i < n; i++)
                    A[i] = result[i];

                digitPlace *= 10;
            }

            return A;
        }


    // Finding the maximum element in the given array
    public int getMax(int A[])
    {
        int max = A[0];
        for (int i = 1; i < A.length; i++){
            if (A[i] > max)
                max = A[i];
        }
        return max;
    }
    }
