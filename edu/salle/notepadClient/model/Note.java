/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.salle.notepadClient.model;


/**
 *
 * @author Andrei
 */
public class Note {
    
	private long id;
	private String text;
	private long dateTime;
	
	public Note() {
		
	}

	public Note(String text, long dateTime) {
		super();
		this.setText(text);
		this.setDateTime(dateTime);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getDateTime() {
		return dateTime;
	}

	public void setDateTime(long dateTime) {
		this.dateTime = dateTime;
	}
}
