package com.mithrilmania.blocktopograph.map.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.mithrilmania.blocktopograph.chunk.Chunk;
import com.mithrilmania.blocktopograph.chunk.ChunkManager;
import com.mithrilmania.blocktopograph.chunk.Version;
import com.mithrilmania.blocktopograph.chunk.terrain.TerrainChunkData;
import com.mithrilmania.blocktopograph.map.Biome;
import com.mithrilmania.blocktopograph.map.Dimension;


public class BiomeRenderer implements MapRenderer {

    /**
     * Render a single chunk to provided bitmap (bm)
     *
     * @param chunk     ChunkManager, provides chunks, which provide chunk-data
     * @param canvas    Bitmap to render to
     * @param dimension Mapped dimension
     * @param chunkX    X chunk coordinate (x-block coord / Chunk.WIDTH)
     * @param chunkZ    Z chunk coordinate (z-block coord / Chunk.LENGTH)
     * @param pX        texture X pixel coord to start rendering to
     * @param pY        texture Y pixel coord to start rendering to
     * @param pW        width (X) of one block in pixels
     * @param pL        length (Z) of one block in pixels
     * @param paint
     * @param version
     * @param chunkManager
     * @return bm is returned back
     * @throws Version.VersionException when the version of the chunk is unsupported.
     */
    public void renderToBitmap(Chunk chunk, Canvas canvas, Dimension dimension, int chunkX, int chunkZ, int pX, int pY, int pW, int pL, Paint paint, Version version, ChunkManager chunkManager) throws Version.VersionException {

        int x, z, biomeID, color, i, j, tX, tY;
        Biome biome;

        //the bottom sub-chunk is sufficient to get biome data.
        TerrainChunkData data = chunk.getTerrain((byte) 0);
        if (data == null || !data.load2DData())
            throw new RuntimeException();

        for (z = 0, tY = pY; z < 16; z++, tY += pL) {
            for (x = 0, tX = pX; x < 16; x++, tX += pW) {


                biomeID = data.getBiome(x, z) & 0xff;
                biome = Biome.getBiome(biomeID);

                color = biome == null ? 0xff000000 : (biome.color.red << 16) | (biome.color.green << 8) | (biome.color.blue) | 0xff000000;

//                for (i = 0; i < pL; i++) {
//                    for (j = 0; j < pW; j++) {
//                        bm.setPixel(tX + j, tY + i, color);
//                    }
//                }
                paint.setColor(color);
                canvas.drawRect(new Rect(tX, tY, tX + pW, tY + pL), paint);


            }
        }
    }

}
