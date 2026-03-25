package klu.SpringBoot_CRUD;

import java.util.Optional;

import java.util.List;   
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;


@SuppressWarnings("unused")
@Service
public class Product_Service {
	private final Product_Repository pr;
	public Product_Service(Product_Repository product_rep) {
				this.pr=product_rep;
	}

	//create
	public Product addproduct(Product product) {
		return pr.save(product);
	}
	
	//retrieve
	
	public List<Product>getallproducts(){
		return pr.findAll();
	}
	
	//by id
	public Product getProductbyid(Long id) {
	    Optional<Product> product = pr.findById(id);
	    
	    if (product.isPresent()) {
	        return product.get();
	    } else {
	        throw new RuntimeException("Product not found with id: " + id);
	    }
	}
	
	// UPDATE
    public Product updateProduct(Long id, Product product) {
        Product existing = pr.findById(id).orElse(null);
        if (existing != null) {
            existing.setName(product.getName());
            existing.setPrice(product.getPrice());
            
            return pr.save(existing);
        }
        return null;
    }
    
    //delete
    public void deletebyid(Long id) {
    	pr.deleteById(id);
    }
    
    //update by
    public int updateProductPriceByName(String name, Double price) { 
      return pr.updatePriceByName(price, name); }
	
    //count by
    public long countProductById(Long id) { 
      return pr.countById(id); }   
}