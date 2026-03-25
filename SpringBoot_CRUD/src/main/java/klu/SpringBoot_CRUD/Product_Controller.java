package klu.SpringBoot_CRUD;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class Product_Controller {
	
	private final Product_Service ps;
	
	public Product_Controller(Product_Service product_ser) {
		this.ps=product_ser;
}
	
	@PostMapping("/add")
	public Product addproduct(@RequestBody Product product) {
		return ps.addproduct(product);
	}
	
	 @GetMapping("/display")
	    public List<Product> getAllProducts() {
	        return ps.getallproducts();
	    }
	
	 @GetMapping("/byid/{id}")
	 public Product getbyid(@PathVariable Long id) {
		 return ps.getProductbyid(id);
	 }
	 
	// UPDATE Product
	    @PutMapping("update/{id}")
	    public Product updateProduct(@PathVariable Long id,
	                                 @RequestBody Product product) {
	        return ps.updateProduct(id, product);
	    }
	    
	    @DeleteMapping("/delete/{id}")
	    public String deletebyid(@PathVariable Long id) {
	    	ps.deletebyid(id);
	    	return " Product Deleted Successfully";
	    }
	    
	 // UPDATE BY (price by name) 
	    @PutMapping("/updatePrice/{name}/{price}") 
	    public String updatePrice(@PathVariable String name, @PathVariable Double price) 
	    { 
	      int updated = ps.updateProductPriceByName(name, price); 
	      return updated > 0 ? "Price updated successfully" : "No product found with given name"; 
	    }
	    
	 // COUNT BY id 
	    @GetMapping("/countById/{id}") 
	    public ResponseEntity<Long> countById(@PathVariable Long id) { 
	      long count = ps.countProductById(id); 
	      if (count > 0) {   
	        return ResponseEntity.ok(count); 
	      } 
	      else { 
	        return ResponseEntity.status(HttpStatus.NOT_FOUND) .body(count); 
	      } 
	    }
}