package com.products.apirest.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.products.apirest.models.Products;
import com.products.apirest.repository.ProductRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Products")
@CrossOrigin(origins="*")
public class ProductResource {

	@Autowired
	ProductRepository productRepository;
	
	@GetMapping("/products")
	@ApiOperation(value="Retorna uma lista com todos os produtos.")
	public List<Products> listProdcts(){
		return productRepository.findAll();
	}
	
	@GetMapping("/product/{id}")
	@ApiOperation(value="Retorna um produto para a id especificada.")
	public Products listOneProduct(@PathVariable(value="id") long id){
		return productRepository.findById(id);
	}
	
	@PostMapping("/product")
	@ApiOperation(value="Adiciona um novo produto ao banco.")
	public Products saveProduct(@RequestBody Products product) {
		return productRepository.save(product);
	}
	
	@DeleteMapping("/product")
	@ApiOperation(value="Deleta um produto do banco com a id especificada.")
	public void deleteProduct(@RequestBody Products product) {
		productRepository.delete(product);
	}
	
	@PutMapping("/product")
	@ApiOperation(value="Atualiza um produto do banco para a id especificada.")
	public Products Product(@RequestBody Products product) {
		return productRepository.save(product);
	}
	
}
