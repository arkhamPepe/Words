package sample.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileWriter {
    private BufferedWriter bw;
    private FileWriter fw;
    private List<String> rows;

    public TextFileWriter(String path){
        setFileWriter(path);
        rows = new ArrayList<>();
    }

    public void setFileWriter(String path) {
        try {
            bw = new BufferedWriter(new FileWriter(path));
        } catch(Exception e){
            System.err.print(e);
        }
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
