package com.Yemeksepeti.todo.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "TODO")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ToDoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @Column(name = "TITLE")
    private String TITLE;

    @Column(name = "DESCRIPTION")
    private String DESCRIPTION;

    @Column(name = "DUE_DATE")
    private Date DUEDATE;

    @Column(name = "COMPLETED")
    private boolean COMPLETED;

    public ToDoModel(String TITLE, String DESCRIPTION, Date DUEDATE, boolean COMPLETED) {
        this.TITLE = TITLE;
        this.DESCRIPTION = DESCRIPTION;
        this.DUEDATE = DUEDATE;
        this.COMPLETED = COMPLETED;
    }

}
