import java.util.*;
import java.util.Scanner;

public class cribbageRunner {
    hand[] players;
    Scanner input;
    deck mainDeck;
    int pips;
    hand[] playedCards;


    public void cribbageRunner()
    {
        players = new hand[2];
        players[0] = new hand();
        players[1] = new hand();
        mainDeck = new deck();
        input = new Scanner(System.in);
        pips = 0;
        playedCards = new hand[2];
        playedCards[0] = new hand();
        playedCards[1] = new hand();

    }
    void run()
    {
        players = new hand[2];
        players[0] = new hand();
        players[1] = new hand();
        mainDeck = new deck();
        input = new Scanner(System.in);
        pips = 0;
        playedCards = new hand[2];
        playedCards[0] = new hand();
        playedCards[1] = new hand();

        players[0].drawCards(6, mainDeck);
        players[1].drawCards(6, mainDeck);

        System.out.println("player one's hand: ");
        players[0].checkHand();
        System.out.println("choose 2 to put to crib");
        System.out.print("card 1: ");
        int p1c1 = input.nextInt();
        System.out.print("card 2: ");
        int p1c2 = input.nextInt();

        if(p1c2>p1c1){p1c2--;}

        System.out.println("player two's hand: ");
        players[1].checkHand();
        System.out.println("choose 2 to put to crib");
        System.out.print("card 1: ");
        int p2c1 = input.nextInt();
        System.out.print("card 2: ");
        int p2c2 = input.nextInt();

        if(p2c2>p2c1){p2c2--;}

        hand crib = new hand();
        crib.addCard(players[0].playCard(p1c1));
        crib.addCard(players[0].playCard(p1c2));
        crib.addCard(players[1].playCard(p2c1));
        crib.addCard(players[1].playCard(p2c2));

        card starter = mainDeck.draw();
        if(starter.getValue()==11)
        {
            players[1].peg(2);
        }
        hand playedCardsP1 = new hand();
        hand playedCardsP2 = new hand();
        
        boolean[] gos = thePlay();
        System.out.println("GO!!!");

        //the Go
        if(gos[0] == true)
        {
            theGo(1);

            boolean[] gosAgain = thePlay();

            if(gosAgain[0] == true)
            {
                theGo(1);
            }
            if(gosAgain[1] == true)
            {
                theGo(0);
            }
        
        }

        if(gos[1] == true)
        {
            theGo(0);

            boolean[] gosAgain = thePlay();

            if(gosAgain[0] == true)
            {
                theGo(1);
            }
            if(gosAgain[1] == true)
            {
                theGo(0);
            }
        }

        System.out.println("player 1 score: " + players[0].score() + " | player 2 score: " + players[1].score());

        input.close();
    }
    
    private boolean[] thePlay()
    {
        
        //the play
        boolean go = false;
        boolean p1Go = false;
        boolean p2Go = false;
        pips = 0;
        while(!go)
        {
            int playables = 0;
            for (int i = 1; i<=players[0].getSize(); i++) 
            {
                if(pips + players[0].getCard(i).getValue() <= 31)   
                {
                    playables++;
                }
            }
            if(playables == 0)
            {
                go = true;
                p1Go = true;
                break;
            }

            int cardP1;
            do
            {
            System.out.println("player one's hand: ");
            players[0].checkHand();
            System.out.println("choose a card to play");
            System.out.print("card: ");
            cardP1 = input.nextInt();

            } while(players[0].getCard(cardP1).getValue() + pips > 31);

            playedCards[0].addCard(players[0].playCard(cardP1));
            pips += playedCards[0].getCard(playedCards[0].getSize()).getValue();
            System.out.println("" + pips + "!");

            playables = 0;
            for (int i = 1; i<=players[1].getSize(); i++) 
            {
                if(pips + players[1].getCard(i).getValue() <= 31)   
                {
                    playables++;
                }
            }
            if(playables == 0)
            {
                go = true;
                p2Go = true;
                break;
            }

            int cardP2;
            do
            {
            System.out.println("player two's hand: ");
            players[1].checkHand();
            System.out.println("choose a card to play");
            System.out.print("card: ");
            cardP2 = input.nextInt();
            } while(players[1].getCard(cardP2).getValue() + pips > 31);

            playedCards[1].addCard(players[1].playCard(cardP2));
            pips += playedCards[1].getCard(playedCards[1].getSize()).getValue();
            System.out.println("" + pips + "!");
        }

        boolean[] out = {p1Go,p2Go};
        return out;
    }

    private void theGo(int p)
    {
        while(true)
            {
                int playables = 0;
                for (int i = 1; i<=players[p].getSize(); i++) 
                {
                    if(pips + players[p].getCard(i).getValue() <= 31)   
                    {
                        playables++;
                    }
                }
                if(playables == 0)
                {
                    
                    break;
                }

                int cardP1;
                do
                {
                System.out.println("player "+ (p+1) + "'s hand: ");
                players[p].checkHand();
                System.out.println("choose a card to play");
                System.out.print("card: ");
                cardP1 = input.nextInt();

                } while(players[p].getCard(cardP1).getValue() + pips > 31);

                if(p == 0)
                playedCards[p].addCard(players[p].playCard(cardP1));
                pips += playedCards[p].getCard(playedCards[p].getSize()).getValue();
                System.out.println("" + pips + "!");
            }

            if (pips == 31) {players[p].peg(2);}
            else {players[p].peg(1);}
    }
}
