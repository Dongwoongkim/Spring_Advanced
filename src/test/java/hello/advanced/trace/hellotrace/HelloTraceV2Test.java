package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloTraceV2Test {

    @Test
    public void begin_end() throws Exception {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status = trace.begin("hello1");
        TraceStatus status1 = trace.beginSync(status.getTraceId(), "hello2");
        trace.end(status1);
        trace.end(status);
    }

    @Test
    public void begin_exception() throws Exception {
        HelloTraceV2 trace = new HelloTraceV2();
        TraceStatus status = trace.begin("hello");
        TraceStatus status1 = trace.beginSync(status.getTraceId(), "hello2");
        trace.exception(status1, new IllegalStateException());
        trace.exception(status, new IllegalStateException());
    }
}