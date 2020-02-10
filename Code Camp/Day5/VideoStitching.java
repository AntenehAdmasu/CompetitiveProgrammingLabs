// Question link : https://leetcode.com/problems/video-stitching/

import java.util.Arrays;
import java.util.Comparator;

public class VideoStitching {

    public static void main(String[] args) {
        int[][] test = new int[][]{

                new int[]{3, 5},
                new int[]{2, 8},
                new int[]{0, 4}

        };

        int min = new VideoStitching().getMinVideos(test, 10);
        System.out.println("========>>>>> " + min);

    }
   public int videoStitching(int[][] videos, int target) {

        Arrays.sort(videos, new TwoDArrayComparator());
        int minVideos = Integer.MAX_VALUE;
        int[] memo = new int[videos.length];


        for (int i = videos.length - 1; i >= 0; i--) {
            int[] video = videos[i];
            if (video[0] <= target && video[1] >= target) {
                int min = getMin(videos,i,memo);
                minVideos = Math.min(minVideos,min);
            }
            if (video[1] < target) break;
        }

        return minVideos == Integer.MAX_VALUE ? -1 : minVideos;
    }

    public int getMin(int[][] videos, int index, int[] memo) {
        if (videos[index][0] == 0) {
            memo[index] = 1;
            return 1;
        }
        if (memo[index] != 0) return memo[index];
        int min = Integer.MAX_VALUE;

        for (int i = index-1; i >= 0; i--) {
            int[] vid = videos[i];
            if (vid[0] <= videos[index][0] && vid[1] >= videos[index][0]) {
                int minimumLen = getMin(videos, i, memo);
                min = Math.min(min, minimumLen);
            }
            if(vid[1] < videos[index][0]) break;
        }
        if (min != Integer.MAX_VALUE) {
            memo[index] = min + 1;
            return min + 1;
        }
        return min;
    }
}
}

class TwoDArrayComparator implements Comparator<int[]> {

    @Override
    public int compare(int[] o1, int[] o2) {
        if (o1[1] < o2[1]) return -1;
        if (o1[1] > o2[1]) return 1;
        return 0;
    }
}
