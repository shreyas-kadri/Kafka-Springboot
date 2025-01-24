This is a simple project which demonstrates the use of apache kafka which is a message broker.
The producer has an /orderPlaced api which sends information regarding a customer order to the kafka broker under the topic 
named as Order-Placed.
The consumer then consumes the message sent to that topic,it retrieves the information of the order,calculates the total bill
and sends an email to the customer stating their order id and total bill.