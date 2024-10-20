package game.ui;

import game.wordRepo.WordData;
import java.util.Set;

public interface UIRenderer {
    void selectCategory();

    void outputCategory(WordData word);

    void selectDifficulty();

    void outputDifficulty(WordData word);

    void guessedLetter();

    void needOrNotHint();

    void outHint(WordData word);

    void partlyGuessedWord(Set<Character> guessedLetters, WordData word);

    void outputHangman(int stage);

    void outputNumOfRemainingFails(WordData word, int fails);

    void outputResult(boolean result);

    void outputStartCondition(int stage, WordData word);
}
