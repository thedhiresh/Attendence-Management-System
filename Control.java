 import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

class Control {
   public String stname;
   public String rollno;

   public void makeAttendence(int var1, String var2) throws IOException {
      String var3;
      do {
         File var4 = new File("data.txt");
         File var5 = new File("date.txt");
         if (!var5.exists()) {
            var5.createNewFile();
         }

         if (!var4.exists()) {
            var4.createNewFile();
         }

         FileReader var6 = new FileReader(var4);
         FileWriter var7 = new FileWriter(var5, true);
         BufferedReader var8 = new BufferedReader(var6);
         BufferedWriter var9 = new BufferedWriter(var7);

         for(String var10 = var8.readLine(); var10 != null; var10 = var8.readLine()) {
            StringTokenizer var11 = new StringTokenizer(var10, " ");
            String var12 = var11.nextToken();
            int var13 = Integer.parseInt(var12);
            String var14 = var11.nextToken();
            String var15 = var13 + " " + var14 + " " + var1 + " \n";
            var9.write(var15);
         }

         var9.close();
         var8.close();
         var4.delete();
         var5.renameTo(var4);
         Scanner var16 = new Scanner(System.in);
         System.out.println("next or not");
         var3 = var16.next();
      } while(var3.equals("next"));

      System.out.println("File Updated:");
   }

   public void setstudendtinsertdata(String var1, String var2) {
      this.stname = var1;
      this.rollno = var2;
      System.out.println("Your given value " + var2 + " " + var1);
   }

   public void Insertdata() throws IOException {
      File var1 = new File("data.txt");
      FileWriter var2 = new FileWriter(var1, true);
      BufferedWriter var3 = new BufferedWriter(var2);
      if (!var1.exists()) {
         var1.createNewFile();
      }

      String var4 = this.rollno + "\t" + this.stname;
      System.out.println("");
      var3.write(var4);
      System.out.println("Data written into file sucessfully");
      var3.close();
   }

   public void showAttendenc() throws IOException {
      System.out.println("Showing the attendence of the student .................");
      File var1 = new File("data.txt");
      Desktop var2 = Desktop.getDesktop();
      if (var1.exists()) {
         var2.open(var1);
      } else {
         System.out.println("data file has been deleted");
      }

   }

   public void Deletedata(String var1, int var2) throws IOException {
      File var3 = new File("tempdata.txt");
      File var4 = new File("tempdata.txt");
      File var5 = new File(var1);
      if (!var4.exists()) {
         var4.createNewFile();
      }

      if (!var5.exists()) {
         var5.createNewFile();
      }

      int var6 = 0;
      FileWriter var8 = new FileWriter(var3, true);
      BufferedWriter var9 = new BufferedWriter(var8);
      PrintWriter var10 = new PrintWriter(var9);
      FileReader var11 = new FileReader(var1);
      BufferedReader var12 = new BufferedReader(var11);

      String var7;
      while((var7 = var12.readLine()) != null) {
         ++var6;
         if (var2 != var6) {
            var10.println(var7);
         }

         var10.flush();
         var10.close();
         var12.close();
         var9.close();
         var8.close();
         var4.delete();
         File var13 = new File("data.txt");
         var5.renameTo(var13);
      }

   }

   public void updateData(int var1, String var2) throws IOException {
      File var3 = new File("data.txt");
      File var4 = new File("temp.txt");
      if (!var3.exists()) {
         var3.createNewFile();
      }

      if (!var4.exists()) {
         var4.createNewFile();
      }

      FileReader var5 = new FileReader(var3);
      FileWriter var6 = new FileWriter(var4, true);
      BufferedReader var7 = new BufferedReader(var5);
      BufferedWriter var8 = new BufferedWriter(var6);
      String var9 = var7.readLine();

      while(var9 != null) {
         StringTokenizer var10 = new StringTokenizer(var9, " ");
         String var11 = var10.nextToken();
         int var12 = Integer.parseInt(var11);
         if (var12 == var1) {
            String var13 = var10.nextToken();
            String var14 = var12 + " " + var2 + " \n";
            var8.write(var14);
            var9 = var7.readLine();
         } else {
            var8.write(var9 + "\n");
            var9 = var7.readLine();
         }
      }

      var8.close();
      var7.close();
      var3.delete();
      var4.renameTo(var3);
      System.out.println("File Updated:");
   }
}
