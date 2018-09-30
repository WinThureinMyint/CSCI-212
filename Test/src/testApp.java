
public class testApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] intArrray = { 4, 3, 5, 1, 7, 8, 3 };
		System.out.println(findMin(intArrray, intArrray.length, 0));
		
		System.out.println(sum(7));

	}

	public static int findMin(int array[], int size, int index) {
		if (index == size - 1)
			return array[index];
		int result = findMin(array, size, index + 1);
		if (array[index] < result)
			return array[index];
		else
			return result;
	}

	public static int sum(int num) {
		int result;
		if (num == 1)
			result = 1;
		else
			result = num + sum(num - 1);
		return result;
	}
}
