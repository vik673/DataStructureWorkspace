package com.rec;

public class Arithematic {

	public static int mul(int x, int y) {
		if (y < 0) {
			y = -y;
			x = -x;
		}
		if (y == 0 || x == 0)
			return 0;
		if (y == 1)
			return x;
		if (x == 1)
			return y;
		return x + mul(x, y - 1);
	}

	public static int div(int x, int y) {
		if (y == 0)
			throw new RuntimeException();
		if (y < 0) {
			y = -y;
			x = -x;
		}
		if (x == 0 || (x < y && -x < y))
			return 0;
		if (x < 0)
			return -1 + div(x + y, y);
		return 1 + div(x - y, y);

	}

}
