package lab0;

public class test {
	public static void main(String[] args) {
		System.out.print("a");
		try {
			System.out.print("b");
			throw new RuntimeException();
		}catch(RuntimeException e) {
			System.out.print("e");
		}finally {
			
		}
	}
}
