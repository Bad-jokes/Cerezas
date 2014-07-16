package com.Manager;

import org.andengine.engine.Engine;
import org.andengine.engine.camera.Camera;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.Main.GameActivity;
import com.Scene.BaseScene;

public class ResourcesManager {
	//--------------------------------------------
		//ATTRIBUTES
		//--------------------------------------------
		private static final ResourcesManager Instance = new ResourcesManager();
		
		private Engine engine;
		private GameActivity activity;
		private Camera camera;
		private VertexBufferObjectManager vbom;
		//--------------------------------------------
		
		//--------------------------------------------
		//SETS AND GETS
		//--------------------------------------------
		
		public Engine getEngine() {
			return engine;
		}
		public void setEngine(Engine engine) {
			this.engine = engine;
		}
		public GameActivity getActivity() {
			return activity;
		}
		public void setActivity(GameActivity activity) {
			this.activity = activity;
		}
		public Camera getCamera() {
			return camera;
		}
		public void setCamera(Camera camera) {
			this.camera = camera;
		}
		public VertexBufferObjectManager getVbom() {
			return vbom;
		}
		public void setVbom(VertexBufferObjectManager vbom) {
			this.vbom = vbom;
		}
		public static ResourcesManager getInstance() {
			return Instance;
		}	
		
		 public static void prepareManager(Engine engine, GameActivity activity, Camera camera, VertexBufferObjectManager vbom)
		    {
		        getInstance().engine = engine;
		        getInstance().activity = activity;
		        getInstance().camera = camera;
		        getInstance().vbom = vbom;
		    }
		 
		 //Logica
		 
		 //Escena
		
		public void LoadScene(BaseScene x)
		 {
			x.getResourcesM().LoadResources();
		 }
		 
		 public void UnLoadScene(BaseScene x)
		 {
			 x.getResourcesM().UnLoadResources();
		 }
		 
		 public void ReloadScene(BaseScene x)
		 {
			 x.getResourcesM().ReLoadResources();
		 }

}
