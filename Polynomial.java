import java.util.TreeMap;

public class Polynomial {
    private TreeMap<Integer, Integer> polynomial;
    private int degree;

    public Polynomial() {
        polynomial = new TreeMap<Integer, Integer>();
    }

    public Polynomial(Polynomial copy) {
        polynomial = copy.copy();
    }

    private TreeMap<Integer, Integer> copy() {
        return polynomial;
    }

    private void updateDegree(int newDegree) {
        if (newDegree > degree) {
            degree = newDegree;
        }
    }

    private int compareDegrees(Polynomial poly2) {

        if (degree >= poly2.getDegree()) {
            return degree;
        } else {
            return poly2.getDegree();
        }
    }

    private int getDegree() {
        return degree;
    }

    public void addTerm(int coefficient, int power) {
        polynomial.put(power, coefficient);
        updateDegree(power);
    }

    public Polynomial add(Polynomial poly2) {
        Polynomial result = new Polynomial();
        int newDegree = compareDegrees(poly2);

        for (int i = 0; i <= degree; i++) {

            if (polynomial.get(i) != null) {

            }
        }

    }

}
