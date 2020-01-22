package com.project.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.pojos.Product;
import com.project.service.IProductService;

@RestController
@CrossOrigin
@RequestMapping("/product")
public class ProductController 
{
	@Autowired(required = true)
	private IProductService pservice;
	
	@PostConstruct
	public void myInit(){
		System.out.println(getClass().getName()+" ...created");
	}
	
	@PostMapping("/imageUpload")
	public ResponseEntity<?> imageUpload(@RequestBody MultipartFile[] fd)
	{
		System.out.println("imageUpload, called");
		//System.out.println(fd);
		return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
	}
	
	/*
	 * @PostMapping("/addProduct") public ResponseEntity<?>
	 * saveOrUpdateProduct(@RequestBody Product p){
	 * System.out.println("ProductController.saveOrUpdateProduct : "+p.getImage());
	 * try { pservice.saveOrUpdateProduct(p); return new
	 * ResponseEntity<String>("SUCCESS", HttpStatus.OK); } catch (RuntimeException
	 * e) { e.printStackTrace(); return new ResponseEntity<String>("FAILURE",
	 * HttpStatus.BAD_REQUEST); } }
	 */
	
	@PostMapping("/addProduct")
	public ResponseEntity<?> saveOrUpdateProduct(@RequestBody MultipartFile mpf){
		Product p = new Product();
		if(mpf.isEmpty())
			System.out.println("in saveOrUpdateProduct");
		//if(mpf != null)
			return new ResponseEntity<String>("MPF SUCCESS", HttpStatus.OK);
		//return new ResponseEntity<String>("MPF FAILURE", HttpStatus.BAD_REQUEST);
//		System.out.println(mpf.toString());
//		p.setName(mpd);
		
		/*
		 * System.out.println("ProductController.saveOrUpdateProduct : "+p.getImage());
		 * try { pservice.saveOrUpdateProduct(p); return new
		 * ResponseEntity<String>("SUCCESS", HttpStatus.OK); } catch (RuntimeException
		 * e) { e.printStackTrace(); return new ResponseEntity<String>("FAILURE",
		 * HttpStatus.BAD_REQUEST); }
		 */		
	}
	
	@GetMapping("/{gtin}")
	public ResponseEntity<?> getProductById(@RequestParam int gtin){
		try {
			return new ResponseEntity<Product>(pservice.getProductById(gtin),HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("No such Product found!!!",HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/deleteProduct")
	public ResponseEntity<?> deleteProduct(@PathVariable int productId)
	{
		if(pservice.deleteProductById(productId))
			return new ResponseEntity<String>("Product Deleted Successfully!!!", HttpStatus.OK);
		return new ResponseEntity<String>("Failed to Delete the product!!!", HttpStatus.BAD_REQUEST);
	}
}
