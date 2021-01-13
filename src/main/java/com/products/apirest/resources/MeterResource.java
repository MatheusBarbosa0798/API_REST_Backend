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
import com.products.apirest.models.Meters;
import com.products.apirest.repository.MeterRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api")
@Api(value="API REST Meters")
@CrossOrigin(origins="*")
public class MeterResource {

	@Autowired
	MeterRepository meterRepository;
	
	@GetMapping("/meters")
	@ApiOperation(value="Retorna uma lista com todos os produtos.")
	public List<Meters> listProdcts(){
		return meterRepository.findAll();
	}
	
	@GetMapping("/meter/{id}")
	@ApiOperation(value="Retorna um produto para a id especificada.")
	public Meters listOneProduct(@PathVariable(value="id") long id){
		return meterRepository.findById(id);
	}
	
	@PostMapping("/meter")
	@ApiOperation(value="Adiciona um novo produto ao banco.")
	public Meters saveProduct(@RequestBody Meters product) {
		return meterRepository.save(product);
	}
	
	@DeleteMapping("/meter")
	@ApiOperation(value="Deleta um produto do banco com a id especificada.")
	public void deleteProduct(@RequestBody Meters product) {
		meterRepository.delete(product);
	}
	
	@PutMapping("/meter")
	@ApiOperation(value="Atualiza um produto do banco para a id especificada.")
	public Meters Product(@RequestBody Meters product) {
		return meterRepository.save(product);
	}
	
}
