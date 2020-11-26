public class CircleAndRectangleOverlapping {

    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        // Check if bounded
        if (x_center >= x1 && x_center <= x1 && y_center >= y1 && y_center <= y2) {
            return true;
        }

        // Check for corners
        int[] tl = new int[]{x1, y2};
        int[] tr = new int[]{x2, y2};
        int[] bl = new int[]{x1, y1};
        int[] br = new int[]{x2, y1};

        double distanceTL = Math.sqrt(Math.pow(x_center - tl[0], 2) + Math.pow(y_center - tl[1], 2));
        if (radius >= distanceTL) {
            return true;
        }

        double distanceTR = Math.sqrt(Math.pow(x_center - tr[0], 2) + Math.pow(y_center - tr[1], 2));
        if (radius >= distanceTR) {
            return true;
        }

        double distanceBL = Math.sqrt(Math.pow(x_center - bl[0], 2) + Math.pow(y_center - bl[1], 2));
        if (radius >= distanceBL) {
            return true;
        }

        double distanceBR = Math.sqrt(Math.pow(x_center - br[0], 2) + Math.pow(y_center - br[1], 2));
        if (radius >= distanceBR) {
            return true;
        }

        // Check top
        if (x1 <= x_center && x_center <= x2) {
            if (y_center - radius <= y2 && y_center + radius >= y1) {
                return true;
            }
        }

        // Check bottom
        if (x1 <= x_center && x_center <= x2) {
            if (y_center + radius <= y1 && y_center - radius >= y2) {
                return true;
            }
        }

        // Check left
        if (y1 <= y_center && y_center <= y2) {
            if (x_center + radius >= x1 && x_center - radius <= x2) {
                return true;
            }
        }

        // Check right
        if (y1 <= y_center && y_center <= y2) {
            if (x_center - radius <= x2 && x_center + radius >= x1) {
                return true;
            }
        }
        return false;
    }

}
