# Black Jack Project
## A simple game of blackjack between one player and the computer.
### Overview
When the app is run the dealer deals two cards to both themselves and the player.
If the player and the dealer hit blackjack on the deal the game is determined a
tie. If just one of the participants is dealt blackjack then that player
automatically wins. If neither scores blackjack the player's turn starts.
They are allowed to hit or stand, hitting will net them a card, but if they go over
21 they automatically lose, conversely if they obtain 21 they automatically win.
Standing will end their turn and start the dealer's turn. The dealer will always
hit if their hand's value is below 17, and keep hitting until they are equal to
or greater than 17. If the dealer busts or hits blackjack they automatically lose
or win respectfully. If the dealer does not hit, does not bust, and does not win
the dealer's turn ends. Next, a winner is determined by finding the hand with
the greatest value.

### Lessons learned
This project allowed me to explore the construction and implementation of an
object oriented program. Specifically, I learned to develop objects who's fields
were other objects. Structuring the program this way ensures data is protected
from accidental manipulation. More concisely, this structure means the program will
be better encapsulated. Working on this project also grew my understanding of
the potential relationships between objects. Conceptualizing objects as abstracted
real life entities made defining their relationships much easier. In other words
a dealer object clearly must emulate their real life counter-part, thus the
dealer 'Has-a' deck of cards, which itself is an array of Card objects who possess
two pieces of information. Finally, this project demonstrated that breaking down a
real life situation into concrete actors (and the information the actors possess and
the actions they are allowed to take), allows one to focus on the logical interaction
between theses entities, rather than attempting to tackle the problem all at once. 
