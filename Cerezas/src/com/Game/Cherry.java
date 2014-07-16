package com.Game;

import org.andengine.engine.camera.Camera;
import org.andengine.entity.sprite.Sprite;
import org.andengine.extension.physics.box2d.PhysicsConnector;
import org.andengine.extension.physics.box2d.PhysicsConnectorManager;
import org.andengine.extension.physics.box2d.PhysicsFactory;
import org.andengine.extension.physics.box2d.PhysicsWorld;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import com.Resources.RedCherryResources;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.Manager.ResourcesManager;

public abstract class Cherry extends Sprite {	

	//-------------------------------
	//ATTRIBUTES
	//-------------------------------
	
	protected Body body;
	protected float peso;
	protected int id;
	
	//-------------------------------
	//CONSTRUCTOR
	//-------------------------------
	
	public Cherry(float pX, float pY, VertexBufferObjectManager vbo, Camera camera, PhysicsWorld physicsWorld, ITextureRegion pITextureRegion) {
		super(pX, pY, pITextureRegion,vbo);
		// TODO Auto-generated constructor stub
	}
	
	private void createPhysics(final Camera camera, PhysicsWorld physicsWorld){
		this.body = PhysicsFactory.createBoxBody(physicsWorld, this, BodyType.DynamicBody, PhysicsFactory.createFixtureDef(this.peso,0,0));
		
		physicsWorld.registerPhysicsConnector(new PhysicsConnector(this, body,true,true){
			@Override
	        public void onUpdate(float pSecondsElapsed)
	        {
				super.onUpdate(pSecondsElapsed);
				camera.onUpdate(0.1f);
	        }
        });			
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getId() {
		return id;
	}

}
