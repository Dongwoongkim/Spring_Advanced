package hello.advanced.app.v1;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {

    private final OrderServiceV1 orderService;
    private final HelloTraceV1 trace;

    @GetMapping("/v1/request")
    public String request(@RequestParam("itemId") String itemId) {
        TraceStatus status = trace.begin("OrderControllerV1.request()");

        try {
            orderService.orderItem(itemId);
            trace.end(status);
            return "OK";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; // 예외 다시 던져주지 않으면 서블릿에 전달되지 않고 예외를 먹어서 흐름이 변경됨.
        }
    }
}
