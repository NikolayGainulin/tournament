import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {
    private final Game game = new Game();

    @Test
    void testRoundPlayer1Wins() {
        // Игрок 1: Камень (0), Игрок 2: Ножницы (2)
        assertEquals(1, game.determineWinner(0, 2));
    }

    @Test
    void testRoundPlayer2Wins() {
        // Игрок 1: Ножницы (2), Игрок 2: Камень (0)
        assertEquals(2, game.determineWinner(2, 0));
    }

    @Test
    void testRoundDraw() {
        // Оба игрока: Бумага (1)
        assertEquals(0, game.determineWinner(1, 1));
    }
}