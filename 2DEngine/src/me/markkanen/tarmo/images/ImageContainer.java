package me.markkanen.tarmo.images;

import java.awt.image.BufferedImage;

public class ImageContainer {
	
	public static BufferedImage test;
	
	public static void loadImages() {
		test = ImageLoader.loadImage("/textures/test.png");
	}
}