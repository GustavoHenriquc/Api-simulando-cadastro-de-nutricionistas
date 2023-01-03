package br.com.nutrition.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import br.com.nutrition.exception.NutricionistaResourceExeption;
import br.com.nutrition.repository.NutricionistaRepository;
import br.com.nutrition.rousource.model.NutricionistaResource;
import datasource.model.Nutricionista;


@Service
public class CadastroNutricionistaServiceImpl {
	@Autowired
	private NutricionistaRepository nutricionistarepository;
	
	@Autowired
	private NutricionistaConversor service;
	
	
	public void cadastro(NutricionistaResource NutricionistaResource) {
	
	try {
		Nutricionista nutricionista = service.conversor(NutricionistaResource);
		nutricionistarepository.saveAndFlush(nutricionista);
	} catch (NutricionistaResourceExeption e) {
		e.printStackTrace();
	}	
	
	
	}
	
}
