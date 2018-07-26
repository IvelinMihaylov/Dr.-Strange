package web;

import com.drstrange.drstrange.models.Article;
import com.drstrange.drstrange.services.base.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/article")
public class ArticleRestController {
  private ArticleService service;
  
  @Autowired
  public ArticleRestController(ArticleService service) {
    this.service = service;
  }
  
  @GetMapping ("/{id}")
  public Article findById(@PathVariable ("id") String id) {
    return service.findById(Integer.parseInt(id));
  }
  
  @GetMapping ("/{name}")
  public Article findByName(@PathVariable ("name") String name) {
    return service.findByName(name);
  }
  
  @GetMapping ("/all")
  public List<Article> getAll() {
    return service.listAll();
  }
  
  @GetMapping ("/filterBySequence/{filter}")
  public List<Article> filterBySequence(@PathVariable ("filter") String filter) {
    return service.filterBySequence(filter);
  }
  
  @ExceptionHandler
  ResponseEntity handleException(Exception e) {
    return new ResponseEntity(HttpStatus.BAD_REQUEST);
  }
  
  @ExceptionHandler
  ResponseEntity<ArticleError> handleParseException(NumberFormatException e) {
    return new ResponseEntity<>(
		  new ArticleError(
				HttpStatus.BAD_REQUEST.value(),
				"Unable to parse article id."),
		  HttpStatus.BAD_REQUEST);
  }
}
