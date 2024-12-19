package ru.mirea.mitia.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "\"user\"")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "first_name", length = 100)
    private String firstName;

    @Column(length = 100)
    private String email;

    @Column(length = 100)
    private String country;

    @Column(length = 7)
    private String gender;
}
