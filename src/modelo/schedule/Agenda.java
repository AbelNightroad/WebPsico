package modelo.schedule;

import javax.persistence.Embeddable;

import modelo.Paciente;
import modelo.Usuario;


@Embeddable
public class Agenda {
	private Usuario psicologa;
	private Paciente paciente;

	public Usuario getPsicologa() {
		return psicologa;
	}

	public void setPsicologa(Usuario psicologa) {
		this.psicologa = psicologa;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
}
