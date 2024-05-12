import java.util.ArrayList;

public class ReviewAnalysis {
    private Review[] allReviews;

    public static void main(String[] args) {
        Review[] reviewList = {new Review(4, "Good! Thx"), new Review(3, "OK site"), new Review(5, "Great!"), new Review(2, "Poor! Bad."), new Review(3, "")};
        ReviewAnalysis analysis = new ReviewAnalysis(reviewList);
        System.out.println(analysis.getAverageRating());
        ArrayList<String> collection = analysis.collectComments();
        for(String i : collection) {
            System.out.println(i);
        }
    }

    public ReviewAnalysis(Review[] allR) {
        allReviews = allR;
    }

    public double getAverageRating() {
        double sum = 0;
        for(Review r : allReviews) {
            sum += r.getRating();
        }
        return (double)sum / allReviews.length;
    }

    public ArrayList<String> collectComments() {
        ArrayList<String> collection = new ArrayList<String>();
        for(int i = 0; i < allReviews.length; i++) {
            String comment = allReviews[i].getComment();
            if(comment.indexOf("!") != -1) {
                comment = i + "-" + comment;
                if(!comment.substring(comment.length() - 1).equals("!") && !comment.substring(comment.length() - 1).equals(".")) {
                    comment += ".";
                }
                collection.add(comment);
            }
        }
        return collection;
    }
}

class Review {
    private int rating;
    private String comment;

    public Review(int r, String c) {
        rating = r;
        comment = c;
    }

    public int getRating() {
        return rating;
    }
    
    public String getComment() {
        return comment;
    }
}