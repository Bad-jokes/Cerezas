package com.Pool;

import java.util.Stack;

import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.util.adt.pool.GenericPool;

import com.Game.RedCherry;
import com.Manager.GameManager;
import com.Manager.ResourcesManager;

public class RedCherryPool extends GenericPool<RedCherry>{

	//--------------------------------------------
	//ATTRIBUTES
	//--------------------------------------------
	
	private ITextureRegion cherryRegion;
	private Stack<RedCherry> pila = new Stack<RedCherry>(); 

	//--------------------------------------------
	//GAME LOGIC
	//--------------------------------------------
	
	public RedCherryPool(ITextureRegion pITextureRegion){
		if(pITextureRegion == null)
			throw new IllegalArgumentException("The texture region must not be null");
		this.cherryRegion = pITextureRegion;
	}
	
	//Called when a Bullet is required but there isn't one in the pool
	@Override
	protected RedCherry onAllocatePoolItem() {
		// TODO Auto-generated method stub
		return new RedCherry(0, 0, ResourcesManager.getInstance().getVbom(), ResourcesManager.getInstance().getCamera(), GameManager.getInstance().getPhysicsWorld(), this.cherryRegion);
	}

	@Override
	protected void onHandleRecycleItem(final RedCherry redCherry){
		redCherry.setIgnoreUpdate(true);
		redCherry.setVisible(false);
	}
	
	
	//Called just before a Bullet is returned to the caller.
	@Override
	protected void onHandleObtainItem(final RedCherry redCherry){
		redCherry.reset();
	}
	
	public RedCherry getCherry(){		
		if(!pila.empty()){
			return this.pila.pop();
		}
		else{
			return this.onAllocatePoolItem();
		}		
	}
	
	public void recycleCherry( RedCherry cherry){
		this.pila.push(cherry);
	}
}
