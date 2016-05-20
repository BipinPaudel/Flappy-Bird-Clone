package com.bipin.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.bipin.game.FlappyDemo;

/**
 * Created by bips on 5/16/16.
 */
public class MenuState extends State {
    Texture backGroundImage;
    Texture playButton;

    public MenuState(com.bipin.game.states.GameStateManager gsm) {
        super(gsm);
        playButton=new Texture("playbtn.png");
        backGroundImage=new Texture("bg.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
        dispose();
        }

    }

    @Override
    public void update(float dt) {
        handleInput();
        //dispose();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(backGroundImage,0,0,
                FlappyDemo.WIDTH,FlappyDemo.HEIGHT);
        sb.draw(playButton,
                (FlappyDemo.WIDTH/2) - (playButton.getWidth()/2),
                FlappyDemo.HEIGHT/2);
        sb.end();
    }

    @Override
    public void dispose() {
backGroundImage.dispose();
        playButton.dispose();
        System.out.println("Menu state disposed");
    }


}
