package fractalTree_LSystem;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Stack;

public class LSystemPlant {
	public static String startChar = "X";
	public Map<Character, String> rules = new HashMap<Character, String>();
	public static double stickLength = 17;
	public static double angle = 90;
	public static int end_X;
	public static int end_Y;
	public static int begin_X = 1000;
	public static int begin_Y = 1900;
	
	
	LSystemPlant(){
		rules.put('F', "F+X++X-F--FF-X+");
		rules.put('X', "-F+XX++X+F--F-X");
	}
	
	//F+[[X]-X]-F[-FX]+X
	
	public String generate(String startChar,Graphics g) {
		int j = 5;
		while (j>0) {
			//startChar=startChar.replaceAll("X", "F-[[X]+X]+F[+FX]-X");

			startChar=startChar.replaceAll("F", "F[+F]F[-F][F]");
			
			System.out.println(startChar);
			draw(g, startChar);
			j--;
		}
		return startChar;
	}
	//F[+F]F[-F]F
	//F[+F]F[-F][F]
	//FF-[-F+F+F]+[+F-F-F]
	
	//F[+X]F[-X]+X
	//FF
	
	public class turtlePos {
		public int x;
		public int y;
		public double angle;
		public double length;
		
		turtlePos(int x, int y, double angle){
			this.x = x;
			this.y = y;
			this.angle = angle;
		}
	}

	Stack<turtlePos> obj = new Stack<>();
	public void draw(Graphics g, String stringToParse) {
		g.setColor(Color.PINK);
		for (int i = 0;i<=stringToParse.length()-1;i++) {
			switch(stringToParse.charAt(i)) {
			case 'F': 
				end_X = (int)(Math.cos(Math.toRadians(angle))*stickLength)+begin_X;
				end_Y = begin_Y-(int)(Math.sin(Math.toRadians(angle))*stickLength);
				g.drawLine(begin_X, begin_Y, end_X, end_Y);
				begin_X = end_X;
				begin_Y = end_Y;
				break;
			case '-': 
				angle = angle+20;
				break;
			case '+': 

				angle = angle-20;
				break;
			case '[': 
				obj.push(new turtlePos(begin_X, begin_Y, angle));
				break;
			case ']': 
				angle = obj.lastElement().angle;
				begin_X = obj.lastElement().x;
				begin_Y = obj.lastElement().y;
				obj.pop();
				break;
			default:
				break;
			}

		}
	}
}
