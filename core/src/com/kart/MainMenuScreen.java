package com.kart;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.ScreenUtils;

public class MainMenuScreen implements Screen {
    final MyKartRacingGame game;
    OrthographicCamera camera;
    private Texture roadImage;
    private Texture welcomeImage;
    private Texture pressEnterImage;
    private Rectangle road;
    private Rectangle welcome;
    private Rectangle pressEnter;
    private Music menuMusic;
    public MainMenuScreen(final MyKartRacingGame game){
        this.game = game;

        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/game_menu.wav"));
        menuMusic.setLooping(true);
        menuMusic.play();

        roadImage = new Texture("pics/Road.png");
        welcomeImage = new Texture("pics/welcome1.png");
        pressEnterImage = new Texture("pics/press_enter1.png");

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1200, 840);

        road = new Rectangle();
        road.x = 0;
        road.y = 0;

        welcome = new Rectangle();
        welcome.x = 400;
        welcome.y = 405;

        pressEnter = new Rectangle();
        pressEnter.x = 424;
        pressEnter.y = 372;
    }
    @Override
    public void show() {}
    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(roadImage, road.x, road.y);
        game.batch.draw(welcomeImage, welcome.x, welcome.y);
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
        welcomeImage.dispose();
        pressEnterImage.dispose();
        menuMusic.dispose();
    }
}
