package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class FieldLogTraceTest {

    LogTrace trace = new FieldLogTrace();

    @Test
    public void begin_end() throws Exception {
        //given
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        TraceStatus status3 = trace.begin("hello3");

        trace.end(status3);
        trace.end(status2);
        trace.end(status1);
        //then
    }

    @Test
    public void begin_exception() throws Exception {
        // when
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        TraceStatus status3 = trace.begin("hello3");

        // then
        trace.exception(status3, new IllegalStateException());
        trace.exception(status2, new IllegalStateException());
        trace.exception(status1, new IllegalStateException());
    }
}
