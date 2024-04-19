import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
public void testWhenSecondPlayerWin() {
        Player Petya = new Player(123, "Петя", 120);
        Player Vasya = new Player(124, "Вася", 100);
        Game game = new Game();
        game.registered(Petya);
        game.registered(Vasya);
        int actual = game.round("Вася", "Петя");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }
}
