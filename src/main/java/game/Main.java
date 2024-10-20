package game;

import game.gameplay.Game;
import game.listener.DataListener;
import game.listener.DataListenerConsole;
import game.service.GameService;
import game.service.GameServiceHangman;
import game.ui.UIRenderer;
import game.ui.UIRendererConsole;
import game.wordRepo.WordRepo;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;


@Slf4j @UtilityClass
public class Main {
    public static void main(String[] args) {
        try {
            final WordRepo wordRepo = new WordRepo();
            final UIRenderer uiRenderer = new UIRendererConsole();
            final DataListener dataListener = new DataListenerConsole();
            final GameService gameService = new GameServiceHangman();
            final Game game = new Game(wordRepo, uiRenderer, dataListener, gameService);
            game.play();
        } catch (Exception e) {
            log.error("Error:", e);
        }
    }
}
