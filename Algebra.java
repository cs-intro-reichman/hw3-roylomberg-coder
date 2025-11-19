// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

    private static int negate(int x) {
        int res = 0;
        if (x > 0) {
            while (x > 0) {
                res--;
                x--;
            }
        } else if (x < 0) {
            while (x < 0) {
                res++;
                x++;
            }
        }
        return res;
    }

    private static int abs(int x) {
        if (x >= 0) {
            return x;
        }
        return negate(x);
    }

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
        int result = x1;
        if (x2 > 0) {
            while (x2 > 0) {
                result++;
                x2--;
            }
        } else {
            while (x2 < 0) {
                result--;
                x2++;
            }
        }
        return result;
    }
		

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
        return plus(x1, negate(x2));
    }

	// Returns x1 * x2
	public static int times(int x1, int x2) {
        if (x1 == 0 || x2 == 0) {
            return 0;
        }

        boolean negative = (x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0);

        int a = abs(x1);
        int b = abs(x2);
        int result = 0;
        int i = 0;

        while (i < b) {
            result = plus(result, a);
            i++;
        }

        if (negative) {
            result = negate(result);
        }

        return result;
    }

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
        int result = 1;
        int i = 0;
        while (i < n) {
            result = times(result, x);
            i++;
        }
        return result;
    }

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
        if (x2 == 0) {
            return 0; // not defined, but tests should not use this case
        }
        if (x1 == 0) {
            return 0;
        }

        boolean negative = (x1 < 0 && x2 > 0) || (x1 > 0 && x2 < 0);

        int dividend = abs(x1);
        int divisor = abs(x2);
        int result = 0;

        while (dividend >= divisor) {
            dividend = minus(dividend, divisor);
            result = plus(result, 1);
        }

        if (negative) {
            result = negate(result);
        }

        return result;
    }

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
        if (x2 == 0) {
            return 0; // undefined mathematically, but safe fallback
        }
        int q = div(x1, x2);
        int prod = times(q, x2);
        int r = minus(x1, prod);
        return r;
    }	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        int z = 0;
        while (times(z, z) <= x) {
            z = plus(z, 1);
        }
        z = minus(z, 1);
        return z;
    }	  	  
}