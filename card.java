

public class card {
	private int value;
	private char suit;
	
	public card()
	{
		value = 1;
		suit = 'S';
	}
	public card(String v, char s)
	{
		setValue(v);
		setSuit(s);
	}
	
	public int getValue()
	{
		if(value > 10)
		{
			return 10;
		}
		return value;
	}
	public char getSuit()
	{
		return suit;
	}
	
	private void setSuit(char s)
	{
		suit = s;
		/*s.toUpperCase();
		switch(s) {
			case "S":
				suit = 'S';
				break;
			case "SPADE":
				suit = 'S';
				break;
			case "C":
				suit = 'C';
				break;
			case "CLUB":
				suit = 'C';
				break;
			case "H":
				suit = 'H';
				break;
			case "HEART":
				suit = 'H';
				break;
			case "D":
				suit = 'D';
				break;
			case "DIAMOND":
				suit = 'D';
				break;
		}*/
	}
	private void setValue(String v)
	{
		v.toUpperCase();
		
		switch(v) {
			case "1": 
				value = 1;
				break;
			case "A":
				value = 1;
				break;
			case "2":
				value = 2;
				break;
			case "3":
				value = 3;
				break;
			case "4":
				value = 4;
				break;
			case "5":
				value = 5;
				break;
			case "6":
				value = 6;
				break;
			case "7":
				value = 7;
				break;
			case "8":
				value = 8;
				break;
			case "9":
				value = 9;
				break;
			case "10":
				value = 10;
				break;
			case "11":
				value = 11;
				break;
			case "JACK":
				value = 11;
				break;
			case "12":
				value = 12;
				break;
			case "QUEEN":
				value = 12;
				break;
			case "13":
				value = 13;
				break;
			case "KING":
				value = 13;
				break;		
		}
	}

	public String toString()
	{
		String s = "";
		switch(value) {
			case 1:
				s += "Ace";
				break;

			case 11:
				s += "Jack";
				break;

			case 12:
				s += "Queen";
				break;

			case 13:
				s += "King";
				break;

			default:
				s += value;
		}
		s+= " of ";
		switch(suit) {
			case 'S':
				s += "Spades";
				break;

			case 'C':
				s += "Clubs";
				break;

			case 'H':
				s += "Hearts";
				break;

			case 'D':
				s += "Diamonds";
				break;
		}
		return s;
	}
}
