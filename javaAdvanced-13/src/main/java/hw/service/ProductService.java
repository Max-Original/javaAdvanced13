package hw.service;

import java.util.Map;

import hw.domain.Product;
import hw.shared.AbstractCRUD;

public interface ProductService extends AbstractCRUD<Product>{
	public Map<Integer, Product> readAllMap();
}
