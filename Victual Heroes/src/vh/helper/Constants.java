package vh.helper;

public class Constants {
	
	public static class Direction {
		public static final int LEFT = 0;
		public static final int UP = 1;
		public static final int RIGHT = 2;
		public static final int DOWN = 3;
	}
	
	public static class Tiles {
		public static final int BLOCKED = 0;
		public static final int TOWERSPOT = 1;
		public static final int ENEMYROAD = 2;
	}
	
	public static class Enemies {
		public static final int BALD = 0;
		public static final int YELLOW = 1;
		public static final int POLICE = 2;
		public static final int ORANGE = 3;
		public static final int PURPLE = 4;
		public static final int MOHAWK = 5;
		public static final int GREEN = 6;
		
		public static float getSpeed(int eType) {
			switch (eType) {
			case BALD :
				return 1.4f;
			case YELLOW :
				return 2f;
			case POLICE :
				return 1.6f;
			case ORANGE :
				return 2.2f;
			case PURPLE :
				return 1.2f;
			case MOHAWK :
				return 1.8f;
			case GREEN :
				return 1f;
			}
			
			return 0;
		}
	}
	
	public static class Towers {
		public static final int METAL = 0;
		public static final int JADE = 1;
		public static final int SNOW = 2;
		public static final int WOOD = 3;
		
		public static String getName(int tType) {
			switch (tType) {
			case METAL :
				return "Metal";
			case JADE :
				return "Jade";
			case SNOW :
				return "Snow";
			case WOOD :
				return "Wood";
			}
			
			return "";
		}
	}
}
