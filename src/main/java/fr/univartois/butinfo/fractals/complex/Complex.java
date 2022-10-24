package fr.univartois.butinfo.fractals.complex;

import java.util.Objects;

public class Complex implements IComplex{

    /**
     * La partie réelle de ce nombre complexe.
     */
    private final double realPart;

    /**
     * La partie imaginaire de ce nombre complexe.
     */
    private final double imaginaryPart;

    public Complex(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    /**
     * Donne la partie réelle de ce nombre complexe.
     *
     * @return La partie réelle de ce nombre complexe.
     */
    @Override
    public double getRealPart() {
        return realPart;
    }

    /**
     * Donne la partie imaginaire de ce nombre complexe.
     *
     * @return La partie imaginaire de ce nombre complexe.
     */
    @Override
    public double getImaginaryPart() {
        return imaginaryPart;
    }

    /**
     * Donne le module de ce nombre complexe.
     *
     * @return Le module de ce nombre complexe.
     */
    @Override
    public double abs() {
        return Math.sqrt(Math.pow(realPart, 2) + Math.pow(imaginaryPart, 2));
    }

    /**
     * Donne l'opposé de ce nombre complexe.
     *
     * @return L'opposé de ce nombre complexe.
     */
    @Override
    public IComplex negate() {
        return new Complex(- realPart, - imaginaryPart);
    }

    @Override
    public IComplex conjugate() {
        return new Complex(realPart, - imaginaryPart);
    }

    @Override
    public IComplex add(IComplex other) {
        return new Complex(realPart + other.getRealPart(), imaginaryPart + other.getImaginaryPart());
    }

    @Override
    public IComplex subtract(IComplex other) {
        return new Complex(realPart - other.getRealPart(), imaginaryPart - other.getImaginaryPart());
    }

    @Override
    public IComplex multiply(double value) {
        return new Complex(realPart * value, imaginaryPart * value);
    }

    @Override
    public IComplex multiply(IComplex other) {
        return new Complex(realPart * other.getRealPart() - imaginaryPart * other.getImaginaryPart(), realPart * other.getImaginaryPart() + imaginaryPart * other.getRealPart());
    }

    @Override
    public IComplex divide(IComplex other) {
        IComplex numerateur = multiply(other.conjugate());
        IComplex denominateur = multiply(other.conjugate());
        return new Complex(numerateur.getRealPart() / denominateur.getRealPart(),
                numerateur.getImaginaryPart() / denominateur.getRealPart());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complex complex = (Complex) o;
        return realPart == complex.realPart && imaginaryPart == complex.imaginaryPart;
    }

    @Override
    public int hashCode() {
        return Objects.hash(realPart, imaginaryPart);
    }

    @Override
    public String toString() {
        return realPart + " + " + imaginaryPart+"i";
    }
}
