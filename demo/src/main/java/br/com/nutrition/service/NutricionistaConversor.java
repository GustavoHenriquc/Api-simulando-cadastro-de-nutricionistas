package br.com.nutrition.service;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import br.com.nutrition.exception.NutricionistaResourceExeption;
import br.com.nutrition.rousource.model.NutricionistaResource;
import datasource.model.Nutricionista;

@Component
public class NutricionistaConversor {
	
	public Nutricionista conversor(
			NutricionistaResource nutricionistaResource) throws NutricionistaResourceExeption {
		try {
			
		Nutricionista nutricionista = new Nutricionista();
			
		Long idPaciente = checkIdPaciente(nutricionistaResource.getIdPaciente());
		
		LocalDate idade = checkIdade(nutricionistaResource.getIdade());
		nutricionista.setIdPaciente(idPaciente);
		nutricionista.setIdade(idade);
		nutricionista.setCodigoRegistro(nutricionistaResource.getCodigoRegistro());
		nutricionista.setNome(nutricionistaResource.getNome());
		return nutricionista;
		
		
		} catch(Exception e) {
			throw new NutricionistaResourceExeption("Falha ao converter o resource para entidade, resource; ");
		}
	}
	private Long checkIdPaciente(String idPaciente) {
		return Long.parseLong(idPaciente);
	}
	
	private LocalDate checkIdade(String idade) {
		return LocalDate.parse(idade);
	}
	}
