package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class HelloTraceV1Test {

    @Test
    public void begin_end() throws Exception {
        //given
        HelloTraceV1 traceV1 = new HelloTraceV1();

        //when
        TraceStatus status = traceV1.begin("hello");

        //then
        traceV1.end(status);
    }

    @Test
    public void begin_exception() throws Exception {
        //given
        HelloTraceV1 traceV1 = new HelloTraceV1();

        //when
        TraceStatus status = traceV1.begin("hello");

        //then
        traceV1.exception(status, new IllegalStateException("예외 발생"));
    }
}
