import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sequentional {

    protected static List<int[][]> solutions = new ArrayList<int[][]>();

    public static int N;
    public static int numb;

    public static void main(String[] args) {

        Scanner vhod = new Scanner(System.in);
        System.out.print("(Seq)Enter N:");

        System.out.println();
        try {
            N = vhod.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid.Number required!");
            return;
        }

        if (N <= 0) {
            System.out.println("N must be greater than 0 !");
            return;
        }

        long startTime = System.currentTimeMillis();

        printMatrices(N, null, 0);

        long endTime = System.currentTimeMillis();

        System.out.println("Time cost: " + (endTime - startTime) + "ms");
        System.out.println("Total Solutions:" + solutions.size());

        int niza[][] = solutions.get(0);

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        JButton[][] buttons = new JButton[N][N];

        GridLayout g = new GridLayout(N, N, 3, 3);
        panel.setLayout(g);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                buttons[i][j] = new JButton("");

                if (niza[i][j] == 1) {
                    buttons[i][j].setBackground(Color.red);
                } else {
                    if (i % 2 == 0) {
                        if (j % 2 == 0) {
                            buttons[i][j].setBackground(Color.black);
                        } else {
                            buttons[i][j].setBackground(Color.white);
                        }

                    } else {
                        buttons[i][j].setBackground(Color.white);
                        if (j % 2 == 1) {
                            buttons[i][j].setBackground(Color.black);
                        }

                    }
                }

                panel.add(buttons[i][j]);
            }
        }

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 600);
        frame.setVisible(true);


    }

    public static void printIt(int f[][]) {

        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f.length; j++) {


                System.out.print(f[i][j] + " ");

            }

            System.out.println();
        }
        System.out.println();

    }

    private static void printMatrices(int n, int[] sequence, int currentIndex) {
        if (currentIndex == 0) {
            sequence = new int[n];
            for (int i = 0; i < n; i++)
                sequence[i] = i;
        }

        /*the function is recursive function ,
         * and this if is checking if the end of recursion is reached or not
         * */

        if (currentIndex == sequence.length - 1) {
            int c[][] = new int[N][N];
            //System.out.println();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (sequence[i] == j) {
                        c[i][j] = 1;
                        //System.out.print(1+" ");
                    } else {
                        c[i][j] = 0;
                        //System.out.print(0+" ");
                    }
                }
                //System.out.println();
            }


            boolean bol = true;

            for (int k = 0; k < c.length; k++) {

                for (int j = 0; j < c.length; j++) {

                    if (c[k][j] == 1) {

                        if (!isSafe(c, k, j)) {

                            bol = false;
                        }

                    }

                }

            }

            if (bol) {

                numb++;
                System.out.println("Solution: " + numb);
                printIt(c);
                solutions.add(c);


            }


        }

        for (int i = currentIndex; i < sequence.length; i++) {
            int temp = sequence[currentIndex];
            sequence[currentIndex] = sequence[i];
            sequence[i] = temp;
            printMatrices(n, sequence, currentIndex + 1);
            temp = sequence[currentIndex];
            sequence[currentIndex] = sequence[i];
            sequence[i] = temp;
        }
    }

    private static boolean isSafe(int mat[][], int r, int c) {

        int i, j;


        for (i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (mat[i][j] == 1) {
                return false;
            }

        }

        for (i = r + 1, j = c + 1; i < mat.length && j < mat.length; i++, j++) {
            if (mat[i][j] == 1) {
                return false;
            }

        }

        for (i = r + 1, j = c - 1; i < mat.length && j >= 0; i++, j--) {
            if (mat[i][j] == 1) {
                return false;
            }

        }

        for (i = r - 1, j = c + 1; j < mat.length && i >= 0; i--, j++) {
            if (mat[i][j] == 1) {
                return false;
            }

        }

        return true;
    }
}


