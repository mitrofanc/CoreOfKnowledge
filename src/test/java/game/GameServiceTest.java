package game;

import com.google.common.util.concurrent.ClosingFuture;
import game.service.GameService;
import game.service.GameServiceHangman;
import game.wordRepo.Category;
import game.wordRepo.Difficulty;
import game.wordRepo.WordData;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameServiceTest {
    GameService gameService = new GameServiceHangman();
    WordData word = new WordData("atom",
        "The basic unit of a chemical element.",
        Category.BASIC_CONCEPTS,
        Difficulty.EASY);

    @Test
    void testIsWordGuessedFull() {
        gameService.checkLetter(word, 'a')  ;
        gameService.checkLetter(word, 't');
        gameService.checkLetter(word, 'o');
        gameService.checkLetter(word, 'm');
        assertTrue(gameService.isGameWin(word));
    }

    @Test
    void testIsWordGuessedNotFull() {
        gameService.checkLetter(word, 'a');
        assertFalse(gameService.isWordGuessed(word));
    }

    @Test
    void testIsGameInProgress() {
        assertTrue(gameService.isGameInProgress(word));
    }

    @Test
    void testIsWordGuessedNotInProgress() {
        for (int i = 0; i < word.difficulty().getMaxFails(); i++) {
            gameService.checkLetter(word, 'g');
        }
        assertFalse(gameService.isGameInProgress(word));
    }

    @Test
    void testIsGameWin() {
        for (char c : word.word().toCharArray()) {
            gameService.checkLetter(word, c);
        }
        assertTrue(gameService.isGameWin(word));
    }

    @Test
    void testIsGameLose() {
        gameService.checkLetter(word, 'a');
        gameService.checkLetter(word, 't');
        assertFalse(gameService.isGameWin(word));
    }

    @Test
    void testCheckCorrectLetter() {
        gameService.checkLetter(word, 'a');
        assertEquals(0, gameService.getFails());
        assertTrue(gameService.getGuessedLetters().contains('a'));
    }

    @Test
    void testCheckIncorrectLetter() {
        gameService.checkLetter(word, 'g');
        assertEquals(1, gameService.getFails());
        assertFalse(gameService.getGuessedLetters().contains('g'));
    }
}
