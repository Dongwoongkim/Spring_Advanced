package hello.advanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV0 {

    private final OrderService orderService;

    @GetMapping("/v0/request")
    public String request(@RequestParam("itemId") String itemId) {
        orderService.orderItem(itemId);
        return "OK";
    }
}
