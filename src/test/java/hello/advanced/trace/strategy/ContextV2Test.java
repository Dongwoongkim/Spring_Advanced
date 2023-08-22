package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    @Test
    public void strategyV0() throws Exception {
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

    @Test
    public void strategyTest() throws Exception {
        Strategy strategyLogic1 = new StrategyLogic1();
        Strategy strategyLogic2 = new StrategyLogic2();

        ContextV2 context = new ContextV2();
        context.execute(strategyLogic1);
        context.execute(strategyLogic2);
    }

    @Test
    public void strategyV2() throws Exception {
        Strategy strategyLogic1 = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        };

        ContextV2 context = new ContextV2();
        context.execute(strategyLogic1);

    }

    @Test
    public void strategyV3() throws Exception {
        ContextV2 context = new ContextV2();
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });
    }

    @Test
    public void strategyV4() throws Exception {
        ContextV2 context = new ContextV2();
        context.execute(() -> {
            log.info("비즈니스 로직1 실행");
        });
        context.execute(() -> {
            log.info("비즈니스 로직2 실행");
        });
    }


}
