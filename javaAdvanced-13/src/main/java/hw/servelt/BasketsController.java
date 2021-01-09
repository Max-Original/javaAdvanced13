package hw.servelt;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dto.BasketDto;
import hw.domain.Basket;
import hw.domain.Product;
import hw.service.BasketService;
import hw.service.ProductService;
import hw.service.impl.BasketServiceImpl;
import hw.service.impl.ProductServiceImpl;


@WebServlet("/baskets")
public class BasketsController extends HttpServlet {
	
	private BasketService basketService = BasketServiceImpl.getBasketService();
	private ProductService productService = ProductServiceImpl.getProductService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	List<Basket> baskets = basketService.readAll();
	Map<Integer, Product> idToProduct = productService.readAllMap();
	List<BasketDto> listOfBasketDtos = map(baskets, idToProduct);
	
	String json = new Gson().toJson(listOfBasketDtos);
	response.setContentType("application/json");
	response.setCharacterEncoding("UTF-8");
	response.getWriter().write(json);
	
}

	public List<BasketDto> map (List<Basket> baskets,Map<Integer,Product> idToProduct){
		return baskets.stream().map(basket->{
			BasketDto basketDto = new BasketDto();
			basketDto.basketId = basket.getId();
			basketDto.purchaseDate = basket.getDate_purchase();
			
			Product product = idToProduct.get(basket.getProduct().getId());
			basketDto.name = product.getName();
			basketDto.description = product.getDescription();
			basketDto.price = product.getPrice();
		
			return basketDto;
		}).collect(Collectors.toList());
	}


} 


