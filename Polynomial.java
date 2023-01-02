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

        for (int i = 0; i <= newDegree; i++) {
            if (polynomial.get(i) != null) {
                if (poly2.getCoefficient(i) != -1) {
                    result.addTerm(polynomial.get(i) + poly2.getCoefficient(i), i);
                } else {
                    result.addTerm(polynomial.get(i), i);
                }
            } else if (poly2.getCoefficient(i) != -1) {
                result.addTerm(poly2.getCoefficient(i), i);
            }
        }
        result.updateDegree(newDegree);
        return result;
    }

    public Polynomial subtract(Polynomial poly2) {
        Polynomial result = new Polynomial();
        int newDegree = compareDegrees(poly2);

        for (int i = 0; i <= newDegree; i++) {
            if (polynomial.get(i) != null) {
                if (poly2.getCoefficient(i) != -1) {
                    result.addTerm(polynomial.get(i) - poly2.getCoefficient(i), i);
                } else {
                    result.addTerm(polynomial.get(i), i);
                }
            } else if (poly2.getCoefficient(i) != -1) {
                result.addTerm(poly2.getCoefficient(i), i);
            }
        }
        result.updateDegree(newDegree);
        return result;
    }

    public Polynomial multiply(Polynomial poly2) {
        Polynomial result = new Polynomial();
        int Maxdegree = compareDegrees(poly2);

        for (int i = 0; i <= Maxdegree; i++) {
            if (polynomial.get(i) != null) {
                if (poly2.getCoefficient(i) != -1) {
                    // When they both exist
                } else {
                    result.addTerm(polynomial.get(i), i);
                }
            } else if (poly2.getCoefficient(i) != -1) {
                result.addTerm(poly2.getCoefficient(i), i);
            }
        }
        result.updateDegree(Maxdegree + Math.min(degree, poly2.getDegree()));
        return result;
    }

    private int getCoefficient(int power) {
        if (polynomial.get(power) == null) {
            return -1;
        } else {
            return polynomial.get(power);
        }

    }

}
