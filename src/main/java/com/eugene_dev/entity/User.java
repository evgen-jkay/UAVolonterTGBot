package com.eugene_dev.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Таблиця в базі данних:
 * user
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName", length = 25, nullable = false)
    private String firstName;

    @Column(name = "lastName", length = 50)
    private String lastName;

    @Column(name = "phone", unique = true)
    private Integer userPhone;

    @Column(name = "chatId", length = 50, nullable = false, unique = true)
    private Integer chatId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages = new ArrayList<>();

    public User() {
    }

    public User(String firstName, String lastName, Integer userPhone, Integer chatId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userPhone = userPhone;
        this.chatId = chatId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userPhone=" + userPhone +
                ", chatId=" + chatId +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getUserPhone() {
        return userPhone;
    }

    public Integer getChatId() {
        return chatId;
    }
}
