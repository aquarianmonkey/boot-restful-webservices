package hello;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @RequestMapping("/")
    public String index() {

        return "Greetings from Spring Boot!";
    }

    @GetMapping(value= {"/greeting","/greeting/{name}"})
    public Greeting2 greeting2(@PathVariable Optional<String> name) {

        if (name.isPresent()) {
            return new Greeting2(counter.incrementAndGet(), String.format(template, name.get()));
        }

        return new Greeting2(counter.incrementAndGet(), "Beautiful Life!");
    }

    @GetMapping("/greeting1")
    public HttpEntity<Greeting> greeting(
            @RequestParam(value = "name", required = false, defaultValue = "World") String name) {

        Greeting greeting = new Greeting(String.format(template, name));
        greeting.add(linkTo(methodOn(HelloController.class).greeting(name)).withSelfRel());

        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }

}