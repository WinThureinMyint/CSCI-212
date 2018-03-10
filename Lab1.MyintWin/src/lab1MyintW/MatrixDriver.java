package lab1MyintW;
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
		Matrix a1 = new Matrix(new int[][]{{1,2},{2,0}});
		Matrix b1 = new Matrix(new int[][]{{1,2},{2,0}});
		Matrix c1 = new Matrix(new int[][]{{1,2},{2,0}});
		System.out.println("1 : "+a1.equal(a1.transpose().transpose()));
		System.out.println("2 : "+a1.sub(b1).transpose().equal(a1.transpose().sub(b1.transpose())));
		System.out.println("3 : "+a1.mult(2).transpose().equal(a1.transpose().mult(2)));
		System.out.println("4 : "+a1.mult(b1).transpose().equal(b1.transpose().mult(a1.transpose())));
		System.out.println("5 : "+a1.mult(b1).equal(b1.mult(a1)));
		System.out.println("6 : "+a1.mult(b1.mult(c1)).equal((a1.mult(b1)).mult(c1)));
		System.out.println("7 : "+a1.mult(b1.add(c1)).equal(a1.mult(b1).add(a1.mult(c1))));
		System.out.println("8 : "+(a1.add(b1)).mult(c1).equal(a1.mult(c1).add(b1.mult(c1))));
		System.out.println("9 : "+((a1.mult(2).mult(b1)).equal(a1.mult(b1).mult(2))==a1.mult(2).mult(b1).equal(a1.mult(b1.mult(2)))));
		
//End of 1-9
		Matrix a = new Matrix(new int[][]{{1,-2,4},{1,-1,0}});
		Matrix b = new Matrix(new int[][]{{3,4},{5,-1},{1,-1}});
		Matrix c = new Matrix(new int[][]{{4,-1,2},{-1,5,1}});
		Matrix d = new Matrix(new int[][]{{-1,0,1},{0,2,1}});
		Matrix e = new Matrix(new int[][]{{3,4},{-2,3},{2,-1}});
		Matrix f = new Matrix(new int[][]{{2},{-3}});
		Matrix g = new Matrix(new int[][]{{2},{-1}});
		try {
			System.out.println("\n3C − 4D  :\n"+c.mult(3).sub(d.mult(4)));
		}catch(Exception exception) {
			System.out.println("3C − 4D  :"+exception.getMessage()+"\n");
		}
		try {
			System.out.println("A − (D + 2C)  :\n"+a.sub(d.add(c.mult(2))));
		}catch(Exception exception) {
			System.out.println("A − (D + 2C)  :"+exception.getMessage()+"\n");
		}
		try {
			System.out.println("A − E :\n"+a.sub(e));
		}catch(Exception exception) {
			System.out.println("A − E :"+exception.getMessage()+"\n");
		}
		try {
			System.out.println("AE :\n"+a.mult(e));
		}catch(Exception exception) {
			System.out.println("AE :"+exception.getMessage()+"\n");
		}
		try {
			System.out.println("3BC − 4BD  :\n"+(b.mult(3).mult(c)).sub(b.mult(d).mult(4)));
		}catch(Exception exception) {
			System.out.println("3BC − 4BD  :"+exception.getMessage()+"\n");
		}
		try {
			System.out.println("CB + D :\n"+c.mult(b).add(d));
		}catch(Exception exception) {
			System.out.println("CB + D :"+exception.getMessage()+"\n");
		}
		try {
			System.out.println("GC :\n"+g.mult(c));
		}catch(Exception exception) {
			System.out.println("GC :"+exception.getMessage()+"\n");
		}
		try {
			System.out.println("FG :\n"+f.mult(g));
		}catch(Exception exception) {
			System.out.println("FG :"+exception.getMessage()+"\n");
		}
		try {
			System.out.println("C^2 :\n"+c.mult(c));
		}catch(Exception exception) {
			System.out.println("C^2 :"+exception.getMessage()+"\n");
		}
		try {
			System.out.println("C+D :\n"+c.add(d));
		}catch(Exception exception) {
			System.out.println("C+D :"+exception.getMessage()+"\n");
		}		
	}
}
