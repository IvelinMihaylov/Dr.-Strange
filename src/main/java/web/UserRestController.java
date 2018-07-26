package web;

import com.drstrange.drstrange.models.User;
import com.drstrange.drstrange.services.base.ArticleService;
import com.drstrange.drstrange.services.base.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/user")
public class UserRestController {
  private UserService service;
  
  @Autowired
  public UserRestController(UserService service) {
    this.service = service;
  }
  
  @GetMapping ("/{id}")
  public User findById(@PathVariable ("id") String id) {
    return service.findById(Integer.parseInt(id));
  }
  
  @GetMapping ("/{name}")
  public User findByName(@PathVariable ("name") String name) {
    return service.findByName(name);
  }
  
  @GetMapping ("/all")
  public List<User> getAll() {
    return service.listAll();
  }
  
  @ExceptionHandler
  ResponseEntity handleException(Exception e) {
    return new ResponseEntity(HttpStatus.BAD_REQUEST);
  }
  
  @ExceptionHandler
  ResponseEntity<UserError> handleParseException(NumberFormatException e) {
    return new ResponseEntity<>(
		  new UserError(
				HttpStatus.BAD_REQUEST.value(),
				"Unable to parse article id."),
		  HttpStatus.BAD_REQUEST);
  }
}
