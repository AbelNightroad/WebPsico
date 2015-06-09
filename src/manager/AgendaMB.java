package manager;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import modelo.schedule.Agenda;
import modelo.schedule.AgendaEvent;
import modelo.schedule.LazyModel;


@Named
@ViewScoped
public class AgendaMB implements Serializable {
	private static final long serialVersionUID = 1L;

	private AgendaEvent agendaEvent = new AgendaEvent();
	private LazyModel lazyEventModel;
	private Agenda agenda;
	
	@PostConstruct
	public void init() {
		Calendar calendar = Calendar.getInstance();
		int firstDay = calendar.getActualMinimum(Calendar.DATE);
	    int lastDay = calendar.getActualMaximum(Calendar.DATE);

	    calendar.set(Calendar.DATE, firstDay);
	    Date inicio = calendar.getTime();
	    
	    calendar.set(Calendar.DATE, lastDay);
	    Date fim = calendar.getTime();
	    
		lazyEventModel = new LazyModel();
		lazyEventModel.loadEvents(inicio, fim);
		
	}

	public AgendaEvent getAgendaEvent() {
		return agendaEvent;
	}

	public void setAgendaEvent(AgendaEvent agendaEvent) {
		this.agendaEvent = agendaEvent;
	}

	public LazyModel getLazyEventModel() {
		return lazyEventModel;
	}

	public void setLazyEventModel(LazyModel lazyEventModel) {
		this.lazyEventModel = lazyEventModel;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}
	
	public void salvarAgenda() {
		agendaEvent.setData(agenda);
		
	}
	
}
