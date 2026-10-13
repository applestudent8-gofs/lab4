package lab4.myWork;

public class USDollar implements CurrecncyStrategy {
    @Override
    public float changeTo(float amount) {
        return amount * 3.75f;
    }

    @Override
    public String getSymbol() {
        return "$";
    }
}
