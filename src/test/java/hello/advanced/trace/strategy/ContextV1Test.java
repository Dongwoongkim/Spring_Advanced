package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.ContextV1;
import hello.advanced.trace.strategy.code.strategy.Strategy;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    /*
       전략 패턴 사용
     */
    @Test
    public void strategyTest() throws Exception {
        Strategy strategyLogic1 = new StrategyLogic1();
        ContextV1 context1 = new ContextV1(strategyLogic1);
        context1.execute();
    }

    /**
     * 전략 패턴 또한 익명 클래스 사용 가능
     * @throws Exception
     */
    @Test
    public void strategyV2() throws Exception {
        Strategy strategyLogic1 = new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        };

        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();
    }

    @Test
    public void strategyV3() throws Exception {
        ContextV1 contextV1 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });
        contextV1.execute();
    }

    @Test
    public void strategyV4() throws Exception {
        ContextV1 contextV1 = new ContextV1(() -> {
            log.info("비즈니스 로직1 실행");
        });
        contextV1.execute();
    }


}
