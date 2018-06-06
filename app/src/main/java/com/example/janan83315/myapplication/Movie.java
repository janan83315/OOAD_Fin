package com.example.janan83315.myapplication;

public class Movie  {
    private int mid;
    private String movietitle;
    private String up_date;
    private String director;
    private String actor;
    private String movietype;
    private String showtime;
    private String moviestory;

    public int getMid(){
        return mid;
    }

    public String getTitle(){
        return movietitle;
    }

    public String getUpDate(){
        return up_date;
    }

    public String getDirector(){
        return director;
    }

    public String getActor(){
        return actor;
    }

    public String getMovietype(){
        return movietype;
    }

    public String getShowtime(){
        return showtime;
    }

    public String getMoviestory(){
        return moviestory;
    }

    public void setMid(int mid){
        this.mid = mid;
    }

    public void setMovietitle(String movietitle){
        this.movietitle = movietitle;
    }

    public void setUp_date(String up_date){
        this.up_date = up_date;
    }

    public void setDirector(String director){
        this.director = director;
    }

    public void setActor(String actor){
        this.actor = actor;
    }

    public void setMovietype(String movietype){
        this.movietype = movietype;
    }

    public void setShowtime(String showtime){
        this.showtime = showtime;
    }

    public void setMoviestory(String moviestory){
        this.moviestory = moviestory;
    }
}
