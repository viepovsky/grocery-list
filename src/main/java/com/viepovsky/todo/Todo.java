package com.viepovsky.todo;

import jakarta.persistence.*;

@Entity
@Table(name = "todos")
class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private boolean done;

    /**
     * Hibernate (JPA) needs it.
     */
    @SuppressWarnings("unused")
    Todo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
