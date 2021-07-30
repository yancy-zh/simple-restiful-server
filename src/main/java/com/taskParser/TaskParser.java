/* This class parses the original TODO file and store the parsed object in the json file
 * */

package com.taskParser;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TaskParser {
	public void main(String args[]) throws Exception {
		String cwp = System.getProperty("user.dir");
		String filePathString = cwp + File.separator + "src/main/resources" + File.separator + "casestudy.todo.txt";
		File file = new File(filePathString);
		FileInputStream fileInputStream = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
		List<Task> tasks = new ArrayList<Task>();
		String line;
		int index = 1;
		while ((line = br.readLine()) != null) {
			Task task = new Task(getProjectTag(line), getContextTag(line), getPriorityTag(line), getToDoContent(line));
			getToDoContent(line);
			task.setID(index);
			index++;
			tasks.add(task);
		}
		//write the variable to a json string
		Gson jsonGson = new Gson();
		String respString = jsonGson.toJson(tasks);
		String filePath = cwp + File.separator  + "db.json";
		System.out.println(filePath);
		//write an object to json file
		try(Writer writer = new FileWriter(filePath)){
			Gson gson = new GsonBuilder().create();
			gson.toJson(tasks, writer);
		}

		br.close();
	}

	private String getProjectTag(String line) {
		// assume only one project tag appears in the line
		Pattern pattern = Pattern.compile("\\+(\\w+)\\s");
		Matcher matcher = pattern.matcher(line);
		if (matcher.find()) {
			return matcher.group().substring(1).strip();
		} else {
			return null;
		}
	}

	private String getContextTag(String line) {
		// assume only one context tag appears in the line
		Pattern pattern = Pattern.compile("type\\:\\w+\\s?");
		Matcher matcher = pattern.matcher(line);
		if (matcher.find()) {
			return matcher.group().substring(5).strip();
		} else {
			return null;
		}
	}
	
	private String getPriorityTag(String line) {
		// assume only one priority tag appears in the line
		Pattern pattern = Pattern.compile("\\([A-Z]\\)");
		Matcher matcher = pattern.matcher(line);
		if (matcher.find()) {
			return matcher.group().substring(1, 2).strip();
		} else {
			return null;
		}
	}
	
	private String getToDoContent(String line) {
		// find pattern for "priority"
		Pattern pattern1 = Pattern.compile("\\([A-Z]\\)");
		Matcher matcher1 = pattern1.matcher(line);
		int index1 = 0;
		int index2 = line.length();
		if (matcher1.find()) {
			index1 = matcher1.end();
		}
		// find pattern for "project"
		Pattern pattern2 = Pattern.compile("\\+(\\w+)\\s");
		Matcher matcher2 = pattern2.matcher(line);
		if (matcher2.find()) {
			index2 = matcher2.start();
		}
		// return the remaining text in line, without the pattern.
		return line.substring(index1, index2);
	}

}
