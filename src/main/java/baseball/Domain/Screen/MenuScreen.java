package baseball.Domain.Screen;

import baseball.GameMainLoop;
import baseball.Enum.MenuList;
import baseball.Enum.ScreenSequence;

import nextstep.utils.Console;

public class MenuScreen extends Screen {
    public MenuScreen(GameMainLoop gameLoop) {
        super(gameLoop);
    }

    @Override
    public void run() {
        render();

        MenuList tempIntroType = getIntroMenuItem();

        if(tempIntroType == MenuList.NEW_GAME) {
            changeScreenSequence(ScreenSequence.GAMEPLAY);
        } else if(tempIntroType == MenuList.QUIT_GAME) {
            changeScreenSequence(ScreenSequence.QUIT);
        }
    }

    public void render() {
        System.out.println("게임을 새로 시작하려면 " + MenuList.NEW_GAME.getMenuName() + ", 종료하려면 " + MenuList.QUIT_GAME.getMenuName() + "를 입력하세요.");
    }

    public MenuList getIntroMenuItem() {
        try {
            return MenuList.findBy(Console.readLine());
        }
        catch(IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        return MenuList.NONE;
    }
}
