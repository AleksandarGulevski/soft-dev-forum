package com.example.softdevforum.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Post> posts = new ArrayList<>();

    public void addPost(Post post) {
        getPosts().add(post);
        post.setUser(this);
    }

    public void removePost(Post post) {
        getPosts().remove(post);
        post.setUser(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
