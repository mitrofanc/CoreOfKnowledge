package game;

import game.exceptions.GameException;
import game.wordRepo.Category;
import game.wordRepo.Difficulty;
import game.wordRepo.WordData;
import game.wordRepo.WordRepo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WordDataRepoTest {
    WordRepo wordRepo = new WordRepo();

    @Test
    void testGetRandomWordAnimalsEasy() {
        WordData word = wordRepo.getRandomWord(Category.BASIC_CONCEPTS, Difficulty.EASY);

        assertNotNull(word);
        assertEquals(Category.BASIC_CONCEPTS, word.category());
        assertEquals(Difficulty.EASY, word.difficulty());
    }
}
