package com.Varun.webFluxProject.model;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Document(collection = "Bookdb")
public class Book{
    @Id
    @NotNull
    private int id;
    @NotNull
    private int copies;
    @NotNull
    private int authorId;
    @NotNull
    @NotBlank
    private String genre;

    public Book(int id, int copies, int authorId, String genre){
        this.id = id;
        this.copies = copies;
        this.authorId = authorId;
        this.genre = genre;
    }

    public void setId(int id){ this.id = id; }

    public void setCopies(int copies){ this.copies = copies; }

    public void setAuthorId(int authorId){ this.authorId = authorId; }

    public void setGenre(String genre){ this.genre = genre;}

//    @Override
//    public String toString() {
//        return "Book{" +
//                "id='" + id + '\'' +
//                ", copies='" + copies + '\'' +
//                ", authorId=" + authorId + '\'' +
//                ", genre=" + genre +
//                '}';
//    }

}

