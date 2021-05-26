package net.Arnas.planes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.Buffer;
import java.util.ArrayList;

public class BufferedCSVReader extends BufferedReader {
    public BufferedCSVReader(Reader in) {
        super(in);
    }

    public String[] readCSVLine() throws IOException {
        String readLine = super.readLine();
        if(readLine == null){
            return null;
        }
        String[] readData = readLine.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
        for(int i = 0; i != readData.length; i++){
            if(readData[i].endsWith("\"")){
                readData[i] = getFixedQuoteField(readData[i]);
            }
        }
        return readData;
    }

    public String getFixedQuoteField(String str){
        str = str.substring(1);
        str = str.substring(0, str.length() - 1);
        str = str.replace("\"\"", "\"");
        return str;
    }
}
