 Android Intent Demonstration Application
 
AIM
This Android application serves as a practical demonstration of using both Implicit and Explicit Intents to perform various common actions and navigate between activities. The application showcases the following functionalities:

Make a Call: Initiate a phone call to a user-specified number.
Open URL: Launch a web browser to display a user-specified URL.
Open Call Log: Display the device's call history.
Open Gallery: Allow the user to view images using a gallery application.
Set Alarm: Open the device's alarm clock application to set a new alarm (or show existing alarms).
Open Camera: Launch the device's camera application to capture an image.
Open Login Activity: Navigate to a dedicated LoginActivity within the application.
Core Concepts Demonstrated (Study Points)
This project explores and utilizes several fundamental Android concepts:

Intent: An Intent is a messaging object used to request an action from another app component. It can be used to start activities, services, and deliver broadcasts.
Types of Intent:
Explicit Intent: Specifies the component to start by name (e.g., LoginActivity::class.java). Typically used for starting components within your own application.
Implicit Intent: Does not specify a component name but instead declares a general action to perform, which allows a component from another app to handle it (e.g., opening a URL, making a call).
Types of Intent Action: Predefined constants that specify the generic action to perform (e.g., Intent.ACTION_VIEW, Intent.ACTION_DIAL, MediaStore.ACTION_IMAGE_CAPTURE, AlarmClock.ACTION_SET_ALARM).
Intent.setData() method: Sets the data this intent is operating on, in the form of a Uri. For example, a tel: URI for dialing or an http: URI for web pages.
Intent.setType() method: Sets an explicit MIME type of the intent's data. This is often used with ACTION_VIEW to specify the kind of data to be viewed (e.g., image/*, CallLog.Calls.CONTENT_TYPE).
UI Components:
Button: Standard UI widget to trigger actions when clicked.
EditText: UI widget for user text input (e.g., for URL or phone number).
ConstraintLayout: A flexible layout manager that allows you to create complex UIs with a flat view hierarchy by defining constraints between views.
CoordinatorLayout: A powerful FrameLayout that provides an additional level of control over touch events between child views, often used for interactions with components like AppBarLayout and FloatingActionButton. (Used in some provided XML, though the core MainActivity might primarily use ConstraintLayout).
Starting Activities:
startActivity(intent): Launches an activity. The system resolves the intent to an activity and starts it.
Handling Missing Apps for Implicit Intents:
Using try-catch (ActivityNotFoundException) or intent.resolveActivity(packageManager) to gracefully handle cases where no application on the device can fulfill an implicit intent, preventing crashes and providing user feedback (e.g., via Toast messages).
URI Parsing:
Uri.parse(): Converts a string representation of a URI into a Uri object, which is necessary for Intent.setData().
Content Types:
CallLog.Calls.CONTENT_TYPE: The MIME type for call log entries.
"image/*": A common MIME type pattern to indicate any kind of image data.
"tel:": The URI scheme used for telephone numbers.
Permissions (Conceptual):
While not explicitly shown in the current MainActivity for all actions (as many common intents delegate permission handling to the target app), the study points include:
Permission in Manifest: Declaring necessary permissions (e.g., <uses-permission android:name="android.permission.CALL_PHONE" /> for direct calls, though ACTION_DIAL doesn't require it).
Runtime Permissions: For Android 6.0 (API level 23) and higher, certain dangerous permissions need to be requested at runtime.
ContextCompat.checkSelfPermission(): Checks if your app has been granted a particular permission.
ActivityCompat.requestPermissions(): Requests permissions from the user.
Note: For the intents used in this project (like ACTION_DIAL, ACTION_VIEW for web/gallery, ACTION_IMAGE_CAPTURE, ACTION_SET_ALARM), the app itself usually doesn't need to request runtime permissions directly, as these actions typically launch other apps that handle their own permissions.
Project Structure
MainActivity.kt: The main screen of the application, containing buttons to trigger various implicit and explicit intents.
LoginActivity.kt: A separate activity demonstrating an explicit intent target.
RegisterActivity.kt: Another activity, likely part of a login/registration flow, demonstrating navigation.
res/layout/activity_main.xml: Layout file for MainActivity.
res/layout/activity_login.xml: Layout file for LoginActivity.
res/layout/activity_register.xml: Layout file for RegisterActivity.
AndroidManifest.xml: Contains declarations for activities and potentially required permissions

Demonstration Screenshots
1.Main Screen
This is the central hub of the app, showing the various actions you can perform.

![image alt](https://github.com/syam2006/MAD_23012531070_PRACTICAL3/blob/13d96a855560363059b2ef916b5182658f9b1b22/Screenshot%202025-11-26%20202606.png)

2.Opening a URL
Entering a URL and clicking "Browse" uses an Implicit Intent to open a web browser.

![image alt]()

3.Making a Phone Call
Entering a phone number and clicking "Call" uses an Implicit Intent to launch the dialer.

![image alt]()

4.Opening the Gallery
Tapping "Gallery" uses an Implicit Intent to open the device's gallery app.

![image alt]()

5.Launching the Camera
Tapping "Camera" uses an Implicit Intent to open the device's camera application.

![image alt]()

6.Setting an Alarm
The "Alarm" button uses an Implicit Intent to launch the device's alarm clock app.

![image alt]()

7.Navigating to Login & Registration
The "Login" button triggers an Explicit Intent to open the LoginActivity within the app.

![image alt]()

The LoginActivity then provides an option to navigate to the RegisterActivity.

![image alt]()

Learning Outcomes
By studying and running this application, one can gain a better understanding of:

The fundamental differences between explicit and implicit intents.
How to construct intents with actions, data (URIs), and types.
Launching system apps and other apps to perform common tasks.
Navigating between different activities within the same application.
Basic UI creation with layouts, buttons, and text fields.
The importance of handling cases where no app can satisfy an implicit intent.
This project serves as a foundational example for more complex inter-component communication in Android development.

