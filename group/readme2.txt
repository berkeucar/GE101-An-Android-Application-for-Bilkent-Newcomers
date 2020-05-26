Project Group Number: g3A

Group Name: The Scheming Quixotics

Project Name: GE101

Project Description: GE101 is a mobile application where you can go around Bilkent’s main campus and learn about the layout of the buildings. 
The app will also present the locations of all the cafeterias, labs, places to study and the bus schedules since there is no detailed information for any of these on the internet. 
Our app will combine all of these together in one place to save the students the hassle of finding all of these from different places.

Current Status: The app is working but can be improved upon by anyone since we left the code
appropriate to be built on. We have implemented the map, added custom labels for easy usage and
also a search bar for finding the locations of every building in the Bilkent Campus. We restricted
the map to only Bilkent Campus so it can only be used inside Bilkent. We added an eating places menu
so users can easily find places to eat in Bilkent and we added the bus schedule as well. All of these
work without any problems. We wanted to add directions so users could see a path to the building they want
to go to but we decided not to implement Google's directions API for this purpose because while Google maps
is accurate in normal roads, it wasn't very accurate inside Bilkent Campus and didn't display the paths correctly
so we thought it would be useless. We would like to implement it ourselves but couldn't think of a way to do so.


Group Members and what they worked on:

Efe Beydoğan: MainActivity, MainScreen, SplashScreen, SettingsScreen classes, customlabels package, custommarkers package, locations package

Arda Önal: MainActivity, SettingsScreen classes, custommarkers package, customlabels package, locations package

Berke Uçar: MainActivity class, SettingsScreen class, eatingplaces package, locations package, customlabels package

Mert Barkın Er: MainActivity class, customlabels package, busschedule package, locations package

Mehmet Alper Çetin: MainActivity class, achievements package and its implementation, customlabels package, locations package


Details of everything we used:

Software:
Android Studio version 3.6.3

Libraries:
androidx.appcompat:appcompat:1.1.0
androidx.constraintlayout:constraintlayout:1.1.3
com.google.android.gms:play-services-maps:17.0.0
com.google.android.gms:play-services-games:19.0.0
com.google.android.gms:play-services-location:15.0.1
com.google.android.material:material:1.1.0
androidx.navigation:navigation-fragment:2.2.2
androidx.navigation:navigation-ui:2.2.2
gr.pantrif:easy-android-splash-screen:0.0.1
androidx.lifecycle:lifecycle-extensions:2.2.0
androidx.legacy:legacy-support-v4:1.0.0

Instructions for using the app:
After downloading the zip file, open the project on Android Studio and then run it on the emulator on your PC
or you may connect your own Android device to your computer and run the app on that device as well.

Here is a guide to using the emulator on Android Studio: https://developer.android.com/studio/run/emulator

Here is a guide to using your own device as an emulator: https://developer.android.com/training/basics/firstapp/running-app







