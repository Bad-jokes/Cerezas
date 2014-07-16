package com.Resources;

import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.atlas.bitmap.BuildableBitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.source.IBitmapTextureAtlasSource;
import org.andengine.opengl.texture.atlas.buildable.builder.BlackPawnTextureAtlasBuilder;
import org.andengine.opengl.texture.atlas.buildable.builder.ITextureAtlasBuilder.TextureAtlasBuilderException;
import org.andengine.opengl.texture.region.ITextureRegion;
import org.andengine.util.debug.Debug;

import android.graphics.Color;

import com.Manager.ResourcesManager;


public class GameResources extends ResourcesBase 
{
	
	//Atributos
	private ITextureRegion game_background_region;
	private Font score_font;
	public BuildableBitmapTextureAtlas gameTextureAtlas;
	
    
    //Logica
    
    @Override
    public void LoadResources()
	{
    	loadMenuGraphics();
        loadMenuAudio();
        loadFont();
	}
    
    
	private void loadMenuGraphics()
    {
		BitmapTextureAtlasTextureRegionFactory.setAssetBasePath("gfx/game/");
		gameTextureAtlas=new BuildableBitmapTextureAtlas(ResourcesManager.getInstance().getActivity().getTextureManager(), 1024, 1024, TextureOptions.BILINEAR);
    	game_background_region = BitmapTextureAtlasTextureRegionFactory.createFromAsset(gameTextureAtlas, ResourcesManager.getInstance().getActivity(), "game_background.png");
    	
    	try 
    	{
    		gameTextureAtlas.build(new BlackPawnTextureAtlasBuilder<IBitmapTextureAtlasSource, BitmapTextureAtlas>(0, 1, 0));
    		gameTextureAtlas.load();
    	} 
    	catch (final TextureAtlasBuilderException e)
    	{
    	        Debug.e(e);
    	}
    }
	
	private void loadFont()
    {
        FontFactory.setAssetBasePath("font/");
        final ITexture mainFontTexture = new BitmapTextureAtlas(ResourcesManager.getInstance().getActivity().getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);

        score_font = FontFactory.createStrokeFromAsset(ResourcesManager.getInstance().getActivity().getFontManager(), mainFontTexture, ResourcesManager.getInstance().getActivity().getAssets(), "score_font.TTF", 50, true, Color.WHITE, 2, Color.BLACK);
        score_font.load();
    }
	
	
    private void loadMenuAudio()
    {
        
    }
    
    @Override
    public void UnLoadResources()
    {
    	gameTextureAtlas.unload();
    }
       

	@Override
	public void ReLoadResources() 
	{
		gameTextureAtlas.load();
	}
	
	public ITextureRegion getBackground()
	{
		return game_background_region;
	}
	
	public Font getFont()
	{
		return score_font;
	}

}
