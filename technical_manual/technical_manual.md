# Languages Made Simple(formerly Irish Made Simple)
##### Jesse Balfe, Victoria Crabbe

##### CA326 Project
 
###### Technical Manual

# Table of contents

- [1: Introduction](#1-introduction)
    + [**1.1 Overview**](#--11-overview--)
    + [**1.2 Glossary**](#--12-glossary--)
- [2. System Architecture](#2-system-architecture)
    
- [3. High Level Design](#3-high-level-design)
    
- [4. Problems & Resolutions](#4-problems-&-resolutions)

- [5. Installation Guide](#5-installation-guide)

- [6. Emulator](#5-emulator) 




# 1: Introduction 


### **1.1 Overview**
Languages Made Simple is an Android application developed to create exercises 
from whatever language the user decides to use. The app extracts verbs from
sentences to create "fill in the blank" style exercises which can be completed
within the application. These can be created from text files the user has on 
their phone or through typing the input manually. This flexible approach means
it is not limited to just Irish as our original functional spec proposed. Based
on feedback we received on the proposal we improved the intelligence of the app
so it was no longer a digital version of a primary school text book. The pattern
matching used means it can also be reused for prepositions. The app has been
tested with Irish and the Ghanaian language Ga. The app could be especially
useful for endangered languages which don't have a lot tools specifically to
cater for them.




### **1.2 Glossary**

* Firebase:
Firebase is a web platform with tools and infrastructure for online user 
authentication


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

* XML:
XML(eXtensible Markup Language) is a markup language used to define the format
of a page to be human-readable and machine-readable.

* APK:
Android application package (APK) is the file format used by the Android
operating system for distribution and installation of apps.

# 2. System Architecture

![System Architecture](http://i.imgur.com/Equ4qTP.jpg)


* **Android OS Version**

our design is targeted at Android versions 5.1 upward to 7.1. This means our app
will be compatible with almost 66% of devices currently in use (as of March 6th 2017)

* **RAM**

The app has been tested on devices ranging from 512MB to 6GB of RAM. 

* **Screen Size**

We have used scalable XML which means our app should display correctly on as 
many screen sizes as possible. 

* **ROM**

The app is small(<3mb) so should not be too large for any user to install.

*  **Internet Connection**

An internet connection is required in order for users to register and log in to
the application



# 3. High Level Design

#### **Entity Relationship Diagram**

![Entity Relationship Diagram](http://i.imgur.com/uhnfJ5g.jpg)


#### **Data Flow Diagram**

![Data Flow Diagram](http://i.imgur.com/XI4W2MW.jpg)




# 4. Problems & Resolutions

* **Android Development**
We originally underestimated the amount of time we would need to get a grip on
developing Android applications. We had set aside 3 weeks in our preliminary
schedule to for learning to develop with Android Studio. In reality it took much
longer and it felt as if we were learning constantly as we worked through the
app.

* **File Loading**
The first working version of the app only took in verbs and sentences that the 
user typed in on the Android device. Our project supervisor wanted to have the 
ability to load these from a txt file typed elsewhere and downloaded onto the 
device. We had issues with the app being unable to locate the txt file on the 
device. We discovered that the external storage location was different on each 
device and not always located at /sdcard. We changed from a hardcoded directory
to one that checked the external storage directory for the phone it was currently
installed on.

* **Dealing with Changes**
The app went through a large number of changes from the concept stage to the current
product. It was difficult at times to put our finger on exactly what we wanted
the finshed product to do. Once we settled on what the exact layout of the app was
going to be it became much easier to plan out and code. Going forward we will spend
more time at the beginning setting out exactly what the end goal of a project is
to save time making changes later on in the development process.




# 5. Installation Guide

#### **Requirements**

* A phone or tablet device running on Android

* An internet connection

#### **Getting Ready to Install**
The app is currently not published on the Google Play Store so there are a couple
of extra steps needed to install the app. By default Android only allows apps to
be installed from the Play Store. A potential user has to enable "Unknown Sources"
in the settings. As shown in the screenshots go to settings and then click Security.
Scroll until you see "Unknown Sources." Click this and you will be prompted to 
check if you want to enable apps from outside of the Play Store. Click okay and 
you will now be able to install Languages Made Simple.
##### Security 
![image](http://i.imgur.com/xp1px6V.jpg) 
##### Unknown Sources
![image](http://i.imgur.com/igsfnFv.jpg)



#### **Installing the App**
The apk can currently be found a shared Google Drive folder. This link can be 
found at the bottom of this technical manual. Click the link and you will be 
brought to a folder containing "LanguagesMadeSimple.apk". If you are on your 
Android device you can download the apk straight to your phone. When the 
download is finished click the file and you will be prompted to install the app.
Currently no special permissions are needed. If this changes you will be shown 
these and asked to allow them. If you download the file on a computer you will 
need to connect your Android device to the computer and copying the apk onto the 
phone. Locate the file on the device and continue as if it was downloaded directly
onto the device.

If a teacher wanted to project the app onto the board they could use an Android
emulator on their PC. Bluestacks is one option for Android emulation and it is 
compatible with Windows, Mac and Linux. A link to install this is included below.

 
# 6. Emulator
for the purposes of using this App for demonsration the emulator can be used. Firstly android studio must be installed, in android studio
start the SDK Manager and click tools menu, select Manage AVDs, while in android virtual device manager select the emulator, click start.
The emulator will start up (with all the normal features of an android phone).


#### **Links**

-   <https://drive.google.com/open?id=0ByGvNLARrqvcTXpGTVg3eHdpR2M>

-   <http://www.bluestacks.com/about-us/app-player.html>