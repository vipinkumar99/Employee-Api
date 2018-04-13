package com.emp.model;

public class Email {
	private interface Columns {
		String ID = "id";
		String TO = "send_to";
		String FROM = "send_from";
		String SUBJECT = "subject";
		String BODY = "message";
		String CREATION = "createdAt";
	}

	private int id;
	private String sentTo;
	private String sentFrom;
	private String subject;
	private String body;
	private String createAt;

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSentTo() {
		return sentTo;
	}

	public void setSentTo(String sentTo) {
		this.sentTo = sentTo;
	}

	public String getSentFrom() {
		return sentFrom;
	}

	public void setSentFrom(String sentFrom) {
		this.sentFrom = sentFrom;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
