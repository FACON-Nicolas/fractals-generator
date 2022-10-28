package fr.univartois.butinfo.fractals.complex;

import java.util.Objects;

/**
 * Permet de générer un complex.
 *
 * @author Arnaud
 *
 * @version 0.1.0
 */
public class Complex implements IComplex{

    /**
     * La partie réelle de ce nombre complexe.
     */
    private final double realPart;

    /**
     * La partie imaginaire de ce nombre complexe.
     */
    private final double imaginaryPart;

    /**
     * Crée une nouvelle instance de Complex.
     * @param realPart Partie réelle du complex.
     * @param imaginaryPart Partie imaginaire du complex.
     */
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

    /**
     * Donne le conjugué de ce nombre complexe.
     *
     * @return Le conjugué de ce nombre complexe.
     */
    @Override
    public IComplex conjugate() {
        return new Complex(realPart, - imaginaryPart);
    }

    /**
     * Ajoute ce nombre complexe à un autre nombre complexe.
     *
     * @param other Le nombre complexe à ajouter à ce nombre.
     *
     * @return Le résultat de {@code this + other}.
     */
    @Override
    public IComplex add(IComplex other) {
        return new Complex(realPart + other.getRealPart(), imaginaryPart + other.getImaginaryPart());
    }

    /**
     * Soustrait un nombre complexe de ce nombre complexe.
     *
     * @param other Le nombre complexe à soustraire de ce nombre.
     *
     * @return Le résultat de {@code this - other}.
     */
    @Override
    public IComplex subtract(IComplex other) {
        return new Complex(realPart - other.getRealPart(), imaginaryPart - other.getImaginaryPart());
    }

    /**
     * Multiplie ce nombre complexe par une valeur réelle.
     *
     * @param value La valeur par laquelle multiplier ce nombre.
     *
     * @return Le résultat de {@code this * value}.
     */
    @Override
    public IComplex multiply(double value) {
        return new Complex(realPart * value, imaginaryPart * value);
    }

    /**
     * Multiplie ce nombre complexe par un autre nombre complexe.
     *
     * @param other Le nombre complexe à mulitplier par ce nombre.
     *
     * @return Le résultat de {@code this * other}.
     */
    @Override
    public IComplex multiply(IComplex other) {
        return new Complex(realPart * other.getRealPart() - imaginaryPart * other.getImaginaryPart(), realPart * other.getImaginaryPart() + imaginaryPart * other.getRealPart());
    }

    /**
     * Divise ce nombre complexe par un autre nombre complexe.
     *
     * @param other Le nombre complexe qui divise ce nombre.
     *
     * @return Le résultat de {@code this / other}.
     */
    @Override
    public IComplex divide(IComplex other) {
        IComplex numerateur = multiply(other.conjugate());
        double denominateur = Math.pow(other.getRealPart(), 2) + Math.pow(other.getImaginaryPart(), 2);
        return new Complex(numerateur.getRealPart() / denominateur, numerateur.getImaginaryPart() / denominateur);
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
