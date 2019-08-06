package entity;

public class Card {
	private int num;
	private Color color;
	private boolean numHint;
	private boolean colorHint;

	public Card(int num, Color color) {
		this.num = num;
		this.color = color;
		this.setNumHint(false);
		this.setColorHint(false);
	}

	public int getNum() {
		return num;
	}
	
	public String getNumWithHint() {
		String result = "";
		result += (numHint) ? num : "?";
		
		return result;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Color getColor() {
		return color;
	}

	public String getColorWithHint() {
		String result = "";
		result += (colorHint) ? color : "?";
		
		return result;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isNumHint() {
		return numHint;
	}

	public void setNumHint(boolean numHint) {
		this.numHint = numHint;
	}

	public boolean isColorHint() {
		return colorHint;
	}

	public void setColorHint(boolean colorHint) {
		this.colorHint = colorHint;
	}

	@Override
	public String toString() {
		String result = "";
//		result += "NUM : " + (isNumHint() ? num : "?") + ", COLOR : " + (isColorHint() ? color.toString() : "?");
		result += "NUM : " + num + ", COLOR : " + color.toString();
		
		return result;
	}
	
	public String printWithHint() {
		String result = "";
		result += "NUM : " + (isNumHint() ? num : "?") + ", COLOR : " + (isColorHint() ? color.toString() : "?");
		
		return result;
	}
	
	public String printWithKnownHint() {
		String result = "";
		result += "NUM : " + num + (isNumHint() ? "(Known)" : "") + " \tCOLOR : " + color + (isColorHint() ? "(Known)" : "");
		
		return result;
	}
}