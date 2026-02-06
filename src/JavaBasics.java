import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

/*
        Name: Minseo KIM
        Group: ITfu-24/1
        Student number: 20253361
*/

/**
*        JavaBasics class demonstrates operations with 2D arrays:
*        random generation, averages, sorting, and frequency analysis.
*/
public class JavaBasics {
    public static void main(String args[]) {
        int n, m, a = 0, b;
        String name, surname;

        // Number 3: To make 2d array
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        System.out.print("Enter your surname: ");
        surname = sc.nextLine();

        n = name.length();
        m = surname.length();

        int[][] myArray = new int[n][m];

        // Number 4: Count vowels in name
        for (int i = 0; i < n; i++) {
            char c = Character.toLowerCase(name.charAt(i));
            if (c == 'a' || c == 'e' || c == 'i' || c == 'u' || c == 'o') {
                a++;
            }
        }

        // b is the sum of name and surname lengths
        b = n + m;
        Random random = new Random();

        // Fill array with random numbers and print as table
        System.out.println("\n2D Array:");
        System.out.print("\t");
        for (int j = 0; j < m; j++) {
            System.out.print("C" + j + "\t");
        }
        System.out.println();

        for (int i = 0; i < n; i++) {
            System.out.print("R" + i + "\t");
            for (int j = 0; j < m; j++) {
                myArray[i][j] = random.nextInt(b - a + 1) + a;
                System.out.print(myArray[i][j] + "\t");
            }
            System.out.println();
        }

        // Number 5: Row and column averages
        double[] row_average = new double[n];
        double[] col_average = new double[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                row_average[i] += myArray[i][j];
            }
            row_average[i] /= m;
        }

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                col_average[j] += myArray[i][j];
            }
            col_average[j] /= n;
        }

        System.out.println("\nRow averages:");
        for (double v : row_average) {
            System.out.printf("%.4f ", v);
        }

        System.out.println("\nColumn averages:");
        for (double v : col_average) {
            System.out.printf("%.4f ", v);
        }

        // Number 6: Count values greater than row average
        System.out.println("\n\nNumber 5:");
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (myArray[i][j] > row_average[i]) {
                    count++;
                }
            }
            System.out.println("Row " + i + ": " + count);
        }

        // Number 7: Find max excluding row a and column a
        System.out.println("\nNumber 7:");
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == a || j == a) {
                    continue;
                }
                if (myArray[i][j] > max) {
                    max = myArray[i][j];
                }
            }
        }
        System.out.println("Max: " + max);

        // Number 8: Sort a-th row without changing original array
        System.out.println("\nNumber 8:");
        int[] rowCopy = myArray[a].clone();
        Arrays.sort(rowCopy);
        for (int value : rowCopy) {
            System.out.print(value + " ");
        }
        System.out.println();

        // Number 9: Find column with minimum average and its minimum value
        System.out.println("\nNumber 9:");
        int idx = 0;
        for (int i = 1; i < m; i++) {
            if (col_average[i] < col_average[idx]) {
                idx = i;
            }
        }

        int min = myArray[0][idx];
        int minRowIndex = 0;
        for (int i = 1; i < n; i++) {
            if (myArray[i][idx] < min) {
                min = myArray[i][idx];
                minRowIndex = i;
            }
        }

        System.out.println("Column index with minimum average: " + idx);
        System.out.println("Min value in that column: (" + minRowIndex + ", " + idx + ") = " + min);
    }
}
