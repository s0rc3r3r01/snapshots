# snapshots

This Repository is made of different projects that were developed at different times with various objectives and scopes.

# whackamole
Project to test concurrency in Java. 

The logical part is described in the Labelled Transition System language (https://en.wikipedia.org/wiki/Transition_system )
The code is written in java.

It is a simulation of a game in which a user and some "enemies" need to access a road. Part of the road is shared and they are accessing it concurrently. Some constraints must be put in place to avoid a clash.

The application is developed as Java applaet has some logic and a simple graphical interface to show the activities. 

Three versions are available :

JavaCode_text contains a fully text version.

JavaCode_withUI that contains the src code of the graphical version
