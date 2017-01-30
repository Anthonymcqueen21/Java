import java.util.Scanner;

class StringMethods {
     public static void main(String[] args) {
        int n;
        String s = "Java Programmer", t = "", u = "";
        
        System.out.println(s);
        
        // Finding the length of strings
        
        n = s.length();
        System.out.println("Number of characters = " + n);
        
        // Replace characters in string
        
        t = s.replace("Java", "C++");
        System.out.println(s);
        System.out.println(t);
        
        // Concatenating string with another string
        
        u = s.concat("Java is Amazing");
        System.out.println(s);
        System.out.println(u);
    }
}
