package game.ui;

import game.constants.ConstantsDialog;
import game.wordRepo.WordData;
import java.util.List;
import java.util.Set;
import static java.lang.System.out;

public class UIRendererConsole implements UIRenderer {

    private final List<String> hangmanStages = List.of(
        ConstantsDialog.STAGE_0,
        ConstantsDialog.STAGE_1,
        ConstantsDialog.STAGE_2,
        ConstantsDialog.STAGE_3,
        ConstantsDialog.STAGE_4,
        ConstantsDialog.STAGE_5,
        ConstantsDialog.STAGE_6
    );

    @Override
    public void selectCategory() {
        out.print(ConstantsDialog.CATEGORY_MENU);
    }

    @Override
    public void outputCategory(WordData word) {
        out.println(ConstantsDialog.CATEGORY + word.category());
    }

    @Override
    public void selectDifficulty() {
        out.print(ConstantsDialog.DIFFICULTY_MENU);
    }

    @Override
    public void outputDifficulty(WordData word) {
        out.println(ConstantsDialog.DIFFICULTY + word.difficulty());
    }

    @Override
    public void guessedLetter() {
        out.println(ConstantsDialog.GUESS_A_LETTER);
    }

    @Override
    public void needOrNotHint() {
        out.print(ConstantsDialog.NEED_HINT_OR_NOT);
    }

    @Override
    public void outHint(WordData word) {
        out.println(word.hint());
    }

    @Override
    public void partlyGuessedWord(Set<Character> guessedLetters, WordData word) {
        for (char c : word.word().toCharArray()) {
            if (guessedLetters.contains(c)) {
                out.print(c);
            } else {
                out.print('_');
            }
        }
        out.println();
    }

    @Override
    public void outputHangman(int stage) {
        out.println(hangmanStages.get(stage));
    }

    @Override
    public void outputNumOfRemainingFails(WordData word, int fails) {
        out.println(ConstantsDialog.REMAINING_FAILS + (word.difficulty().getMaxFails() - fails));
    }

    @Override
    public void outputResult(boolean result) {
        if (result) {
            out.print(ConstantsDialog.WIN);
        } else {
            out.println(ConstantsDialog.LOSE);
        }
    }

    @Override
    public void outputStartCondition(int stage, WordData word) {
        outputHangman(stage);
        outputCategory(word);
        outputDifficulty(word);
    }
}
