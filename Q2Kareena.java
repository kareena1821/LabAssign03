// Write a program to implement counting sort (with input in the range 0 to 20 and input
// can be repeated multiple times)
//19105112

import java.util.*;
class Q2Kareena {
    void count_sort(char arr[])
    {

        int length = arr.length;//length of array
        char solution[] = new char[length]; // array of length as same as array
        int array_count[] = new int[256];// array count array of 256 chars to store the count of each

        for (int i = 0; i < 256; ++i){
            array_count[i] = 0;//initialisation
        }

        for (int i = 0; i < length; ++i){
            array_count[arr[i]]++;//count the occureance of each
        }
        
        for (int i = 1; i <= 255; ++i){
            array_count[i] += array_count[i - 1];//add the previous 
        }
        for (int i = length - 1; i >= 0; i--) {
            solution[array_count[arr[i]] - 1] = arr[i];
            array_count[arr[i]]--;//find the solution
        }
        for (int i = 0; i < length; ++i){
            arr[i] = solution[i];
        }

    }
  

    public static void main(String args[])
    {
        Q2Kareena cs = new Q2Kareena();
        char arr[] = { 'k', 'a', 'r', 'e', 'e', 'n', 'a' }; //input
        //sort the array
        cs.count_sort(arr);
        //print the sorted array
        for (int i = 0; i < arr.length; i++){

            System.out.print(arr[i]);
        
        }
    }
}