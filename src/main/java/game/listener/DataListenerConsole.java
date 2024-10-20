package game.listener;

import com.google.common.collect.ImmutableMap;
import game.constants.ConstantsDialog;
import game.wordRepo.Category;
import game.wordRepo.Difficulty;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Scanner;
import static java.lang.System.out;

public class DataListenerConsole implements DataListener {
    private final static int RANDOM_MAGNIFIER = 1;
    private final static int FIRST_OPTION = 1;
    private final static int SECOND_OPTION = 2;
    private final static int THIRD_OPTION = 3;
    private final static int FOURTH_OPTION = 4;
    private final static int FIFTH_OPTION = 5;
    private final static int SIXTH_OPTION = 6;
    private final static int SEVENTH_OPTION = 7;
    private final static int EIGHT_OPTION = 8;
    public static final ImmutableMap<Integer, Difficulty> DIFFICULTY_MAP = ImmutableMap.of(
        FIRST_OPTION, Difficulty.EASY,
        SECOND_OPTION, Difficulty.MEDIUM,
        THIRD_OPTION, Difficulty.HARD
    );
    public static final ImmutableMap<Integer, Category> CATEGORY_MAP = ImmutableMap.of(
        FIRST_OPTION, Category.BASIC_CONCEPTS,
        SECOND_OPTION, Category.REACTIONS,
        THIRD_OPTION, Category.DECAY,
        FOURTH_OPTION, Category.PARTICLES,
        FIFTH_OPTION, Category.TECHNOLOGY,
        SIXTH_OPTION, Category.HISTORY,
        SEVENTH_OPTION, Category.ENVIRONMENT,
        EIGHT_OPTION, Category.SAFETY
    );
    private static final SecureRandom RANDOM = new SecureRandom();
    private final Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    @Override
    public Category getUserCategory() {
        int choice = getInt();
        if (!CATEGORY_MAP.containsKey(choice)) {
            choice = RANDOM.nextInt(CATEGORY_MAP.size()) + RANDOM_MAGNIFIER;
        }
        return CATEGORY_MAP.get(choice);
    }

    @Override
    public Difficulty getUserDifficulty() {
        int choice = getInt();
        if (!DIFFICULTY_MAP.containsKey(choice)) {
            choice = RANDOM.nextInt(DIFFICULTY_MAP.size()) + RANDOM_MAGNIFIER;
        }
        return DIFFICULTY_MAP.get(choice);
    }

    @Override
    public int getOrNotHint() {
        return getInt();
    }

    @Override
    public Character getGuessedLetter() {
        String str;
        while (true) {
            str = scanner.nextLine().trim().toLowerCase();
            if (str.isEmpty()) {
                out.println("Enter a letter: ");
            } else if (str.length() == 1) {
                return str.charAt(0);
            } else {
                out.println(ConstantsDialog.TRY_AGAIN);
            }
        }

    }

    @Override
    public int getInt() {
        int number;
        while (true) {
            out.print("Enter an integer: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                out.println(ConstantsDialog.TRY_AGAIN);
                scanner.nextLine();
            }
        }
        return number;
    }
}
