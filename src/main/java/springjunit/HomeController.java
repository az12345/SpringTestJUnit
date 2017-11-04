package springjunit;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Hello World controller.
 */
@RestController
public class HomeController {

    @RequestMapping(value = "/", method = GET)
    public ResponseEntity helloWorld() {
        return ResponseEntity.ok().body("Hello World");
    }
}
