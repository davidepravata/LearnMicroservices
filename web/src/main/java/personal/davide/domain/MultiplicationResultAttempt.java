package personal.davide.domain;

public final class MultiplicationResultAttempt {

    private User user;
    private Multiplication multiplication;
    private int attempt;

    public MultiplicationResultAttempt(User user, Multiplication multiplication, int attempt) {
        this.user = user;
        this.multiplication = multiplication;
        this.attempt = attempt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Multiplication getMultiplication() {
        return multiplication;
    }

    public void setMultiplication(Multiplication multiplication) {
        this.multiplication = multiplication;
    }

    public int getAttempt() {
        return attempt;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    @Override
    public String toString() {
        return "MultiplicationResultAttempt{" + "user=" + user + ", multiplication=" + multiplication + ", attempt=" + attempt + '}';
    }
}
