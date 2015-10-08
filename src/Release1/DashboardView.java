package Release1;

public class DashboardView extends View {
   
   /**
    * Creates the application's dashboard view 
    * @param portfolio the user's portfolio
    */
   public DashboardView(Portfolio portfolio) {
      
      super();
      this.screen.setTitle("FPTS - " + portfolio.getUsername() + " - Home");
   }

}
