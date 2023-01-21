import java.util.*;


class Deck{
    //subject to change

    public Deck (){
        deck = new ArrayList<String>();
        dealt = new ArrayList<String>();
    }

    
    String[] SUITS = {
        "Clubs", "Diamonds", "Hearts", "Spades"
    };

    String[] RANKS = {
        "2", "3", "4", "5", "6", "7", "8", "9", "10",
        "Jack", "Queen", "King", "Ace"
    };

    public int totalLen = SUITS.length * RANKS.length;
    ArrayList<String> deck = new ArrayList<String>();
    ArrayList<String> dealt = new ArrayList<String>();




    public ArrayList<String> setDeck(){
        for(int i = 0; i < RANKS.length; i++){
            for (int j = 0; j < SUITS.length; j++) {
                deck.add(RANKS[i] + " of " + SUITS[j]);
            }
        }

        return deck;

    }

    public int getValue(String card){
        String rank=card.substring(0,1);
        int value;
        switch (rank){
            case "A":value=1; break;
            case "K":value=10; break;
            case "Q":value=10; break;
            case "J":value=10; break;
            case "1":value=10; break;
            default: value=Integer.valueOf(rank);
        }
        return value;
    }
    public ArrayList<String> draw(int num){
        Iterator<String> index = deck.iterator();

        for(int i =0; i < num; ++i){
            dealt.add(index.next());
            index.remove();
        }


        return dealt;
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public ArrayList<String> deal(){
        Iterator<String> itr = deck.iterator();
        ArrayList<String> temp = new ArrayList<String>();

        for (int i = 0; i < 6; ++i){ 
            dealt.add(itr.next());
            temp.add(itr.next());
            itr.remove();
        }

        return temp;
    }

    public String cut(){
        Iterator<String> newCard = deck.iterator();
        ArrayList<String> temp = new ArrayList<String>();

        for (int i = 0; i < 26; ++i){ 
            temp.add(newCard.next());
            newCard.remove();
        }
        deck.addAll(temp);

        return deck.get(0);
    }

    // START OF THE GAME CUT (RETURNS PLAYER TURN)
    public int cut(int player1cut, int player2cut){
        Iterator<String> newCard = deck.iterator();
        ArrayList<String> temp = new ArrayList<String>();

        for (int i = 0; i < 26; ++i){ 
            temp.add(newCard.next());
            newCard.remove();
        }
        deck.addAll(temp);
        System.out.println("Person A's cut was: " + deck.get(((int) player1cut/2)));
        System.out.println("Person B's cut was: " + deck.get(((int) player2cut/2)));
        if(player1cut > player2cut){
            System.out.println("Person B starts as Player 1 and Person A starts as Player 2\n");
            return 1;
        } else if (player1cut < player2cut){
            System.out.println("Person A starts as Player 1 and Person B starts as Player 2\n");
            return 1;
        }
        return 1;
    }

    public void display(ArrayList<String> plays){
        int num = plays.size();
        
        for (int i = 0; i < num; ++i){ 
            System.out.print(i + 1 + ": ");
            System.out.println(plays.get(i));
        }
        System.out.println();
    }

    /* 
    public static void main(String[] args) {
        deck newDeck = new deck();
        
        newDeck.setDeck();
        newDeck.shuffle();
        newDeck.cut();
        newDeck.deal();
        
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of times drawn: ");
        int num = s.nextInt();
        newDeck.draw(num);
    }*/
}
