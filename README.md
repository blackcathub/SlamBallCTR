# SlamBallCTR
>`PROJECT 3` for Googles Udacity Android Developement Course

The 3rd project for Android Development Course was an app that can keep score for 2 teams during a match in a sport of choice. Requirements for the app specified that it should have separate counters and point buttons for each team as well as a Reset button to set counters back on 0 points. I chose SlamBall as the sport my app would keep scores for. In SlamBall a player can score 2 points when the ball is thrown and goes through the basket, 3 points when it's throw from behind the 3point line or also 3 points when a player jump and put it directly into the basket - this is called a slam.
----------------------------
* **_DESIGN IDEA_**

In my app the user can keep track of current points for each team and also number of slams each team has made through the game. The app uses custom made graphics to make it more colourful and add a bit of SlamBall spirit to the looks. The main area of the screen is divided into 2 sides representing each team and has a reset button placed on the bottom. Each button has an image along with the text so a user who forgets the order of them and doesn't want to miss anything during the game reading labels can quickly cach which button does what. Buttons also received shadows and animations so they look like real buttons not just still images.

* **_USER EXPERIENCE_**

I mainly focused on user experience what led to a few improvements making the app even more user friendly. The whole design is concentrated on left and right edge of the screen mirroring objects along the center line to improve the feel of 2 columns being separated. Because the app was hard to use in landscape mode I made a separate layout for it putting the score displays close to the center and buttons far on the sides. Now user can keep the phone in both hands and operate the app using thumbs - left thumb to track Team A and right for Team B. This proved to be the most comfortable way of using my score keeper. 

* **_DATA LOSS PREVENTION_**

Also since you don't want to loose your scores by accidently pressing [RESET] in the middle of the game I made the reset button call a separate screen layer where user can select to keep the scores or confirm he wanted to reset them. In case this happened by accident and the user surprised by something covering the whole screen pressed the "return" arrow on the phone I intercepted the press and made it exit the reset screen not the whole app. On top of that Save/RestoreInstanceState method was used to keep the displayed data while changing orientation and prevent accidental data loss.

