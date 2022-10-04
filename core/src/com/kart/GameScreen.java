package com.kart;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;

public class GameScreen implements Screen {
    final MyKartRacingGame game;
    private Texture roadImage;
    private Texture kartImage;
    private Texture redShellImage;
    private Texture greenShellImage;
    private Texture blooperImage;
    private Texture coinImage;
    private Texture bulletImage;
    private Texture beerImage;
    private Texture friesImage;
    private Texture blackImage;
    private SpriteBatch batch;
    private OrthographicCamera camera;
    private Rectangle road;
    private Rectangle kart;
    private Rectangle black;
    private Rectangle black2;
    private double speed = 1.5;
    private Array<Rectangle> Obstacles;
    private Array<Rectangle> Obstacles2;
    private Array<Rectangle> Obstacles3;
    private Array<Rectangle> Obstacles4;
    private Array<Rectangle> Obstacles5;
    private Array<Rectangle> Obstacles6;
    private Array<Rectangle> Obstacles7;
    long lastDropTime;
    long lastDropTime2;
    private Music gameMusic;
    private Music gameDrunkMusic;
    private Sound hitSound;
    private Sound coinSound;
    private Sound bulletSound;
    private Sound beerSound;
    private Sound friesSound;
    private Sound louseSound;
    private Sound startEngineSound;
    private boolean isDrunk = false;
    private int score = 0;
    private int speedObstacles = 460;
    private int lives = 3;
    private int randomX () {
        int random = (int) Math.floor(Math.random() * 2);
        int x = 0;
        switch (random){
            case 0:
                return  510;
            case 1:
                return  760;
        }
        return x;
    }
    private int randomX2 () {
        int random = (int) Math.floor(Math.random() * 2);
        int x = 0;
        switch (random){
            case 0:
                return  400;
            case 1:
                return  640;
        }
        return x;
    }
    private void spawnObstacles(){
        Rectangle obstacle = new Rectangle();
        obstacle.x = randomX();
        obstacle.y = 840;
        obstacle.width = 55;
        obstacle.height = 55;
        Obstacles.add(obstacle);
        lastDropTime = TimeUtils.nanoTime();
    }
    private void spawnObstacles2(){
        Rectangle obstacle2 = new Rectangle();
        obstacle2.x = randomX2();
        obstacle2.y = 840;
        obstacle2.width = 55;
        obstacle2.height = 55;
        Obstacles2.add(obstacle2);
        lastDropTime2 = TimeUtils.nanoTime();
    }
    private void spawnObstacles3(){
        Rectangle obstacle3 = new Rectangle();
        obstacle3.x = randomX();
        obstacle3.y = 840;
        obstacle3.width = 55;
        obstacle3.height = 55;
        Obstacles3.add(obstacle3);
        lastDropTime = TimeUtils.nanoTime();
    }
    private void spawnObstacles4(){
        Rectangle obstacle4 = new Rectangle();
        obstacle4.x = randomX2();
        obstacle4.y = 840;
        obstacle4.width = 55;
        obstacle4.height = 55;
        Obstacles4.add(obstacle4);
        lastDropTime2 = TimeUtils.nanoTime();
    }
    private void spawnObstacles5(){
        Rectangle obstacle5 = new Rectangle();
        obstacle5.x = randomX();
        obstacle5.y = 840;
        obstacle5.width = 55;
        obstacle5.height = 55;
        Obstacles5.add(obstacle5);
        lastDropTime = TimeUtils.nanoTime();
    }
    private void spawnObstacles6(){
        Rectangle obstacle6 = new Rectangle();
        obstacle6.x = randomX2();
        obstacle6.y = 840;
        obstacle6.width = 55;
        obstacle6.height = 55;
        Obstacles6.add(obstacle6);
        lastDropTime2 = TimeUtils.nanoTime();
    }
    private void spawnObstacles7(){
        Rectangle obstacle7 = new Rectangle();
        obstacle7.x = randomX();
        obstacle7.y = 840;
        obstacle7.width = 55;
        obstacle7.height = 55;
        Obstacles7.add(obstacle7);
        lastDropTime = TimeUtils.nanoTime();
    }
    public GameScreen(final MyKartRacingGame game){
        this.game = game;

        roadImage = new Texture("pics/Road.png");
        kartImage = new Texture("pics/mario-kart.png");
        redShellImage = new Texture("pics/red-shell.png");
        greenShellImage = new Texture("pics/green-shell.png");
        blooperImage = new Texture("pics/blooper.png");
        coinImage = new Texture("pics/coin.png");
        bulletImage = new Texture("pics/bullet.png");
        beerImage = new Texture("pics/beer.png");
        friesImage = new Texture("pics/fries.png");
        blackImage = new Texture("pics/black.png");

        coinSound = Gdx.audio.newSound(Gdx.files.internal("audio/game_coin-sound.wav"));
        hitSound = Gdx.audio.newSound(Gdx.files.internal("audio/game_hit.wav"));
        bulletSound = Gdx.audio.newSound(Gdx.files.internal("audio/game_bullet.wav"));
        beerSound = Gdx.audio.newSound(Gdx.files.internal("audio/game_beer.wav"));
        friesSound = Gdx.audio.newSound(Gdx.files.internal("audio/game_fries.wav"));
        louseSound = Gdx.audio.newSound(Gdx.files.internal("audio/game_louse.mp3"));
        startEngineSound = Gdx.audio.newSound(Gdx.files.internal("audio/game_start_engine.mp3"));
        gameMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/game.wav"));
        gameDrunkMusic = Gdx.audio.newMusic(Gdx.files.internal("audio/game_drunk.wav"));

        gameMusic.setLooping(true);
        gameMusic.play();
        gameDrunkMusic.setLooping(true);
        startEngineSound.play();


        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1200, 840);

        road = new Rectangle();
        road.x = 0;
        road.y = 0;

        kart = new Rectangle();
        kart.x = 525;
        kart.y = 10;
        kart.width = 120;
        kart.height = 120;

        black = new Rectangle();
        black.x = 0;
        black.y = 720;

        black2 = new Rectangle();
        black2.x = 900;
        black2.y = 720;

        Obstacles = new Array<Rectangle>();
        Obstacles2 = new Array<Rectangle>();
        Obstacles3 = new Array<Rectangle>();
        Obstacles4 = new Array<Rectangle>();
        Obstacles5 = new Array<Rectangle>();
        Obstacles6 = new Array<Rectangle>();
        Obstacles7 = new Array<Rectangle>();
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        camera.update();

        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(roadImage, road.x, road.y);
        game.batch.draw(kartImage, kart.x, kart.y);
        game.batch.draw(blackImage, black.x, black.y);
        game.batch.draw(blackImage, black2.x, black2.y);
        game.font.draw(game.batch, "YOU HAVE : "+lives+" LIVES!", 70,750);
        game.font.draw(game.batch, "YOU HAVE : "+score+" POINTS!", 990,750);
        for(Rectangle obstacle: Obstacles){
            game.batch.draw(greenShellImage, obstacle.x, obstacle.y);
        }
        for (Rectangle obstacle2: Obstacles2){
            game.batch.draw(blooperImage, obstacle2.x, obstacle2.y);
        }
        for (Rectangle obstacle3: Obstacles3){
            game.batch.draw(redShellImage, obstacle3.x, obstacle3.y);
        }
        for (Rectangle obstacle4: Obstacles4){
            game.batch.draw(coinImage, obstacle4.x, obstacle4.y);
        }
        for (Rectangle obstacle5: Obstacles5){
            game.batch.draw(bulletImage, obstacle5.x, obstacle5.y);
        }
        for (Rectangle obstacle6: Obstacles6){
            game.batch.draw(beerImage, obstacle6.x, obstacle6.y);
        }
        for (Rectangle obstacle7: Obstacles7){
            game.batch.draw(friesImage, obstacle7.x, obstacle7.y);
        }
        game.batch.end();


        road.y -= 350*speed * Gdx.graphics.getDeltaTime();
        if(road.y < -840) road.y = 0;

        if(isDrunk){
            if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                kartImage = new Texture("pics/mario-kart-R1.png");
                kart.x += 250 * Gdx.graphics.getDeltaTime();
            }
            if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                kartImage = new Texture("pics/mario-kart-L1.png");
                kart.x -= 250 * Gdx.graphics.getDeltaTime();
            }
        }
        else{
            if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
                kartImage = new Texture("pics/mario-kart-L1.png");
                kart.x -= 350 * Gdx.graphics.getDeltaTime();
            }
            if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
                kartImage = new Texture("pics/mario-kart-R1.png");
                kart.x += 350 * Gdx.graphics.getDeltaTime();
            }
        }
        if(!Gdx.input.isKeyPressed(Input.Keys.ANY_KEY)){
            kartImage = new Texture("pics/mario-kart.png");
        }
        if(kart.x > 900 - 170) kart.x = 900 - 170;
        if(kart.x < 320) kart.x = 320;


        int random = (int) Math.floor(Math.random() * speedObstacles);
        if(random == 20 || random == 33){spawnObstacles();}
        if (random == 1 || random == 111){spawnObstacles2();}
        if(random == 80 || random == 9){spawnObstacles3();}
        if(random == 100 || random == 150){spawnObstacles4();}
        if(random == 50){spawnObstacles5();}
        if(random == 70 || random == 200){spawnObstacles6();}
        if(random == 30 || random == 229){spawnObstacles7();}
        Iterator<Rectangle> iter = Obstacles.iterator();
        while (iter.hasNext()){
            Rectangle shell = iter.next();
            shell.y -= 350*speed * Gdx.graphics.getDeltaTime();
            if(shell.y + 100 < 0) iter.remove();
            if (shell.overlaps(kart)){
                lives--;
                iter.remove();
                hitSound.play();
            }
            for (Rectangle fries: Obstacles7){
                if(shell.overlaps(fries)){Obstacles7.removeIndex(Obstacles7.indexOf(fries,true));}
            }
        }
        Iterator<Rectangle> iter2 = Obstacles2.iterator();
        while (iter2.hasNext()){
            Rectangle blooper = iter2.next();
            blooper.y -= 315*speed * Gdx.graphics.getDeltaTime();
            if(blooper.y +100 < 0) iter2.remove();
            if (blooper.overlaps(kart)){
                lives--;
                iter2.remove();
                hitSound.play();
            }
            for (Rectangle coin: Obstacles4){
                if(blooper.overlaps(coin)){Obstacles4.removeIndex(Obstacles4.indexOf(coin,true));}
            }
            for (Rectangle beer: Obstacles6){
                if(blooper.overlaps(beer)){Obstacles6.removeIndex(Obstacles6.indexOf(beer,true));}
            }
        }
        Iterator<Rectangle> iter3 = Obstacles3.iterator();
        if (iter3.hasNext()){
            Rectangle rShell = iter3.next();
            rShell.y -= 350*speed * Gdx.graphics.getDeltaTime();
            if(rShell.y + 100 < 0) iter3.remove();
            if (rShell.overlaps(kart)){
                lives--;
                iter3.remove();
                hitSound.play();
            }
            for (Rectangle shell: Obstacles){
                if(rShell.overlaps(shell)){Obstacles.removeIndex(Obstacles.indexOf(shell,true));}
            }
            for (Rectangle fries: Obstacles7){
                if(rShell.overlaps(fries)){Obstacles7.removeIndex(Obstacles7.indexOf(fries,true));}
            }
        }
        Iterator<Rectangle> iter4 = Obstacles4.iterator();
        if (iter4.hasNext()){
            Rectangle coin = iter4.next();
            coin.y -= 350*speed * Gdx.graphics.getDeltaTime();
            if(coin.y + 100 < 0) iter4.remove();
            if (coin.overlaps(kart)){
                iter4.remove();
                coinSound.play();
                score += 10;
                if(score % 100 == 0){
                    speed += 0.2;
                    if(speedObstacles > 230){speedObstacles -= 10;}
                }
            }
            for (Rectangle beer: Obstacles6){
                if(coin.overlaps(beer)){Obstacles6.removeIndex(Obstacles6.indexOf(beer,true));}
            }
        }
        Iterator<Rectangle> iter5 = Obstacles5.iterator();
        if (iter5.hasNext()){
            Rectangle bullet = iter5.next();
            bullet.y -= 650*speed * Gdx.graphics.getDeltaTime();
            if(bullet.y + 100 < 0) iter5.remove();
            if (bullet.overlaps(kart)){
                lives--;
                iter5.remove();
                bulletSound.play();
            }
            for (Rectangle shell: Obstacles){
                if(bullet.overlaps(shell)){Obstacles.removeIndex(Obstacles.indexOf(shell,true));}
            }
            for (Rectangle rShell: Obstacles3){
                if(bullet.overlaps(rShell)){Obstacles3.removeIndex(Obstacles3.indexOf(rShell,true));}
            }
            for (Rectangle fries: Obstacles7){
                if(bullet.overlaps(fries)){Obstacles7.removeIndex(Obstacles7.indexOf(fries,true));}
            }
        }
        Iterator<Rectangle> iter6 = Obstacles6.iterator();
        if (iter6.hasNext()){
            Rectangle beer = iter6.next();
            beer.y -= 350*speed * Gdx.graphics.getDeltaTime();
            if(beer.y + 100 < 0) iter6.remove();
            if (beer.overlaps(kart)){
                iter6.remove();
                if(isDrunk == false){
                    gameMusic.stop();
                    gameDrunkMusic.play();
                }
                beerSound.play();
                isDrunk = true;
            }
        }
        Iterator<Rectangle> iter7 = Obstacles7.iterator();
        if (iter7.hasNext()){
            Rectangle fries = iter7.next();
            fries.y -= 350*speed * Gdx.graphics.getDeltaTime();
            if(fries.y + 100 < 0) iter7.remove();
            if (fries.overlaps(kart)){
                iter7.remove();
                if (isDrunk){
                    gameDrunkMusic.stop();
                    gameMusic.play();
                }
                else{
                    if(lives < 3){lives++;}
                }
                friesSound.play();
                isDrunk = false;
            }
        }
        if(lives <= 0){
            gameMusic.stop();
            gameDrunkMusic.stop();
            beerSound.stop();
            friesSound.stop();
            bulletSound.stop();
            hitSound.stop();
            louseSound.play();
            game.setScreen(new GameOverScreen(game));
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
        kartImage.dispose();
        redShellImage.dispose();
        greenShellImage.dispose();
        blooperImage.dispose();
        coinImage.dispose();
        friesImage.dispose();
        bulletImage.dispose();
        beerImage.dispose();
        gameMusic.dispose();
        gameDrunkMusic.dispose();
        beerSound.dispose();
        friesSound.dispose();
        bulletSound.dispose();
        hitSound.dispose();
        louseSound.dispose();
        batch.dispose();
    }
}
