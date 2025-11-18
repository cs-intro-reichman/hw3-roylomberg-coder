public class LoanCalc {
    static double epsilon = 0.001;
    static int iterationCounter;

    public static void main(String[] args) {
        double loan = Double.parseDouble(args[0]);
        double rate = Double.parseDouble(args[1]);
        int n = Integer.parseInt(args[2]);

        System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

        System.out.print("\nPeriodical payment, using brute force: ");
        System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
        System.out.println("number of iterations: " + iterationCounter);

        System.out.print("\nPeriodical payment, using bi-section search: ");
        System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
        System.out.println("number of iterations: " + iterationCounter);
    }

    // Computes the ending balance of a loan, given the loan amount, the periodical
    // interest rate (as a percentage), the number of periods (n),
    // and the periodical payment.
    private static double endBalance(double loan, double rate, int n, double payment) {
        for (int i = 0; i < n; i++) {
            loan -= payment;
            loan += loan * rate / 100.0;
        }
        return loan;
    }

    // Brute-force search for the periodical payment.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
        iterationCounter = 0;
        double payment = loan / n;
        double balance = endBalance(loan, rate, n, payment);

        while (balance > 0.0) {
            iterationCounter++;
            payment += epsilon;
            balance = endBalance(loan, rate, n, payment);
        }
        return payment;
    }

    // Bisection search for the periodical payment.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {
        iterationCounter = 0;

        double lowPayment = loan / n;
        double highPayment = loan;
        double paymentGuess = (lowPayment + highPayment) / 2.0;

        while (highPayment - lowPayment >= epsilon) {
            iterationCounter++;

            double balance = endBalance(loan, rate, n, paymentGuess);

            if (balance > 0) {
                lowPayment = paymentGuess;
            } else {
                highPayment = paymentGuess;
            }

            paymentGuess = (lowPayment + highPayment) / 2.0;
        }

        return paymentGuess;
    }
}