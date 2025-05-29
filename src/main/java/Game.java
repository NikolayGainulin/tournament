public class Game {
    // Константы для ходов
    public static final int ROCK = 0;
    public static final int PAPER = 1;
    public static final int SCISSORS = 2;

    public int determineWinner(int player1Move, int player2Move) {
        if (player1Move == player2Move) {
            return 0; // Ничья
        }

        // Проверка победы игрока 1
        if ((player1Move == ROCK && player2Move == SCISSORS) ||
                (player1Move == PAPER && player2Move == ROCK) ||
                (player1Move == SCISSORS && player2Move == PAPER)) {
            return 1; // Исправлено с -1 на 1
        } else {
            return 2; // Исправлено с 1 на 2
        }
    }
}