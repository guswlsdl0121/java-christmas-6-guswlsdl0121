package christmas.input.parser;

import christmas.input.creator.DateCreator;
import christmas.input.result.DateParseResult;
import christmas.input.validator.date.DateValidator;
import java.time.LocalDate;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DateParserTest {
    private final DateParser parser = new DateParser(new DateValidator());
    private final DateCreator creator = new DateCreator();

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
        if (expectException) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                DateParseResult parseResult = parser.parse(input);
                creator.create(parseResult);
            });
        } else {
            DateParseResult parseResult = parser.parse(input);
            LocalDate parsedDate = creator.create(parseResult);
            Assertions.assertEquals(expectedDate, parsedDate);
        }
    }
}
