package com.stackroute.domain;

/* Add Annotation to declare this class as a JPA Entity */
public class Blog {
    /*Add Annotation to declare this field as a Unique Identifier */
    private int blogId;
    private String blogTitle;
    private String authorName;
    private String blogContent;

    /* Generate no-arg and parametrized consructor */

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }
}
