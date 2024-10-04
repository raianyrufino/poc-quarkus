package br.com.alura.model;

import java.time.LocalDateTime;

public class Athlete {
    private Long id;
    private String username;
    private Integer resourceState;
    private String firstname;
    private String lastname;
    private String city;
    private String state;
    private String country;
    private String sex;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer badgeTypeId;
    private Double weight;
    private String profileMedium;
    private String profile;
    private Object friend;

    public Athlete() {
    }

    public Athlete(Long id, String username, Integer resourceState, String firstname, String lastname,
                   String bio, String city, String state, String country, String sex, Boolean premium,
                   Boolean summit, LocalDateTime createdAt, LocalDateTime updatedAt, Integer badgeTypeId,
                   Double weight, String profileMedium, String profile, Object friend, Object follower) {
        this.id = id;
        this.username = username;
        this.resourceState = resourceState;
        this.firstname = firstname;
        this.lastname = lastname;
        this.city = city;
        this.state = state;
        this.country = country;
        this.sex = sex;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.badgeTypeId = badgeTypeId;
        this.weight = weight;
        this.profileMedium = profileMedium;
        this.profile = profile;
        this.friend = friend;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getResourceState() {
        return resourceState;
    }

    public void setResourceState(Integer resourceState) {
        this.resourceState = resourceState;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getBadgeTypeId() {
        return badgeTypeId;
    }

    public void setBadgeTypeId(Integer badgeTypeId) {
        this.badgeTypeId = badgeTypeId;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getProfileMedium() {
        return profileMedium;
    }

    public void setProfileMedium(String profileMedium) {
        this.profileMedium = profileMedium;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public Object getFriend() {
        return friend;
    }

    public void setFriend(Object friend) {
        this.friend = friend;
    }
}