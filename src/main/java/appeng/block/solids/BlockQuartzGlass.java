package appeng.block.solids;

import java.util.EnumSet;

import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;
import appeng.block.AEBaseBlock;
import appeng.client.render.BaseBlockRender;
import appeng.client.render.blocks.RenderQuartzGlass;
import appeng.core.features.AEFeature;
import appeng.helpers.AEGlassMaterial;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockQuartzGlass extends AEBaseBlock
{

	public BlockQuartzGlass() {
		this( BlockQuartzGlass.class );
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Class<? extends BaseBlockRender> getRenderer()
	{
		return RenderQuartzGlass.class;
	}

	@Override
	public boolean shouldSideBeRendered(IBlockAccess w, int x, int y, int z, int side)
	{
		Material mat = w.getBlock( x, y, z ).getMaterial();
		if ( mat == Material.glass || mat == AEGlassMaterial.instance )
		{
			if ( w.getBlock( x, y, z ).getRenderType() == this.getRenderType() )
				return false;
		}
		return super.shouldSideBeRendered( w, x, y, z, side );
	}

	public BlockQuartzGlass(Class c) {
		super( c, Material.glass );
		setFeature( EnumSet.of( AEFeature.DecorativeQuartzBlocks ) );
		setLightOpacity( 0 );
		isOpaque = false;
	}

}
