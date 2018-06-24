package sample.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** HOW TO USE:
 * 1. Instantiate object with a file path. (Send false as 2nd arg if file should be overwritten).
 * 2. Call the method writeToFile with String or List<String> arg (The input will be written at the end of the file).
 */

public class TextFileWriter {
    private BufferedWriter bw;
    private FileWriter fw;
    private List<String> rows;

    public TextFileWriter(String path){
        this(path, true);
    }
    public TextFileWriter(String path, boolean append){
        setFileWriter(path, append);
        rows = new ArrayList<>();
    }

    public void setFileWriter(String path, boolean append) {
        try {
            fw = new FileWriter(path, append);
            bw = new BufferedWriter(fw);
        } catch(Exception e){
            System.err.print(e);
        }
    }

    public void writeToFile(String content){
        List<String> list = new ArrayList<>();
        list.add(content);
        writeToFile(list);
    }
    public void writeToFile(List<String> content) {
        try {
            StringBuilder sb = new StringBuilder();
            for (String s : content)
            {
                sb.append(s);
                sb.append("\n");
            }

            bw.write(sb.toString());
            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
