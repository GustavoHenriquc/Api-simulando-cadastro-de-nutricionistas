package br.com.nutrition.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nutrition.exception.NutricionistaNotFoundException;
import br.com.nutrition.repository.NutricionistaRepository;
import br.com.nutrition.rousource.model.NutricionistaResource;
import br.com.nutrition.service.BuscaNutricionistasServiceImpl;
import br.com.nutrition.service.BuscarNutricionistaPorIdServiceImpl;
import br.com.nutrition.service.CadastroNutricionistaServiceImpl;
import datasource.model.Nutricionista;

@RestController
@RequestMapping(value = "/api")
public class NutricionistaController {
	
	
	
	@Autowired
	private BuscaNutricionistasServiceImpl serviceBuscar;
	
	@Autowired
	private CadastroNutricionistaServiceImpl serviceCadastro;
	
	@Autowired
	private BuscarNutricionistaPorIdServiceImpl serviceBuscarPorId;
	
	@GetMapping(path = "/nutricionista")
	public List<Nutricionista> buscarNutricionistas() {
		return serviceBuscar.buscarTodosOsNutricionistas();
	}

	@GetMapping(path = "/nutricionista/id/{id}")
	public Nutricionista buscarNutricionistasPorId(@PathVariable(name="id", required = true) Long id) throws NutricionistaNotFoundException {
		return serviceBuscarPorId.buscarPorId(id);
	}
	
	@PostMapping(path="nutricionista/save")
	public void salvarNutricionista(@RequestBody NutricionistaResource nutricionista) {
		serviceCadastro.cadastro(nutricionista);
	}
	
	@DeleteMapping(path ="/nutricionista/delete/{id}")
	public void deleteNutricionista (@PathVariable (name="id", required = true) Long id) throws NutricionistaNotFoundException {
		serviceBuscarPorId.deletarPorId(id);
	}
}
