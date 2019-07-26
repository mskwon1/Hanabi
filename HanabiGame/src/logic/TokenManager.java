package logic;

public class TokenManager {
	private static final int BLUE_DEFAULT = 8;
	private static final int RED_DEFAULT = 3;
	
	private int blueToken;
	private int redToken;
	
	public TokenManager() {
		this(BLUE_DEFAULT, RED_DEFAULT);
	}
	
	public TokenManager(int blue, int red) {
		blueToken = blue;
		redToken = red;
	}
	
	public boolean useBlue() {
		if (blueToken >= 1) {
			blueToken--;
			return true;
		} else {
			/*
			 * ��밡�� ��ū ����
			 */
			return false;
		}
	}
	
	public boolean addBlue() {
		if (blueToken == 8) {
			/*
			 * ���̻� ��Ʈ ��ū ���� �� ����
			 */
			return false;
		} else {
			blueToken++;
			return true;
		}
	}
	
	public boolean useRed() {
		redToken--;
		
		if (redToken == 0) {
			/*
			 * ���� ����
			 */
			return false;
		} else {
			return true;
		}
	}

	public int getBlueToken() {
		return blueToken;
	}

	public int getRedToken() {
		return redToken;
	}
	
	public String toString() {
		String result = "";
		
		result += "Blue Token : " + blueToken + ", Red Token : " + redToken;
		
		return result;
	}
	
	public static void main(String[] args) {
		TokenManager t = new TokenManager();
		System.out.println(t);
		
		t.useBlue();
		t.useBlue();
		t.useBlue();
		t.useBlue();
		t.useBlue();
		
		t.useRed();
		
		System.out.println(t);
		

		t.addBlue();
		t.addBlue();
		t.addBlue();
		t.addBlue();
		t.addBlue();
		t.addBlue();
		t.addBlue();
		
		System.out.println(t);
	}
}