# My Fitness
**My Fintness** is an application done as a part of term project for *Moblie Applications* course
## Raneem
1. Setup some configurations in the App
  -Icon app
  -Prevent changing orientation from the manifest
  -Create bottom navigation with three fragments{home,physical, and mental}
    
 2. Mental Fragment
  That contains a liner recycler view, that contains cards representing some mental games with click response
    - Calculation Activity
         Contains a text view that represents a randomly generated equation with a horizontal progress bar to consume the time, and two buttons will show the result            status, after the time is finished the equation will be removed to make the game much harder.
   
   - Difference Activity 
          This Activity contains an image that represents two images for computing the number of differences between them, an edit text for enetring the number of                 difference,  and a submit button to check if the enter answer is true or not by showing the image with determine the differences.
    - Puzzle Activity
           It will add soon, now it just contains a gif image

## Salsabeel
1.	splash screen:
I used three gif images and applied some Animations on them.
2.	Sign up screen:
The sign-up screen has the fields (email, password, name, gender, age, height, weight, target Weight). User must enter valid values for them. After data verification data will be saved locally using shared preferences. This is because these data will be used in some calculations like the BMI index. If non-valid data was entered then a toast message will be shown to help user detect the problem
3.	Log in screen
User need to enter its email and password to log-in the app, if no account has this Registration information before, then a toast message appears to show that this is not valid account and you need to sign up in order to enter the app.
In the first we successfully log-in app the current state will be updated in the shared preferences to be logged-in and in the next log-in time current Registration email and password will be automatically put in the input fields.
## Dana
1. Physical Exercises Activites
    - Fragment that contains a recycler view, that contains cards represinting exersices
    - Each card lead to its exersice activity when clicking on it
      - Contains the activiy GIF, timer, and its steps
2. Home
    - Fragment that contains a constaint layout, that some general user info
      - BMI index
      - Circular progress bar to show user progress
