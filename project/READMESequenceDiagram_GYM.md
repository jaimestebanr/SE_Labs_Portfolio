This sequence diagram represents the interaction flow of a Gym Management System during the class booking process.

The diagram shows how the member first logs into the system, then views the available classes, and finally sends a booking request through the web interface. The request is processed by the booking controller, which coordinates the validation of the member’s membership status and the availability of slots in the selected class.

If the membership is active and places are available, the system creates the booking in the database and sends a confirmation through the notification service. If the membership is inactive or the class is full, the booking is rejected and the user is informed accordingly.

Overall, the diagram illustrates the sequence of messages exchanged between the actor and the system components in order to complete or reject a class booking.