package com.ps;

import java.lang.String;


public class Main {
    public static void main(String[] args) {
        System.out.println("\nWelcome to Mavericks Motors!");

        // ASCII art for display in console
        String asciiSportsCar = """
                                                                    
                                                                  ,----------------,              ,-------------,
                                                            _.-="   _- [Syed]     | ||""\"""\""---._______     __..
                                                ___.===""\""-.______-,,,,,,,,,,,,`-''----" ""\"""       ""\"""  __'
                                         __.--""     __        ,'                   o \\           __        [__|
                                    __-""=======.--""  ""--.=================================.--""  ""--.=======:
                                   ]            : /        \\ : |========================|    : /        \\ :    [---------------- 
                                   S___________:|          |: |========================|    :|          |:   _-"
                                    S__________: \\        / :_|=======================/_____: \\        / :__-"
                                    -----------'  "-____-"  `-------------------------------'  "-____-
                """;
        System.out.println(asciiSportsCar);


        UserInterface ui = new UserInterface();
        ui.display();
    }
}