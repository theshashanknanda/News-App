package com.example.newsapp.Utils;

public class Model {

    public String title;
    public String description;
    public String author;
    public String imageURL;
    public String sourceURL;
    public String published;

    public Model(String title, String description, String author, String imageURL, String sourceURL, String published) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.imageURL = imageURL;
        this.sourceURL = sourceURL;
        this.published = published;
    }

    public Model(){
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getSourceURL() {
        return sourceURL;
    }

    public void setSourceURL(String sourceURL) {
        this.sourceURL = sourceURL;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }
}
