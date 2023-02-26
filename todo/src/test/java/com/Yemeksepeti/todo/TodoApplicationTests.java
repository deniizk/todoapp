package com.Yemeksepeti.todo;

import com.Yemeksepeti.todo.model.ToDoModel;
import com.Yemeksepeti.todo.repo.ToDoRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.sql.Date;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TodoApplicationTests {

	@Autowired
	public ToDoRepository toDoRepository;

	@Test
	@Order(1)
	void testSave()
	{
		ToDoModel toDoModel = new ToDoModel();
		Date date = new Date(2023,03,01);
		toDoModel.setTITLE("Finish project");
		toDoModel.setDESCRIPTION("Finish the ToDo application project");
		toDoModel.setDUEDATE(date);
		toDoModel.setCOMPLETED(false);
		toDoRepository.save(toDoModel);
		assertNotNull(toDoRepository.findById(1L).get());
	}

	@Test
	@Order(2)
	void testGetAll()
	{
		List<ToDoModel> list = toDoRepository.findAll();
		assertThat(list).size().isGreaterThan(0);
	}

	@Test
	@Order(3)
	void testGetById()
	{
		ToDoModel toDoModel = toDoRepository.findById(1L).get();
		assertEquals(1L,toDoModel.getID());
	}

	@Test
	@Order(4)
	void testUpdate()
	{
		ToDoModel toDoModel = toDoRepository.findById(1L).get();
		toDoModel.setCOMPLETED(true);
		toDoRepository.save(toDoModel);
		assertNotEquals(false, toDoRepository.findById(1L).get().isCOMPLETED());
	}

	@Test
	@Order(5)
	void testDelete()
	{
		toDoRepository.deleteById(1L);
		assertThat(toDoRepository.existsById(1L)).isFalse();
	}





}