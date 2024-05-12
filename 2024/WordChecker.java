import java.util.ArrayList;

public class WordChecker {
    private ArrayList<String> wordList;

    public static void main(String[] args) {
        ArrayList<String> wordList = new ArrayList<String>();
        wordList.add("an");
        wordList.add("band");
        wordList.add("band");
        wordList.add("abandon");
        WordChecker wc = new WordChecker(wordList);
        System.out.println(wc.isWordChain());

        ArrayList<String> wordList2 = new ArrayList<String>();
        wordList2.add("to");
        wordList2.add("too");
        wordList2.add("stool");
        wordList2.add("tools");
        WordChecker wc2 = new WordChecker(wordList2);
        System.out.println(wc2.isWordChain());

        ArrayList<String> wordList3 = new ArrayList<String>();
        wordList3.add("catch");
        wordList3.add("bobcat");
        wordList3.add("catchacat");
        wordList3.add("cat");
        wordList3.add("at");
        WordChecker wc3 = new WordChecker(wordList3);
        ArrayList<String> output = wc3.createList("cat");
        for(String i : output) {
            System.out.println(i);
        }
    }

    public WordChecker(ArrayList<String> list) {
        wordList = list;
    }

    public boolean isWordChain() {
        for(int i = 1; i < wordList.size(); i++) {
            if(wordList.get(i).indexOf(wordList.get(i-1)) == -1) {
                return false;
            }
        }
        return true;
    }

    public ArrayList<String> createList(String target) {
        ArrayList<String> output = new ArrayList<String>();
        for(String i : wordList) {
            if(i.indexOf(target) == 0) {
                String temp = i.substring(target.length());
                output.add(temp);
            }
        }
        return output;
    }
}