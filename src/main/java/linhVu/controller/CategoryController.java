package linhVu.controller;

import linhVu.model.BlogRESTful;
import linhVu.model.CategoryRESTful;
import linhVu.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    //Retrieve all categories; GET request "/api/categories/"
    @GetMapping("/categories")
    public ResponseEntity<List<CategoryRESTful>> listCategory(){
        List<CategoryRESTful> categories = categoryService.findAll();
        if(categories.isEmpty()){
            return new ResponseEntity<List<CategoryRESTful>>(HttpStatus.NO_CONTENT);// you may decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<CategoryRESTful>>(categories,HttpStatus.OK);
    }

//    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
//    public ResponseEntity<List<BlogRESTful>> viewCategory(@PathVariable long id) {
//        List<BlogRESTful> blogs = categoryService.findAllByCategory(id);
//        if (blogs.isEmpty()) {
//            return new ResponseEntity<List<BlogRESTful>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<List<BlogRESTful>>(blogs, HttpStatus.OK);
//    }


}
