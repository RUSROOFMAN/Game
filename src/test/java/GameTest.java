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
    @Test
    public void testWhenFirstPlayerWin(){
        Player Petya = new Player(1, "Петя", 100);
        Player Vasya = new Player(2, "Вася", 120);
        Game game = new Game();
        game.registered(Vasya);
        game.registered(Petya);
        int actual = game.round("Вася", "Петя");
        int expected = 1;
        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void testWhenStrengthsEquals(){
        Player Petya = new Player(1, "Петя", 100);
        Player Vasya = new Player(2, "Вася", 100);
        Game game = new Game();
        game.registered(Vasya);
        game.registered(Petya);
        int actual = game.round("Вася", "Петя");
        int expected = 0;
        Assertions.assertEquals(expected, actual);

    }
    @Test
    public void testWhenFirstPlayerNotExist() {
        Player Vasya = new Player(1, "Вася", 100);
        Game game = new Game();
        game.registered(Vasya);
        Assertions.assertThrows(NotRegisteredException.class,
        () -> game.round("Жора","Вася")
        );
    }
    @Test
    public void testWhenSecondPlayerNotExist() {
        Player Vasya = new Player(1, "Вася", 100);
        Game game = new Game();
        game.registered(Vasya);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Вася", "Жора")
        );
    }


}
