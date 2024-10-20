package game.wordRepo;

public enum Difficulty {
    EASY(6),
    MEDIUM(3),
    HARD(2);

    private final int maxFails;

    Difficulty(int maxFails) {
        this.maxFails = maxFails;
    }

    public int getMaxFails() {
        return maxFails;
    }
}
