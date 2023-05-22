package com.neymeha.myadminclientapplication.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="anime_list")
public class Anime_List {

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "anime_categories",
                joinColumns = @JoinColumn(name = "anime_id"),
                inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Categories> anime_categories;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "watched",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List <User_Info> watched;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "wish_list",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List <User_Info> wish_list;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anime_id")
    private int anime_id;

    @Column(name = "name")
    private String name;

    @Column(name = "rating")
    private float rating;

    @Column(name = "poster")
    private String poster;

    @Column(name = "description")
    private String description;

    public Anime_List() {
    }

    public Anime_List(String name, float rating, String poster, String description) {
        this.name = name;
        this.rating = rating;
        this.poster = poster;
        this.description = description;
    }

    public void addCategoryForAnime(Categories category){
        if (anime_categories==null){
            anime_categories = new ArrayList<>();
        }
        anime_categories.add(category);
    }

    public int getAnime_id() {
        return anime_id;
    }

    public void setAnime_id(int anime_id) {
        this.anime_id = anime_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Categories> getAnime_categories() {
        return anime_categories;
    }

    public void setAnime_categories(List<Categories> anime_categories) {
        this.anime_categories = anime_categories;
    }

    public List<User_Info> getWatched() {
        return watched;
    }

    public void setWatched(List<User_Info> watched) {
        this.watched = watched;
    }

    public List<User_Info> getWish_list() {
        return wish_list;
    }

    public void setWish_list(List<User_Info> wish_list) {
        this.wish_list = wish_list;
    }

    @Override
    public String toString() {
        return "Anime_List{" +
                "anime_id=" + anime_id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", poster='" + poster + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
