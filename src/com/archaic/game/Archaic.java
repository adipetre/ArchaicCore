package com.archaic.game;

import com.archaic.game.components.Society;
import com.archaic.game.living.Animal;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

public class Archaic implements ApplicationListener, GestureListener, InputProcessor {
	private SpriteBatch batch;
	private Texture img;
	private Sprite sprite;
	private BitmapFont font;
	private OrthographicCamera camera;
	private Society society;
	
	@Override
	public void create () {
		camera = new OrthographicCamera(1280, 720);
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		sprite = new Sprite(img);
		font = new BitmapFont();
		Gdx.input.setInputProcessor(new GestureDetector(this));
		society = new Society();
		society.addMember(new Animal.Builder().createChild(society).create());
		society.addMember(new Animal.Builder().createChild(society).create());
		society.addMember(new Animal.Builder().createChild(society).create());
		society.addMember(new Animal.Builder().createChild(society).create());
		society.addMember(new Animal.Builder().createChild(society,
				society.getMembers().iterator().next(),
				society.getMembers().iterator().next()).create());
		society.addMember(new Animal.Builder().createChild(society,
				society.getMembers().iterator().next(),
				society.getMembers().iterator().next()).create());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		//batch.draw(img, 0, 0);
		//sprite.setPosition(0, 0);
		sprite.draw(batch);
		//sprite.setPosition(400, 200);
		//sprite.draw(batch);
		font.draw(batch, "and so it begins!" + society.getMemberSexRatio(), 200, 200);
		batch.end();
	}
	
	@Override
	public void dispose()
	{
		batch.dispose();
		img.dispose();
		font.dispose();
	}

	@Override
	public boolean fling(float arg0, float arg1, int arg2) {
		// 
		return false;
	}

	@Override
	public boolean longPress(float arg0, float arg1) {
		// 
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		camera.translate(-deltaX, deltaY);
		camera.update();
		return false;
	}

	@Override
	public boolean panStop(float arg0, float arg1, int arg2, int arg3) {
		// 
		return false;
	}

	@Override
	public boolean pinch(Vector2 arg0, Vector2 arg1, Vector2 arg2, Vector2 arg3) {
		// 
		return false;
	}

	@Override
	public boolean tap(float arg0, float arg1, int arg2, int arg3) {
		// 
		return false;
	}

	@Override
	public boolean touchDown(float arg0, float arg1, int arg2, int arg3) {
		// 
		return false;
	}

	@Override
	public boolean zoom(float arg0, float arg1) {
		// 
		return false;
	}

	@Override
	public void pause() {
		// 
		
	}

	@Override
	public void resize(int arg0, int arg1) {
		// 
		
	}

	@Override
	public void resume() {
		// 
		
	}

	@Override
	public boolean keyDown(int arg0) {
		// 
		return false;
	}

	@Override
	public boolean keyTyped(char arg0) {
		// 
		return false;
	}

	@Override
	public boolean keyUp(int arg0) {
		// 
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		//camera.translate(screenX, screenY);
		//camera.update();
		
		return true;
	}

	@Override
	public boolean scrolled(int arg0) {
		// 
		return false;
	}

	@Override
	public boolean touchDown(int arg0, int arg1, int arg2, int arg3) {
		// 
		return false;
	}

	@Override
	public boolean touchDragged(int x, int y, int pointer) {
		
		return false;
	}

	@Override
	public boolean touchUp(int arg0, int arg1, int arg2, int arg3) {
		// 
		return false;
	}
}
