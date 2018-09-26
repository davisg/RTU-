package PerfectNumber;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PerfectNumber {
	
  enum STATE {
        ABUNDANT,
        PERFECT,
        DEFICIENT,
        ERROR
	}
    
    public static STATE process(int n) {
    	return (n>0) ? STATE.values()[detect(n)+2] : STATE.ERROR;
    }
    public static Integer detect(Integer n) {
    	return Integer.signum(divisors(n).stream().filter(i -> i != n).collect(Collectors.summingInt(Integer::intValue)).compareTo(n));
	}
    
    public static Set<Integer> divisors(Integer n) {
    	Set<Integer> set = new HashSet<Integer>();
		set.addAll(IntStream.rangeClosed(2, (int)Math.ceil(Math.sqrt(n))).filter(i -> n % i == 0).flatMap(i -> IntStream.of(i, (int)(n/i))).boxed().collect(Collectors.toSet()));
		set.add(1);
		set.add(n);
		return set;
    }
    
	public static void main(String[] args) {
		Integer num;
		Scanner s = new Scanner(System.in);
		System.out.print("Enter a number: ");
		while (!s.hasNextInt()) s.next();
		num = s.nextInt();
		s.close();

		Consumer<STATE> output = (state) -> System.out.println("Number is - " + state.toString().toLowerCase() + ".");
		output.accept(process(num));
        }
}
