package Release1;

public class User {
   
   /**
    * the user's username
    */
   private final String username;
   
   /**
    * the user's password
    */
   private String password;
   
   /**
    * the user's portfolio containing all of his or her's holdings 
    */
   private Portfolio portfolio;

   public User(String name, String password) {
      
      this.username = name;
      this.password = password;
      this.portfolio = new Portfolio(this);
   }
   
   protected String getPassword() { return this.password; }
   
   protected void setPassword(String newPassword) { this.password = newPassword; }
   
   protected String getUsername() { return this.username; }
}
