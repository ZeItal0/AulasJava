package Aula07;

public class Calculator implements operation{

    @Override
    public int sum(int valueFirst, int ValueSecond) {
        return valueFirst + ValueSecond;
    }

    @Override
    public int subtract(int valueFirst, int ValueSecond) {
        return valueFirst - ValueSecond;
    }

    @Override
    public int multiply(int valueFirst, int ValueSecond) {
        return valueFirst * ValueSecond;
    }

    @Override
    public double divide(int valueFirst, int ValueSecond) {
        if (ValueSecond == 0) {
            throw new ArithmeticException("Divisão por zero não é permitida.");
        }
        return (double) valueFirst / ValueSecond;
    }
}
