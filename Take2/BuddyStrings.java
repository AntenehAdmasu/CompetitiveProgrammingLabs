import java.util.HashSet;

class BuddyStrings {

    public boolean buddyStrings(String A, String B) {
        HashSet<Character> set = new HashSet<>();
        if(A.length() != B.length()){
            return false;
        }
        boolean buddies = false;
        int dif1 = -1;
        int dif2 = -1;
        if(A.equals(B)){
            for(char c : A.toCharArray()){
                if(!set.contains(c)){
                    set.add(c);
                }
            }
            return set.size() < A.length();
        }

        for (int i = 0; i < A.length(); i++) {
            char a = A.charAt(i);
            char b = B.charAt(i);
            if(a == b){
                continue;
            }
            if(dif1 == -1){
                dif1 = i;
            }else{
                buddies = false;
                if(dif2 == -1){
                    dif2 = i;
                    if(A.charAt(dif1) == B.charAt(dif2) && A.charAt(dif2) == B.charAt(dif1)){
                        buddies = true;
                    }
                }else{
                    break;
                }
            }
        }

        return buddies;
    }
}