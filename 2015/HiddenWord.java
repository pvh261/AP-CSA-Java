public class HiddenWord {
    String hiddenWord;

    public HiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord;
    }

    public String getHint(String guess) {
        String hint = "";
        for(int i = 0; i < guess.length(); i++) {
            if(hiddenWord.indexOf(guess.substring(i, i+1)) == -1) {
                hint += "*";
            } else {
                if(hiddenWord.indexOf(guess.substring(i, i+1)) == i) {
                    hint += guess.substring(i, i+1);
                } else {
                    hint += "+";
                }
            }
        }
        return hint;
    }

    public static void main(String[] args) {
        HiddenWord puzzle = new HiddenWord("HARPS");
        System.out.println(puzzle.getHint("AAAAA"));
        System.out.println(puzzle.getHint("HELLO"));
        System.out.println(puzzle.getHint("HEART"));
        System.out.println(puzzle.getHint("HARMS"));
        System.out.println(puzzle.getHint("HARPS"));
    }
}