package by.teachmeskills.homework.hw_10032023;

public enum Alphabet {
    A,
    B,
    C,
    D,
    E,
    F,
    G,
    H,
    I,
    J,
    K,
    L,
    M,
    N,
    O,
    P,
    Q,
    R,
    S,
    T,
    U,
    V,
    W,
    X,
    Y,
    Z;
    public void getLetterPosition() {
        System.out.println("The letter position is: " + (this.ordinal() + 1));
    }
}