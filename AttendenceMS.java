 import java.io.IOException;
import java.util.Scanner;

public class AttendenceMS {
   public static void main(String[] var0) throws IOException {
      Scanner var1 = new Scanner(System.in);
      System.out.println(" Start of Attendence Management system ");
      Control var2 = new Control();

      String var5;
      do {
         System.out.println("Enter '1' to Insert the data in the attendece ");
         System.out.println("Enter '2' to Show the data in the attendece ");
         System.out.println("Enter '3' to Delete the data in the attendece ");
         System.out.println("Enter '4' to update the data in the attendece ");
         System.out.println("Enter '5' to Make attendece ");
         System.out.print("Enter your NO. to operate:");
         String var3 = var1.next();
         byte var7 = -1;
         switch(var3.hashCode()) {
         case 49:
            if (var3.equals("1")) {
               var7 = 0;
            }
            break;
         case 50:
            if (var3.equals("2")) {
               var7 = 1;
            }
            break;
         case 51:
            if (var3.equals("3")) {
               var7 = 2;
            }
            break;
         case 52:
            if (var3.equals("4")) {
               var7 = 3;
            }
            break;
         case 53:
            if (var3.equals("5")) {
               var7 = 4;
            }
         }

         String var4;
         String var8;
         int var11;
         String var12;
         label51:
         switch(var7) {
         case 0:
            System.out.println("Enter your Password:");
            var4 = var1.next();
            if (var4.equals("admin")) {
               while(true) {
                  System.out.println("Password is Matched");
                  System.out.print("Roll of Student : ");
                  var12 = var1.next();
                  System.out.println("");
                  System.out.print("Enter the name of Student : ");
                  String var10 = var1.next();
                  var2.setstudendtinsertdata(var10, var12);
                  var2.Insertdata();
                  System.out.println("do you want to repeat the inserting data or no : yes /no");
                  var8 = var1.next();
                  if (!var8.equals("yes")) {
                     break label51;
                  }
               }
            }

            System.out.println("Sorry , you cannot access it \n Password is not Mathech");
            break;
         case 1:
            var2.showAttendenc();
            break;
         case 2:
            System.out.println("Enter your Password:");
            var4 = var1.next();
            if (var4.equals("admin")) {
               System.out.println("Password is Matched");
               System.out.print("Enter the roll no. that yu want to delete : ");
               var11 = var1.nextInt();
               var2.Deletedata("data.txt", var11);
            } else {
               System.out.println("Sorry , you cannot access it \n Password is not Mathech");
            }
            break;
         case 3:
            System.out.println("Enter your Password:");
            var4 = var1.next();
            if (var4.equals("admin")) {
               System.out.println("Password is Matched");
               System.out.print("Enter the Roll no. of Student : ");
               var11 = var1.nextInt();
               System.out.print("Enter the name  of the Student : ");
               var12 = var1.next();
               var2.updateData(var11, var12);
            } else {
               System.out.println("Sorry , you cannot access it \n Password is not Mathech");
            }
            break;
         case 4:
            System.out.println("Enter your Password:");
            var4 = var1.next();
            if (var4.equals("admin")) {
               System.out.println("Password is Matched");
               System.out.print("Please enter today date");
               var8 = var1.next();
               System.out.print("\n Enter '1' to make attendence");
               int var9 = var1.nextInt();
               var2.makeAttendence(var9, var8);
            } else {
               System.out.println("Sorry , you cannot access it \n Password is not Mathech");
            }
            break;
         default:
            System.out.println("Invalid Please  try again");
         }

         System.out.println("Do u  want to prform more operation then enter yes/no");
         var5 = var1.next();
      } while(var5.equals("yes"));

   }
}
    
