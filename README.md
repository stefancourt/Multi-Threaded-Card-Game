# Multi-threaded Card game

## 🧑🏻‍💻 Author
[Stefan Court](https://github.com/stefancourt)

## 📖 Game information
The game is run between **n number of players** where there is a test file that contains **8n number of cards**. The program creates n number of players and n number of decks and inputs these cards into the players hands and decks respectively. Each player then draws a card from the deck to the left of them and discards a card from their hand to the deck to the right of them. This carries on until a person has a hand full of the **same values** of card, this person then declares that they are the winner and the game is stopped.

## ❓ How to run the game
If running from terminal you can run the class files, they are in *CardGame\target\classes* you then must type **java com.mycompany.cardgame.CardGame** to start the application. If running from an IDE, you must press start/run on the **CardGame** executable class, the program will ask for an input of the number of players and the file location. Once inputted, the game will start and the player that has won will be printed out to the screen. You can then see each players actions in their respective *player(n)_output.txt* files and the final decks once the game has ended in their respective *deck(n)_output.txt* files. There is also a runnable jar file to run the program.

## 🧪 How to run the test suite
To run the tests you must press **run tests** on the IDE, we used NetBeans so this was under the run section of the IDE. this will then pass through some various tests using an input file of *test.txt*. This will then print out that the tests have been completed and some information that has been outputted while the tests were completed.

## 📝 License
This project is [MIT](https://choosealicense.com/licenses/mit/) licensed.