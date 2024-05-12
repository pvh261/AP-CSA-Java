public class Candy {
   private int row;
   private int col;
   private String flavor;

   public static void main(String[] args) {
      //a)
      // Candy lime = new Candy(0, 1, "lime");
      // Candy orange = new Candy(1, 1, "orange");
      // Candy cherry = new Candy(2, 2, "cherry");
      // Candy lemon = new Candy(3, 1, "lemon");
      // Candy grape = new Candy(3, 2, "grape");
      // Candy[] list = {lime, orange, cherry, lemon, grape};
      // BoxOfCandy cbox = new BoxOfCandy(list, 4, 3);
      // cbox.present();
      // System.out.println(cbox.moveCandyToFirstRow(0));
      // System.out.println(cbox.moveCandyToFirstRow(1));
      // System.out.println(cbox.moveCandyToFirstRow(1));
      // System.out.println(cbox.moveCandyToFirstRow(2));
      // System.out.println(cbox.moveCandyToFirstRow(2));
      // cbox.present();

      //b)
      Candy[] list = {new Candy(0, 0, "lime"), new Candy(0, 1, "lime"), new Candy(0, 3, "lemon"), new Candy(1, 0, "orange"), new Candy(1, 3, "lime"), new Candy(1, 4, "lime"), new Candy(2, 0, "cherry"), new Candy(2, 2, "lemon"), new Candy(2, 4, "orange")};
      BoxOfCandy box = new BoxOfCandy(list, 3, 5);
      box.present();
      box.removeNextByFlavor("cherry");
      box.removeNextByFlavor("lime");
      box.present();
      box.removeNextByFlavor("lime");
      box.present();
   }

   public Candy(int row, int col, String flavor) {
      this.row = row;
      this.col = col;
      this.flavor = flavor;
   }

   public int getRow() {
      return row;
   }

   public int getCol() {
      return col;
   }

   public String getFlavor() {
      return flavor;
   }
}

class BoxOfCandy {
   private Candy[][] box;
   private int height;
   private int width;

   public BoxOfCandy(Candy[] box, int height, int width) {
      this.box = new Candy[height][width];
      for(Candy i : box) {
         this.box[i.getRow()][i.getCol()] = i;
      }
   }

   public boolean moveCandyToFirstRow(int col) {
      if(box[0][col] != null) {
         return true;
      } else {
         for(int i = 1; i < box.length; i++) {
            if(box[i][col] != null) {
               box[0][col] = box[i][col];
               box[i][col] = null;
               return true;
            }
         }
      }
      return false;
   }

   public Candy removeNextByFlavor(String flavor) {
      for(int i = box.length - 1; i >= 0; i--) {
         for(int j = 0; j < box[i].length; j++) {
            if(box[i][j] != null && box[i][j].getFlavor() == flavor) {
               Candy output = box[i][j];
               box[i][j] = null;
               return output;
            }
         }
      }
      return null;
   }

   public void present() {
      for(int i = 0; i < box.length; i++) {
         for(int j = 0; j < box[i].length; j++) {
            if(box[i][j] == null) {
               System.out.print("[]  ");
            } else {
               System.out.print("[" + box[i][j].getFlavor() + "]  ");
            }
         }
         System.out.println();
      }
      System.out.println();
   }
}