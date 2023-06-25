package br.com.deveficente.event;

import java.time.LocalDateTime;
import java.util.UUID;

public class EventsBook {

	private UUID uuid;
	private String nameEvent;
	private LocalDateTime dateEvent;
	private String operation;
	private Object object;
	
	public EventsBook(UUID uuid, String nameEvent, LocalDateTime dateEvento, String operation) {
		super();
		this.uuid = uuid;
		this.nameEvent = nameEvent;
		this.dateEvent = dateEvento;
		this.operation = operation;

	}

	public EventsBook() {
		super();
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getNameEvent() {
		return nameEvent;
	}

	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}

	public LocalDateTime getDateEvento() {
		return dateEvent;
	}

	public void setDateEvent(LocalDateTime dateEvent) {
		this.dateEvent = dateEvent;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
}
