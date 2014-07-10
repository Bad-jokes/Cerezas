package com.Manager;

import org.andengine.engine.Engine;
import org.andengine.ui.IGameInterface.OnCreateSceneCallback;

import com.Scene.BaseScene;
import com.Scene.LoadingScene;
import com.Scene.MainMenuScene;
import com.Scene.SplashScene;
import com.Manager.ResourcesManager;
import com.Resources.LoadingResources;
import com.Resources.MenuResources;
import com.Resources.SplashResources;

public class SceneManager {

	//----------------------------------
	// SCENES
	//----------------------------------
	
	private BaseScene splashScene;
	private BaseScene menuScene;
	private BaseScene gameScene;
	private BaseScene loadingScene;
	
	//----------------------------------
	//ATTRIBUTES
	//----------------------------------
		
	private static final SceneManager Instance = new SceneManager();
	private SceneType currentSceneType = SceneType.SCENE_SPLASH;
	private BaseScene currentScene;
	private Engine engine = ResourcesManager.getInstance().getEngine();
	
	public enum SceneType{
		SCENE_SPLASH,
		SCENE_MENU,
		SCENE_GAME,
		SCENE_LOADING
	}

	//----------------------------------
	//GETS AND SETS
	//----------------------------------
	
	public SceneType getCurrentSceneType() {
		return currentSceneType;
	}

	public void setCurrentSceneType(SceneType currentSceneType) {
		this.currentSceneType = currentSceneType;
	}

	public BaseScene getCurrentScene() {
		return currentScene;
	}
	
	public static SceneManager getInstance()
	{
		return Instance;
	}
	
	
	public void setScene(BaseScene scene){
		this.engine.setScene(scene);
		currentScene = scene;
		currentSceneType = scene.getSceneType();		
	}
	
	//----------------------------------
	//CLASS LOGIC
	//----------------------------------		
	
	public void setScene(SceneType sceneType){
		switch (sceneType) {
			case SCENE_SPLASH:
				this.setScene(splashScene);
				break;
			case SCENE_MENU:
				this.setScene(menuScene);
				break;
			case SCENE_GAME:
				this.setScene(gameScene);
				break;
			case SCENE_LOADING:
				this.setScene(loadingScene);
				break;	
			default:
				break;
		}
		
		
		
	}
	
	 public void createSplashScene(OnCreateSceneCallback pOnCreateSceneCallback)
	    {
		 	SplashResources x=new SplashResources();
		 	x.LoadResources();
	        splashScene = new SplashScene(x);
	        currentScene = splashScene;
	        pOnCreateSceneCallback.onCreateSceneFinished(this.splashScene);
	    }
	    
	    public void createMenuScene()
	    {
	    	MenuResources x=new MenuResources();
	    	x.LoadResources();
	    	menuScene = new MainMenuScene(x);
	    	createLoadingScene();
	        setScene(menuScene);
	        disposeSplashScene();
	    }
	    
	    public void createLoadingScene()
	    {
	    	LoadingResources  x=new LoadingResources();
	    	x.LoadResources();
	    	loadingScene=new LoadingScene(x);
	    }
	    
	    private void disposeSplashScene()
	    {
	    	ResourcesManager.getInstance().UnLoadScene(splashScene);
	    	splashScene.disposeScene();
	    	splashScene=null;
	    }
	
}
	
		
	
