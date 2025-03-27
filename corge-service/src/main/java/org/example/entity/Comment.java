package org.example.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "comment_id_gen")
    @SequenceGenerator(name = "comment_id_gen", sequenceName = "comment_id_seq")
    private Long id;

    @Column(name = "text")
    @NotNull
    @NotEmpty
    @Size(min = 1, max = 2000)
    private String text;

    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timestampOfRegistration;

    @ManyToOne
    @JoinColumn(name = "cargo_id", referencedColumnName = "id")
    private Cargo cargo;

    public Comment(){}

    public Comment(String text) {
        this.text = text;
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

    public Date getTimestampOfRegistration() {
        return timestampOfRegistration;
    }

    public void setTimestampOfRegistration(Date timestampOfRegistration) {
        this.timestampOfRegistration = timestampOfRegistration;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
