package com.example.pathfinder.models.entities;

import com.example.pathfinder.models.enums.LevelEnum;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "routes")
public class Route extends BaseEntity {

    @Column(columnDefinition = "LONGTEXT", name = "gpx_coordinates")
    private String gpxCoordinates;

    @Enumerated(EnumType.STRING)
    private LevelEnum level;

    @Column
    private String name;

    @ManyToOne
    private User author;

    @Column(name = "video_url")
    private String videoUrl;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToMany(targetEntity = Comment.class, mappedBy = "route", cascade = CascadeType.ALL)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "route", fetch = FetchType.EAGER)
    private Set<Picture> pictures;

    @ManyToMany
    private Set<Category> categories;



    public Route() {
        this.comments = new HashSet<>();
        this.categories = new HashSet<>();
        this.pictures = new HashSet<>();
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public Route setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
        return this;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public Route setLevel(LevelEnum level) {
        this.level = level;
        return this;
    }

    public String getName() {
        return name;
    }

    public Route setName(String name) {
        this.name = name;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public Route setAuthor(User author) {
        this.author = author;
        return this;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public Route setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
        return this;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public Route setComments(Set<Comment> comments) {
        this.comments = comments;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Route setDescription(String description) {
        this.description = description;
        return this;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }


    public Route setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
        return this;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public Route setCategories(Set<Category> categories) {
        this.categories = categories;
        return this;
    }
}
