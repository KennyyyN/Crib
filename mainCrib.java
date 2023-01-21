import java.util.*;


class mainCrib{
    static Scanner s = new Scanner(System.in);
    static Deck newDeck = new Deck();
    static Player one= new Player();
    static Player two = new Player();
    static Combo combo = new Combo();
    static int total;
    public static void main(String[] args){
        Crib crib = new Crib();
        ArrayList<String> cards = newDeck.setDeck();
        newDeck.shuffle();
        String cutCard = newDeck.cut();
        //System.out.println(cutCard);
        System.out.println("2 or 3 players: ");
        int num = s.nextInt(), cutP1, cutP2, turn;

        if(num == 2){
            ArrayList<String> P1 = newDeck.deal();
            ArrayList<String> P2 = newDeck.deal();
            one.setTurn(1);
            two.setTurn(2);
            //First Cut
            System.out.println("Person A pick a card from 0-51: ");
            cutP1 = s.nextInt();
            System.out.println("Person B pick a card from 0-51: ");
            cutP2 = s.nextInt();
            turn = newDeck.cut(cutP1, cutP2);

            cards.removeAll(P1);
            cards.removeAll(P2);

            System.out.println("Player 1's hand\n");
            newDeck.display(P1);
            System.out.println("Player 2's hand\n");
            newDeck.display(P2);

            while(true){
                //crib
                setUpCrib(turn, s, P1, P2, crib); // CRIB METHOD IS BASED ON TURN INPUT 1 OR 2 PLAYER 2 OR 1 GO FIRST FOR CRIB SETUP
                //table
                //ArrayList<String> totalTable = new ArrayList<String>();
                while(P1.size()>0&&P2.size()>0){
                total=0;
                ArrayList<String> oneTable = new ArrayList<String>();
                ArrayList<String> twoTable = new ArrayList<String>();
                ArrayList<String> roundTa = new ArrayList<String>();
                
                    while(true){
                        if(P1.size()>0){
                            if(thirtyOne(one, two, P1, oneTable)){;
                            roundTa.addAll(oneTable);
                            }else break;

                            System.out.println("Current Table:");
                            newDeck.display(roundTa);
                        }else break;
                        if(P2.size()>0){
                            if(thirtyOne(two, one, P2, twoTable)){
                            roundTa.addAll(twoTable);
                            }else break;

                            System.out.println("Current Table:");
                            newDeck.display(roundTa);
                        }else break;
                    }
                one.addPoints(combo.assign(oneTable));
                two.addPoints(combo.assign(twoTable));
                pointCheck();
                }
                P1 = newDeck.deal();
                P2 = newDeck.deal();
                
            }
            
        }
        else if(num == 3){
            ArrayList<String> P1 = newDeck.deal();
            ArrayList<String> P2 = newDeck.deal();
            ArrayList<String> P3 = newDeck.deal();

            cards.remove(P1);
            cards.remove(P2);
            cards.remove(P3);

            System.out.println("Player 1's hand\n");
            newDeck.display(P1);
            System.out.println("Player 2's hand\n");
            newDeck.display(P2);
            System.out.println("Player 3's hand\n");
            newDeck.display(P3);

        }
        else{
            System.out.println("Has to be eithe 2 or 3 players");
        }

    }

    private static void pointCheck() {
        System.out.println("\nCurrent Points:\nPlayer "+one.getTurn()+": "+one.getPoints()+" points.\nPlayer "+two.getTurn()+": "+two.getPoints()+" points.\n");
        if(one.getPoints()>=121){
            System.out.println("Player "+one.getTurn()+" wins with "+one.getPoints()+" points. Congrats!");
            System.exit(0);
        }
        if(two.getPoints()>=121){
            System.out.println("Player "+two.getTurn()+" wins with "+two.getPoints()+" points. Congrats!");
            System.exit(0);
        }
    }
    private static boolean thirtyOne(Player current, Player other, ArrayList<String> hand, ArrayList<String> table){
            System.out.println("Player "+current.getTurn()+"'s Hand:\n");
            newDeck.display(hand);

            String card="";
            while(true){
            try{System.out.println("Choose an index to put on the table");
                card=hand.get(s.nextInt()-1);break;
            }catch(IndexOutOfBoundsException e){System.out.println("Bad Index. Try Again!");}
            }

            System.out.println("You Played: "+card+"\n");
            if(total+newDeck.getValue(card)<31){
                total+=newDeck.getValue(card);
                System.out.println("Current Total: "+total+"\n");
                hand.remove(card);
                table.add(card);
            }
            else if(total+newDeck.getValue(card)==31){
                current.addPoints(1);
                System.out.println("Player "+current.getTurn()+" won round, gets 1 point"); //TERMINOLGY?
                hand.remove(card);
                table.add(card);
                return false;
            }
            else{
                System.out.println("Player "+current.getTurn()+" plays Go, Player "+other.getTurn()+" gets 1 point");
                other.addPoints(1);
                return false;
            }
            return true;
    }

    private static void setUpCrib(int turn, Scanner s, ArrayList<String> P1, ArrayList<String> P2, Crib crib){
            int input, pastInput;
                
             // Player 1 Crib Section
             System.out.println("Player 1: Choose an index to put in the crib: ");
             input = s.nextInt();
             pastInput = input;
             crib.addCardsCrib(P1.get(input));
             do{
                 System.out.println("Player 1: Choose another index to put in the crib (different value): ");
                 input = s.nextInt();
             }while (pastInput == input);
             crib.addCardsCrib(P1.get(input));
             if(input > pastInput){
                 P1.remove(input);
                 P1.remove(pastInput);
             }
             else{
                 P1.remove(pastInput);
                 P1.remove(input);
             }
             // Player 2 Crib Section
             System.out.println("Player 2: Choose an index to put in the crib: ");
             input = s.nextInt();
             pastInput = input;
             crib.addCardsCrib(P2.get(input));
             do{
                 System.out.println("Player 2: Choose another index to put in the crib (different value): ");
                 input = s.nextInt();
             }while (pastInput == input);
             crib.addCardsCrib(P2.get(input));
             if(input > pastInput){
                 P2.remove(input);
                 P2.remove(pastInput);
             }
             else{
                 P2.remove(pastInput);
                 P2.remove(input);
             }
             crib.calculateCrib();
            }
    }

