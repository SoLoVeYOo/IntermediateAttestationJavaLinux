import Toys.Toy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class Writer {
    public Writer(LinkedList<Toy> listToy) throws Exception {
        try (FileWriter writer = new FileWriter(String.format("src/winning.txt"), true)) {
            writer.append(listToy.pollFirst().getName());
            writer.append("\n");
            writer.flush();
            System.out.println("\nThe data entered is correct and written to a file");
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
