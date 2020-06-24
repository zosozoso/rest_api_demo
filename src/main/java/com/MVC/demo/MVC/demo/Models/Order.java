package com.MVC.demo.MVC.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name = "id_person", nullable = false)
    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Person person;

    @OneToMany(mappedBy="order")
    @JsonIgnoreProperties("order")
    List<OrderLines> orderLines;

    @Column(name = "total_quote")
    private float totalQuote;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<OrderLines> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLines> orderLines) {
        this.orderLines = orderLines;
    }

    public float getTotalQuote() {
        return totalQuote;
    }

    public void setTotalQuote(float totalQuote) {
        this.totalQuote = totalQuote;
    }

}