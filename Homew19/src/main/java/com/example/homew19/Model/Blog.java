package com.example.homew19.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = " Title can't be null")
    @Column(columnDefinition ="varchar(20) not null")
    private String title;

    @NotEmpty(message = "category can't be null")
    @Column(columnDefinition = "varchar(20) not null check(category='health' or category='education' or category='programming')")
    private String category;

    @NotEmpty(message = "Body can't be null")
    @Column(columnDefinition = "varchar(300) not null")
    @Size(min = 4,max = 300 ,message = "body max 300 letters")
    private String body;

//    @AssertFalse
    @Column(columnDefinition = "varchar(20) not null")
    private boolean isPublished ;

}
