import net.Arnas.multithreadtask.ProgressionCalculator;
import net.Arnas.multithreadtask.WebScraper;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Thread> threadList = new ArrayList<>();
    public static ArrayList<ProgressionCalculator> progressionCalculatorList = new ArrayList<>();

    /**
     * waits for threads from threadList to die
     */
    public static void waitForThreads(){
        for(Thread thread : threadList){
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * clears lists
     */
    public static void clearLists(){
        threadList.clear();
        progressionCalculatorList.clear();
    }

    /**
     *
     * @param scanner scanner that is used for input
     */
    public static void multiThreadingTaskSelection(Scanner scanner){
        System.out.println("Select task: \n1) Pi calculation\n2) Web data download");

        int taskID = scanner.nextInt();
        long startTime, stopTime;
        System.out.println(threadList.size());
        switch (taskID){
            case 1:
                int increment, scale, threadCount;

                System.out.println("Enter Pi scale: ");
                scale = scanner.nextInt();
                System.out.println("Enter arithmetic calculation count per thread: ");
                increment = scanner.nextInt();
                System.out.println("Enter Thread count: ");
                threadCount = scanner.nextInt();

                startTime = System.nanoTime();

                BigDecimal sum = new BigDecimal(BigInteger.ZERO);
                BigDecimal from = new BigDecimal(BigInteger.ONE);

                for(int i = 0; i != threadCount; i++){
                    ProgressionCalculator progressionCalculator = new ProgressionCalculator(from, increment, scale);
                    Thread thread = new Thread(progressionCalculator);
                    thread.start();
                    threadList.add(thread);
                    progressionCalculatorList.add(progressionCalculator);

                    BigDecimal bigIncrement = BigDecimal.valueOf((increment * 2));

                    from = from.add(bigIncrement);
                }

                waitForThreads();

                for(ProgressionCalculator progressionCalculator : progressionCalculatorList){
                    sum = sum.add(progressionCalculator.getResult());
                }

                stopTime = System.nanoTime();
                System.out.println(sum);
                System.out.println("Run time: " + (stopTime - startTime) / 1000000 + "ms");
            break;
            case 2:
                ArrayList<String> urlList = new ArrayList<>();
                System.out.println("Enter websites you want to scrape (quit by typing \"end\"): ");
                String readLine;
                while(!(readLine = scanner.next()).equals("end")){
                    urlList.add(readLine);
                }

                startTime = System.nanoTime();

                BufferedWriter bufferedWriter = null;

                try {
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("resultsMT.txt")));

                    for(String link : urlList){
                        Thread thread = new Thread(new WebScraper(link, bufferedWriter));
                        thread.start();
                        threadList.add(thread);
                    }
                    waitForThreads();

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        bufferedWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                stopTime = System.nanoTime();

                System.out.println("Run time: " + (stopTime - startTime) / 1000000 + "ms");
            default:
                return;
        }
        clearLists();
        System.gc();
        askForMultithreading();
    }

    /**
     *
     * @param scanner scanner that is used for input
     */
    public static void taskSelection(Scanner scanner){
        System.out.println("Select task: \n1) Pi calculation\n2) Web data download");

        int taskID = scanner.nextInt();
        long startTime, stopTime;
        switch (taskID){
            case 1:
                int scale, calculation;
                System.out.println("Enter Pi scale: ");
                scale = scanner.nextInt();
                System.out.println("Enter progression calculations count: ");
                calculation = scanner.nextInt();

                startTime = System.nanoTime();

                BigDecimal from = new BigDecimal(BigInteger.ONE);
                ProgressionCalculator progressionCalculator = new ProgressionCalculator(from, calculation, scale);
                progressionCalculator.run();

                stopTime = System.nanoTime();

                System.out.println(progressionCalculator.getResult());
                System.out.println("Run time: " + (stopTime - startTime) / 1000000 + "ms");
                break;
            case 2:
                ArrayList<String> urlList = new ArrayList<>();
                System.out.println("Enter websites you want to scrape (quit by typing \"end\"): ");
                String readLine;
                while(!(readLine = scanner.next()).equals("end")){
                    urlList.add(readLine);
                }

                startTime = System.nanoTime();

                BufferedWriter bufferedWriter = null;
                try {
                    bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("results.txt")));
                    WebScraper webScraper = new WebScraper(urlList, bufferedWriter);
                    webScraper.run();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (bufferedWriter != null) {
                            bufferedWriter.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                stopTime = System.nanoTime();

                System.out.println("Run time: " + (stopTime - startTime) / 1000000 + "ms");
                break;
            default:
                return;
        }
        clearLists();
        System.gc();
        askForMultithreading();

    }

    public static void askForMultithreading(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Turn on multithreading? (true/false): ");
        boolean multithreading = scanner.nextBoolean();

        if(multithreading){
            multiThreadingTaskSelection(scanner);
        } else {
            taskSelection(scanner);
        }
    }

    public static void main(String args[]){
        askForMultithreading();
    }
}
