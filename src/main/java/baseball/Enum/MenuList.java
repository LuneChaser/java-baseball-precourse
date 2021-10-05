package baseball.Enum;

public enum MenuList {
    NONE(""),
    NEW_GAME("1"),
    QUIT_GAME("2");

    private String menuName;
	
	MenuList(String menuName) {
		this.menuName = menuName;
	}

    public String getMenuName() {
        
        return this.menuName;
    }

    public static MenuList findBy(String menuName) {
        for(MenuList value : values()){
            if(value.getMenuName().equals(menuName)) {
                return value;
            }
        }

        throw new IllegalArgumentException("[ERROR] 사용자 입력값이 잘못되었습니다. " + NEW_GAME.getMenuName() + ", " + QUIT_GAME.getMenuName() + "값 중 1개를 입력해주세요");
    }
}