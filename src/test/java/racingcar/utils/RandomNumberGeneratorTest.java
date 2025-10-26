package racingcar.utils;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @DisplayName("디폴트 랜덤 숫자 생성기는 0 이상 9 이하의 숫자를 반환한다.")
    @Test
    public void testGenerateDefaultRandomNumber() {
        RandomNumberGenerator randomNumberGenerator = new DefaultRandomNumberGenerator();
        for (int i = 0; i < 100; i++) {
            int randomNumber = randomNumberGenerator.generate();
            assertTrue(randomNumber >= 0 && randomNumber <= 9);
        }
    }
}