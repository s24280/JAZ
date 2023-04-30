package pl.pjwstk.tw.Movie.Model;

import java.util.concurrent.atomic.AtomicInteger;

public class Movie {
    private static final AtomicInteger count = new AtomicInteger(0);
    int id = 0;
    String name;
    String category;

    public Movie(String name, String category) {
        this.id = count.incrementAndGet();
        this.name = name;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setNameAndCategory(String name, String category) {
        this.name = name;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
