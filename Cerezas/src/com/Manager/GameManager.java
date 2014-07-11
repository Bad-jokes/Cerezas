package com.Manager;

import org.andengine.extension.physics.box2d.PhysicsWorld;

import com.Pool.RedCherryPool;


public class GameManager {

	//--------------------------------------------
	//ATTRIBUTES
	//--------------------------------------------
		
	private static final GameManager Instance = new GameManager();
	private PhysicsWorld physicsWorld;
	private RedCherryPool pool;
	
	
	//--------------------------------------------
	//SETS AND GETS
	//--------------------------------------------
	
	public static GameManager getInstance() {
		return Instance;
	}
	public PhysicsWorld getPhysicsWorld() {
		return physicsWorld;
	}
	public RedCherryPool getPool() {
		return pool;
	}
	
}
