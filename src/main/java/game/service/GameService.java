package game.service;

import game.wordRepo.WordData;
import java.util.Set;

public interface GameService {
    boolean isWordGuessed(WordData wordData);

    boolean isGameInProgress(WordData word);

    boolean isGameWin(WordData word);

    void checkLetter(WordData word, char guessedLetter);

    int getFails();

    int getStage();

    Set<Character> getGuessedLetters();
}
