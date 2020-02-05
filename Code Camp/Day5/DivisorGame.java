// Question link : https://leetcode.com/problems/divisor-game/

public class DivisorGame {

    public boolean divisorGame(int N) {

        /*  EXPLANATION

            Once Alice get an even she always decrement by 1(since 1 is a factor of all numbers
            and give Bob an odd number. Bob can never give Alice because all numbers he can choose
            from are odd. This cycle continues until Alice reaches 2 and give Bob. Bob has nothing
            to choose from because the only factor of 1 is 1 and the factor can not be equal to the
            number according to the question
         */

        return N % 2 == 0;
    }
}
