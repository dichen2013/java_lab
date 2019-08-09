
/*
 * SimpleTokenizer
 * Eric McCreath 2017
 */

public class SimpleTokenizer extends Tokenizer {

	private String text; // the text to be tokenizer
	private int pos; // position the tokenizer is currently pointing at.
	private Object current; // the current token that has just been tokenized, noting
					// the "pos" will point just after the text of this token

	static final char whiteSpace[] = {' ', '\n','\t'};
	static final char symbol[] = {'(',')','=',':','?',',','*','+'};

	public SimpleTokenizer(String text) {
		this.text = text;
		pos = 0;
		next();
	}

	@Override
	boolean hasNext() {
		return current != null;
	}

	@Override
	Object current() {
		return current;
	}

	@Override
	boolean currentis(String s) {
		if(hasNext() && current.equals(s)){
			return true;
		}else {
			return false;
		}
	}

	@Override
	void next() {
		char c = 0;
		int textlen = text.length();

		if (pos < textlen)
			c = text.charAt(pos);


		// consume the white space
		if (isIn(c,whiteSpace)) {
			pos++;
			next();
			return;
		}

		// modify this code

		if (pos >= textlen) {
			current = null;
		} else if (isIn(c,symbol)) {
			pos++;
			current = "" + c;
		} else if (Character.isDigit(c)) {
			int start = pos;
			while (pos < textlen && Character.isDigit(text.charAt(pos))){
				pos++;
			}

			if(pos+1 < textlen && text.charAt(pos) == '.' &&
					Character.isDigit(text.charAt(pos+1))) {
				pos++;
				while (pos < textlen && Character.isDigit(text.charAt(pos))) {
					pos++;
				}
				current = Double.parseDouble(text.substring(start, pos));
			}else{
				current = Integer.parseInt(text.substring(start,pos));
			}
		} else if (Character.isAlphabetic(c)) {
			int start = pos;
			pos++;
			while (pos < textlen && Character.isAlphabetic(text.charAt(pos))) {
				pos++;
			}
			current = text.substring(start,pos);
		}
		return;

	}

	private boolean isIn(char c, char[] whiteSpace) {
		for(char w : whiteSpace){
			if(w == c)
				return true;
		}
		return false;
	}


	public static void main(String[] args) {
		String exp = "25+x";
		SimpleTokenizer ST = new SimpleTokenizer(exp);
		while(ST.hasNext()){
			System.out.println(ST.current());
			ST.next();
		}
	}
}
