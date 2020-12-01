package com.example.demo.entity;

import javax.persistence.*;

/**
 * Created by pestano on 22/07/15.
 */
@Entity
public class Tweet {

    @Id
    @GeneratedValue
    private String id;

    private String content;

    public String getContent() {
        return content;
    }
    public void setContent(String content){
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tweet tweet = (Tweet) o;

        return !(id != null ? !id.equals(tweet.id) : tweet.id != null);

    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
