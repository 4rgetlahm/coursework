import net.Arnas.planes.BufferedCSVReader;
import net.Arnas.planes.MilitaryPlane;
import net.Arnas.planes.NoEngineException;
import net.Arnas.planes.Plane;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String fileLocation = scanner.next();
        String outputLocation = scanner.next();

        ArrayList<Plane> planeList = new ArrayList<>();
        File file = new File(fileLocation);
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try
        {
            if(!file.exists()){
                return;
            }
            if(fileLocation.endsWith(".csv")){
                BufferedCSVReader reader = new BufferedCSVReader(new FileReader(file));
                for(;;){
                    String[] CSVline = reader.readCSVLine();
                    if(CSVline == null){
                        break;
                    }

                    Plane plane = null;
                    if(CSVline.length == 3){
                        plane = new Plane(CSVline[0], Integer.parseInt(CSVline[1]), Integer.parseInt(CSVline[2]));
                    } else if(CSVline.length == 5){
                        plane = new MilitaryPlane(CSVline[0], Integer.parseInt(CSVline[1]), Integer.parseInt(CSVline[2]), Integer.parseInt(CSVline[3]), CSVline[4]);
                    }
                    if(plane != null){
                        planeList.add(plane);
                    }
                }
            } else {
                objectInputStream = new ObjectInputStream(new FileInputStream(file));
                for(;;){
                    Plane plane = (Plane) objectInputStream.readObject();
                    planeList.add(plane);
                }
            }
        } catch (EOFException e){
            System.out.println("File read");
        }
        catch (Exception e){
            e.printStackTrace();
        } finally{

        }


        File outputFile = new File(outputLocation);
        if(!outputFile.exists()){
            outputFile.createNewFile();
        }
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(outputFile));

        for(Plane plane : planeList){
            System.out.println(plane);
            try {
                plane.fly(10,10);
            } catch (NoEngineException e) {
                e.printStackTrace();
            }
        }

        for(Plane plane : planeList){
            objectOutputStream.writeObject(plane);
        }


    }


}
