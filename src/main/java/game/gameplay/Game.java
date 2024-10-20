package game.gameplay;

import game.listener.DataListener;
import game.service.GameService;
import game.ui.UIRenderer;
import game.wordRepo.Category;
import game.wordRepo.Difficulty;
import game.wordRepo.WordData;
import game.wordRepo.WordRepo;

public class Game {
    private final static int GET_HINT = 1;
    private final WordRepo wordRepo;
    private final UIRenderer uiRenderer;
    private final DataListener dataListener;
    private final GameService gameService;
    private WordData word;

    public Game(WordRepo wordRepo, UIRenderer uiRenderer, DataListener dataListener, GameService gameService) {
        this.wordRepo = wordRepo;
        this.uiRenderer = uiRenderer;
        this.dataListener = dataListener;
        this.gameService = gameService;
    }

    public void play() {
        uiRenderer.selectCategory();
        final Category category = dataListener.getUserCategory();
        uiRenderer.selectDifficulty();
        final Difficulty difficulty = dataListener.getUserDifficulty();
        word = wordRepo.getRandomWord(category, difficulty);
        uiRenderer.outputStartCondition(0, word);

        while (gameService.isGameInProgress(word)) {
            internalGameLogic();
        }
        uiRenderer.outputResult(gameService.isGameWin(word));
    }

    public void internalGameLogic() {
        uiRenderer.partlyGuessedWord(gameService.getGuessedLetters(), word);
        uiRenderer.needOrNotHint();
        if (dataListener.getOrNotHint() == GET_HINT) {
            uiRenderer.outHint(word);
        }
        uiRenderer.guessedLetter();
        final var guessedLetter = dataListener.getGuessedLetter();
        gameService.checkLetter(word, guessedLetter);
        uiRenderer.outputNumOfRemainingFails(word, gameService.getFails());
        uiRenderer.outputHangman(gameService.getStage());
    }
}
