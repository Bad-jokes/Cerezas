package com.Resources;

import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.region.ITextureRegion;

public abstract class CherryResources extends ResourcesBase{

	//--------------------
	//ATTRIBUTES
	//--------------------
	protected BuildableBitmapTextureAtlas cherrySprite;
	protected ITextureRegion cherryRegion;
	

	//-------------------------------
	//SETS AND GETS
	//-------------------------------
	
	public ITextureRegion getCherryRegion() {
		return cherryRegion;
	}

	public BuildableBitmapTextureAtlas getCherrySprite() {
		return cherrySprite;
	}	
	
	
}
