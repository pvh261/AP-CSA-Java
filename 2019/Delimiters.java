import java.util.ArrayList;

public class Delimiters {
    private String openDel;
    private String closeDel;

    public static void main(String[] args) {
        Delimiters math = new Delimiters("(", ")");
        String[] tokens1 = {"(", "x + y", ")", " * 5"};
        for(String s : math.getDelimitersList(tokens1)) {
            System.out.println(s);
        }
        Delimiters html = new Delimiters("<q>", "</q>");
        String[] tokens2 = {"<q>", "yy", "</q>", "zz", "</q>"};
        for(String s : html.getDelimitersList(tokens2)) {
            System.out.println(s);
        }
        Delimiters html2 = new Delimiters("<sup>", "</sup>");
        String[] ex1 = {"<sup>", "<sup>", "</sup>", "<sup>", "</sup>", "</sup>"};
        String[] ex2 = {"<sup>", "</sup>", "</sup>", "<sup>"};
        String[] ex3 = {"</sup>"};
        String[] ex4 = {"<sup>", "<sup>", "</sup>"};
        System.out.println(html2.isBalanced(html2.getDelimitersList(ex1)));
        System.out.println(html2.isBalanced(html2.getDelimitersList(ex2)));
        System.out.println(html2.isBalanced(html2.getDelimitersList(ex3)));
        System.out.println(html2.isBalanced(html2.getDelimitersList(ex4)));
    }

    public Delimiters(String open, String close) {
        openDel = open;
        closeDel = close;
    }

    public ArrayList<String> getDelimitersList(String[] token) {
        ArrayList<String> output = new ArrayList<String>();
        for(String s : token) {
            if(s.equals(openDel) || s.equals(closeDel)) {
                output.add(s);
            }
        }
        return output;
    }

    public boolean isBalanced(ArrayList<String> delimiters) {
        int countOpen = 0;
        int countClose = 0;
        for(String s : delimiters) {
            if(s.equals(openDel)) {
                countOpen++;
            } else {
                countClose++;
            }
            if(countClose > countOpen) {
                return false;
            }
        }
        if(countOpen != countClose) {
            return false;
        } else {
            return true;
        }
    }
}