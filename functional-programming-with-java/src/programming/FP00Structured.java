package programming;

import java.util.List;
import java.util.stream.Collectors;

public class FP00Structured {

	public static void main(String[] args) {

		//printAllNumberinListStructured(List.of(12,9,13,11,4,6,2,4,12,15));
		//printAllNumberinListFunctional(List.of(12,9,13,11,4,6,2,4,12,15));
		//printEvenNumberinListFunctional(List.of(12,9,13,11,4,6,2,4,12,15));
		//printOddNumberinListFunctional(List.of(12,9,13,11,4,6,2,4,12,15));
		//printSquareOfEvenNumberinListFunctional(List.of(12,9,13,11,4,6,2,4,12,15));
		//printCubeOfOddNumbersInListFunctional(List.of(12,9,13,11,4,6,2,4,12,15));
		List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernates");
		//printAllCourses(courses);
		//printCoursesWithSpring(courses);
		//printCoursesWithAtleastFourChar(courses);
		printNumberOfChars(courses);
	}

	private static void printNumberOfChars(List<String> courses) {
		
		courses.stream().map(s -> s +": "+s.length()).forEach(System.out::println);
		
	}

	private static void printCubeOfOddNumbersInListFunctional(List<Integer> numbers) {
		
		numbers.stream().filter(n->n%2!=0).map(x->x*x*x).forEach(System.out::println);
		
	}

	private static void printSquareOfEvenNumberinListFunctional(List<Integer> numbers) {
		
		numbers.stream().filter(x->x%2==0).map(n->n*n).forEach(System.out::println);
	}

	private static void printCoursesWithAtleastFourChar(List<String> courses) {
		courses.stream().filter(s->s.length()>=4).forEach(System.out::println);
		
	}

	private static void printCoursesWithSpring(List<String> courses) {
		courses.stream().filter(s -> s.contains("Spring")).forEach(System.out::println);
		
	}

	private static void printAllCourses(List<String> courses) {
		courses.stream().forEach(System.out::println);
		
	}

	private static void printOddNumberinListFunctional(List<Integer> numbers) {
		
		numbers.stream().filter(n -> n%2 != 0).forEach(System.out::println);
	}

	private static void printEvenNumberinListFunctional(List<Integer> numbers) {
		
		numbers.stream().filter(i -> i%2==0).forEach(System.out::println);
	}

	private static void printAllNumberinListFunctional(List<Integer> numbers) {
		
		numbers.stream().forEach(System.out::println);
		
	}

	private static void printAllNumberinListStructured(List<Integer> numbers) {
		for(int num: numbers) {
			System.out.println(num);
		}
		
	}

}
