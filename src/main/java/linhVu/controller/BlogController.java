package linhVu.controller;

import linhVu.model.BlogRESTful;
import linhVu.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    BlogService blogService;

    //Retrieve all blogs; GET request "/api/blogs/"
    @GetMapping("/blogs")
    public ResponseEntity<List<BlogRESTful>> listBlog(){
        List<BlogRESTful> blogs = blogService.findAll();
        if(blogs.isEmpty()){
            return new ResponseEntity<List<BlogRESTful>>(HttpStatus.NO_CONTENT);// you may decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<BlogRESTful>>(blogs,HttpStatus.OK);
    }


    //-------------------Create a blog--------------------------------------------------------
    @RequestMapping(value = "/create-blog", method = RequestMethod.POST)
    public ResponseEntity<Void> createBlog(@RequestBody BlogRESTful blogRESTful) {
        System.out.println("Create Blog "+blogRESTful.getTitle() );
        blogService.save(blogRESTful);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    //-------------------Retrieve Single blog--------------------------------------------------------
    @RequestMapping(value = "blog/{id}", method = RequestMethod.GET)
    public ResponseEntity<BlogRESTful> getBlog(@PathVariable Long id){
        System.out.println("Fetching Blog with id " + id);
        BlogRESTful blog= blogService.findById(id);
        if (blog == null) {
            System.out.println("blog with id " + id + " not found");
            return new ResponseEntity<BlogRESTful>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BlogRESTful>(blog, HttpStatus.OK);
    }

    //------------------- Update a Blog --------------------------------------------------------
    @RequestMapping(value = "/edit-blog/{id}", method = RequestMethod.PUT)
    public ResponseEntity<BlogRESTful> editCustomer(@PathVariable Long id, @RequestBody BlogRESTful blogRESTful){
        System.out.println("Updating Blog " + id);
        BlogRESTful currentBlog = blogService.findById(id);
        if (currentBlog == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<BlogRESTful>(HttpStatus.NOT_FOUND);
        }

        currentBlog.setTitle(blogRESTful.getTitle());
        currentBlog.setContent(blogRESTful.getContent());
        currentBlog.setId(blogRESTful.getId());
        currentBlog.setCategoryName(blogRESTful.getCategoryName());
        currentBlog.setDateCreate(blogRESTful.getDateCreate());

        blogService.save(currentBlog);
        return new ResponseEntity<BlogRESTful>(currentBlog, HttpStatus.OK);
    }

    //------------------- Delete a Customer --------------------------------------------------------

    @RequestMapping(value = "delete-blog/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<BlogRESTful> deleteCustomer(@PathVariable("id") Long id){
        BlogRESTful bog = blogService.findById(id);
        if (bog == null) {
            System.out.println("Unable to delete. Blog with id " + id + " not found");
            return new ResponseEntity<BlogRESTful>(HttpStatus.NOT_FOUND);
        }

        blogService.remove(id);
        return new ResponseEntity<BlogRESTful>(HttpStatus.NO_CONTENT);
    }


}
