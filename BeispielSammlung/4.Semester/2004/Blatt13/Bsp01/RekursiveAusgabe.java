public class RekursiveAusgabe {

	public static void print1(int n) {
		System.out.println(n);
		if (n > 0) {
			print1(n-1);
		}
	}

	public static void print2(int n) {
		if (n > 0) {
			print2(n-1);
		}
		System.out.println(n);
	}

	public static void print3(int n) {
		System.out.println(n);
		if (n > 0) {
			print3(n-1);
			System.out.println(n);
		}
	}

	public static void main(String[] args) {
		System.out.println("-- Print1 --");
		print1(4);
		System.out.println("-- Print2 --");
		print2(4);
		System.out.println("-- Print3 --");
		print3(4);
	}
	
}
