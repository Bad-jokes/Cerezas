package com.Resources;


import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITextureRegion;

import com.Manager.ResourcesManager;

public class SplashResources extends ResourcesBase 
{
	//Atributos
	
	private ITextureRegion splash_region;
    private BitmapTextureAtlas splashTextureAtlas;
	
    
    //Logica
    
    @Override
    public void LoadResources()
    {
	    BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/");
	    splashTextureAtlas=new BitmapTextureAtlas(ResourcesManager.getInstance().getActivity().getTextureManager(), 256, 256,TextureOptions.BILINEAR);		
		splash_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(splashTextureAtlas, ResourcesManager.getInstance().getActivity(), "splash.png",0,0);
		splashTextureAtlas.load();
    
    }
    
    @Override
    public void UnLoadResources()
    {
    	splashTextureAtlas.unload();
    	splash_region = null;
    }

	@Override
	public void ReLoadResources()
	{
		return;
	}
	
	public ITextureRegion getSplash()
	{
		return splash_region;
	}
	
	
}
