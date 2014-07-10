package com.Scene;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.entity.scene.Scene;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.Manager.ResourcesManager;
import com.Manager.SceneManager.SceneType;
import com.Resources.ResourcesBase;

import android.app.Activity;

public abstract class BaseScene extends Scene{	
	
	//----------------------------------
	//ATTRIBUTES
	//----------------------------------
	
	protected Engine engine;
	protected Activity activity;
	protected Camera camera;	
	protected VertexBufferObjectManager vbom;
	
	//----------------------------------
	//CONSTRUCTOR
	//----------------------------------
	
	public BaseScene(){		
		this.engine = ResourcesManager.getInstance().getEngine();
		this.activity = ResourcesManager.getInstance().getActivity();
		this.camera = ResourcesManager.getInstance().getCamera();
		this.vbom = ResourcesManager.getInstance().getVbom();
	}
	
	//----------------------------------
	//ABSTRACTTION
	//----------------------------------
	
	public abstract void createScene();
	
	public abstract void onBackKeyPressed();
	
	public abstract SceneType getSceneType();
	
	public abstract void disposeScene();
	
	public abstract ResourcesBase getResourcesM();
	
	
}
