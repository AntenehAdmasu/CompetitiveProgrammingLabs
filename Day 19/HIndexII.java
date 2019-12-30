// Question : https://leetcode.com/problems/h-index-ii/

public class HIndexII {

    public static void main(String[] args) {
        int[] citations = new int[] {1,1,2,3,4,5,7};
        System.out.println("hindex is " + hIndex(citations));
    }

    public static int hIndex(int[] citations) {
        int hindex = getHIndex(citations,0,citations.length-1,0);
        return hindex;
    }


    public static int getHIndex(int[] citations,int left,int right,int hindex){
        int length = citations.length;
        int h = hindex;

        if(right >= left){
            int middle = (left + right - 1) / 2 ;
            if(left == right) middle = left;
            
            if(right >= left){
                if(left == right) middle = left;
                if(citations[middle] <= length - middle){
                    h = (citations[middle] < length - middle) ? length - (middle + 1) : length - middle;
                    return getHIndex(citations,middle + 1,right,h);
                }else{
                    return getHIndex(citations,left,middle-1,h);
                }
            }
        }
        return h;
    }
}
