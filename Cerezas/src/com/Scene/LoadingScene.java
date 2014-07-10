package com.Scene;



import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;
import org.andengine.util.adt.color.Color;

import com.Manager.SceneManager.SceneType;
import com.Resources.LoadingResources;
import com.Resources.ResourcesBase;

public class LoadingScene extends BaseScene
{
	//Atributos
		private LoadingResources x;

	//Logica
		
	public LoadingScene(LoadingResources y){
			this.x=y;
		    
			this.createScene();
	}
		
	 @Override
	    public void createScene()
	    {
	    	setBackground(new Background(Color.WHITE));
	        attachChild(new Text(400, 240, x.getFont(), "Loading...", vbom));
	    }

	    @Override
	    public void onBackKeyPressed()
	    {
	        return;
	    }

	    @Override
	    public SceneType getSceneType()
	    {
	        return SceneType.SCENE_LOADING;
	    }

	    @Override
	    public void disposeScene()
	    {

	    }

		@Override
		public ResourcesBase getResourcesM() 
		{
			return x;
		}
	    
}
