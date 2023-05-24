package com.example.homew19.Controller;

import com.example.homew19.Model.Blog;
import com.example.homew19.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/get")
    public ResponseEntity getAllBlog(){
        List<Blog> blogs=blogService.getAllBlog();
        return ResponseEntity.status(200).body(blogs);
    }

    @PostMapping("/add")
    public ResponseEntity addBlog(@Valid @RequestBody Blog blog){
        blogService.addBlog(blog);
        return ResponseEntity.status(200).body("Blog Added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@Valid @RequestBody Blog blog ,@PathVariable Integer id){
        blogService.updateBlog(id,blog);
        return ResponseEntity.status(200).body("Blog Update");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@PathVariable Integer id){
        blogService.deleteBlog(id);
        return ResponseEntity.status(200).body("Blog Delete");
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity getBlogById(@PathVariable Integer id){
       Blog blog=blogService.findBlogById(id);
        return ResponseEntity.status(200).body("Get by Id");
    }
    @GetMapping("/get-title/{title}")
    public ResponseEntity getBlogByTitle(@PathVariable String title){
        Blog blogs=blogService.findBlogByTitle(title);
        return ResponseEntity.status(200).body("Get by Title");
    }
    @GetMapping("/get-category/{category}")
    public ResponseEntity getBlogByCategory (String category){
        List<Blog> blogs=blogService.findBlogByCategory(category);
        return ResponseEntity.status(200).body("Get by category");
    }

    @GetMapping("/get-published/{id}")
    public ResponseEntity getBlogByPublished(@PathVariable Integer id ){
        blogService.updatepublished(id);
        return ResponseEntity.status(200).body("Get byPublished");

    }
}
