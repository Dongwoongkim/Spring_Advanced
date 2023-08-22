
package hello.advanced.trace.template_method.code;

import hello.advanced.trace.template_method.AbstractTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubClassLogic2 extends AbstractTemplate {
    @Override
    protected void call() {
        log.info("비즈니스 로직2 실행");
    }
}
