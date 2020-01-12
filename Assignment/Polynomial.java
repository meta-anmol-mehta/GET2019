/**
 * The class represents a polynomial with integer coefficients. Polynomials are
 * immutable: their values cannot be changed after they are created. It includes
 * methods for addition, multiplication, composition,evaluation.
 *
 * @author Anmol mehta
 */

public final class Polynomial {

	int[] polynomialCoefficient;
	int polynomialDegree;

	public Polynomial(int[] polynomialCoefficient) {

		this.polynomialCoefficient = polynomialCoefficient;
		this.polynomialDegree = polynomialCoefficient.length - 1;

	}

	/**
	 * Returns the result of evaluating this polynomial at the point x.
	 *
	 * @param x
	 *            the point at which to evaluate the polynomial
	 * @return the integer
	 */

	public float evaluate(float x) {

		if (polynomialCoefficient.length < 1) {
			throw new AssertionError("Array is empty");
		}

		float evaluation = (float) 0.0;

		for (int i = polynomialDegree; i >= 0; --i) {
			evaluation += (float) (polynomialCoefficient[i] * Math.pow(x, i));
		}
		return evaluation;
	}

	/**
	 * Returns the degree of this polynomial.
	 * 
	 * @return the degree of this polynomial, -1 for the zero polynomial.
	 */
	public int degree() {
		if (polynomialCoefficient.length < 1) {
			throw new AssertionError("Array is empty");
		}
		return polynomialDegree;
	}

	/**
	 * Returns the sum of this polynomial and the specified polynomial.
	 *
	 * @param that
	 *            the other polynomial
	 * @return the polynomial sum
	 */
	public String addPolynomial(Polynomial inputPolynomial) {
		if (polynomialCoefficient.length < 1
				|| inputPolynomial.polynomialCoefficient.length < 1) {
			throw new AssertionError("Array is empty");
		}
		int maxLength = Math.max(polynomialDegree + 1,
				inputPolynomial.polynomialDegree + 1);
		int minLength = Math.min(polynomialDegree + 1,
				inputPolynomial.polynomialDegree + 1);
		Polynomial sum = new Polynomial(new int[maxLength]);

		for (int i = 0; i < minLength; ++i) {
			sum.polynomialCoefficient[i] = polynomialCoefficient[i]
					+ inputPolynomial.polynomialCoefficient[i];

		}
		if (maxLength == polynomialCoefficient.length) {
			for (int i = minLength; i < maxLength; ++i) {
				sum.polynomialCoefficient[i] = polynomialCoefficient[i];
			}
		} else {
			for (int i = minLength; i < maxLength; ++i) {

				sum.polynomialCoefficient[i] = inputPolynomial.polynomialCoefficient[i];
			}
		}
		return getPolyString(sum);

	}

	/**
	 * Returns the product of this polynomial and the specified polynomial.
	 * Takes time proportional to the product of the degrees. (Faster algorithms
	 * are known, e.g., via FFT.)
	 *
	 * @param that
	 *            the other polynomial
	 * @return the polynomial multiplication
	 */
	public String multiPolynomial(Polynomial inputPolynomial) {
		if (polynomialCoefficient.length < 1
				|| inputPolynomial.polynomialCoefficient.length < 1) {
			throw new AssertionError("Array is empty");
		}
		Polynomial multi = new Polynomial(new int[polynomialDegree
				+ inputPolynomial.polynomialDegree + 1]);

		for (int i = 0; i <= polynomialDegree; ++i) {
			for (int j = 0; j <= inputPolynomial.polynomialDegree; ++j) {
				multi.polynomialCoefficient[i + j] += polynomialCoefficient[i]
						* inputPolynomial.polynomialCoefficient[j];
			}
		}

		return getPolyString(multi);
	}

	/**
	 * 
	 * @param inputPolynomial
	 * @return return string which show polynomial
	 */
	public String getPolyString(Polynomial inputPolynomial) {
		if (inputPolynomial.polynomialCoefficient.length < 1) {
			throw new AssertionError("Array is empty");
		}
		StringBuilder dispalyString = new StringBuilder();
		for (int i = inputPolynomial.polynomialCoefficient.length - 1; i > 0; i--) {
			dispalyString.append(inputPolynomial.polynomialCoefficient[i]
					+ "x^" + i + "+");
		}
		dispalyString.append(inputPolynomial.polynomialCoefficient[0]);
		return dispalyString.toString();
	}

}
