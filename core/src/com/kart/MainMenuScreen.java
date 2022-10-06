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
    private Texture backImage;
    private Texture redShellImage;
    private Texture greenShellImage;
    private Texture blooperImage;
    private Texture coinImage;
    private Texture bulletImage;
    private Texture beerImage;
    private Texture friesImage;
    private Rectangle road;
    private Rectangle welcome;
    private Rectangle pressEnter;
    private Rectangle back;
    private Rectangle redShell;
    private Rectangle greenShell;
    private Rectangle blooper;
    private Rectangle coin;
    private Rectangle bullet;
    private Rectangle beer;
    private Rectangle fries;
    private Music menuMusic;
    public MainMenuScreen(final MyKartRacingGame game){
        this.game = game;

        menuMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/game_menu.wav"));
        menuMusic.setLooping(true);
        menuMusic.play();

        roadImage = new Texture("pics/Road.png");
        welcomeImage = new Texture("pics/welcome1.png");
        pressEnterImage = new Texture("pics/press_enter1.png");
        backImage = new Texture("pics/game_road_back.png");
        redShellImage = new Texture("pics/red-shell.png");
        greenShellImage = new Texture("pics/green-shell.png");
        blooperImage = new Texture("pics/blooper.png");
        coinImage = new Texture("pics/coin.png");
        bulletImage = new Texture("pics/bullet.png");
        beerImage = new Texture("pics/beer.png");
        friesImage = new Texture("pics/fries.png");

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1200, 840);

        road = new Rectangle();
        road.x = 0;
        road.y = 0;

        welcome = new Rectangle();
        welcome.x = 400;
        welcome.y = 395;

        pressEnter = new Rectangle();
        pressEnter.x = 424;
        pressEnter.y = 363;

        back = new Rectangle();
        back.x = 360;
        back.y = 0;

        redShell = new Rectangle();
        redShell.x = 375;
        redShell.y = 760;

        greenShell = new Rectangle();
        greenShell.x = 375;
        greenShell.y = 570;

        blooper = new Rectangle();
        blooper.x = 379;
        blooper.y = 655;

        coin = new Rectangle();
        coin.x = 375;
        coin.y = 230;

        bullet = new Rectangle();
        bullet.x = 392;
        bullet.y = 472;

        beer = new Rectangle();
        beer.x = 382;
        beer.y = 120;

        fries = new Rectangle();
        fries.x = 381;
        fries.y = 20;
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
        game.batch.draw(backImage, back.x, back.y);
        game.batch.draw(welcomeImage, welcome.x, welcome.y);
        game.batch.draw(pressEnterImage, pressEnter.x, pressEnter.y);
        game.batch.draw(redShellImage, redShell.x, redShell.y);
        game.font.draw(game.batch, "---Hit him and you louse a live!", 500, redShell.y+40);
        game.batch.draw(greenShellImage, greenShell.x, greenShell.y);
        game.font.draw(game.batch, "---Hit him and you louse a live!", 500, greenShell.y+40);
        game.batch.draw(blooperImage, blooper.x, blooper.y);
        game.font.draw(game.batch, "---Hit him and you louse a live!", 500, blooper.y+50);
        game.batch.draw(coinImage, coin.x, coin.y);
        game.font.draw(game.batch, "---Grab it and you get 10 points!", 500, coin.y+40);
        game.batch.draw(bulletImage, bullet.x, bullet.y);
        game.font.draw(game.batch, "---Hit him and you louse a live!", 500, bullet.y+40);
        game.batch.draw(beerImage, beer.x, beer.y);
        game.font.draw(game.batch, "---Drink it and you get drunk!", 500, beer.y+35);
        game.batch.draw(friesImage, fries.x, fries.y);
        game.font.draw(game.batch, "---eat them and you win a live ", 500, fries.y+50);
        game.font.draw(game.batch, "   but if you are drunk you only get sober!", 500, fries.y+20);
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
