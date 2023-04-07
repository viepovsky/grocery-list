package com.viepovsky.tobuy;

import jakarta.persistence.*;

@Entity
@Table(name = "grocery")
class ToBuy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private boolean bought;
    private String created;

    /**
     * Hibernate (JPA) needs it.
     */
    @SuppressWarnings("unused")
    ToBuy() {
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

    public boolean isBought() {
        return bought;
    }

    public void setBought(boolean done) {
        this.bought = done;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
