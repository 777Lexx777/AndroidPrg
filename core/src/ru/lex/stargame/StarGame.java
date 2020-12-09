package ru.lex.stargame;

import com.badlogic.gdx.Game;
import ru.lex.stargame.screen.MenuScreen;


public class StarGame extends Game {

	@Override
	public void create() {
		setScreen(new MenuScreen());
	}
}
