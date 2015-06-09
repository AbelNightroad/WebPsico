package modelo.schedule;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.primefaces.model.ScheduleEvent;

public class AgendaEvent implements Serializable, ScheduleEvent {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String title;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	private boolean allDay = false;
	private String styleClass;
	private Object data;
    private boolean editable = true;
    private String description;
	
	public AgendaEvent() {	}
	
	public AgendaEvent(String title, Date startDate, Date endDate) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public AgendaEvent(String title, Date startDate, Date endDate,
			boolean allDay) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.allDay = allDay;
	}

	public AgendaEvent(String title, Date startDate, Date endDate,
			String styleClass) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.styleClass = styleClass;
	}

	public AgendaEvent(String title, Date startDate, Date endDate, Object data) {
		super();
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isAllDay() {
		return allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (allDay ? 1231 : 1237);
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + (editable ? 1231 : 1237);
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result
				+ ((styleClass == null) ? 0 : styleClass.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AgendaEvent other = (AgendaEvent) obj;
		if (id.equals(other.getId())) {
			
		}
		return false;
	}

	@Override
	public String toString() {
		return "AgendaEvent [getTitle()=" + getTitle() + "]";
	}
	
}
