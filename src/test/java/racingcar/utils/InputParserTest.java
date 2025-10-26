package racingcar.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputParserTest {

    @DisplayName("구분자로 자동차 이름을 분리해 리스트로 반환한다.")
    @ParameterizedTest
    @CsvSource({
            "'pobi,woni', 2",
            "'pobi,woni,jun', 3",
            "'pobi', 1"
    })
    void splitCarName(String input, int expectedSize) {
        List<String> result = InputParser.splitCarName(input);
        assertThat(result.size()).isEqualTo(expectedSize);
    }
}