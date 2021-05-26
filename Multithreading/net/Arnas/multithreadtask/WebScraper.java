package net.Arnas.multithreadtask;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class WebScraper implements Runnable{

    private final ArrayList<String> links;
    private final BufferedWriter bufferedWriter;

    /**
     *
     * @param links list of website URL's
     * @param bufferedWriter BufferedWriter that is going to output text
     */
    public WebScraper(ArrayList<String> links, BufferedWriter bufferedWriter){
        this.links = links;
        this.bufferedWriter = bufferedWriter;
    }

    /**
     *
     * @param link one link of website (URL)
     * @param bufferedWriter BufferedWriter that is going to output text
     */
    public WebScraper(String link, BufferedWriter bufferedWriter){
        this.links = new ArrayList<>();
        links.add(link);
        this.bufferedWriter = bufferedWriter;
    }


    @Override
    public void run() {
        URL url;
        InputStream inputStream = null;

        try {
            for (String link : links) {
                System.out.println(link);
                url = new URL(link);
                inputStream = url.openStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                synchronized (bufferedWriter) {
                    bufferedWriter.write(link + "\n");
                    String readLine;
                    while ((readLine = bufferedReader.readLine()) != null) {
                        bufferedWriter.write(readLine);
                    }
                    bufferedWriter.write("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
