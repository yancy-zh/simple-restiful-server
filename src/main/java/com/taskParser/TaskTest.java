package com.taskParser;

import static org.junit.Assert.*;

import org.junit.Test;

public class TaskTest {

	@Test
	public void testTask() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetID() {
		Task task = new Task(null, null, null, null);
		task.setID(1);
		assertEquals(task.id, 1);
	}

}
