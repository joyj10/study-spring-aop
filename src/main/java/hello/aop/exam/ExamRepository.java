package hello.aop.exam;

import hello.aop.exam.annotation.Retry;
import hello.aop.exam.annotation.Trace;
import org.springframework.stereotype.Repository;

@Repository
public class ExamRepository {

    private static int seq = 0;

    /**
     * 5번에 1번 실패 하는 요청
     * : retry 테스트 위한 설정
     * retry 조심해서 사용해야 함 max가 꼭 필요하며, 간헐적으로 발생하고, 재시도해도 이슈가 없을 때 사용해야 함
     */
    @Trace
    @Retry
    public String save(String itemId) {
        seq++;
        if (seq % 5 == 0) {
            throw new IllegalStateException("예외 발생");
        }
        return "ok " + itemId;
    }
}
