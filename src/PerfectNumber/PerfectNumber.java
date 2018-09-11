package PerfectNumber;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PerfectNumber {
	
  enum STATE {
        ABUNDANT,
        PERFECT,
        DEFICIENT,
        ERROR
	}
    
    public static STATE process(int n) {
        switch(detect(n)) {
            case 0:
                return STATE.DEFICIENT;
            case 1:
                return STATE.PERFECT;
            case 2:
                return STATE.ABUNDANT;
            default:
                return STATE.ERROR;
        }
    }
    public static Integer detect(Integer n) {
        if (n <= 0)
            return -1;

        Set<Integer> set = divisors(n);
        int sum = 0;

        for (int i : set) {
            if ( i != n )
                sum += i; 
        }

        if (sum < n)
            return 0;
        else if (sum == n)
            return 1;
        else
            return 2;
	}
    
    public static Set<Integer> divisors(Integer n) {
        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        for(int i = 1; i <= n; i++) {
                if(n % i == 0) set.add(i);
        }

        return set;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  Integer number;
        try (Scanner reader = new Scanner(System.in)) {
            System.out.print("Enter a number:");
            while (!reader.hasNextInt())
                reader.next();
            number = reader.nextInt();
        }

        switch(process(number)) {
            case ABUNDANT: System.out.println("Number " + number.toString() + " Is abundant."); break;
            case DEFICIENT: System.out.println("Number " + number.toString() + " Is deficient."); break;
            case PERFECT: System.out.println("Number " + number.toString() + " Is perfect."); break;
            default: System.out.println("Input is not valid.");
        }
	}
}
