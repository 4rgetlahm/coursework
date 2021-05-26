import java.util.HashMap;
import java.util.Scanner;

public class uzd {

    private static final HashMap<String, String> vocativeEndings = new HashMap<String, String>(){{
        put("a", "a");
        put("as", "ai");
        put("ė", "e");
        put("is", "i");
        put("us", "au");
        put("ys", "y");
    }};

    private static final HashMap<String, String> monthSeasons = new HashMap<String, String>(){{
        put("gruodis", "žiema");
        put("sausis", "žiema");
        put("vasaris", "žiema");
        put("kovas", "pavasaris");
        put("balandis", "pavasaris");
        put("gegužė", "pavasaris");
        put("birželis", "vasara");
        put("liepa", "vasara");
        put("rugpjūtis", "vasara");
        put("rugsėjis", "ruduo");
        put("spalis", "ruduo");
        put("lapkritis", "ruduo");
    }};


    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Įveskite savo vardą: ");
        String name = scanner.next();
        System.out.println("Sveiki, " + getVocative(name) + "!");

        String month;
        do{
            System.out.println("Įveskite savo gimimo mėnesį: ");
            month = scanner.next().toLowerCase();
        } while(!monthSeasons.containsKey(month));

        System.out.println("Jūsų gimimo sezonas: " + getSeason(month));
    }

    /**
     *
     * @param monthName - Lithuanian name of the month
     * @return - Lithuanian season name
     */

    private static String getSeason(String monthName){
        return monthSeasons.get(monthName);
    }

    /**
     *
     * @param name - Name of the user
     * @return - Name of the user in vocative form
     */

    private static String getVocative(String name){
        String result = name; 
        for(String currentEnding : vocativeEndings.keySet()){
            if(name.endsWith(currentEnding)){
                result = name.substring(0, name.length() - currentEnding.length()); // get name without ending
                result += vocativeEndings.get(currentEnding); // add vocative ending
            }
        }
        return result;
    }

}