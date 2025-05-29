import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;
    private Player player1;
    private Player player2;
    private Player player3;

    @BeforeEach
    void setUp() {
        game = new Game();
        player1 = new Player(1, "Alice", 100);
        player2 = new Player(2, "Bob", 80);
        player3 = new Player(3, "Charlie", 100);
    }

    @Test
    @DisplayName("Player registration should work")
    void registerPlayer() {
        game.register(player1);
        game.register(player2);

        assertThrows(IllegalArgumentException.class,
                () -> game.register(player1),
                "Should throw on duplicate registration");
    }

    @Test
    @DisplayName("Round should return 1 when first player wins")
    void roundFirstPlayerWins() {
        game.register(player1);
        game.register(player2);

        assertEquals(1, game.round("Alice", "Bob"));
    }

    @Test
    @DisplayName("Round should return 2 when second player wins")
    void roundSecondPlayerWins() {
        game.register(player2);
        game.register(player1);

        assertEquals(2, game.round("Bob", "Alice"));
    }

    @Test
    @DisplayName("Round should return 0 when draw")
    void roundDraw() {
        game.register(player1);
        game.register(player3);

        assertEquals(0, game.round("Alice", "Charlie"));
    }

    @Test
    @DisplayName("Round should throw when first player not registered")
    void roundFirstPlayerNotRegistered() {
        game.register(player2);

        NotRegisteredException exception = assertThrows(
                NotRegisteredException.class,
                () -> game.round("Alice", "Bob")
        );
        assertEquals("Player Alice not registered", exception.getMessage());
    }

    @Test
    @DisplayName("Round should throw when second player not registered")
    void roundSecondPlayerNotRegistered() {
        game.register(player1);

        NotRegisteredException exception = assertThrows(
                NotRegisteredException.class,
                () -> game.round("Alice", "Bob")
        );
        assertEquals("Player Bob not registered", exception.getMessage());
    }

    @Test
    @DisplayName("Round should throw when both players not registered")
    void roundBothPlayersNotRegistered() {
        NotRegisteredException exception = assertThrows(
                NotRegisteredException.class,
                () -> game.round("Alice", "Bob")
        );
        assertTrue(exception.getMessage().contains("not registered"));
    }
}