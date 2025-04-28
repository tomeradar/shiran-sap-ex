package classes;

public class Book {
    private Long id;
    private String title;
    private boolean available = true;

    public Book(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}
