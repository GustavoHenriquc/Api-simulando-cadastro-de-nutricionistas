package br.com.nutrition.service;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.nutrition.repository.NutricionistaRepository;
import datasource.model.Nutricionista;

@Service
public class BuscaNutricionistasServiceImpl {
		

	@Autowired
	private NutricionistaRepository nutricionistaRepository;

	public List<Nutricionista> buscarTodosOsNutricionistas(){
		List<Nutricionista>listaNutricionista = nutricionistaRepository.findAll(); 
	return listaNutricionista;
	}

}
