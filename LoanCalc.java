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