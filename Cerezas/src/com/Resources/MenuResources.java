package com.Resources;

import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.util.debug.Debug;

import com.Manager.ResourcesManager;


public class MenuResources extends ResourcesBase 
{
	
	//Atributos
	private ITextureRegion menu_background_region;
    private ITextureRegion play_region;
    private ITextureRegion options_region;
    private BuildableBitmapTextureAtlas menuTextureAtlas;
    
    //Logica
    
    @Override
    public void LoadResources()
	{
    	loadMenuGraphics();
        loadMenuAudio();
	}
    
    
	private void loadMenuGraphics()
    {
    	BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/menu/");
    	menuTextureAtlas=new BuildableBitmapTextureAtlas(ResourcesManager.getInstance().getActivity().getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
    	menu_background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, ResourcesManager.getInstance().getActivity(), "menu_background.png");
    	play_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, ResourcesManager.getInstance().getActivity(), "play.png");
    	options_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(menuTextureAtlas, ResourcesManager.getInstance().getActivity(), "options.png");
    	       
    	try 
    	{
    		menuTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
    		menuTextureAtlas.load();
    	} 
    	catch (final TextureAtlasBuilderException e)
    	{
    	        Debug.e(e);
    	}
    }
	
	
    private void loadMenuAudio()
    {
        
    }
    
    @Override
    public void UnLoadResources()
    {
    	menuTextureAtlas.unload();
    }
       

	@Override
	public void ReLoadResources() 
	{
		menuTextureAtlas.load();
	}
	
	public ITextureRegion getBackground()
	{
		return menu_background_region;
	}
	
	public ITextureRegion getPlay()
	{
		return play_region;	
	}
	
	public ITextureRegion getOptions()
	{
		return options_region;
	}

}
