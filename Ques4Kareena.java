//19105121
// Write a ConsoleProgram that reads in a number from the user and then displays the
// Hailstone sequence for that number (Pick some positive integer and call it n. If n is even,
// divide it by two. If n is odd, multiply it by three and add one. Continue this process until n
// is equal to one). 

import java.util.*;
public class Ques4Kareena {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Input number: ");

        int n = sc.nextInt();//input from user
        
        while(n != 1){ // when n = 1 stop

            System.out.println(n);

            if(n % 2 ==0)  n = n / 2; // if even divide by two

            else{

                n = n * 3;//else multiply by 3 and then add 1
                n = n + 1;

            }
        }
    }

}
