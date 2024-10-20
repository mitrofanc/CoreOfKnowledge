package game.listener;

import game.wordRepo.Category;
import game.wordRepo.Difficulty;

public interface DataListener {
    Category getUserCategory();

    Difficulty getUserDifficulty();

    int getOrNotHint();

    Character getGuessedLetter();

    int getInt();
}
