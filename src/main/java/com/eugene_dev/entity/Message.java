package com.eugene_dev.entity;

import javax.persistence.*;

/**
 * Таблиця в базі данних:
 * message
 */
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "message", length = 3000, nullable = false)
    private String message;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    public Message() {
    }

    public Message(String city, String message) {
        this.city = city;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", message='" + message + '\'' +
                ", user=" + user +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getMessage() {
        return message;
    }
}
