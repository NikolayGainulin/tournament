import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Game {
    private final List<Player> players = new ArrayList<>();

    public void register(Player player) {
        if (findByName(player.getName()).isPresent()) {
            throw new IllegalArgumentException("Player " + player.getName() + " already registered");
        }
        players.add(player);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findByName(playerName1)
                .orElseThrow(() -> new NotRegisteredException("Player " + playerName1 + " not registered"));

        Player player2 = findByName(playerName2)
                .orElseThrow(() -> new NotRegisteredException("Player " + playerName2 + " not registered"));

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }

    private Optional<Player> findByName(String name) {
        return players.stream()
                .filter(p -> p.getName().equals(name))
                .findFirst();
    }
}