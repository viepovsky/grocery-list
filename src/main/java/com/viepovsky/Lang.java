package com.viepovsky;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "languages")
class Lang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String welcomeMessage;
    private String code;

    /**
     * Hibernate (JPA) needs it.
     */
    @SuppressWarnings("unused")
    Lang() {
    }

    public Lang(Long id, String welcomeMessage, String code) {
        this.id = id;
        this.welcomeMessage = welcomeMessage;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
