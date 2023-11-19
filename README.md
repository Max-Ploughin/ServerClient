# Client-Server
___
The client, upon initiation, establishes a single connection with the server and begins sending "ping" messages. The client prints a notification when a message is sent and reports the reception of a "pong" response. Clients persistently send "ping" messages every second, irrespective of whether responses are received or not. The server is designed to concurrently handle multiple clients.

If an error occurs on the client side, the client displays an error message and terminates.

It's noteworthy that the implementation avoids the use of high-level server frameworks, such as J2EE, Spring, Express, etc. 

Additionally, server-side error logging functionality has been implemented, recording errors to a dedicated text file.