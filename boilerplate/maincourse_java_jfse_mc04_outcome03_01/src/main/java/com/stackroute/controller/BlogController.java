package com.stackroute.controller;


import com.stackroute.domain.Blog;

/* Add annotation to declare this class as REST Controller */
public class BlogController {

    /* Provide implementation code for these methods */

    /*This method should save blog and return savedBlog Object */
    public ResponseEntity<?> saveBlog() {
        return null;
    }

    /*This method should fetch all blogs and return the list of all blogs */
    public ResponseEntity<?> getAllBlogs() {
        return null;
    }

    /*This method should fetch the blog taking its id and return the respective blog */
    public ResponseEntity<Blog> getBlogById(){
        return null;
    }

    /*This method should delete the blog taking its id and return the deleted blog */
    public ResponseEntity<?> getBlogAfterDeleting() {
        return null;
    }

    /*This method should update blog and return the updatedBlog */
    public ResponseEntity<?> updateBlog() {
        return null;
    }
}