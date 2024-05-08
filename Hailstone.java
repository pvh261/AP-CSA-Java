public class Hailstone {
    public static void main(String[] args) {
        System.out.println(hailstoneLength(8));
        System.out.println(isLongSeq(8));
        System.out.println(propLong(10));
    }

    public static int hailstoneLength(int n) {
        boolean next = true;
        int count = 1;
        while(next) {
            if(n == 1) {
                next = false;
            } else if(n % 2 == 0) {
                n /= 2;
                count++;
            } else {
                n = 3*n + 1;
                count++;
            }
        }
        return count;
    }

    public static boolean isLongSeq(int n) {
        int count = hailstoneLength(n);
        if(count > n) {
            return true;
        } else {
            return false;
        }
    }

    public static double propLong(int n) {
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(isLongSeq(i)) {
                count++;
            }
        }
        return count / Double.valueOf(n);
    }
}