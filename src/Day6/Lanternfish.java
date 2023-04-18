public class Lanternfish {
    byte internalTimer;

    public Lanternfish() {
        this.internalTimer = 8;
    }

    public Lanternfish(byte internalTimer) {
        this.internalTimer = internalTimer;
    }

    public boolean newDay() {
        internalTimer--;
        if (internalTimer == -1) {
            internalTimer = 6;
            return true;
        }

        return false;
    }

}
