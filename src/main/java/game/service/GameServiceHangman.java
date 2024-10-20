package game.service;

import game.wordRepo.Difficulty;
import game.wordRepo.WordData;
import java.util.HashSet;
import java.util.Set;


public class GameServiceHangman implements GameService {
    private final static int TWO_STAGES = 2;
    private final static int THREE_STAGES = 3;
    private final Set<Character> guessedLetters = new HashSet<>();
    private int fails = 0;
    private int stage = 0;

    @Override
    public boolean isWordGuessed(WordData wordData) {
        for (char c : wordData.word().toCharArray()) {
            if (!guessedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isGameInProgress(WordData word) {
        if (fails == word.difficulty().getMaxFails()) {
            return false;
        }
        return !isWordGuessed(word);
    }

    @Override
    public boolean isGameWin(WordData word) {
        return fails < word.difficulty().getMaxFails() && isWordGuessed(word);
    }

    public void checkLetter(WordData word, char guessedLetter) {
        if (word.word().contains(String.valueOf(guessedLetter))) {
            guessedLetters.add(guessedLetter);

        } else {
            if (word.difficulty() == Difficulty.EASY) {
                stage++;
            } else if (word.difficulty() == Difficulty.MEDIUM) {
                stage += TWO_STAGES;
            } else if (word.difficulty() == Difficulty.HARD) {
                stage += THREE_STAGES;
            }
            fails++;
        }
    }

    // Почему-то не видит lombok в обычном классе, поэтому сам прописал геттеры
    @Override
    public int getFails() {
        return fails;
    }

    @Override
    public int getStage() {
        return stage;
    }

    @Override
    public Set<Character> getGuessedLetters() {
        return guessedLetters;
    }
}
