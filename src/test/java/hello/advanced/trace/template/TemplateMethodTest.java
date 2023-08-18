package hello.advanced.trace.template;

import hello.advanced.trace.template.code.SubClassLogic1;
import hello.advanced.trace.template.code.SubClassLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    public void templateMethodV0() throws Exception {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();
        log.info("로직 1 실행");
        long endTime = System.currentTimeMillis();
        log.info("result Time = {}", endTime - startTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();
        log.info("로직 2 실행");
        long endTime = System.currentTimeMillis();
        log.info("result Time = {}", endTime - startTime);
    }


    /**
     * 템플릿 메소드 패턴 적용
     */
    @Test
    public void templateMethodV1() throws Exception {
        AbstractTemplate template1 = new SubClassLogic2();
        template1.execute();
    }

    /**
     * 익명 내부 클래스 사용
     */
    @Test
    public void templateMethodV2() throws Exception {
        AbstractTemplate template1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직1 실행");
            }
        };

        template1.execute();

        AbstractTemplate template2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직2 실행");
            }
        };

        template2.execute();
    }
}
