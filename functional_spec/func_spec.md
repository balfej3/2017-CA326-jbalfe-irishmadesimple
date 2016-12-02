# Table of contents

- [1: Introduction](#1-introduction)
    + [**1.1 Overview**](#--11-overview--)
    + [**1.2 Business Context**](#--12-business-context--)
    + [**1.3 Glossary of Terms**](#--13-glossary-of-terms--)
- [2. General Description](#2-general-description)
    + [**2.1 Product/System Functions**](#--21-product-system-functions--)
    + [**2.2 User Characteristics and Objectives**](#--22-user-characteristics-and-objectives--)
    + [**2.3 Operational Scenarios**](#--23-operational-scenarios--)
    + [**2.4 Constraints**](#--24-constraints--)
- [3. Functional Requirements](#3-functional-requirements)
    + [**Download**](#--download--)
    - [**Pronunciations**](#--pronunciations--)
    - [**Feedback**](#--feedback--)
    - [**External resources**](#--external-resources--)
    - [**Translation**](#--translation--)
    - [**Choose Book Type**](#--choose-book-type--)
    - [**Homework - Fill the Blanks**](#--homework---fill-the-blanks--)
    - [**Homework -Story**](#--homework--story--)
    - [**Homework - Spellings**](#--homework---spellings--)
- [4. System Architecture](#4-system-architecture)
- [5. High Level Design](#5-high-level-design)
- [6. Preliminary Schedule](#6-preliminary-schedule)
- [7. Appendices](#7-appendices)



# 1: Introduction 


### **1.1 Overview**

Our product is an Android app to aid primary school children in completing
their Irish homework. Children will have a clearer understanding of exactly
what is expected of them after their first attempt at each exercise.

Teachers, kids and parents have requested product such as this to help
primary schools nation wide. The product is expected to be used alongside
Bun go Barr and Ceartlitriu which are the main Irish books used nation wide.
The product will have all the different categories of exercises such as

* Word searches

* Fill the blanks

* Storytelling for relevant chapters and exercises

* Spellings

The app will assist kids in coming up with the correct answers by giving
clearer understanding of exercises through audio pronunciations, phonetics,
translation to English and visuals.

### **1.2 Business Context**


This app will be used by primary school children, their parents and teachers

### **1.3 Glossary of Terms**


* SQLite:

SQLite is an in-process library that implements a self-contained,
serverless,zero-configuration, transactional SQL database engine.

* Android:
An open source operating system for smartphones and tablets.

* SDK:
Software developer kit is a set of tools that allow the creation of
applications for a specific software framework, in our case Android.

* Android Studio:
The official integrated development environment for developing Android
applications.

* GUI:
Graphical User Interface, allows communication between users and the
application through graphics.

# 2. General Description


### **2.1 Product/System Functions**


The app will function as follows:

* **Selections**

	* Main section (books)

*  **Extras**

	* External links

	* Feedback

*  **Watch tutorial videos for specific chapters**

* **Select type of exercise to be completed**

	* Word Search

	* Fill the blanks

	* Spellings

### **2.2 User Characteristics and Objectives**


The targeted audience for the app are primary school kids, teachers and
parents and users will need internet access and portable devices such as 
mobile phones and tablets to be able to utilise the application.

The application will be user friendly because human computer interaction
principles are part of the guidelines in the development process. Navigation
will be very easy considering that our targeted audience includes kids.

### **2.3 Operational Scenarios**


The same use cases apply to both books in use, Bun go Barr and Ceartlitriu

| **USE CASE**                  | A person decides to use the application                                                                             |                                                                                                                       |
|-------------------------------|---------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------|
| **Goal in Context**           | A person needs help with Irish homework                                                                             |                                                                                                                       |
| **Scope & Level**             | Application, Core.                                                                                                  |                                                                                                                       |
| **Preconditions**             | Must first download the application                                                                                 |                                                                                                                       |
| **Success End Condition**     | User will have access to all available services provided by the application                                         |                                                                                                                       |
| **Failed End Condition**      | User will not have access                                                                                           |                                                                                                                       |
| **Primary, Secondary Actors** | User, application                                                                                                   |                                                                                                                       |
| **Trigger**                   | A person decides to use the application                                                                             |                                                                                                                       |
| **DESCRIPTION**               | **Step**                                                                                                            | **Action**                                                                                                            |
|                               | 1                                                                                                                   | A person downloads the application                                                                                    |
|                               | 2                                                                                                                   | Application download completes successfully                                                                           |
|                               | 3                                                                                                                   | User can begin to use application as desired                                                                          |
| **EXTENSIONS**                | **Step**                                                                                                            | **Branching Action**                                                                                                  |
|                               |                                                                                                                     | N/A                                                                                                                   |
| **VARIATIONS**                |                                                                                                                     | **Branching Action**                                                                                                  |
|                               |                                                                                                                     | User launches the application and take to the home screen                                                             |
| **USE CASE**                  | User wants to hear how a word is pronounced                                                                         |                                                                                                                       |
| **Goal in Context**           | A user would like to hear how to correctly pronounce an Irish word                                                  |                                                                                                                       |
| **Preconditions**             | The user is in the Bun go Barr or Ceartlitriu section                                                               |                                                                                                                       |
| **Success End Condition**     | The user hears how to pronounce their chosen word                                                                   |                                                                                                                       |
| **Failed End Condition**      | The user is unable to hear the correct pronunciation                                                                |                                                                                                                       |
| **Primary, Secondary Actors** | Player Server, GUI                                                                                                  |                                                                                                                       |
| **Trigger**                   | The player selects the word they wish to translate                                                                  |                                                                                                                       |
| **DESCRIPTION**               | **Step**                                                                                                            | **Action**                                                                                                            |
|                               | 1                                                                                                                   | The user presses on their word                                                                                        |
|                               | 2                                                                                                                   | A popup box gives them options                                                                                        |
|                               | 3                                                                                                                   | The user selects hear pronunciation                                                                                   |
|                               | 4                                                                                                                   | The app finds the correct audio to play                                                                               |
|                               | 5                                                                                                                   | The app ¨checks if the phone is muted                                                                                 |
|                               | 6a                                                                                                                  | The user is prompted to turn up their volume                                                                          |
|                               | 6b                                                                                                                  | The app plays the audio pronunciation                                                                                 
| **USE CASE**                  | User wants to leave feedback to the developers                                                                      |                                                                                                                       |
| **Goal in Context**           | A user wishes to leave some form of feedback to the developers, possibly a bug report                               |                                                                                                                       |
| **Preconditions**             | The user is at the main menu of the app                                                                             |                                                                                                                       |
| **Success End Condition**     | The user successfully leaves feedback to the developers                                                             |                                                                                                                       |
| **Failed End Condition**      | The user is unable to deliver the feedback they wanted to send to the developers                                    |                                                                                                                       |
| **Primary, Secondary Actors** | Player Server, GUI                                                                                                  |                                                                                                                       |
| **Trigger**                   | The player clicks on the extras button                                                                              |                                                                                                                       |
| **DESCRIPTION**               | **Step**                                                                                                            | **Action**                                                                                                            |
|                               | 1                                                                                                                   | The user clicks on the extras button                                                                                  |
|                               | 2                                                                                                                   | The screen changes to the extras area of the app                                                                      |
|                               | 3                                                                                                                   | The user is shown a selection of extra features                                                                       |
|                               | 4                                                                                                                   | The user chooses the button for “Feedback”                                                                            |
|                               | 5                                                                                                                   | The display updates to show the feedback options i.e. email developer or leave Play Store review                      |
|                               | 6                                                                                                                   | The user presses on the link they wish to view                                                                        |
|                               | 7a                                                                                                                  | The user is brought to their email client with the developer’s email in the “to:” area                                |
|                               | 7b                                                                                                                  | The user is brought to the Play Store page of the application                                                         |
| **USE CASE**                  | User wants to translate word                                                                                        |                                                                                                                       |
| **Goal in Context**           | A user would like to see the English translation of an Irish word in one of the exercises                           |                                                                                                                       |
| **Preconditions**             | The user is in the Bun go Barr or Ceartlitriu section                                                               |                                                                                                                       |
| **Success End Condition**     | The user is given the correct English translation                                                                   |                                                                                                                       |
| **Failed End Condition**      | The user is not given the translation                                                                               |                                                                                                                       |
| **Primary, Secondary Actors** | Player Server, GUI                                                                                                  |                                                                                                                       |
| **Trigger**                   | The player selects the word they wish to translate                                                                  |                                                                                                                       |
| **DESCRIPTION**               | **Step**                                                                                                            | **Action**                                                                                                            |
|                               | 1                                                                                                                   | The user presses on the word                                                                                          |
|                               | 2                                                                                                                   | A popup box gives them options                                                                                        |
|                               | 3                                                                                                                   | The user selects translate                                                                                            |
|                               | 4                                                                                                                   | The app displays the English translation of the word                                                                  |
| **USE CASE**                  | Adult user wants information on external resources                                                                  |                                                                                                                       |
| **Goal in Context**           | An adult(e.g. Parent of the child) wants to learn Irish and would like more information on where they could do this |                                                                                                                       |
| **Scope & Level**             | System, Core.                                                                                                       |                                                                                                                       |
| **Preconditions**             | The user is at the main menu of the app                                                                             |                                                                                                                       |
| **Success End Condition**     | The user finds the links and resources they were looking for                                                        |                                                                                                                       |
| **Failed End Condition**      | The app crashes or the user is not brought to the correct screen within the app                                     |                                                                                                                       |
| **Trigger**                   | The player clicks on the extras button                                                                              |                                                                                                                       |
| **DESCRIPTION**               | **Step**                                                                                                            | **Action**                                                                                                            |
|                               | 1                                                                                                                   | The user clicks on the extras button                                                                                  |
|                               | 2                                                                                                                   | The screen changes to the extras area of the app                                                                      |
|                               | 3                                                                                                                   | The user is shown a selection of extra features                                                                       |
|                               | 4                                                                                                                   | The user chooses the button for “Extra Irish Assistance”                                                              |
|                               | 5                                                                                                                   | The display updates to show the links to these sites etc                                                              |
|                               | 6                                                                                                                   | The user presses on the link they wish to view                                                                        |
|                               | 7                                                                                                                   | The link is opened successfully in the Android browser of their choosing                                              |
| **USE CASE**                  | User decides to complete exercise with Bun go Barr Irish book                                                       |                                                                                                                       |
| **Goal in Context**           | User wants to complete Bun go Barr exercise                                                                         |                                                                                                                       |
| **Scope & Level**             | Application, Core.                                                                                                  |                                                                                                                       |
| **Preconditions**             | Application downloaded                                                                                              |                                                                                                                       |
| **Success End Condition**     | exercise successfully completed                                                                                     |                                                                                                                       |
| **Failed End Condition**      | No help received, exercise not completed                                                                            |                                                                                                                       |
| **Primary, Secondary Actors** | User, application                                                                                                   |                                                                                                                       |
| **Trigger**                   | Bun go Barr exercise completion                                                                                     |                                                                                                                       |
| **DESCRIPTION**               | **Step**                                                                                                            | **Action**                                                                                                            |
|                               | 1                                                                                                                   | On the homescreen user clicks on Bun go Barr book                                                                     |
|                               | 2                                                                                                                   | User selects a category of exercise to be completed from the different categories                                     |
|                               | 3                                                                                                                   | Help is given and exercise is online after which hard copy must be completed                                          |
| **EXTENSIONS**                | **Step**                                                                                                            | **Branching Action**                                                                                                  |
|                               |                                                                                                                     | N/A                                                                                                                   |
| **VARIATIONS**                |                                                                                                                     | **Branching Action**                                                                                                  |
|                               |                                                                                                                     | User chooses to complete exercise in Ceartlitriu                                                                      |
| **USE CASE**                  | User chooses to complete “Word search” category exercise in Bun go Barr                                             |                                                                                                                       |
| **Goal in Context**           | complete Word search category exercise                                                                              |                                                                                                                       |
| **Scope & Level**             | Application, Bun go Barr.                                                                                           |                                                                                                                       |
| **Preconditions**             | Bun go Barr book selected                                                                                           |                                                                                                                       |
| **Success End Condition**     | Search for appropriate words completed, user can complete hard copy version of exercise                             |                                                                                                                       |
| **Failed End Condition**      | Words could not be found                                                                                            |                                                                                                                       |
| **Primary, Secondary Actors** | User, application                                                                                                   |                                                                                                                       |
| **Trigger**                   | Bun go Barr word search category exercise                                                                           |                                                                                                                       |
| **DESCRIPTION**               | **Step**                                                                                                            | **Action**                                                                                                            |
|                               | 1                                                                                                                   | In exercise categories user clicks word search                                                                        |
|                               | 2                                                                                                                   | Grid is drawn                                                                                                         |
|                               | 3                                                                                                                   | Appropriate words are searched for by clicking on the right letters to form a word                                    |
| **EXTENSIONS**                | **Step**                                                                                                            | **Branching Action**                                                                                                  |
|                               |                                                                                                                     | N/A                                                                                                                   |
| **VARIATIONS**                |                                                                                                                     | **Branching Action**                                                                                                  |
|                               |                                                                                                                     | User chooses Fill the blanks category within Bun go Barr                                                              |
| **USE CASE**                  | User chooses to complete “Fill the blanks” category exercise in Bun go Barr                                         |                                                                                                                       |
| **Goal in Context**           | Complete Fill the blanks category exercise                                                                          |                                                                                                                       |
| **Scope & Level**             | Application, Bun go Barr.                                                                                           |                                                                                                                       |
| **Preconditions**             | Bun go Barr book selected                                                                                           |                                                                                                                       |
| **Success End Condition**     | Blanks are filled, score given and user can complete exercise in hard copy                                          |                                                                                                                       |
| **Failed End Condition**      | User inputs incorrect words and tries again                                                                         |                                                                                                                       |
| **Primary, Secondary Actors** | User, application                                                                                                   |                                                                                                                       |
| **Trigger**                   | Bun go Barr Fill the blanks category exercise                                                                       |                                                                                                                       |
| **DESCRIPTION**               | **Step**                                                                                                            | **Action**                                                                                                            |
|                               | 1                                                                                                                   | In exercise categories user clicks fill the blanks                                                                    |
|                               | 2                                                                                                                   | User is presented with appropriate sentences with blanks                                                              |
|                               | 3                                                                                                                   | User fills in blanks with correct words from a pool of words with visuals, phonetics and pronunciation availabilities |
|                               | 4                                                                                                                   | Score is given                                                                                                        |
| **EXTENSIONS**                | **Step**                                                                                                            | **Branching Action**                                                                                                  |
|                               |                                                                                                                     | N/A                                                                                                                   |
| **VARIATIONS**                |                                                                                                                     | **Branching Action**                                                                                                  |
|                               |                                                                                                                     | User chooses Story category within Bun go Barr                                                                        |
| **USE CASE**                  | User chooses “Story” category exercise in Bun go Barr                                                               |                                                                                                                       |
| **Goal in Context**           | Get tutorials on all different categories of exercise as appropriate                                                |                                                                                                                       |
| **Scope & Level**             | Application, Bun go Barr.                                                                                           |                                                                                                                       |
| **Preconditions**             | Bun go Barr book selected                                                                                           |                                                                                                                       |
| **Success End Condition**     | Tutorials are given, user understands better, relevant exercise completed and score is given                        |                                                                                                                       |
| **Failed End Condition**      | User does not understand and replays tutorials                                                                      |                                                                                                                       |
| **Primary, Secondary Actors** | User, application                                                                                                   |                                                                                                                       |
| **Trigger**                   | Bun go Barr story category exercise                                                                                 |                                                                                                                       |
| **DESCRIPTION**               | **Step**                                                                                                            | **Action**                                                                                                            |
|                               | 1                                                                                                                   | In exercise categories user clicks “story”                                                                            |
|                               | 2                                                                                                                   | User selects which chapter tutorials needed                                                                           |
|                               | 3                                                                                                                   | Clicks the play button begin tutorials                                                                                |
|                               | 4                                                                                                                   | Replays or goes back to complete exercise under the relevant tutorial                                                 |
| **EXTENSIONS**                | **Step**                                                                                                            | **Branching Action**                                                                                                  |
|                               |                                                                                                                     | N/A                                                                                                                   |
| **VARIATIONS**                |                                                                                                                     | **Branching Action**                                                                                                  |
|                               |                                                                                                                     | User chooses spellings category within Bun go Barr                                                                    |
| **USE CASE**                  | User chooses to complete “Spellings” category exercise in Bun go Barr                                               |                                                                                                                       |
| **Goal in Context**           | Complete Spellings category exercise                                                                                |                                                                                                                       |
| **Scope & Level**             | Application, Bun go Barr.                                                                                           |                                                                                                                       |
| **Preconditions**             | Bun go Barr book selected                                                                                           |                                                                                                                       |
| **Success End Condition**     | User spells words correctly and scored                                                                              |                                                                                                                       |
| **Failed End Condition**      | User inputs incorrect words and have to re-spell words                                                              |                                                                                                                       |
| **Primary, Secondary Actors** | User, application                                                                                                   |                                                                                                                       |
| **Trigger**                   | Bun go Barr Spellings category exercise                                                                             |                                                                                                                       |
| **DESCRIPTION**               | **Step**                                                                                                            | **Action**                                                                                                            |
|                               | 1                                                                                                                   | In exercise categories user clicks “Spellings”                                                                        |
|                               | 2                                                                                                                   | User is presented with words spelt in wrong order to give the correct spellings                                       |
|                               | 3                                                                                                                   | User spells words correctly                                                                                           |
|                               | 4                                                                                                                   | Score is given                                                                                                        |
| **EXTENSIONS**                | **Step**                                                                                                            | **Branching Action**                                                                                                  |
|                               |                                                                                                                     | N/A                                                                                                                   |
| **VARIATIONS**                |                                                                                                                     | **Branching Action**                                                                                                  |
|                               |                                                                                                                     | N/A                                                                                                                   |

### **2.4 Constraints**


* **Android OS Version**

We need to design to target Android versions 4.2 upwards. This means our app
will be compatible with almost 90% of devices currently in use(as of November
7th 2016.).

* **RAM**

We will aim for our app to be optimised on devices with 2GB and upwards

* **Screen Size**

We will implement scalability in our app so it will run on as many screen
sizes as possible i.e. from phones to tablets

* **ROM**

We intend to store our data locally. This means we have to consider how
much storage the user has free on their device

*  **Internet Connection**

As we will be using data from abair.ie for our audio the app will require an
internet connection in order for the user to use this feature

* **Battery Life:**

Efficiency of data transmission must be ensured for batteries to last longer

# 3. Functional Requirements
#### **Download**

* Description:

This is where it all starts, during download users will get to know all the
system requirement specifications of the application and see if their device
qualifies or not. It is during this time that users also get to read the
description of the application

*  Criticality:

The app cannot be used without first downloading it and while downloading you
get all the necessary information about the app.

*  Technical Issues:

Internet connectivity is essential for this phase to be completed. It is also
necessary to make sure that the device in use is not in Airplane Mode and the
system requirements must be met otherwise the download would fail.

*  Dependencies:

N/A

#### **Pronunciations**

• Description

The app should be able to provide the user with audio pronunciations for any
Irish word they choose within the app.

• Criticality

This feature is essential for students using the app. Without this feature
they would be left to work out the correct pronunciation on their own which
could prove difficult.

• Technical Issues

We will be using audio from an external source(abair.ie) so we will have to
ensure the user has an internet connection to make use of this feature.

• Dependencies

N/A

#### **Feedback**

• Description

Users of the app should be able to give feedback about it. This could be a
review on the Play Store or an email to the developers e.g. a bug report

• Criticality

The app could function without this feature so it is nonessential. However
we feel it would be beneficial if we implemented it.

• Technical Issues

We will have to make sure the app has the correct permissions to access the
email functions of the phone

• Dependencies

#### **External resources**

• Description

The app will feature a section that contains links to external resources
associated with the Irish language e.g. videos, links to lessons for adults

• Criticality

This is not a critical feature of the app. However we feel the addition of
these resources would be useful for adults using the app.

• Technical Issues

As the links will not be under our control we will have to find resources
that are unlikely to change or be taken down

• Dependencies

N/A

#### **Translation**

• Description

The app should have the ability to translate words from Irish to English.
Users should easily be able to switch words between the 2 languages.

• Criticality

This is a critical feature of our app. It is a key feature for both children
and parents using the app, particularly those with little to no Irish

• Technical Issues

We will need a database of the translations and the translation will have to
be correct

• Dependencies

The translation feature relies on the text being implemented correctly in
the Bun go Barr/Ceartlitriu sections

#### **Choose Book Type**

• Description:

After download the user is presented with the home screen which has three
categories to choose from, two of which belong to the Book Type category namely
Bun go barr and Ceartlitriu. Users chooses their preferred book for homework
completion

• Criticality:

It is very important that users choose the correct book as the tasks / homework
differ in each book.

• Technical Issues:

N/A

• Dependencies:

This requirement is dependent on whether or not the application was successfully
downloaded.

#### **Homework - Word Search**

• Description:

This is a category of homework in both books (Bun go barr and Ceartlitriu), upon
clicking on this category a grid is drawn, words to be searched for are listed
and user is required to click on the letters in the grid to match the relevant words
they are suppose to search for.

• Criticality:

This function is essential as it is part of the academic homework structure of
primary school Irish homework

• Technical Issues:

Internet connectivity is essential as the audio and pronunciations data is from
an external source

• Dependencies:

Relevant book type must first be selected.

#### **Homework - Fill the Blanks**

• Description:

In this category there are sentences with blanks to be filled out, user fills
out the blanks by selecting the correct word from a list of words.

• Criticality:

It is essential in the sense that it is a category of homework

• Technical Issues:

Internet connectivity is essential as the audio and pronunciations data is from
an external source

• Dependencies:

Relevant book type must first be selected.

#### **Homework -Story**

• Description:

Stories section of either of the books can be found here. This serves as a form
of tutorials section to render help before completion of homework.

• Criticality:

This is not essential as the kids must have first read the story in the hard
copy version or teacher must have narrated the story in class

• Technical Issues:

N/A

• Dependencies:

Relevant book type must first be selected.

#### **Homework - Spellings**

• Description:

There is a list of words, each word has been spelt in the wrong order and needs
to be rearranged in the right order.

• Criticality:

This part is essential due to the fact that it is an exercise to be completed.

• Technical Issues:

N/A

• Dependencies:

Relevant book type must first be selected.


# 4. System Architecture 


Figure 1 shows the architectural layout of the app

![image](http://i.imgur.com/8xXjyrK.jpg)
##### Figure 1

# 5. High Level Design


**5.1** The following data flow diagram(DFD) shows where the data needed for our
app to function will be coming from.
![image](http://i.imgur.com/3TTKutf.jpg )
##### Figure 2

**5.2** The following diagram illustrates the potential layout of the classes in
our application
![image](http://i.imgur.com/oWkmISH.jpg)
##### Figure 3

# 6. Preliminary Schedule


We have outlined our preliminary schedule in the PERT diagram seen below in
figure 4.
![image](http://i.imgur.com/WFWGqSh.jpg)
##### Figure 4


# 7. Appendices


#### **Sources**

-   <https://developer.android.com/about/dashboards/index.html>

#### **Resources**

-   <https://developer.android.com/studio/index.html>

-   <https://sqlite.org/https://sqlite.org/>

-   <http://www.abair.tcd.ie/?lang=eng>

-   <https://www.visualstudio.com>

-   <https://www.visual-paradigm.com/>
