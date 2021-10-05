package baseball.Enum;

public enum ScreenSequence {
	NONE(""),
	QUIT("종료"),
    MENU("메뉴"),
	GAMEPLAY("플레이");

	private String screenName;

	ScreenSequence(String screenName) {
		this.screenName = screenName;
	}
}