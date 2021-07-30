package com.taskParser;

public class Task {
	int id;
	String project;
	String context;
	String priority;
	String contentString;
	
	public Task(String p_project, String p_context, String p_priority, String p_content) {
		// TODO Auto-generated constructor stub
		project = p_project;
		context = p_context;
		priority = p_priority;
		contentString = p_content;
	}
	
	public void setID(int p_id) {
		id= p_id;
	}
}
