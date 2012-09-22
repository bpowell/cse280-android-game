#Android Source#

##Set up##
###Eclipse###
Import the project into Eclipse. You can do this by going to File->Import. Then choose Android->Existing Android Code Into Workspace. Then select the location of the Android source. After that click Finish and you are all set.

###Command Line###
Create a file local.properties. The contents of the file shoudl be:

sdk.dir=/path/to/android-sdk

##Compile and deploy##
###Eclipse###
Open up the project in Eclipse and then go to Run->Debug or press the <F11> key. This will compile and run the app.

###Command Line###
Go to the root directory of the application. To compile the application:

ant debug
To compile and install the application to device:

ant debug install
To compile, install, and run the application:

ant debug install run
