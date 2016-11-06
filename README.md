# snapshots

This Repository is made of different projects that were developed in different times with various objectives and scopes.

# whackamole 
Project to test system concurrency and hard restrictions (Using Java, LTS, Swing Library)
# vps
Test implementation of a Service Oriented Architecure System to sell and buy vehicles. (Using Java, XML, SOAP, Axis2, BPEL, WSDL)

# whackamole
Project to test concurrency in Java. 

The logical part is described in the Labelled Transition System language (https://en.wikipedia.org/wiki/Transition_system )
The code is written in java.

It is a simulation of a game in which a user and some "enemies" need to access a road. Part of the road is shared and they are accessing it concurrently. Some constraints must be put in place to avoid a clash.

The application is developed as Java applaet has some logic and a simple graphical interface to show the activities. 

Three versions are available :

JavaCode_text contains a fully text version.

JavaCode_withUI that contains the src code of the graphical version


# vps

Test implementation of a Service Oriented Architecure System to sell and buy vehicles. Using, Java, SOAP, XML, Axis2, BPEL, WSDL.

The project is written in Java and and all the services are mock implemented.
There is a main library “CommonLibrary” that is copied and imported by all the services.
(Code repeated and test outputs added for non-technical reasons).

It contains the definition of four classes : Vehicle, SearchResults, Loan and LoanResults. They, all, are serializable POJOs that provide a consistent representation maintaining the independence of the services.

Services I have created mock services with realistic signatures but providing static or random data as output. They all support multiple users and provide personalised data for each specific user (each user can save its own Vehicles Searches or its own Loans). The user is identified via a String parameter that is supplied at each method call. When needed, the services return boolean values, as status of operations, that are parsed in the client. 
VSERS – shows the search capabilities; provided with a Vehicle and a user, it returns 4 pseudo-random search results 
VSTOS – stores searches results or single vehicles for a specific user and allows this user to get or delete its searches. LBROS –This service accepts as input a Vehicle, a user and his age and provides four possible Loans with a number of months and a monthly wage depending on the value of the car. 
LAPPS – stores search results or single Loans and files a Loan application verifying the output of the Card Payment Service, if the payment is successful, it stores the application and the username. 
VOMS - allows a user to submit the offer for a vehicle, it accepts and stores the offer IF the offer is greater than the 80% of the price of the Vehicle and if nobody has made an offer for that Vehicle. CPAYS – I have used an external service (http://www.webservicex.net/New/Home/ServiceDetail/14 )
that verifies the type and the number of a specific credit card. 
