package sample.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


/** HOW TO USE:
 * 1. Instantiate object with a file path.
 * 2. Call the method loadTextRows (to read the .txt-file and store the data).
 * 3. Call the method getRows (to receive a list of all rows in String format).
 */

public class TextFileReader {
    private BufferedReader br;
    private List<String> rows;

    public TextFileReader(String path){
        setFileReader(path);
        rows = new ArrayList<>();
    }

    public void loadTextRows(){
        String str;
        rows.clear();

        try{
            while((str = br.readLine()) != null){
                rows.add(str);
                //System.out.println(str);
            }
            br.close();
        } catch(Exception e){}
    }

    /* GETTERS */
    /** Returns defensive copy of List rows */
    public List<String> getRows(){
        loadTextRows();

        List<String> copy = new ArrayList<>();

        for(int i = 0; i < rows.size(); i++){
            copy.add(rows.get(i));
        }

        return copy;
    }
    public BufferedReader getBr() {
        return br;
    }

    /* SETTERS */
    public void setFileReader(String path) {
        try {
            br = new BufferedReader(new FileReader(path));
        } catch(Exception e){}
    }
    public void setFileReader(FileReader fr){
        try {
            br = new BufferedReader(fr);
        } catch (Exception e){}
    }
}
