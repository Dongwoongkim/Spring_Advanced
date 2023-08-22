package hello.advanced.trace.template_callback;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

    @Test
    public void callbackTest() throws Exception {

        TimeLogTemplate template = new TimeLogTemplate();
        Callback callback = new Callback() {
            @Override
            public void call() {
                log.info("비즈니스 로직 실행1");
            }
        };
        template.execute(callback);
    }
}
