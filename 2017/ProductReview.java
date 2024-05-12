import java.util.ArrayList;

public class ProductReview {
   private String name;
   private String review;

   public ProductReview(String pName, String pReview) {
      name = pName;
      review = pReview;
   }

   public String getName() {
      return name;
   }

   public String getReview() {
      return review;
   }

   public static void main(String[] args) {
      ReviewCollector c = new ReviewCollector();
      c.addReview(new ProductReview("A", "BEST"));
      c.addReview(new ProductReview("A", "aasdbest"));
      c.addReview(new ProductReview("A", "Best"));
      c.addReview(new ProductReview("A", "asdasdbest"));
      c.addReview(new ProductReview("B", "Best"));
      c.addReview(new ProductReview("B", "abestos"));

      System.out.println(c.getNumGoodReviews("A"));
      System.out.println(c.getNumGoodReviews("B"));
      System.out.println(c.getNumGoodReviews("C"));
   }
}

class ReviewCollector {
   private ArrayList<ProductReview> reviewList;
   private ArrayList<String> productList;

   public ReviewCollector() {
      reviewList = new ArrayList<ProductReview>();
      productList = new ArrayList<String>();
   }

   public void addReview(ProductReview prodReview) {
      reviewList.add(prodReview);
      if(!productList.contains(prodReview.getName())) {
         productList.add(prodReview.getName());
      }
   }

   public int getNumGoodReviews(String prodName) {
      int count = 0;
      for(ProductReview prodReview : reviewList) {
         if(prodReview.getName() == prodName && prodReview.getReview().indexOf("best") >= 0) {
            count++;
         }
      }
      return count;
   }
}