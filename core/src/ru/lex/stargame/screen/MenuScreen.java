package ru.lex.stargame.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import ru.lex.stargame.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private static final float V_len = 1.5f;
    private Texture img;
    private Vector2 pos;
    private Vector2 click;
    private Vector2 v1;
    private Vector2 v2;

    @Override
    public void show() {

        img = new Texture("sokol.jpg");
        pos = new Vector2();
        click = new Vector2();
        v1 = new Vector2();
        v2 = new Vector2();
        super.show();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        v2.set(click);
        if (v2.sub(pos).len() > v1.len()){
            pos.add(v1);
        }else {
            pos.set(click);
        }

        Gdx.gl.glClearColor(0.5f, 0.5f, 0.5f, 5);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(img, pos.x,pos.y,100,130);
        batch.end();
//        pos.sub(v);
//        pos.add(v1);
//        pos.nor();
        //v.add(v1);
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
        super.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        click.set(screenX,Gdx.graphics.getHeight() - screenY);
        System.out.println(1);
        v1.set(click.cpy().sub(pos)).setLength(V_len);
        System.out.println(2);

        //pos.set(screenX,screenY);
//        pos.nor();
//        v.nor();
        //pos.scl(screenX,Gdx.graphics.getHeight() - screenY -2);
      //  pos.scl(0.9f);
       // System.out.println(3);
     //   v1.set(pos);
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        pos.set(screenX,Gdx.graphics.getHeight() - screenY);
        return super.touchDragged(screenX, screenY, pointer);
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode){
            case Input.Keys.UP:
                pos.y += 10;
                break;
            case Input.Keys.DOWN:
                pos.y -= 10;
                break;
            case Input.Keys.RIGHT:
                pos.x += 10;
                break;
            case Input.Keys.LEFT:
                pos.x -= 10;
                break;
        }
        return super.keyDown(keycode);
    }
}
