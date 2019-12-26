import java.util.*;
public class Watermelon {

    public static void main(String[] args) throws IOException {
	    Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        if((input == 2) || (input % 2 != 0)){
            System.out.println("NO");
        }else if(input % 2 == 0 ){
            System.out.println("YES");
        }
    }
}
