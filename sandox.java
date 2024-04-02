import java.util.*;
public class sandox{
   public static void main(String[] args){
      Person ID01 = new Person("alex", "Test");
      Person ID02 = new Person("ethan", "What");
      Person[] usernames = new Person[100];
      usernames[0] = ID01;
      usernames[1] = ID02;
      Scanner Input = new Scanner(System.in);
      String Answer = "";
      while (Answer != "Place Holder3285429jd923"){
         System.out.print("New User?: ");
         Answer = Input.nextLine();
         Answer = Answer.toLowerCase();
         if (Answer.equals("yes")){
            System.out.println("Welcome!");
            break;
         }else if (Answer.equals("no")){
            System.out.println("Womp Womp");
            break;
         }
      }
      if (Answer.equals("no")){
         boolean hasSignedIn = false;
         while (hasSignedIn == false){
            System.out.print("What is your Username: ");
            String username = Input.nextLine();
            username = username.toLowerCase();
            System.out.println(nameisIn(usernames, username));
            System.out.print("What is your Password: ");
            String Password = Input.nextLine();
            boolean signin = passisIn(usernames, username, Password);
            if (signin == true){
               System.out.println("Signing in...");
               hasSignedIn = true;
               SignedIn();
            } else {
               System.out.println("\n\n\nThere was an error while Signing in...");
               System.out.println("\nPlease Try again \n");
            }
         }
      }else {
         System.out.println("\n\n\n Account Creation!");
         System.out.print("Please create a username: ");
         String newusername = Input.nextLine();
         newusername = newusername.toLowerCase();
         while (isUsername(usernames, newusername)){
            System.out.println("This person already exists...\n");
            System.out.print("Please create a username: ");
            newusername = Input.nextLine();
            newusername = newusername.toLowerCase();
            
         }
         System.out.print("What is your Password: ");
         String newPassword = Input.nextLine();
         Person ID03 = new Person(newusername, newPassword);
         usernames[3] = ID03;
         listUsers(usernames);
         System.out.println("Username made!");
         SignedIn();
         
      }
   }
   public static boolean isUsername(Person[] usernames, String username){
      boolean found = false;
      int UC = 0;
      while ((UC<usernames.length) || (!found && UC<usernames.length)){
         if (usernames[UC] != null){
            if (usernames[UC].getName().equals(username)){
               found = true;
               break;
            }
         }
         UC++;
      }
      return found;
   }
   public static void SignedIn(){
      Scanner Input = new Scanner(System.in);
      System.out.println("You have Signed in!");
      Input.nextLine();
   }
   public static void listUsers(Person[] usernames){
      for (Person num : usernames){
         if (num != null){
            System.out.println(num.getName());
         }
      }
   }
   public static boolean nameisIn(Person[] usernames, String username){
      boolean found = false;
      int UC = 0;
      while ((UC<usernames.length) || (!found && UC<usernames.length)){
         if (usernames[UC] != null){
            if (usernames[UC].getName().equals(username)){
               found = true;
               break;
            }
         }
         UC++;
      }
      return found;
   }
   public static boolean passisIn(Person[] usernames,String username, String password){
      boolean found = false;
      int UC = 0;
      while ((UC<usernames.length) || (!found && UC<usernames.length)){
         if (usernames[UC] != null){
            if (usernames[UC].getName().equals(username)){
               if (usernames[UC].getPassword().equals(password)){
                  found = true;
                  break;
               }
            }
         }
         UC++;
      }
      return found;
   }

}

class Person
{
   protected String name;
   protected String password;
   public Person(String n, String p)
   {
      name = n;
      password = p;
   }
   
   public String getName()
   {  return name;   }
   public String getPassword()
   {  return password;  }
   public String toString()
   {
      return "Name: " + name + "\nPassword: " + password;
   }
  
   
}