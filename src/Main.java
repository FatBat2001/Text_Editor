import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        FileManager fm = new FileManager();
        Scanner sc = new Scanner(System.in);


        System.out.println("***********************************************************");
        System.out.println("\t\t\t\t**** text editor ****\n");
        String option;
        System.out.println("Press an option key from the following menu\n\n");


        while (true) {
            System.out.println("R- Read from file");
            System.out.println("W- Write to file");
            System.out.println("I- insert to a specific line");
            System.out.println("D- delete a specific line");
            System.out.println("L- show length of a specific line");
            System.out.println("S- show all lines");
            System.out.println("C- replace specific line with a new line");
            System.out.println("Q- quit\n");


            option = sc.nextLine();

            if (option.equals("R")) {

                list = fm.readFile("File.txt");
                System.out.println("------------Reading from file------------");

            } else if (option.equals("W")) {

                fm.writeToFile(list, "File.txt");
                System.out.println("------------Writing in file------------");

            } else if (option.equals("I")) {

                int index;
                String line;
                System.out.println("Enter the line number you want to insert: ");
                index = Integer.parseInt(sc.nextLine()); // parsing the input to avoid errors

                System.out.println("Enter the line you want to insert: ");
                line = sc.nextLine();

                boolean flag = list.addAt(index, line);
                if (flag) {
                    System.out.println("------------Line inserted successfully------------");
                } else {
                    System.out.println("------------Line not inserted (out of bound)------------");
                }

            }else if (option.equals("D")) {

                System.out.println("Enter the line number you want to delete: ");
                int index = Integer.parseInt(sc.nextLine());
                String str = list.removeAt(index);
                if (str != null) {
                    System.out.println("------------Line deleted successfully------------");
                } else {
                    System.out.println("------------Line not deleted (out of bound)------------");
                }


            } else if (option.equals("L")) {

                System.out.println("Enter the line number you want to show the length of: ");
                String line = list.show_line_length(Integer.parseInt(sc.nextLine()));
                if (line == null) {
                    System.out.println("The file is empty or the line doesn't exist");
                } else {
                    System.out.println(line.length());
                }

            } else if (option.equals("S")) {

                System.out.println(list.show_all_lines());

            } else if (option.equals("C")) {
                int line_number;
                String line;
                System.out.println("Enter line number you want to replace");
                line_number = Integer.parseInt(sc.nextLine());
                System.out.println("Entre the new line");
                line = sc.nextLine();
                boolean flag = list.replace(line_number, line);
                if (flag) {
                    System.out.println("------------Line replaced successfully------------");
                } else {
                    System.out.println("------------Line not replaced (out of bound)------------");
                }

            } else if (option.equals("Q")) {

                break;

            } else {

                System.out.println("Invalid option");

            }

        }

    }

}
