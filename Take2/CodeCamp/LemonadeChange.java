public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {

        int total = 0;
        int fives = 0;
        int tens = 0;
        int twentys = 0;

        for(int bill: bills){
            int change = bill  - 5;
            if(change > total){
                return false;
            }
            total += bill;

            if(change > 10 && tens > 0){
                change -= 10;
                tens--;
            }

            //Five
            int five = change / 5;
            if(five <= fives){
                change -= five * 5;
                fives -= five;
            }else{
                return false;
            }
            if(bill == 5){
                fives++;
            }else if(bill == 10){
                tens++;
            }
        }
        return true;
    }
}
