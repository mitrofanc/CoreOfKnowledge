package game.constants;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ConstantsDialog {
    public static final String TRY_AGAIN = "Try again";
    public static final String CATEGORY_MENU =
        "Choose a category:\n"
            + "1. Basic concepts\n"
            + "2. Reactions\n"
            + "3. Decay\n"
            + "4. Particles\n"
            + "5. Technology\n"
            + "6. History\n"
            + "7. Environment\n"
            + "8. Safety\n";
    public static final String CATEGORY = "Category: ";
    public static final String DIFFICULTY_MENU =
        "Choose a difficulty:\n"
            + "1. Easy\n"
            + "2. Medium\n"
            + "3. Hard\n";
    public static final String DIFFICULTY = "Difficulty: ";
    public static final String GUESS_A_LETTER = "Guess a letter: ";
    public static final String NEED_HINT_OR_NOT = "Need a hint?: 1. Yes; 2. No\n";
    public static final String REMAINING_FAILS = "Remaining fails: ";
    public static final String WIN = "You win!\n";
    public static final String LOSE = "You lose :(\n";
    public static final String STAGE_0 = """
           +---+
           |   |
               |
               |
               |
               |
        =========
        """;

    public static final String STAGE_1 = """
           +---+
           |   |
           O   |
               |
               |
               |
        =========
        """;

    public static final String STAGE_2 = """
           +---+
           |   |
           O   |
           |   |
               |
               |
        =========
        """;

    public static final String STAGE_3 = """
           +---+
           |   |
           O   |
          /|   |
               |
               |
        =========
        """;

    public static final String STAGE_4 = """
           +---+
           |   |
           O   |
          /|\\  |
               |
               |
        =========
        """;

    public static final String STAGE_5 = """
           +---+
           |   |
           O   |
          /|\\  |
          /    |
               |
        =========
        """;

    public static final String STAGE_6 = """
           +---+
           |   |
           O   |
          /|\\  |
          / \\  |
               |
        =========
        """;
}
