import constructs.abstractclass.Animal;
import constructs.abstractclass.Dog;
import oops.inheritance.ComputerPlayer;
import oops.inheritance.GameUtility;
import oops.inheritance.HumanPlayer;
import oops.inheritance.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class InheritanceTest {
    GameUtility gameUtility = new GameUtility();
    Animal dogAnimal = new Dog("Johnny");

    @Test
    void inheritPlayers() {
        Player comp = new ComputerPlayer();
        Player hum = new HumanPlayer();

        List<Player> players = new ArrayList<>();
        players.add(comp);
        players.add(hum);

        gameUtility.gameBegins(players);
        dogAnimal.speak();
        dogAnimal.move();
        dogAnimal.printName();
    }
}
