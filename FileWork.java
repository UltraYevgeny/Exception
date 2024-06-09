
import java.io.FileWriter;
import java.io.IOException;

public class FileWork {

    public void addData(StringBuilder personData, String fileName)
    {
        FileWriter fw = null;
        try{
            fw = new FileWriter(fileName, true);

            fw.write(personData.toString());
            fw.append('\n');
            fw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


