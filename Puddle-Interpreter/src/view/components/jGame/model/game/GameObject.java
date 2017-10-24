package view.components.jGame.model.game;

import view.components.jGame.model.graphics.Camera;
import view.components.jGame.model.input.Input;
import view.components.jGame.view.Renderer;

public interface GameObject {

	public void reset();
	public abstract void input(Input input, long deltaTime, Camera camera);
	public abstract void logic(long deltaTime);
	public abstract void render(Renderer renderer, Camera camera);
	public void close();
}