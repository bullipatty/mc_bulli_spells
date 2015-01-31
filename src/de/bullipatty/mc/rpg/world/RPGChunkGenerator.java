package de.bullipatty.mc.rpg.world;

import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

public abstract class RPGChunkGenerator extends ChunkGenerator {

	@SuppressWarnings("unused")
	private byte TOP = 1;
	@SuppressWarnings("unused")
	private byte BOTTOM = 2;
	@SuppressWarnings("unused")
	private byte LEFT = 4;
	@SuppressWarnings("unused")
	private byte RIGHT = 8;
	
	public RPGChunkGenerator() {
		
	}
	
	@Override
	public boolean canSpawn(World world, int x, int z) {
		// return super.canSpawn(world, x, z);
		return false;
	}
	
	@Override
	public byte[][] generateBlockSections(World world, Random random, int x,
			int z, BiomeGrid biomes) {
		byte[][] _sections = new byte[world.getMaxHeight()/16][];
		return _sections;
	}
	
	@Override
	public short[][] generateExtBlockSections(World world, Random random,
			int x, int z, BiomeGrid biomes) {
		// TODO Auto-generated method stub
		return super.generateExtBlockSections(world, random, x, z, biomes);
	}
	
	@Override
	public List<BlockPopulator> getDefaultPopulators(World world) {
		return super.getDefaultPopulators(world);
	}
	
	@Override
	public Location getFixedSpawnLocation(World world, Random random) {
		return super.getFixedSpawnLocation(world, random);
	}
	
	protected void setBlock(byte[][] result, int x, int y, int z, byte blkid) {
        if (result[y >> 4] == null) {
            result[y >> 4] = new byte[4096];
        }
        result[y >> 4][((y & 0xF) << 8) | (z << 4) | x] = blkid;
    }
	
	protected byte getBlock(byte[][] result, int x, int y, int z) {
        if (result[y >> 4] == null) {
            return (byte)0;
        }
        return result[y >> 4][((y & 0xF) << 8) | (z << 4) | x];
    }
	
	protected void setBlock(short[][] result, int x, int y, int z, short blkid) {
        if (result[y >> 4] == null) {
            result[y >> 4] = new short[4096];
        }
        result[y >> 4][((y & 0xF) << 8) | (z << 4) | x] = blkid;
    }
	
	protected short getBlock(short[][] result, int x, int y, int z) {
        if (result[y >> 4] == null) {
            return (short)0;
        }
        return result[y >> 4][((y & 0xF) << 8) | (z << 4) | x];
    }
	
	protected abstract void generate(byte[][] arr);
	
}
