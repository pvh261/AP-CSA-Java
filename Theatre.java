public class Theatre {
   private Seat[][] theatreSeats;

   public Theatre(int seatsPerRow, int tier1Rows, int tier2Rows) {
      theatreSeats = new Seat[tier1Rows + tier2Rows][seatsPerRow];
      for(int i = 0; i < tier1Rows + tier2Rows; i++) {
         int tier;
         if(i < tier1Rows) {
            tier = 1;
         } else {
            tier = 2;
         }
         for(int j = 0; j < seatsPerRow; j++) {
            theatreSeats[i][j] = new Seat(true, tier);
         }
      }
   }

   public boolean reassignSeat(int fromRow, int fromCol, int toRow, int toCol) {
      Seat toSeat = theatreSeats[toRow][toCol];
      Seat fromSeat = theatreSeats[fromRow][fromCol];
      if(toSeat.isAvailable() && fromSeat.getTier() <= toSeat.getTier()) {
         toSeat.setAvailability(false);
         fromSeat.setAvailability(true);
         return true;
      }
      return false;
   }

   public void showSeats() {
      for(int i = 0; i < theatreSeats.length; i++) {
         for(Seat j : theatreSeats[i]) {
            System.out.print("[" + j.getTier() + "] ");
         }
         System.out.println();
      }
   }

   public static void main(String[] args) {
      Theatre t = new Theatre(5, 3, 6);
      t.showSeats();
   }
}

class Seat {
   private boolean available;
   private int tier;
   
   public Seat(boolean isAvail, int tierNum) {
      available = isAvail;
      tier = tierNum;
   }

   public boolean isAvailable() {
      return available;
   }

   public int getTier() {
      return tier;
   }

   public void setAvailability(boolean isAvail) {
      available = isAvail;
   }
}
