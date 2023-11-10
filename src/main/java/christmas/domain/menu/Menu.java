package christmas.domain.menu;

import christmas.vo.MenuQuantity;

public enum Menu {
    //애피타이저
    MUSHROOM_SOUP(MenuType.APPETIZER, MenuName.MUSHROOM_SOUP, 6000),
    TAPAS(MenuType.APPETIZER, MenuName.TAPAS, 5500),
    CAESAR_SALAD(MenuType.APPETIZER, MenuName.CAESAR_SALAD, 8000),

    //메인
    T_BONE_STEAK(MenuType.MAIN, MenuName.T_BONE_STEAK, 55000),
    BBQ_RIBS(MenuType.MAIN, MenuName.BBQ_RIBS, 54000),
    SEAFOOD_PASTA(MenuType.MAIN, MenuName.SEAFOOD_PASTA, 35000),
    CHRISTMAS_PASTA(MenuType.MAIN, MenuName.CHRISTMAS_PASTA, 25000),

    //디저트
    CHOCO_CAKE(MenuType.DESSERT, MenuName.CHOCO_CAKE, 15000),
    ICE_CREAM(MenuType.DESSERT, MenuName.ICE_CREAM, 5000),

    //음료
    ZERO_COLA(MenuType.BEVERAGE, MenuName.ZERO_COLA, 3000),
    RED_WINE(MenuType.BEVERAGE, MenuName.RED_WINE, 60000),
    CHAMPAGNE(MenuType.BEVERAGE, MenuName.CHAMPAGNE, 25000);

    private final MenuType menuType;
    private final MenuName menuName;
    private final int price;

    Menu(MenuType menuType, MenuName menuName, int price) {
        this.menuType = menuType;
        this.menuName = menuName;
        this.price = price;
    }

    public int calculatePrice(MenuQuantity menuQuantity) {
        return this.price * menuQuantity.getQuantity();
    }
}
