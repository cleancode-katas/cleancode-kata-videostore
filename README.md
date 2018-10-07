# Clean Code Kata - VideoStore

Code used to demonstrate in a workshop how clean code principles can be
applied to existing legacy code.

## Getting Started

This workshop is organized into two folders start and finish.

Start folder has working files in original state

Finish folder has files after the refactoring is done.  The finish folder
shall be used to check the final results of the refactoring as
model state for verification.

The learner shall start in the start folder and open the project inside
the start folder in an IDE like IntelliJ IDEA or Eclipse.

The project is a maven project and can be imported directly in any IDE.
The README file in the start folder project details all the observations
and the activities of the refactoring to be done to files.

After every activity learner is supposed to run the test cases and
verify nothing is broken while doing the refactoring mentioned
in the activities of the README file.

## Going through gradual activity changes

The commits in this repositoy are done after performing every
listed activity in the README file and they can be studied
by opening in any git visualization like gitk or Git UI apps.

The commits can also be checked out one by one using the commit
hashes to study what changes were made to files in every activity.

## Original source

[Clean Coders Episode 3](https://cleancoders.com/episode/clean-code-episode-3/show)
has the detailed explanation of how to refactor the classes in this project
into clean code.

Original source for this project is available at Uncle Bob's
[videostore](https://github.com/unclebob/videostore) repository.

This repository is also created using the concept of the first
chapter of Martin Fowler's classic book: Refactoring.