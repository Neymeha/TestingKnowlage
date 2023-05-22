package com.neymeha.myadminclientapplication.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="user_info")
public class User_Info {

    @OneToOne(mappedBy = "user_info")
    private Logging logging;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "user_categories",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List <Categories> user_categories;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "watched",
                joinColumns = @JoinColumn(name = "user_id"),
                inverseJoinColumns = @JoinColumn(name = "anime_id"))
    private List <Anime_List> watched;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinTable(name = "wish_list",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "anime_id"))
    private List <Anime_List> wish_list;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "nickname")
    private String nickname;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "date_of_birth")
    private Date date_of_birth;

    public User_Info() {
    }

    public User_Info(String nickname, String avatar, Date date_of_birth) {
        this.nickname = nickname;
        this.avatar = avatar;
        this.date_of_birth = date_of_birth;
    }

    public void addUserCategories(Categories category){
        if (user_categories==null) {
            user_categories = new ArrayList<>();
        }
        user_categories.add(category);
    }

    public void addAnimeToWatched(Anime_List anime){
        if (watched==null){
            watched = new ArrayList<>();
        }
        watched.add(anime);
    }

    public void addAnimeToWishList(Anime_List anime){
        if (wish_list==null){
            wish_list = new ArrayList<>();
        }
        wish_list.add(anime);
    }

    public Logging getLogging() {
        return logging;
    }

    public void setLogging(Logging logging) {
        this.logging = logging;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public List<Categories> getUser_categories() {
        return user_categories;
    }

    public void setUser_categories(List<Categories> user_categories) {
        this.user_categories = user_categories;
    }

    public List<Anime_List> getWatched() {
        return watched;
    }

    public void setWatched(List<Anime_List> watched) {
        this.watched = watched;
    }

    public List<Anime_List> getWish_list() {
        return wish_list;
    }

    public void setWish_list(List<Anime_List> wish_list) {
        this.wish_list = wish_list;
    }

    @Override
    public String toString() {
        return "User_Info{" +
                "user_id=" + user_id +
                ", nickname='" + nickname + '\'' +
                ", avatar='" + avatar + '\'' +
                ", date_of_birth='" + date_of_birth + '\'' +
                '}';
    }
}
