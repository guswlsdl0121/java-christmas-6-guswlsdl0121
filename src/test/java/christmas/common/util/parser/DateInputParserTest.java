package christmas.common.util.parser;

import java.time.LocalDate;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DateInputParserTest {

    private static Stream<Arguments> provideInputsForParsing() {
        return Stream.of(
                // 정상적인 입력
                Arguments.of("3", LocalDate.of(2023, 12, 3), false),
                Arguments.of("15", LocalDate.of(2023, 12, 15), false),
                // 비정상적인 입력
                Arguments.of("-1", null, true),
                Arguments.of("2147483648", null, true),
                Arguments.of("3.5", null, true),
                Arguments.of("@3", null, true),
                Arguments.of("일", null, true),
                // 비정상적인 날짜
                Arguments.of("32", null, true),
                Arguments.of("0", null, true)
        );
    }

    @ParameterizedTest
    @MethodSource("provideInputsForParsing")
    void testDateInputNumberParser(String input, LocalDate expectedDate, boolean expectException) {
        DateInputParser parser = new DateInputParser();
        if (expectException) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> parser.parse(input));
        } else {
            LocalDate parsedDate = parser.parse(input);
            Assertions.assertEquals(expectedDate, parsedDate);
        }
    }
}
