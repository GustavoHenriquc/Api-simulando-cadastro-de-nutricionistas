package datasource.model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="nutricionista")
public class Nutricionista implements Serializable{
		
	private static final long serialVersionUID = 1799437134009423228L;

		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		
		@Column(name="nome")
		private String nome;
		private LocalDate idade;
		
		@Column(name="codigo_registro")
		private String codigoRegistro;
		
		@Column(name="id_paciente")
		private Long idPaciente;
		
			
		public Nutricionista(String nome, LocalDate idade, String codigoRegistro, Long idPaciente) {
			this.nome = nome;
			this.idade = idade;
			this.codigoRegistro = codigoRegistro;
			this.idPaciente = idPaciente;
		}
		
		public Nutricionista() {
		}
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public LocalDate getIdade() {
			return idade;
		}
		public void setIdade(LocalDate idade) {
			this.idade = idade;
		}
		public String getCodigoRegistro() {
			return codigoRegistro;
		}
		public void setCodigoRegistro(String codigoRegistro) {
			this.codigoRegistro = codigoRegistro;
		}
		public Long getIdPaciente() {
			return idPaciente;
		}
		public void setIdPaciente(Long idPaciente) {
			this.idPaciente = idPaciente;
		}
		


	}


