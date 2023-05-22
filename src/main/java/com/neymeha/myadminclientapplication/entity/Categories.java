package com.neymeha.myadminclientapplication.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="categories")
public class Categories {

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "user_categories",
                joinColumns = @JoinColumn(name = "category_id"),
                inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User_Info> users;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "anime_categories",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "anime_id"))
    private List <Anime_List> animes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int category_id;

    @Column(name = "category_name")
    private String category_name;

    public Categories() {
    }

    public Categories(String category_name) {
        this.category_name = category_name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public List<User_Info> getUsers() {
        return users;
    }

    public void setUsers(List<User_Info> users) {
        this.users = users;
    }

    public List<Anime_List> getAnimes() {
        return animes;
    }

    public void setAnimes(List<Anime_List> animes) {
        this.animes = animes;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}
