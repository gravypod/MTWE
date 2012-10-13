package com.gravypod.mtwe;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.block.Block;

public class SetThread implements Runnable {
	
	List<Block> blocks;
	
    public SetThread(ArrayList<Block> _blocks) {
    	
    	blocks = _blocks;
    	
    }
	
	@Override
    public void run() {
		
		for (Block block : blocks) {
			synchronized (block) {
				synchronized (block.getChunk()) {
					block.setTypeId(1);
				}
			}
		}
		
    }
	
}
