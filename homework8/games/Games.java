package homework8.games;

import java.util.Random;

public abstract class Games {
    protected int attempts;
    protected boolean isGame;
    protected final Random random = new Random();
    protected int hiddenNumber;


    protected int getRandom(int min, int max) {
        return random.nextInt(max + 1 - min) + min;
    }

    public boolean isGame() {
        return isGame;
    }

    public void resetGame() {
        attempts = 0;
        isGame=true;
    }

    public abstract String greeting();
    public abstract String playerTurn(String userWord);


}
