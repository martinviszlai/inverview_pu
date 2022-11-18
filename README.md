# About project

This is simple project for interview purposes. The project is a backend service for a code review tool.

Project has some simplifications, that should be ignored as part of assignment:
* Logic how code review is linked to actual code - for sake of this project, simple string with reference is good enough.
* Analytics data are extremely simplified.
* Users are represented as simple string (email). Consider this as sufficient information about user.
* Database engine selection - a simple in-memory H2 DB is used. Only the DB itself is intentional simplification, 
its configuration and usage in Application _is_ subject of assignment. 

Anything else should be subject of consideration by interviewee. 

# Interview assignment

## Home assignment 
Perform a code review on sample code. 
Imagine a scenario that a junior developer created a PR with his changes for task with following definition:

    User story: As a reviewer, I want to be able to add comments to a code review, so I can give my feeback.
    AC: - A comment can be added to any place in code in a Review, or to a Review as generic comment
        - A user can't update comment after it was created, only deletion is possible.
        - All comments for given Review are shown on Review detail page.

Assignments represents:
1. pull code from repo
2. get familiar with the code base
3. try to understand changes in PR
4. perform a code review (write review comments). Consider aspects like:
    * application (code) design
    * code smells
    * code quality - clean code and other best practises
    * error handling & recovery
    * observability
    * security
    * performance

Expected time for home assignment: up to 2 hours.

## Interview part
On interview, there will be a discussion about the code review, with some pair coding of design and draft
implementation of some components. Just as if author of the PR summoned you to explain your thoughts from comments 
as he/she doesn't understand them.

_If possible, we recommend to bring your own computer with your favourite IDE with your configuration, 
so we could discuss the code in your familiar environment. If there is no such possibility, 
we will provide a machine with IntelliJ Idea._ 