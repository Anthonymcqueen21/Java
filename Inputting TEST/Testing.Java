import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class InputTest {
    public static void main(String[] args) {
       try{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           // Reading system output ignoring case
          while(true) {
              System.out.print("Enter SomeText('x' to exit):");
              String str = br.readLine();
              System.out.println("You just entered:" + str);
              if("x".equalsIgnoreCase(str)) {
                  System.out.println("Bye");
                  break;
              }
          }
       }catch(IOException e) {
          e.printStackTree();
       }
    }
}
