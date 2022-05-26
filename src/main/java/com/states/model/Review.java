package com.states.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "review")
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String textBody;
    @Transient
    private String userName;
    @Transient
    private String stateReviewed;
    @Transient
    private Integer userId;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "posted_at")
    private Date postedAt = new Date();

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    private Date updatedAt = new Date();

    public Review() {

    }

    public Review(Integer id, String title, String textBody, Integer userId) {
        this.id = id;
        this.title = title;
        this.textBody = textBody;
        this.stateReviewed = stateReviewed;
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStateReviewed() {
        return stateReviewed;
    }

    public void setStateReviewed(String stateReviewed) {
        this.stateReviewed = stateReviewed;
    }

    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(Date postedAt) {
        this.postedAt = postedAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Review)) return false;
        Review review = (Review) o;
        return Objects.equals(id, review.id) && Objects.equals(title, review.title) && Objects.equals(textBody, review.textBody) && Objects.equals(userName, review.userName) && Objects.equals(stateReviewed, review.stateReviewed) && Objects.equals(userId, review.userId) && Objects.equals(postedAt, review.postedAt) && Objects.equals(updatedAt, review.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, textBody, userName, stateReviewed, userId, postedAt, updatedAt);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", textBody='" + textBody + '\'' +
                ", userName='" + userName + '\'' +
                ", stateReviewed='" + stateReviewed + '\'' +
                ", userId=" + userId +
                ", postedAt=" + postedAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
