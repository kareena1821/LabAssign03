//19105121
 //Write a java program to compare two strings lexicographically (without using library function).
//if strings are same then give 0 if first is greater then 1 otherwise -1
public class Ques119105112 {


    public static int answer(String firstString, String secondString){

        for(int i = 0; i < secondString.length() && i < firstString.length(); i++){ //iterate in the strings

            if((int)firstString.charAt(i) == (int)secondString.charAt(i)){
                continue;//if the character is same then nothing to be calculated
            }
            else{
                if((int)firstString.charAt(i) > (int)secondString.charAt(i)) 
                    return 1;//return 1 if greater. we got pur answer
                else 
                    return -1;//strign 1 is smaller
            }
        }
        int solution=0;
        if(firstString.length() == secondString.length()){

            solution = 0;//if the length is same

        }if(firstString.length() > secondString.length()){

            solution = 1;//if the 1st string has greater length

        }if(firstString.length() < secondString.length()){

            solution = -1;//if the 2nd string is greater length

        }
        return solution;
    }

    public static void main(String[] args){
       
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first string"); //take input for first dtring
        String firstString = sc.nextLine();

        System.out.println("Enter the second string"); //take input for second string
        String secondString = sc.nextLine();
        
        System.out.println("the answer is: ");
        System.out.println(answer(firstString, secondString)); 

}
}
