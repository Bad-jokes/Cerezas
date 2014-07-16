package com.Game;

import org.andengine.engine.camera.Camera;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

public class RedCherry extends Cherry{	
	
	public RedCherry(float pX, float pY, VertexBufferObjectManager vbo,	Camera camera, PhysicsWorld physicsWorld,ITextureRegion pITextureRegion) {
		super(pX, pY, vbo, camera, physicsWorld, pITextureRegion);
		// TODO Auto-generated constructor stub
		this.id = 1;
	}	
	

}
