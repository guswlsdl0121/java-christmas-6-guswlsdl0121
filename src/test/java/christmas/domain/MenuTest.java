package christmas.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import christmas.vo.order.MenuQuantity;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MenuTest {

    @ParameterizedTest
    @ValueSource(strings = {"양송이수프", "티본스테이크", "초코케이크"})
    void testFindByMenuName(String menuNameKorean) {
        Optional<Menu> foundMenu = Menu.findByMenuName(menuNameKorean);
        assertTrue(foundMenu.isPresent());
        assertEquals(menuNameKorean, foundMenu.get().getKoranName());
    }

    @Test
    void testCalculatePrice() {
        Menu menu = Menu.T_BONE_STEAK;
        int quantity = 2;
        int expectedPrice = 55000 * quantity;
        assertEquals(expectedPrice, menu.calculatePrice(new MenuQuantity(quantity)));
    }

    @Test
    void testIsDessert() {
        assertTrue(Menu.CHOCO_CAKE.isDessert());
        assertFalse(Menu.T_BONE_STEAK.isDessert());
    }

    @Test
    void testIsMain() {
        assertTrue(Menu.T_BONE_STEAK.isMain());
        assertFalse(Menu.CHOCO_CAKE.isMain());
    }

    @Test
    void testIsBeverage() {
        assertTrue(Menu.ZERO_COLA.isBeverage());
        assertFalse(Menu.T_BONE_STEAK.isBeverage());
    }

    @Test
    void testGetKoranName() {
        assertEquals("티본스테이크", Menu.T_BONE_STEAK.getKoranName());
    }

    @Test
    void testGetMenuName() {
        assertEquals("T_BONE_STEAK", Menu.T_BONE_STEAK.getMenuName());
    }
}
