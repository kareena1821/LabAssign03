//19105112
import java.util.Scanner;
import java.util.ArrayList;

public class Q5Kareena {
    static ArrayList<ArrayList<String>> arrs = new ArrayList<ArrayList<String>>();

    static void printAllChanges(String word1, String word2, ArrayList<String> changes,int[][] cost) {

        int i = word1.length();
        int j = word2.length();

        while (true) {

            if (i == 0 || j == 0) {
                arrs.add(changes);
                break;
            }

            if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                i--;
                j--;
            }

            else {
                boolean if1 = false, if2 = false;

                if (cost[i][j] == cost[i - 1][j - 1] + 1) {

                    changes.add("Change " + word1.charAt(i - 1) + " to " + word2.charAt(j - 1));
                    i--;
                    j--;

                    if1 = true;
                }

                if (cost[i][j] == cost[i - 1][j] + 1) {
                    if (if1 == false) {
                        changes.add("Delete " + word1.charAt(i - 1));
                        i--;
                    } else {
                        
                        ArrayList<String> changeword2 = new ArrayList<String>();
                        changeword2.addAll(changes);

                        changeword2.remove(changes.size() - 1);

                        changeword2.add("Delete " + word1.charAt(i));

                        printAllChanges(word1.substring(0, i),
                                word2.substring(0, j + 1), changeword2,cost);
                    }

                    if2 = true;
                }

                if (cost[i][j] == cost[i][j - 1] + 1) {
                    if (if1 == false && if2 == false) {
                        changes.add("Add " + word2.charAt(j - 1));
                        j--;
                    } else {

                        ArrayList<String> changeword2 = new ArrayList<String>();
                        changeword2.addAll(changes);
                        changeword2.remove(changes.size() - 1);
                        changeword2.add("Add " + word2.charAt(j));

                        printAllChanges(word1.substring(0, i + 1), word2.substring(0, j), changeword2,cost);
                    }
                }
            }
        }
    }

    static void printWays(String word1, String word2, ArrayList<String> changes,int[][] cost) {

        printAllChanges(word1, word2, new ArrayList<String>(),cost);

        int i = 1;

        for (ArrayList<String> ar : arrs) {
            System.out.println("\nMethod " + i++ + " : \n");
            for (String s : ar) {
                System.out.println(s);
            }
        }
    }

    static int[][] costArray(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] cost = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            cost[i][0] = i;
        for (int i = 1; i <= n; i++)
            cost[0][i] = i;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
               
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    cost[i][j] = cost[i - 1][j - 1];
                else {
                    int a = cost[i - 1][j - 1]; 
                    int b = cost[i][j - 1];// Insert operation
                    int c = cost[i - 1][j]; // Replace operation
                    // minimum of three operations possible
                    cost[i][j] = a < b ? (a < c ? a : c) : (b < c ? b : c);
                    cost[i][j]++;
                }
            }
        }
        return cost;

    }

    public static void main(String[] args) throws Exception {
       
        Scanner s = new Scanner(System.in);
        System.out.print("Input string 1 ");
        String word1 = s.nextLine();
        System.out.print("Input string 2 ");
        String word2 = s.nextLine();

        int[][] cost = costArray(word1, word2);

        // print the steps
        printWays(word1, word2, new ArrayList<String>(),cost);

    }
}
