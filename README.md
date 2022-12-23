# My Fitness
**My Fintness** is an application done as a part of term project for *Moblie Applications* course
## Raneem
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
