package datastructures.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PixelTest {

	public static void main(String[] args) {
		// 1280 x 720
		int pixelCount = 1280 * 720 ;
		System.out.println("Pixel count = "+ pixelCount);
		
		Map<Pixel, Integer> pixels = new ConcurrentHashMap<>();
		
		for (int x=0;x<1280;x++) {
			for (int y=0;y<720;y++) {
				Pixel pixel = new Pixel (x , y);
				pixels.put(pixel, pixel.hashCode());
			}
		}
		Set<Integer> uniqueHashCodes = new HashSet<>(pixels.values());
		System.out.println("uniqueHashCodes.size() = " + uniqueHashCodes.size());
		System.out.println("Hashes per unique hashcodes = " + pixelCount / uniqueHashCodes.size());
		
		long grandtotal = 0;
		for(int i=0;i<10;i++) {
			grandtotal = testPerformance(pixels);
		}
		System.out.println("grandtotal = " + grandtotal);

	}

	private static long testPerformance(Map<Pixel, Integer> pixels) {
		List<Pixel> lookup = new ArrayList<>(pixels.keySet());
		Collections.shuffle(lookup, new Random(0));
		
		long totalHash = 0;
		long time = System.nanoTime();
		try {
			for (int i=0;i<10;i++) {
				for (Pixel p : lookup) {
					totalHash += pixels.get(p);
				}
			}
		} finally {
			time = System.nanoTime() - time ;
			System.out.printf("time = %dms%n",(time/1_000_000));
		}
		return totalHash;
	}

}
