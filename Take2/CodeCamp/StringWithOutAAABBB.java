public class StringWithOutAAABBB {

    public String strWithout3a3b(int A, int B) {
        String ans = A > B ? "a" : "b";
        A -= ans == "a" ? 1 : 0;
        B -= ans == "b" ? 1 : 0;

        String prev = ans;
        StringBuilder answer = new StringBuilder(ans);
        boolean doubled = false;
        while(A > 0 || B > 0){
            if(prev.equals("a")){
                if(doubled || B > A){
                    answer.append("b");
                    prev = "b";
                    doubled = false;
                    B--;
                }else{
                    answer.append("a");
                    A--;
                    doubled = true;
                }
            }
            else if(prev.equals("b")){
                if(doubled || A > B){
                    answer.append("a");
                    prev = "a";
                    doubled = false;
                    A--;
                }else{
                    answer.append("b");
                    prev = "b";
                    B--;
                    doubled = true;
                }
            }
        }
        return answer.toString();
    }
}
