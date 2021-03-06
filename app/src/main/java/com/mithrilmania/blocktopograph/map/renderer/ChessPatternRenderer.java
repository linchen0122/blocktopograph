package com.mithrilmania.blocktopograph.map.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.mithrilmania.blocktopograph.chunk.Chunk;
import com.mithrilmania.blocktopograph.chunk.ChunkManager;
import com.mithrilmania.blocktopograph.chunk.Version;
import com.mithrilmania.blocktopograph.map.Dimension;


public class ChessPatternRenderer implements MapRenderer {

    public final int darkShade, lightShade;// int DARK_SHADE = 0xFF2B2B2B, LIGHT_SHADE = 0xFF585858;

    ChessPatternRenderer(int darkShade, int lightShade) {
        this.darkShade = darkShade;
        this.lightShade = lightShade;
    }

    /**
     * Render a single chunk to provided bitmap (bm)
     *
     * @param chunk        ChunkManager, provides chunks, which provide chunk-data
     * @param canvas       Bitmap to render to
     * @param dimension    Mapped dimension
     * @param chunkX       X chunk coordinate (x-block coord / Chunk.WIDTH)
     * @param chunkZ       Z chunk coordinate (z-block coord / Chunk.LENGTH)
     * @param pX           texture X pixel coord to start rendering to
     * @param pY           texture Y pixel coord to start rendering to
     * @param pW           width (X) of one block in pixels
     * @param pL           length (Z) of one block in pixels
     * @param paint
     * @param version
     * @param chunkManager
     * @return bm is returned back
     * @throws Version.VersionException when the version of the chunk is unsupported.
     */
    public void renderToBitmap(Chunk chunk, Canvas canvas, Dimension dimension, int chunkX, int chunkZ, int pX, int pY, int pW, int pL, Paint paint, Version version, ChunkManager chunkManager) throws Version.VersionException {

        int x, z, tX, tY;
        int color;

        for (z = 0, tY = pY; z < 16; z++, tY += pL) {
            for (x = 0, tX = pX; x < 16; x++, tX += pW) {
                color = ((x + z) & 1) == 1 ? darkShade : lightShade;
                paint.setColor(color);
                canvas.drawRect(new Rect(tX, tY, tX + pW, tY + pL), paint);
                //This would get hardware acceleration.
            }
        }
    }


}
