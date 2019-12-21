import java.util.ArrayList;
import java.util.List;



public class PositiveIntegerSolution {
    public static void main(String[] args) {
        CustomFunction c = new CustomFunction();
        List<List<Integer>> x = new PositiveIntegerSolution().findSolution(c,100);

        System.out.println("#######################################");
        System.out.println("#######################################\n");

        for (List<Integer> l:x) {
            System.out.print(l.get(0)+"\t");
            System.out.println(l.get(1)+"\t");
        }
    }


    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            List<Integer> unitResult = checkFunction(customfunction,1,1000,i,z);
            if(unitResult.get(0) == -1) continue;
            answer.add(unitResult);
        }
        return answer;

    }


    public List<Integer> checkFunction(CustomFunction customfunction,int left,int right,int x,int z){
        System.out.println();
        List<Integer> result = new ArrayList<>();
        result.add(-1);result.add(-1);

        if(right >= left){

            int middle = (left + right - 1) / 2 ;

            if(left == right) middle = left;
            int funcVal = customfunction.f(x,middle);

            if(funcVal == z){
                result.add(0,x);
                result.add(1,middle);
                return result;
            }

            if(funcVal > z) return checkFunction(customfunction, left, middle-1,x, z);

            return checkFunction(customfunction, middle + 1, right,x,z);
        }

        return result;

    }

}

class CustomFunction{
    int f(int x, int y){
        return (int)(x*y );
    }
}