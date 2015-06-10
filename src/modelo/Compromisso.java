package modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import persistence.EntidadeBase;

@Entity
public class Compromisso implements Serializable, EntidadeBase{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	private Usuario psicologa;
	
	@OneToOne
	private Paciente paciente;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataMarcado;
	
	@Override
	public Integer getId() {
		return id;
	}
	
}
