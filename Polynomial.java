import java.util.TreeMap;

public class Polynomial {
    private TreeMap<Integer, Integer> polynomial;
    private int degree;

    public Polynomial() {
        polynomial = new TreeMap<Integer, Integer>();
        degree = 0;
    }

    public Polynomial(Polynomial copy) {
        polynomial = copy.copy();
        degree = 0;
    }

    private TreeMap<Integer, Integer> copy() {
        return polynomial;
    }

    public void printPolynomial() {
        int i = 0;
        for (Integer key : polynomial.keySet()) {
            if (polynomial.get(key) >= 0 && i != 0) {
                System.out.print(" + ");
            }
            System.out.print(polynomial.get(key) + "x^" + key + "");
            i++;
        }
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

    public void removeTerm(int power) {
        polynomial.remove(power);

        if (polynomial.size() == 0) {
            degree = 0;

        } else if (power == degree) {
            for (int i = degree; i < 1; i--) {
                if (polynomial.get(i) != null) {
                    degree = i;
                }
            }
        }
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
        result.checkZeros();
        return result;
    }

    private void checkZeros() {

        for (Integer key : polynomial.keySet()) {
            if (polynomial.get(key) != null && polynomial.get(key) == 0) {

                polynomial.remove(key);
            }
        }
    }

    private int getCoefficient(int power) {
        if (polynomial.get(power) == null) {
            return -1;
        } else {
            return polynomial.get(power);
        }

    }

}
