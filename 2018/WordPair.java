import java.util.ArrayList;

public class WordPair {
    private String first;
    private String second;

    public static void main(String[] args) {
        String[] list = {"the", "more", "the", "merrier"};
        WordPairList wl = new WordPairList(list);
        wl.showList();
        System.out.println(wl.numMatches());
        String[] list2 = {"the", "red", "fox", "the", "red"};
        WordPairList wl2 = new WordPairList(list2);
        wl2.showList();
        System.out.println(wl2.numMatches());
    }

    public WordPair(String f, String s) {
        first = f;
        second = s;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }
}

class WordPairList {
    private ArrayList<WordPair> allPairs;

    public WordPairList(String[] words) {
        allPairs = new ArrayList<WordPair>();
        for(int i = 0; i < words.length; i++) {
            for(int j = i + 1; j < words.length; j++) {
                allPairs.add(new WordPair(words[i], words[j]));
            }
        }
    }

    public int numMatches() {
        int count = 0;
        for(WordPair w : allPairs) {
            if(w.getFirst().equals(w.getSecond())) {
                count++;
            }
        }
        return count;
    }

    public void showList() {
        for(WordPair w : allPairs) {
            System.out.print("{" + w.getFirst() + ", "+ w.getSecond() + "}, ");
        }
    }
}