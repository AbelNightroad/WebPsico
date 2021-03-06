package manager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import modelo.Compromisso;
import persistence.AgendaDAO;


@Named
@ViewScoped
public class AgendaMB implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nomepac;
	private String nomepsic;
	private Date dataInicial = new Date();
	private Compromisso compromisso = new Compromisso();
	private List<Compromisso> agenda;

	@PostConstruct
	public void init() {
		Calendar calendar = Calendar.getInstance();
		int firstDay = calendar.getActualMinimum(Calendar.DATE);
		int lastDay = calendar.getActualMaximum(Calendar.DATE);

		calendar.set(Calendar.DATE, firstDay);
		Date inicio = calendar.getTime();

		calendar.set(Calendar.DATE, lastDay);
		Date fim = calendar.getTime();

		agenda = new AgendaDAO().buscaPorData(inicio, fim);
		
		if ((agenda == null) || !(agenda.size() > 0)) {
			agenda = new ArrayList<Compromisso>();
		}
	}

	public String getNomepac() {
		return nomepac;
	}

	public void setNomepac(String nomepac) {
		this.nomepac = nomepac;
	}

	public String getNomepsic() {
		return nomepsic;
	}

	public void setNomepsic(String nomepsic) {
		this.nomepsic = nomepsic;
	}

	public Compromisso getCompromisso() {
		return compromisso;
	}

	public void setCompromisso(Compromisso compromisso) {
		this.compromisso = compromisso;
	}

	public List<Compromisso> getAgenda() {
		return agenda;
	}

	public void setAgenda(List<Compromisso> agenda) {
		this.agenda = agenda;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public void salvarCompromisso() {
		try {
			compromisso = new AgendaDAO().salvar(compromisso);
			if (! agenda.contains(compromisso)) {
				agenda.add(compromisso);
			}else {
				int index = -1;
				for (int i = 0; i < agenda.size(); i++) {
					if (agenda.get(index).equals(compromisso)) {
						index = i;
					}
				}
				if (index >= 0) {
					agenda.set(index, compromisso);
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void removerCompromisso() {
		new AgendaDAO().delete(compromisso);
		agenda.remove(compromisso);
		compromisso = new Compromisso();
	}

}
