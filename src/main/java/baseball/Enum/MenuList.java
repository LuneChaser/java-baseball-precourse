package baseball.Enum;

import java.util.HashMap;

public enum MenuList {
    NONE(""),
    NEW_GAME("1"),
    QUIT_GAME("2");

    private String menuName;
	
    public static  HashMap<String, MenuList> menuMap = new HashMap<String, MenuList>();
    
    static {
        for (MenuList menuitem : values()) {
            menuMap.put(menuitem.getMenuName(), menuitem);
        }
    }
    
	MenuList(String menuName) {
		this.menuName = menuName;
	}

    public String getMenuName() {
        return this.menuName;
    }

    public static MenuList findBy(String menuName) {
        MenuList menuList = menuMap.get(menuName);

        if(menuList == null) {
            System.out.println("[ERROR] 사용자 입력값이 잘못되었습니다. " + NEW_GAME.getMenuName() + ", " + QUIT_GAME.getMenuName() + "값 중 1개를 입력해주세요");
        }
        
        return menuList;
    }
}