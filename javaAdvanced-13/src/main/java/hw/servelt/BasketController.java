package hw.servelt;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hw.domain.Basket;
import hw.domain.Product;
import hw.domain.UserAccount;
import hw.service.BasketService;
import hw.service.ProductService;
import hw.service.UserAccountService;
import hw.service.impl.BasketServiceImpl;
import hw.service.impl.ProductServiceImpl;
import hw.service.impl.UserAccountServiceImpl;


@WebServlet("/basket")
public class BasketController extends HttpServlet {

	private static final long serialVersionUID = 1L;
    private BasketService basketService = BasketServiceImpl.getBasketService();  
    private ProductService productService = ProductServiceImpl.getProductService();
    private UserAccountService userAccountService = UserAccountServiceImpl.getUserAccountService();
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String productId = request.getParameter("productId");
	
	Product product = productService.read(Integer.parseInt(productId));
	
	HttpSession session = request.getSession();
	Integer userId = (Integer)session.getAttribute("userId");
	UserAccount user = userAccountService.read(userId);

	Basket basket = new Basket();
	basket.setId(UUID.randomUUID().toString());
	basket.setProduct(product);
	basket.setUser(user);
	basket.setDate_purchase(new Date());
	
	basketService.creat(basket);
	
	response.setContentType("type");
	response.setCharacterEncoding("UTF-8");
	response.getWriter().write("Success");
	
	
	
	}

	protected void doDelete(HttpServletRequest request,HttpServletResponse response) throws IOException {
		String basketId = request.getParameter("basketId");
		
		basketService.delete(Integer.parseInt(basketId));
		
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}
}
