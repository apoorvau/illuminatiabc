package test;
import test.Product;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.OracleDriver;

public class ProductDAO {

	Connection conn;
	private	PreparedStatement pst;
		ResultSet rs;
  int count1;
  int remaining;
		public void getConnection()
		{
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				String url="jdbc:oracle:thin:@localhost:1521:xe";
				conn=DriverManager.getConnection(url,"illuminati", "manager");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}

		public int searchProduct1(int product_id,int quantity)
		{
			Product pr=new Product();
			getConnection();
			System.out.println("connected..");
			int pid=product_id;
			count1=quantity;
			System.out.println("hi");
			
			try {
				pst=conn.prepareStatement("select * from inventory_details where product_id=? and store_id=1");
				pst.setInt(1,pid);
				rs=pst.executeQuery();
				System.out.println("connected1..");
				while(rs.next())
				{
					System.out.println(""+rs.getInt(3));
				
					remaining=rs.getInt(3)-count1;
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return remaining;
		}
		
		public void updateInventory1(int prod_id,int remaining)
		{
			int product_id=prod_id;
			getConnection();
			try {
				pst=conn.prepareStatement("update inventory_details set available_stock=? where product_id=? and store_id=1");
				pst.setInt(1,remaining);
				pst.setInt(2,product_id);
				rs=pst.executeQuery();
				System.out.println("stock updated..");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public void requestWarehouse(int store_id,int prod_id)
		{
			int storeId=store_id;
			int product_id=prod_id;
			getConnection();
			try {
				pst=conn.prepareStatement("update inventory_details set available_stock=? where product_id=? and store_id=1");
				pst.setInt(1,remaining+200);
				pst.setInt(2,product_id);
				rs=pst.executeQuery();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}


		public int searchProduct2(int product_id, int quantity) {
			getConnection();
			System.out.println("connected..");
			int pid=product_id;
			count1=quantity;
			System.out.println("hi");
			
			try {
				pst=conn.prepareStatement("select * from inventory_details where product_id=? and store_id=2");
				pst.setInt(1,pid);
				rs=pst.executeQuery();
				while(rs.next())
				{
					System.out.println(""+rs.getInt(3));
				
					remaining=rs.getInt(3)-count1;
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return remaining;
			
		}

		public void updateInventory2(int prod_id, int remaining) {
			
			 int product_id=prod_id;
			getConnection();
			try {
				pst=conn.prepareStatement("update inventory_details set available_stock=? where product_id=? and store_id=2");
				pst.setInt(1,remaining);
				pst.setInt(2,product_id);
				rs=pst.executeQuery();
				System.out.println("stock updated..");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		//product3
		
		public int searchProduct3(int product_id,int quantity)
		{
			Product pr=new Product();
			getConnection();
			System.out.println("connected..");
			int pid=product_id;
			count1=quantity;
			System.out.println("hi");
			
			try {
				pst=conn.prepareStatement("select * from inventory_details where product_id=? and store_id=3");
				pst.setInt(1,pid);
				rs=pst.executeQuery();
				System.out.println("connected3..");
				while(rs.next())
				{
					System.out.println(""+rs.getInt(3));
				
					remaining=rs.getInt(3)-count1;
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return remaining;
		}
		
		public void updateInventory3(int prod_id, int remaining) {
			
			 int product_id=prod_id;
			getConnection();
			try {
				pst=conn.prepareStatement("update inventory_details set available_stock=? where product_id=? and store_id=3");
				pst.setInt(1,remaining);
				pst.setInt(2,product_id);
				rs=pst.executeQuery();
				System.out.println("stock updated..");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
}
