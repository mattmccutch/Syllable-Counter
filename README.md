# Syllable-Counter
This is a simple command-line application written in Java that takes an English word as input and returns the number of syllables in the word.

The program utilizes the regular expression functionality in Java to count the syllables. The algorithm counts the number of vowels in the word, subtracts for diphtongs and triphongs, subtracts a syllable if the word ends with a silent 'e', and adds a syllable if the word ends with a consonant followed by 'le' or 'les'. Words of 3 letters or less are assumed to have 1 syllable.

## Requirements
JDK (Java Development Kit) 8 or later
A command line interface (CLI) like Terminal, Command Prompt, or PowerShell
Usage
Open your CLI and navigate to the directory where SyllableCounter.java is located.
Compile the Java code using the command javac SyllableCounter.java. This creates a SyllableCounter.class file.
Run the program using the command java SyllableCounter.
The program will wait for you to enter a word. Enter any word and press Enter.
The program will output the number of syllables in the word. It continues to wait for additional words until you terminate the program.
To terminate the program, use Ctrl + C (or the equivalent command for your CLI).
Note: The program assumes that the input word only contains lowercase letters from 'a' to 'z'. Any other characters will lead to an "Invalid input" error message. Words are converted to lowercase before syllable counting.
