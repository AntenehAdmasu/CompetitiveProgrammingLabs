import java.util.ArrayList;
import java.util.Scanner;

public class TemporarilyUnavailable {

    public static void main(String[] args) {
        ArrayList<String> userinputs = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int numberOfInputs = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i  < numberOfInputs ; i++) {

            String nums = scanner.nextLine();
            userinputs.add(nums);
        }

        for (int i = 0; i < userinputs.size() ; i++) {
            String[] nums = userinputs.get(i).split(" ");
            System.out.println(getMinutesofUnavailability(Integer.parseInt(nums[0]),Integer.parseInt(nums[1]),Integer.parseInt(nums[2]),Integer.parseInt(nums[3])));
        }
        scanner.close();
    }

    public static int getMinutesofUnavailability(int a, int b, int c, int r){
        int totalTravel = Math.abs(b-a);
        int intersection = getIntersection(a, b, c-r, c+r);

        return totalTravel - intersection;

    }

    private static int getIntersection(int s1, int e1, int s2, int e2) {
        if(s1 > e1){
            int temp = s1;
            s1 = e1;
            e1 = temp;
        }

        return Math.max((Math.min(e1, e2) - Math.max(s1, s2)),0 );
    }
}
