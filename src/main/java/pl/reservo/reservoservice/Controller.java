package pl.reservo.reservoservice;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class Controller {

    private ExampleService exampleService;

    @GetMapping
    public void test() {
        exampleService.test();
    }


}
