import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class RemoveAdjecentDuplicate {

    public static void main(String[] args) {
        String s = "adccde";
        String before = s.substring(0,0);
        String after = s.substring(3);
        System.out.println(before);

//        System.out.println(s2);
        System.out.println(removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy" ,4) );
    }
    public static String removeDuplicates(String s, int k) {

        for (int i = 0; i < s.length(); i++) {
            if(checkDuplicates(s,i,i+k)){
                String before = s.substring(0,i);
                String after = s.substring(i+k);
                return removeDuplicates(before + after,k);
            }
        }
        return s;
    }

    public static boolean checkDuplicates(String s, int start , int end){

        if(end > s.length()) return false;
        char test = s.charAt(start);
        for (int i = start; i < end ; i++) {
            if(s.charAt(i) != test) return false;
        }
        return true;
    }
}
