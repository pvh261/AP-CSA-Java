public class Sign {
    private String message;
    private int width;

    public Sign(String message, int width) {
        this.message = message;
        this.width = width;
    }

    public int numberOfLines() {
        int length = message.length();
        int numberOfLines = length / width;
        if(message.trim().isEmpty()) {
            return 0;
        } else {
            if(length % width != 0) {
                numberOfLines++;
            }
            return numberOfLines;
        }
    }

    public void getLines() {
        if(!message.trim().isEmpty()) {
            for(int i = 0; i < message.length(); i++) {
                System.out.print(message.substring(i, i+1));
                if((i+1) % width == 0 && i != message.length() - 1) {
                    System.out.print(";");
                }
            }
        }
    }

    public static void main(String[] args) {
        int x;
        Sign s1 = new Sign("ABC222DE", 3);
        s1.getLines();
        System.out.println();
        s1.getLines();
        System.out.println();
        Sign s2 = new Sign("ABCD", 10);
        System.out.println(s2.numberOfLines());
        s2.getLines();
        System.out.println();
        Sign s3 = new Sign("ABCDEF", 6);
        System.out.println(s3.numberOfLines());
        s3.getLines();
        System.out.println();
        Sign s4 = new Sign(" ", 4);
        System.out.println(s4.numberOfLines());
        s4.getLines();
        System.out.println();
        Sign s5 = new Sign("AB_CD_EF", 2);
        System.out.println(s5.numberOfLines());
        s5.getLines();
    }
}