package com.states.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "state")
public class State implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String stateName;
    private String capital;

    @OneToMany(mappedBy = "stateId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Review> reviews;

    public State() {
    }

    public State(Integer id, String stateName, String capital, List<Review> reviews) {
        this.id = id;
        this.stateName = stateName;
        this.capital = capital;
        this.reviews = reviews;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof State)) return false;
        State state = (State) o;
        return Objects.equals(id, state.id) && Objects.equals(stateName, state.stateName) && Objects.equals(capital, state.capital) && Objects.equals(reviews, state.reviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, stateName, capital, reviews);
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", stateName='" + stateName + '\'' +
                ", capital='" + capital + '\'' +
                ", reviews=" + reviews +
                '}';
    }


}
