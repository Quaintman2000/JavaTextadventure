//package TextAdventureFiles;

public class source {

    public static void main(String[] args) {
        // Declare needed objects.
        storyFunctions storyFunc = new storyFunctions();
        player player = new player();
        character narrator = new character();
        narrator.SetName("Narrator");

        // Create a play again bool to put the game on a loop until they stop it.
        boolean playAgain = true;

        // Keep playing the game while playAgain is true.
        while (playAgain) {
            // Play Introduction.
            storyFunc.Introduction();

            // Set the player alive status to true.
            player.alive = true;
            // Ask for the player's name and set it.
            player.SetName(storyFunc.StoryGetName());
            // Ask for the player's desired class and set it.
            player.playerClass = storyFunc.StoryGetClass();

            // Play story introduction.
            narrator.Talk(storyFunc.PlayGameIntro(player.GetName(), player.playerClass));

            // Set the scene to scene 1.
            int sceneNum = 1;

            while (player.alive && sceneNum <= 3) {
                // grab user input.
                String playerAnswer = storyFunc.GetUserInput();

                String stuffToSay = "";
                // if it's scene 1
                if (sceneNum == 1) {
                    // if player said yes
                    if (playerAnswer == "YES") {
                        // return what to say
                        stuffToSay += "You enter the dungeon but you were immediately introduced to a giant spider!\n";
                        stuffToSay += "\t The spider charges at you! What will you do?\n";
                        stuffToSay += "\t Attack, Block, or Dodge?\n";

                       
                    }
                    // if player types no
                    else if (playerAnswer == "NO") {
                        // return what to say
                        stuffToSay += "You decide its not worth it so you take your leave but, a gaint boulder falls out of no where and smashes you.\n\n";
                        stuffToSay += "\t Game over...\n *cough* *cough* Just go inside you pussy! *cough* *cough*\n";

                        // set alive status
                        player.alive = false;

                        
                    }
                    // if the player types in an invalid input
                    else {
                        // return what to say
                        stuffToSay += "As you sat there and did nothing, a poisonous snake comes by and bites your leg.\n";
                        stuffToSay += "\t You kneel over and die from the poison...\n\n";
                        stuffToSay += "\t Game over... Hint: try putting in a valid input next time!\n";

                        // set alive status to false
                        player.alive = false;
                    }
                }
                // if it's scene 2
                else if (sceneNum == 2) {
                    // if tried to attack
                    if (playerAnswer == "ATTACK") {
                        // return what to say
                        stuffToSay += "You tried to swing your weapon but the spider got to you first and you died.\n\n";
                        stuffToSay += "\t Game over...\n";

                        // set alive status to false
                        player.alive = false;
                    } 
                    else if (playerAnswer == "BLOCK") {
                        // if the player is the knight
                        if (player.playerClass == "NOBLE KNIGHT") {
                            // return what to say
                            stuffToSay += "You block the spider's attack with your shield then you swing a fatal counter blow\n";
                            stuffToSay += "\t killing the spider. You continue down further the dungeon...\n\n";
                            stuffToSay += "\t You reached the end of the dungeon, killing a few more spiders on the way, and it appears to be a large room with a chest on the other side\n";
                            stuffToSay += "\t but it's guarded by a giant Oger with a club. It seems to being currently distracted as it's feasting on a donkey carcass...\n";
                            stuffToSay += "\t what will you do?\n";
                            stuffToSay += "\t Steal or Assassinate?\n";

                            
                        }
                        // if the player is the ROGUE
                        else {
                            // return what to say
                            stuffToSay += "You try to block the attack with your tiny knife but failed.\n";
                            stuffToSay += "\t The spider mauls you to death.\n\n";
                            stuffToSay += "\t Game over... Hint: Try dodging as a " + player.playerClass + " next time!\n";

                            // set alive status to false
                            player.alive = false;
                        }
                    } else if (playerAnswer == "DODGE") {
                        // if the player is the knight
                        if (player.playerClass == "NOBLE KNIGHT") {
                            // return what to say
                            stuffToSay += "You try move your fat ass out of the way but you were too slow.\n";
                            stuffToSay += "\tThe spider mauls you to death.\n\n";
                            stuffToSay += "\tGame over... Hint: Try blocking as a " + player.playerClass + " next time!\n";

                            // set alive status to false
                            player.alive = false;
                        }
                        // if the player is the ROGUE
                        else {
                            // return what to say
                            stuffToSay += "You swiftly dodge out of the way of the spiders attack and then you land a critical blow as you stab the back of the spider's head,\n";
                            stuffToSay += "\t killing the spider. You continue down further the dungeon...\n\n";
                            stuffToSay += "\t You reached the end of the dungeon, killing a few more spiders on the way, and it appears to be a large room with a chest on the other side\n";
                            stuffToSay += "\t but it's guarded by a giant Oger with a club. It seems to being currently distracted as it's feasting on a donkey carcass...\n";
                            stuffToSay += "\t what will you do?\n";
                            stuffToSay += "\t Steal or Assassinate?\n";

                            
                        }
                    } else {
                        // return what to say
                        stuffToSay += "You sat there doing nothing as the spider jumps onto you and mauls you.\n\n";
                        stuffToSay += "\t Game over... Hint: try putting in a valid input next time!\n";

                        // set alive status to false
                        player.alive = false;
                    }
                }
                // if it's scene 3
                else {
                    // if player tries to steal
                    if (playerAnswer == "STEAL") {
                        // if the player is the knight
                        if (player.playerClass == "NOBLE KNIGHT") {
                            // return stuff to say for the narrator
                            stuffToSay += "You sheath your sword and pull out a cloth bag to put the gold in. The sound of your armor clinking together and the rustling of gold coins\n";
                            stuffToSay += "\t made just enough noise for the oger to hear you and he grabs his club, quickly turns around, and smacks you into wall with the club. Breaking ever bone you had.\n";
                            stuffToSay += "\t You slowly bleed out.\n\n Game over...";

                            // set alive status to dead
                            player.alive = false;
                        }
                        // if the player is a ROGUE
                        else {
                            // return stuff to say for the narrator
                            stuffToSay += "silently sneak up to the treasure chest without the oger noticing due to your lack of armor and\n";
                            stuffToSay += "\t You grab as much gold as you can carry and quickly sneak back out of the dungeon to live the rest of your days in riches!\n";
                            stuffToSay += "\t As the world hear's your story, you earn the title: " + player.GetName() + " the oger deciever!\n\n";
                            stuffToSay += "\t You win! Try playing as the knight next time!\n";

                           
                        }
                    } else if (playerAnswer == "ASSASSINATE") {
                        // if the player is the knight
                        if (player.playerClass == "NOBLE KNIGHT") {
                            // return stuff to say for the narrator
                            stuffToSay += "You slowly tip-toe up to the oger. He doesn't notice you still so you grab your sword with both hands and shove it up the ogers back.\n";
                            stuffToSay += "\t It pierces the oger's heart and it dies.\n\n";
                            stuffToSay += "\t You grab as much gold as you can carry and walk back out of the dungeon to live the rest of your days in riches!\n";
                            stuffToSay += "\t As the world hear's your story, you earn the title: " + player.GetName()
                                    + " the oger slayer!\n";
                            stuffToSay += "\t You win! Try playing as the ROGUE next time!\n";

                           
                        }
                        // if the player is a ROGUE
                        else {
                            // return stuff to say for the narrator
                            stuffToSay += "You slowly sneak up to the oger and you quickly stab the oger in the back.\n";
                            stuffToSay += "\t It doesn't appear to be affective because oger slowly stands up, turns to you, pulls the knife out his back, and gives you a 'what the fuck bro' look.\n";
                            stuffToSay += "\t You give a nervous laugh and quickly makes towards the exit. The oger grabs and flings you into the wall, breaking ever bone you had.\n";
                            stuffToSay += "\t You slowly bleed out.\n\n Game over...\n";

                            // set alive status to dead
                            player.alive = false;
                        }
                    } else {
                        // return stuff to say for the narrator
                        stuffToSay += "As you sat there and do nothing, the oger notices you and throws his club at you.\n";
                        stuffToSay += "\t It was a direct hit and you die from the blow.\n\n Game over... Hint: try putting a valid input next time.\n";

                        // set alive status to dead
                        player.alive = false;
                    }
                }
                
                // Narrator narratates the stuff to say.
                narrator.Talk(stuffToSay);
                // Change scene.
                sceneNum = storyFunc.NextScene(sceneNum);
            }
            // Ask the user if the want to play again.
            narrator.Talk(storyFunc.AskToPlayAgain(player.alive));
            // Determine the play again function.
            playAgain = storyFunc.PlayAgainYesOrNo();

        }
    }
}
