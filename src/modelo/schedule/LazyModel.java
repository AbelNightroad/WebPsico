package modelo.schedule;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.primefaces.model.LazyScheduleModel;
import org.primefaces.model.ScheduleEvent;

import persistence.PersistenceUtil;

public class LazyModel extends LazyScheduleModel {
	private static final long serialVersionUID = 1L;

	private EntityManager em = new PersistenceUtil().getEntityManager();

	@Override
	public void loadEvents(Date start, Date end) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<AgendaEvent> cq = cb.createQuery(AgendaEvent.class);
		Root<AgendaEvent> r = cq.from(AgendaEvent.class);
		ParameterExpression<Date> dataInicio = cb.parameter(Date.class, "inicio");
        ParameterExpression<Date> dataFim = cb.parameter(Date.class, "fim");

        Expression<Date> data = r.get("startDate");
        cq.where(cb.between(data, dataInicio, dataFim));

        TypedQuery<AgendaEvent> q = em.createQuery(cq);
        q.setParameter("inicio", start);
        q.setParameter("fim", end);

        for (ScheduleEvent scheduleEvent : q.getResultList()) {
			addEvent(scheduleEvent);
		}
		
	}
	
	@Override
	public void addEvent(ScheduleEvent event) {
		if (event.getId() == null) {
			super.addEvent(event);
		}else {
			getEvents().add(event);
		}
	}
}
