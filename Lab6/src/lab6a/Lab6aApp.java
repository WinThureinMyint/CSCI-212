package lab6a;

/**
 * <p>
 * Title: UnorderedArrayList Class 
 * </p>
 * 
 * <p>
 * Description: Writing	and	Testing	the	UnorderedArrayList	Class
 * </p>
 * 
 * <p>
 * Copyright: Copyright (c) 2018
 * </p>
 * 
 * @author Win Thurein Myint
 *
 */
import java.sql.*;

public class Lab6aApp {

	public static void main(String args[]) {
		UnorderedArrayList<Product> list1 = new UnorderedArrayList<>();
		list1.toString();
		UnorderedArrayList<Product> list2 = new UnorderedArrayList<>(5);
		list2.toString();
		Product prod = new Product("1", 1, 1);
		Product[] products;
		products = getData();
		for (int i = 0; i < products.length; i++) {
			list2.add(products[i]);
			System.out.println(products[i].toString());
		}
		// ##### No.10-11 - testSearch
		Product products1 = new Product("264j45", 15, 13.5);
		Product products2 = new Product("344d97", 15, 13.5);
		System.out.println(testSearch(products1, list2));
		System.out.println(testSearch(products2, list2));
		// System.out.println(list2.get((testSearch("264j45", list2))));
		// ##### No.12 -indexOf, lastIndexOf, and contains
		for (int i = 0; i < products.length; i++) {
			list1.add(products[i]);
		}
		list1.add(products1);
		System.out.println("The index of " + products1.getId() + " is: " + list1.indexOf(products1));
		System.out.println("The last index of " + products1.getId() + " is: " + list1.lastIndexOf(products1));
		if (list1.contains(products1))
			System.out.println(products1.getId() + " is contains");
		else
			System.out.println(products1.getId() + " is not contains");
		System.out.println(list1.toString());
		// ##### No.14
		System.out.println(testRemove(products1, list2));
		System.out.println(list2.toString());
		// ##### No.15
		System.out.println(testRemove(products2, list2));
		System.out.println(list2.toString());
		// ##### No.16
			//reset the array
			list2.clear();
			for (int i = 0; i < products.length; i++) {
				list2.add(products[i]);
			}
		// test remove an item that is found in the beginning of the list
			System.out.println(list2.toString());
		list2.remove(products1);
		System.out.println("Test remove an item "+products1.getId()+" that is found in the beginning of the list \n" + list2);
		//reset the array
			list1.clear();
			for (int i = 0; i < products.length; i++) {
				list1.add(products[i]);
			}
			list1.add(products1);
		// Test remove an item that is found in the end of the list
		System.out.println("List of before remove \n"+list1.toString());
		list1.remove(list1.lastIndexOf(products1));
		System.out.println("Test remove an item "+products1.getId()+" that is found in the end of the list \n" + list1);
		// Test remove a list with 1 item
		list1.clear();
		list1.add(products1);
		list1.remove(products1);
		System.out.println("After remove form a list with 1 item \n"+list1.toString());
		// Remove form an empty set
		System.out.println("Remove form an empty set \n"+list1.remove(products1));
		// ##### No.17
			// I don't get any error message. The output is not change because we have not used equal method at all in our main method.
	}

	/**
	 * to locate the position of a product in the list.
	 * 
	 * @param key
	 * @param ulist
	 * @return the location of the first occurrence of the specified item in this
	 *         list; if searchItem is not found, cannot find message is returned
	 */
	public static String testSearch(Product key, UnorderedArrayList<Product> ulist) {

		int index =  ulist.indexOf(key);
		if (index != -1) {
			return "ID of the product: " + key.getId() + "\n" + "The location is: " + index;
		}else {
			return "The Prodcut of Key " + key.getId() + " can't Found";
		}
		
	}

	/**
	 * to test the remove function
	 * @param key
	 * @param ulist
	 * @return the information of remove product is return.
	 */
	public static String testRemove(Product key, UnorderedArrayList ulist) {

		Product removeProduct = (Product) ulist.remove(key);
		if (removeProduct != null) {
			return "The id " + removeProduct.getId() + " have been removed";
		}else {
			return "The Prodcut of Key " + key.getId() + " can't find to remove";
		}
	}

	/**
	 * getData method -- gets the products from an SQLite database
	 * 
	 * @return the an array of products
	 */
	public static Product[] getData() {
		Statement stmt = null;
		int records = 0;
		Product[] products = null;
		try {
			Class.forName("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection("jdbc:sqlite:products.db");
			c.setAutoCommit(false);
			System.out.println("Opened database successfully");

			stmt = c.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * FROM products;");
			ResultSetMetaData rsmd = rs.getMetaData();

			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				System.out.print(String.format("%-12s", rsmd.getColumnLabel(i)) + "\t");
				System.out.print(rsmd.getColumnTypeName(i) + "\t");
				System.out.println(rsmd.getPrecision(i));
			}

			rs = stmt.executeQuery("select count (*) AS totalRecords from products");
			int totalRecords = rs.getInt("totalRecords");
			System.out.println("Records: " + totalRecords);

			rs = stmt.executeQuery("SELECT * FROM products;");
			if (rs != null) {
				products = new Product[totalRecords];
				while (rs.next()) {
					String prodId = rs.getString("prodId");
					int quantity = rs.getInt("quantity");
					double price = rs.getFloat("price");

					System.out.println(String.format("%3s %-6s %3d %6.2f", records, prodId, quantity, price));
					products[records++] = new Product(prodId, quantity, price);
				}
				System.out.println();
			}

			stmt.close();
			c.commit();
			c.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException se) {
			System.err.println(se.getClass().getName() + ": " + se.getMessage());
		}
		return products;
	}
}
