package test;
import test.ProductDAO;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PayNow
 */
public class PayNow extends HttpServlet {
	private static final long serialVersionUID = 102831973239L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	int product_id;
	int quantity;
	int remaining1;
	int remaining2;
	int remaining3;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		product_id=Integer.parseInt(request.getParameter("product_id"));
		quantity=Integer.parseInt(request.getParameter("quantity"));
		ProductDAO pdao=new ProductDAO();
		remaining1=pdao.searchProduct1(product_id, quantity);
		System.out.println("connected2..");
		if(remaining1>25)
		{
			out.println("stock available in store1..");
			out.println("items left are:"+" "+remaining1);
			pdao.updateInventory1(product_id, remaining1);
			out.println("<h1>Order Successfully Placed</h1>");
		}
			else{
				if(remaining1>0 && remaining1<=25)
				{
					pdao.requestWarehouse(1,product_id);
					out.println("requested warehouse and updated the inventory ..");
				}
				else if(remaining1==0)
				{
				
				//second store
		out.println("order redirected to next store..store2");
		remaining2=pdao.searchProduct2(product_id, quantity);
		if(remaining2>0)
		{
			out.println("stock available..in store2");
			out.println("items left are:"+" "+remaining2);
			pdao.updateInventory2(product_id, remaining2);
			out.println("<h1>Order Successfully Placed in store 2</h1>");
		}
			else if(remaining2==0){
				
				//third store
				out.println("order redirected to next store..store3");
				remaining3=pdao.searchProduct3(product_id, quantity);
				if(remaining3>0)
				{
					out.println("stock available..in store3");
					out.println("items left are:"+" "+remaining3);
					pdao.updateInventory3(product_id, remaining3);
					out.println("<h1>Order Successfully Placed in store 3</h1>");
				}
			}
				}	
		/*else{
		RequestDispatcher view= request.getRequestDispatcher("VerizonStores.html");
		view.forward(request,response);
		}*/
			
}
	}
}
		
