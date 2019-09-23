package datastructures.hashing;

public class Pixel implements Comparable<Pixel>{

	private final int x,y;
	
	public Pixel(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pixel other = (Pixel) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		/*
		 * final int prime = 31; 
		 * int result = 1; 
		 * result = prime * result + x; 
		 * result = prime * result + y; 
		 * return result;
		 */
		
		
		// or 
		
		//return x << 16 ^ y;
		
		//or
		
		return x * 720 + y; // will return unique values
		
		
	}

	@Override
	public int compareTo(Pixel o) {
		int result = x < o.x ? -1 : x == o.x ? 0 : 1;
		if (result != 0) return result;
		return y < o.y ? -1 : y==o.y ? 0 : 1;
	}
	
}
