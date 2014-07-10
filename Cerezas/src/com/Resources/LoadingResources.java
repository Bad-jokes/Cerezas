package com.Resources;

import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.ITexture;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;

import com.Manager.ResourcesManager;

import android.graphics.Color;

public class LoadingResources extends ResourcesBase
{

	
	//Atributos
	private Font font_loading;

	//Logica
	
	@Override
	public void LoadResources()
    {
        FontFactory.setAssetBasePath("font/");
        final ITexture mainFontTexture = new BitmapTextureAtlas(ResourcesManager.getInstance().getActivity().getTextureManager(), 256, 256, TextureOptions.BILINEAR_PREMULTIPLYALPHA);

        font_loading = FontFactory.createStrokeFromAsset(ResourcesManager.getInstance().getActivity().getFontManager(), mainFontTexture, ResourcesManager.getInstance().getActivity().getAssets(), "loading_font.ttf", 50, true, Color.WHITE, 2, Color.BLACK);
        font_loading.load();
    }
	
	@Override
	public void UnLoadResources()
    {
		return;
    }

	@Override
	public void ReLoadResources()
	{
		return;
		
	}
	
	public Font getFont()
	{
		return font_loading;
	}
}
