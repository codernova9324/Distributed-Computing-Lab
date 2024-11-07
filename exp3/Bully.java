import java.io.*;
import java.util.Scanner;

class Bully {
    static int n;
    static int p[] = new int[100];
    static int s[] = new int[100];
    static int c;

    public static void main(String args[]) throws IOException {
        System.out.println("Enter no of process");
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int i, j, k, l, m;
        for (i = 0; i < n; i++) {
            System.out.println("For process" + (i + 1) + ":");
            System.out.println("Status:");
            s[i] = in.nextInt();
            System.out.println("Priority");
            p[i] = in.nextInt();
        }
        System.out.println("Which process will intiate the election?");
        int ele = in.nextInt();
        election(ele);
        System.out.println("final co-ordinator is:" + c);
    }

    static void election(int ele) {
        ele = ele - 1;
        c = ele + 1;
        for (int i = 0; i < n; i++) {
            if (p[ele] < p[i]) {
                System.out.println("Election message is sent from" + (ele + 1) + "to" + (i + 1));
                if (s[i] == 1) {
                    election(i + 1);
                }
            }
        }
    }
}