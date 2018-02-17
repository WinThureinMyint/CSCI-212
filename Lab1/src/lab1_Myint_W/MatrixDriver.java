package lab1_Myint_W;
/**
*   <b>Title:</b> Lab 1<br>
*   <b>Filename:</b> Matix.java<br>
*   <b>Date Written:</b> February 18, 2018<br>
*   <b>Due Date:</b> February 24, 2018<br>
*   <p>
*   <b>Description:</b><br>
*    The Matrix class that implements addition, subtraction, multiplication, scalar
multiplication, equal, and transpose methods for m x n matrices
*   </p>

*   <p><b>Algorithm:</b></p>
*   <p>
*   Arithmetic operations such as addition and multiplication are defined for matrices. For
example, two matrices may be added or multiplied together to yield a new matrix. </p>
* 	@author Win Thurein Myint
*/
public class MatrixDriver {
	public static void main(String[] args) {
		Matrix a = new Matrix(new int[][]{{1,2},{2,0}});
		Matrix b = new Matrix(new int[][]{{1,2},{2,0}});
		Matrix c = new Matrix(new int[][]{{1,2},{2,0}});
		System.out.println("1 : "+a.equal(a.transpose().transpose()));
		System.out.println("2 : "+a.sub(b).transpose().equal(a.transpose().sub(b.transpose())));
		System.out.println("3 : "+a.mult(2).transpose().equal(a.transpose().mult(2)));
		System.out.println("4 : "+a.mult(b).transpose().equal(b.transpose().mult(a.transpose())));
		System.out.println("5 : "+a.mult(b).equal(b.mult(a)));
		System.out.println("6 : "+a.mult(b.mult(c)).equal((a.mult(b)).mult(c)));
		System.out.println("7 : "+a.mult(b.add(c)).equal(a.mult(b).add(a.mult(c))));
		System.out.println("8 : "+(a.add(b)).mult(c).equal(a.mult(c).add(b.mult(c))));
		System.out.println("9 : "+((a.mult(2).mult(b)).equal(a.mult(b).mult(2))==a.mult(2).mult(b).equal(a.mult(b.mult(2)))));
		
//End of 1-9
		Matrix A = new Matrix(new int[][]{{1,-2,4},{1,-1,0}});
		Matrix B = new Matrix(new int[][]{{3,4},{5,-1},{1,-1}});
		Matrix C = new Matrix(new int[][]{{4,-1,2},{-1,5,1}});
		Matrix D = new Matrix(new int[][]{{-1,0,1},{0,2,1}});
		Matrix E = new Matrix(new int[][]{{3,4},{-2,3},{2,-1}});
		Matrix F = new Matrix(new int[][]{{2},{-3}});
		Matrix G = new Matrix(new int[][]{{2},{-1}});
		try {
			System.out.println("\n3C − 4D  :\n"+C.mult(3).sub(D.mult(4)));
		}catch(Exception e) {
			System.out.println("3C − 4D  :"+e.getMessage()+"\n");
		}
		try {
			System.out.println("A − (D + 2C)  :\n"+A.sub(D.add(C.mult(2))));
		}catch(Exception e) {
			System.out.println("A − (D + 2C)  :"+e.getMessage()+"\n");
		}
		try {
			System.out.println("A − E :\n"+A.sub(E));
		}catch(Exception e) {
			System.out.println("A − E :"+e.getMessage()+"\n");
		}
		try {
			System.out.println("AE :\n"+A.mult(E));
		}catch(Exception e) {
			System.out.println("AE :"+e.getMessage()+"\n");
		}
		try {
			System.out.println("3BC − 4BD  :\n"+(B.mult(3).mult(C)).sub(B.mult(D).mult(4)));
		}catch(Exception e) {
			System.out.println("3BC − 4BD  :"+e.getMessage()+"\n");
		}
		try {
			System.out.println("CB + D :\n"+C.mult(B).add(D));
		}catch(Exception e) {
			System.out.println("CB + D :"+e.getMessage()+"\n");
		}
		try {
			System.out.println("GC :\n"+G.mult(C));
		}catch(Exception e) {
			System.out.println("GC :"+e.getMessage()+"\n");
		}
		try {
			System.out.println("FG :\n"+F.mult(G));
		}catch(Exception e) {
			System.out.println("FG :"+e.getMessage()+"\n");
		}
		try {
			System.out.println("C^2 :\n"+C.mult(C));
		}catch(Exception e) {
			System.out.println("C^2 :"+e.getMessage()+"\n");
		}
		try {
			System.out.println("C+D :\n"+C.add(D));
		}catch(Exception e) {
			System.out.println("C+D :"+e.getMessage()+"\n");
		}		
	}
}
