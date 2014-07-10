package com.Resources;

import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.util.debug.Debug;

import com.Manager.ResourcesManager;

public class RedCherryResources extends CherryResources{	
	//--------------------
	//CLASS LOGIC
	//--------------------	
	
	@Override
	public void LoadResources() {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/cherry/");
		this.cherrySprite = new BuildableBitmapTextureAtlas(ResourcesManager.getInstance().getActivity().getTextureManager(), 100, 114,TextureOptions.BILINEAR);
		this.cherryRegion = BitmapTextureAtlasTextureRegionFactory.createFromAsset(cherrySprite, ResourcesManager.getInstance().getActivity(), "cherry.png");
		
		try{
			this.cherrySprite.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
			this.cherrySprite.load();
		}
		catch (final TextureAtlasBuilderException e){
			Debug.e(e);
		}
	}

	@Override
	public void UnLoadResources() {
		this.cherrySprite.unload();
		this.cherryRegion = null;
		
	}

	@Override
	public void ReLoadResources() {
		// TODO Auto-generated method stub
		return;
	}

}
