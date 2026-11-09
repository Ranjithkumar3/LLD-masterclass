package oops.inheritance;

import java.util.List;

public class GameUtility {
    public void gameBegins(List<Player> players) {
        for(Player player : players) {
            player.playGame();
            player.celebrateVictory();
        }
    }
}
