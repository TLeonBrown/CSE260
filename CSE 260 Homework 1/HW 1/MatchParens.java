import java.util.Stack;

//Tian Brown, 111597217
public class MatchParens {
	
	public static boolean check (String s) {
		if (s == null || s == "") 
			return true;
		s = s.replaceAll("\'[\\(\\[\\{\\)\\]\\}]\'", "");
		
		Stack<Character> ch = new Stack<>();
		
		for (char c : s.toCharArray()) {
			switch (c) {
				case '[':
				case '(':
				case '{':
					ch.push(c);
					break;
				case ']':
					if (ch.isEmpty())
						return false;
					if (ch.pop() == '[')
						break;
					else
						return false;
				case ')':
					if (ch.isEmpty())
						return false;
					if (ch.pop() == '(')
						break;
					else
						return false;
				case '}':
					if (ch.isEmpty())
						return false;
					if (ch.pop() == '{') 
						break;
					else
						return false;
			}
		}
		return ch.isEmpty();
	}
	
	
	public static void main (String [] args) {
		String s = "((()))[[]]dd{}{}{}";
		System.out.println(check(s));
	}
}
