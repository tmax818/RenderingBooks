package tylermaxwell.renderingbooks.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity // represents an entity model for our application
@Table(name = "books") //sets this as a table in the database
public class Book {
    @Id //  sets this as the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // sets this as an auto-incrementing value
    private Long id;
    @NotNull // adds validation that the column must be null
    @Size(min = 5, max = 200) // adds validation that the column must be in the specified range
    private String title;
    @NotNull // adds validation that the column must be null
    @Size(min = 5, max = 200)
    private String description;
    @NotNull // adds validation that the column must be null
    @Size(min = 3, max = 40)
    private String language;
    @NotNull
    @Min(100)
    private Integer numberOfPages;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Book(){}

    public Book(String title, String desc, String lang, int pages) {
        this.title = title;
        this.description = desc;
        this.language = lang;
        this.numberOfPages = pages;
    }

    @PrePersist // runs the method right before the object is created
    protected void onCreate(){
        this.createdAt = new Date();
    }

    @PreUpdate // runs a method when the object is modified
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
