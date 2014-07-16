package com.Scene;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.camera.hud.HUD;
import org.andengine.entity.sprite.Sprite;
import org.andengine.entity.text.Text;
import org.andengine.entity.text.TextOptions;
import org.andengine.opengl.util.GLState;
import org.andengine.util.adt.align.HorizontalAlign;

import com.Manager.SceneManager.SceneType;
import com.Resources.GameResources;
import com.Resources.MenuResources;
import com.Resources.ResourcesBase;
import com.Manager.SceneManager;

public class GameScene extends BaseScene 
{
	
	//Atributos--------------------
		private HUD gameHUD;
		private Text scoreText;
		private int score = 0;
		
		private GameResources Resources;

		
		
	//Logica
		
	public GameScene(GameResources y)
	{
		this.Resources=y;
		this.createScene();
	}
	
	@Override
	public void createScene() 
	{
		createBackground();
		createHUD();
		
	}
	
	private void createBackground(){
		attachChild(new Sprite(400,240,Resources.getBackground(),vbom)
		{
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera){
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		});		
	}
	
	private void createHUD()
    {
    	 gameHUD = new HUD();
    	    
    	    // CREATE SCORE TEXT
    	 
    	    scoreText = new Text(20, 420, Resources.getFont(), "Score: 0123456789",new TextOptions(HorizontalAlign.LEFT), vbom);
    	    scoreText.setAnchorCenter(0, 0);    
    	    scoreText.setText("Score: 0");
    	    gameHUD.attachChild(scoreText);
    	    
    	    camera.setHUD(gameHUD);
    }

	@Override
	public void onBackKeyPressed() 
	{
		SceneManager.getInstance().loadMenuScene(engine);
	}

	@Override
	public SceneType getSceneType() 
	{
		return SceneType.SCENE_GAME;
	}

	@Override
	public void disposeScene()
	{
        camera.setHUD(null);
        camera.setCenter(400, 240);
	}

	@Override
	public ResourcesBase getResourcesM() 
	{
		return Resources;
	}

}
