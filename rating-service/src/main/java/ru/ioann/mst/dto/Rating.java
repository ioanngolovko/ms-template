package ru.ioann.mst.dto;

public class Rating {
    public Long id;
    public Long bookId;
    public int stars;

    public Rating(Long id, Long bookId, int stars) {
        this.id = id;
        this.bookId = bookId;
        this.stars = stars;
    }
}
