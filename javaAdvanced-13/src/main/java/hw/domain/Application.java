package hw.domain;

import hw.service.BasketService;
import hw.service.ProductService;
import hw.service.UserAccountService;
import hw.service.impl.BasketServiceImpl;
import hw.service.impl.ProductServiceImpl;
import hw.service.impl.UserAccountServiceImpl;

public class Application {

	public static void main(String[] args) {
		
		
		BasketService basketService = BasketServiceImpl.getBasketService();
		ProductService productService = ProductServiceImpl.getProductService();
		UserAccountService userService = UserAccountServiceImpl.getUserAccountService();
		
//		userService.delete(20);
//		productService.delete(1);
//		System.out.println(read);
		
		 basketService.delete(15);
		//System.out.println(read);
//		List<Basket> readAll = basketService.readAll();
//		System.out.println(readAll);
	}

}
