import net.Arnas.patterns.Account;
import net.Arnas.patterns.AccountBuilder;
import net.Arnas.patterns.Prototype;
import net.Arnas.patterns.Robot;

public class Main {

    public static void main(String args[]){
        AccountBuilder accountBuilder = new AccountBuilder();

        Account account = accountBuilder
                .userID(1)
                .nickname("Test")
                .name("John")
                .lastName("Test")
                .password("password")
                .age(18)
                .build();

        Robot baseRobot = new Robot();
        baseRobot.setModel("A1");
        baseRobot.setLimbCount(4);
        baseRobot.setName("ASDFGH");
        baseRobot.setMaterial("Iron");

        Robot coolerRobot = baseRobot.clone();
        coolerRobot.setMaterial("Platinum");
    }
}
