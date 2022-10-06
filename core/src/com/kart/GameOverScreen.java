package com.kart;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class GameOverScreen implements Screen {
    final MyKartRacingGame game;
    OrthographicCamera camera;
    private Texture roadImage;
    private Texture youLouseImage;
    private Texture pressEnterImage;
    private Texture backImage;
    private Rectangle road;
    private Rectangle youLouse;
    private Rectangle pressEnter;
    private Rectangle back;
    public GameOverScreen(final MyKartRacingGame game){
        this.game = game;

        roadImage = new Texture("pics/Road.png");
        youLouseImage = new Texture("pics/you_louse.png");
        pressEnterImage = new Texture("pics/press_enter1.png");
        backImage = new Texture("pics/game_road_back.png");

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1200, 840);

        road = new Rectangle();
        road.x = 0;
        road.y = 0;

        youLouse = new Rectangle();
        youLouse.x = 400;
        youLouse.y = 405;

        pressEnter = new Rectangle();
        pressEnter.x = 424;
        pressEnter.y = 372;

        back = new Rectangle();
        back.x = 360;
        back.y = 0;
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(roadImage, road.x, road.y);
        game.batch.draw(backImage, back.x, back.y);
        game.batch.draw(youLouseImage, youLouse.x, youLouse.y);
        game.batch.draw(pressEnterImage, pressEnter.x, pressEnter.y);
        game.batch.end();

        if (Gdx.input.isKeyPressed(Input.Keys.ENTER)){
            game.setScreen(new GameScreen(game));
            dispose();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        roadImage.dispose();
        pressEnterImage.dispose();
        youLouseImage.dispose();
    }
}
