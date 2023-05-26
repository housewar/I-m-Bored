# I'm Bored App
The **I'm Bored** app is a toy app that displays things to do when you are bored.

The purpose of the app is to test ways of adapting to various screen sizes without abandoning the NavHost Controller.

In Portrait Mode:
+ The app navigates forward and backward from the first to last screen as expected.

In Landscape Mode:
+ The first screen always displays the next screen.
+ The last screen always displays the prior screen.
+ Middle screens can either show the next screen or the prior screen.
+ Whether to show the next/prior screen is determined by whether the user is navigating forward or backward.
+ Forward/Backward navigation is determined by tracking the last screen.

I'm relatively happy with the end result.
I'm sure there are other/better ways of implementing this sort of view, but this app was created with specific targets in mind, which I feel were met.