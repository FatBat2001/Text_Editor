import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManager {
    public  DoublyLinkedList<String> readFile(String fileName) {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String s;
            while ((s = br.readLine()) != null) {
                list.AddLast(s);
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public  void writeToFile(DoublyLinkedList<String> list, String fileName) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            String s = list.show_all_lines();
            bw.write(s);
            bw.close();
        } catch (Exception e) {
        }
    }
}
