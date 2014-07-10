package com.Scene;



import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;

import com.Resources.ResourcesBase;
import com.Resources.SplashResources;
import com.Scene.BaseScene;
import com.Manager.SceneManager.SceneType;


public class SplashScene extends BaseScene
{
	private Sprite splash;
	private SplashResources x;
	
	public SplashScene(SplashResources y)
	{
		this.x=y;
	    
		this.createScene();
	}
	
    @Override
    public void createScene()
    {
    	this.attachChild(splash = new Sprite(400,240,x.getSplash(),vbom){
			@Override
			protected void preDraw(GLState pGLState, Camera pCamera){
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		});			

    }

    @Override
    public void onBackKeyPressed()
    {
    	System.exit(0);
    }

    @Override
    public SceneType getSceneType()
    {
    	return SceneType.SCENE_SPLASH;
    }

    @Override
    public void disposeScene()
    {
    	splash.detachSelf();
        splash.dispose();
        this.detachSelf();
        this.dispose();
    }

	@Override
	public ResourcesBase getResourcesM() 
	{
		return x;
	}

    
    
}