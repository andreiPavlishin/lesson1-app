package lesson6.Animal;

public abstract class Animal {
    private final int MAX_RUN_LENGTH = 0;
    private final int MAX_SWIM_LENGTH = 0;
    private final double MAX_JUMP_HEIGTH = 0;

    public abstract void run(int length);

    public abstract void swim(int length);

    public abstract void jump(double height);
}
