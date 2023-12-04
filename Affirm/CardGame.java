import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Card {
    private final String suit;
    private final String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

class Deck {
    private final List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        initializeDeck();
        shuffle();
    }

    private void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (!cards.isEmpty()) {
            return cards.remove(0);
        } else {
            return null; // No more cards in the deck
        }
    }
}

class Player {
    private final String name;
    private final List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void addToHand(Card card) {
        hand.add(card);
    }

    public Card playCard() {
        if (!hand.isEmpty()) {
            return hand.remove(0);
        } else {
            return null; // No more cards in hand
        }
    }

    public String getName() {
        return name;
    }
}

public class WarGame {
    public static void main(String[] args) {
        Deck deck = new Deck();

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");

        // Deal cards to players
        while (true) {
            Card card1 = deck.drawCard();
            Card card2 = deck.drawCard();

            if (card1 == null || card2 == null) {
                break; // No more cards to deal
            }

            player1.addToHand(card1);
            player2.addToHand(card2);
        }

        // Play the game
        while (true) {
            Card card1 = player1.playCard();
            Card card2 = player2.playCard();

            if (card1 == null || card2 == null) {
                break; // No more cards to play
            }

            System.out.println(player1.getName() + " plays: " + card1);
            System.out.println(player2.getName() + " plays: " + card2);

            // Compare ranks
            int result = card1.getRank().compareTo(card2.getRank());

            if (result > 0) {
                System.out.println(player1.getName() + " wins the round!");
            } else if (result < 0) {
                System.out.println(player2.getName() + " wins the round!");
            } else {
                System.out.println("It's a tie!");
            }
        }
    }
}


// ...

public class WarGame {
    public static void main(String[] args) {
        // ... (same initialization code as before)

        // Play the game
        while (true) {
            Card card1 = player1.playCard();
            Card card2 = player2.playCard();

            if (card1 == null || card2 == null) {
                break; // No more cards to play
            }

            System.out.println(player1.getName() + " plays: " + card1);
            System.out.println(player2.getName() + " plays: " + card2);

            // Compare ranks
            int result = card1.getRank().compareTo(card2.getRank());

            if (result > 0) {
                System.out.println(player1.getName() + " wins the round!");
                player1.addToHand(card1);
                player1.addToHand(card2);
            } else if (result < 0) {
                System.out.println(player2.getName() + " wins the round!");
                player2.addToHand(card1);
                player2.addToHand(card2);
            } else {
                System.out.println("It's a tie! Going to war...");

                List<Card> faceDownCards = new ArrayList<>();
                List<Card> faceUpCards = new ArrayList<>();

                // Add a face-down card for each player
                faceDownCards.add(player1.playCard());
                faceDownCards.add(player2.playCard());

                // Add a face-up card for each player
                faceUpCards.add(player1.playCard());
                faceUpCards.add(player2.playCard());

                System.out.println(player1.getName() + " plays face down card: " + faceDownCards.get(0));
                System.out.println(player2.getName() + " plays face down card: " + faceDownCards.get(1));

                System.out.println(player1.getName() + " plays face up card: " + faceUpCards.get(0));
                System.out.println(player2.getName() + " plays face up card: " + faceUpCards.get(1));

                // Compare face-up cards to determine the winner
                int warResult = faceUpCards.get(0).getRank().compareTo(faceUpCards.get(1).getRank());

                if (warResult > 0) {
                    System.out.println(player1.getName() + " wins the war!");
                    player1.addToHand(faceDownCards);
                    player1.addToHand(faceUpCards);
                } else if (warResult < 0) {
                    System.out.println(player2.getName() + " wins the war!");
                    player2.addToHand(faceDownCards);
                    player2.addToHand(faceUpCards);
                } else {
                    System.out.println("It's a tie again! The war continues...");
                    // The game could continue to loop in case of a tie in the war.
                }
            }
        }
    }
}


// for multiple players
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Player {
    private final String name;
    private final List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void addToHand(Card card) {
        hand.add(card);
    }

    public void addToHand(List<Card> cards) {
        hand.addAll(cards);
    }

    public Card playCard() {
        if (!hand.isEmpty()) {
            return hand.remove(0);
        } else {
            return null; // No more cards in hand
        }
    }

    public String getName() {
        return name;
    }
}

public class WarGame {
    public static void main(String[] args) {
        int numberOfPlayers = 3; // Change the number of players as needed

        // Initialize players
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(new Player("Player " + i));
        }

        Deck deck = new Deck();

        // Deal cards to players
        while (true) {
            Card card = deck.drawCard();

            if (card == null) {
                break; // No more cards to deal
            }

            for (Player player : players) {
                player.addToHand(card);
            }
        }

        // Play the game
        while (true) {
            // Play one round
            List<Card> playedCards = new ArrayList<>();

            for (Player player : players) {
                Card card = player.playCard();
                if (card != null) {
                    System.out.println(player.getName() + " plays: " + card);
                    playedCards.add(card);
                }
            }

            if (playedCards.isEmpty()) {
                break; // No more cards to play
            }

            // Compare ranks
            int maxRank = -1;
            boolean tie = false;

            for (Card card : playedCards) {
                int rankValue = getRankValue(card.getRank());
                if (rankValue > maxRank) {
                    maxRank = rankValue;
                    tie = false;
                } else if (rankValue == maxRank) {
                    tie = true;
                }
            }

            if (!tie) {
                Player winner = findPlayerWithCard(players, playedCards.get(playedCards.size() - 1));
                System.out.println(winner.getName() + " wins the round!");
                winner.addToHand(playedCards);
            } else {
                System.out.println("It's a tie! Going to war...");

                List<Card> faceDownCards = new ArrayList<>();
                List<Card> faceUpCards = new ArrayList<>();

                for (Player player : players) {
                    faceDownCards.add(player.playCard());
                    faceUpCards.add(player.playCard());
                }

                printWarCards(players, faceDownCards, "face down");
                printWarCards(players, faceUpCards, "face up");

                int maxFaceUpRank = getMaxRankValue(faceUpCards);
                List<Player> warWinners = findPlayersWithMaxRank(players, faceUpCards, maxFaceUpRank);

                if (warWinners.size() == 1) {
                    Player warWinner = warWinners.get(0);
                    System.out.println(warWinner.getName() + " wins the war!");
                    warWinner.addToHand(faceDownCards);
                    warWinner.addToHand(faceUpCards);
                } else {
                    System.out.println("It's a tie again! The war continues...");
                    // The game could continue to loop in case of a tie in the war.
                }
            }
        }
    }

    private static int getRankValue(String rank) {
        switch (rank) {
            case "Jack":
                return 11;
            case "Queen":
                return 12;
            case "King":
                return 13;
            case "Ace":
                return 14;
            default:
                return Integer.parseInt(rank);
        }
    }

    private static int getMaxRankValue(List<Card> cards) {
        int maxRank = -1;
        for (Card card : cards) {
            int rankValue = getRankValue(card.getRank());
            if (rankValue > maxRank) {
                maxRank = rankValue;
            }
        }
        return maxRank;
    }

    private static void printWarCards(List<Player> players, List<Card> cards, String status) {
        for (int i = 0; i < players.size(); i++) {
            System.out.println(players.get(i).getName() + " plays " + status + " card: " + cards.get(i));
        }
    }

    private static Player findPlayerWithCard(List<Player> players, Card card) {
        for (Player player : players) {
            if (player.playCard() == card) {
                return player;
            }
        }
        return null;
    }

    private static List<Player> findPlayersWithMaxRank(List<Player> players, List<Card> cards, int maxRank) {
        List<Player> winners = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            if (getRankValue(cards.get(i).getRank()) == maxRank) {
                winners.add(players.get(i));
            }
        }
        return winners;
    }
}
