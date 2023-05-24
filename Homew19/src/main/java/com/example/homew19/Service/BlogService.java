package com.example.homew19.Service;

import com.example.homew19.Model.Blog;
import com.example.homew19.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final BlogRepository blogRepository;

    public List<Blog> getAllBlog(){
        return blogRepository.findAll();
    }

    public void addBlog (Blog blog){
        blogRepository.save(blog);
    }

    public void updateBlog(Integer id,Blog blog){
        Blog oldBlog=blogRepository.findBlogById(id);
        if (oldBlog==null){
            throw new ArithmeticException("Blog not Found");
        }
        oldBlog.setTitle(blog.getTitle());
        oldBlog.setCategory(blog.getCategory());
        oldBlog.setBody(blog.getBody());
        oldBlog.setPublished(blog.isPublished());

        blogRepository.save(oldBlog);
    }

    public void deleteBlog(Integer id){
        Blog oldBlog=blogRepository.findBlogById(id);
        if (oldBlog==null){
            throw new ArithmeticException("Blog not Found");
        }
        blogRepository.delete(oldBlog);
    }

    public Blog findBlogById(Integer id){
        Blog blog=blogRepository.findBlogById(id);
        if (blog==null){
            throw new ArithmeticException(" Wrong ID ");
        }
        return blog;

    }

    public Blog findBlogByTitle(String title){
        Blog blog=blogRepository.findBlogByTitle(title);
        if (blog==null){
            throw new ArithmeticException(" Wrong Title ");
        }
        return blog;
    }

    public List<Blog> findBlogByCategory(String category){
        List<Blog>blogs=blogRepository.findBlogByCategory(category);
        if (blogs==null){
            throw new ArithmeticException(" Wrong Category ");
        }
        return blogs;
    }
    public void updatepublished(Integer id){
        Blog oldBlog=blogRepository.findBlogById(id);
        if (oldBlog==null){
            throw new ArithmeticException("Blog not Found");
        }

        oldBlog.setPublished(true);
        blogRepository.save(oldBlog);
    }
}
