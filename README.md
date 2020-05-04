# Music Launcher Android

![Picture](app/src/main/res/mipmap-hdpi/ic_launcher_foreground.png)

Project for re-purposing your old mobile phone in to a mp3 player via a launcher. No ROOT privileges required.

[For Demo Visit here](https://youtu.be/ik7YlZy_g8U)

## Problem Statement

The agenda was to re-purpose an old android phone into a MP3/MP4 player. Went through a lot of articles about turning a phone into a standalone music player but all they talked about was installing the apps, radio blah blah blah. I found some where one needs to root the device and execute a lot of CLI commands, flash the OS etc . Very tedious.

Then this idea dawned on me. I created a custom launcher to open my music app on startup and that's exactly what I wanted. I use YouTube Music and that serves in-app video as well. Disabled the lock screen and there you go, the phone always is in the music mode. You can do the same for any app if your requirements are same as mine. make it completely offline if you want. The phone's WiFi allows me to download the songs into phone's storage and keep them for offline use.

Now I have a WiFi enabled MP3/MP4 player with headphone jack.

## Steps to Run

- Download the project.
- Build the code.
- Check if there any bugs. Mostly it will be related to sdk downloads.
- This project targets for KitKat and above.
- Go to app/src/main/res/values/strings.xml.
- Change property target_app's value to your music app's package name. You can get the the package name from Google Play Store. It will be in URL.
- Build and Run.
- In your device set the default launcher to 'Music Launcher' and there you go. All set.


Enjoy!!