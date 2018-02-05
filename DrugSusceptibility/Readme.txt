Executive Summary:
In this day and age, when accessibility to drugs has increased manifolds, vast sections of the
population have become susceptible to drug abuse. Consequently, a lot needs to be done to
help healthcare organizations combat this problem. There is a plethora of factors that demand
consideration when determining whether an individual has the tendency towards drug
addiction. In our system, we attempt to provide a framework for healthcare/social workers to
begin working with and build upon. We propose to find patterns in population data to put a
face to the kind of profile that is vulnerable to fall prey to drug abuse. By studying and
employing various methods of data analysis, we will help organizations identify target groups
to focus their efforts on.

-Version 2.3
1] Final Release
2] Incorporated more attributes in creation of profiles (Taking user demographics, personality parameters, and showing susceptibility)
3] Refactoring of code was done to improve the overall design of the system code
4] Created modules and removed dead code to clean the project
5] Removed the counts showing weighted averages of the profiles 
7] Suggested drug susceptibility based on user responses and weighted average calculation

Assumptions:
1] Weighted average is an accurate indicator of trends in drug susceptibility
2] The three personality traits influence drug use
 
Setup:
To set up a running instance of MongoDB on command prompt:

1. Change directory to that of bin folder(MongoDB) in command prompt
2. Run command: mongod.exe

To run the project:

1. Open a new command prompt and change directory to workspace of project
2. Run command: gradle run