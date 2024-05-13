interface StringChecker {
    boolean isValid(String str);
}

public class CodeWordChecker implements StringChecker {
    int minLength;
    int maxLength;
    String not;

    public static void main(String[] args) {
        StringChecker sc1 = new CodeWordChecker(5, 8, "$");
        System.out.println(sc1.isValid("happy"));
        System.out.println(sc1.isValid("happy$"));
        System.out.println(sc1.isValid("Code"));
        System.out.println(sc1.isValid("happyCode"));

        StringChecker sc2 = new CodeWordChecker("pass");
        System.out.println(sc2.isValid("MyPass"));
        System.out.println(sc2.isValid("Mypassport"));
        System.out.println(sc2.isValid("happy"));
        System.out.println(sc2.isValid("1,000,000,000,000,000"));
    }
    
    public CodeWordChecker(int min, int max, String n) {
        minLength = min;
        maxLength = max;
        not = n;
    }

    public CodeWordChecker(String n) {
        minLength = 6;
        maxLength = 20;
        not = n;
    }

    public boolean isValid(String code) {
        return code.length() >= minLength && code.length() <= maxLength && code.indexOf(not) == -1;
    }
}