# TCP
## Overview
A socket server and a client built in java TCP socket.

## Requirement
You need to develop a socket server which will listen for messages, and client which can send socket messages.
The communication has to be on HEX format not plain text.

For example
If a client wants to say 'HELLO', it should send in this format -> 'MESSAGE:5:HELLO:END' and convert this to HEX format which will look something like this '4d4553534147453a353a48454c4c4f3a454e44'. The other client who is going to recieve this message should decode this message and display 'HELLO' on the screen.

## Data Format
&lt;type&gt;:&lt;length&gt;:&lt;data&gt;:END

**type** is always `MESSAGE`

**length** is the size of data. from the example 'MESSAGE:5:HELLO:END' 5 is the string length of 'HELLO'

**data** string text of message

**:END** represents end of packet. (useless but worth to mention)


### Following diagram visualizes the same.

<img style="width: 80%" src="https://raw.githubusercontent.com/zoroute/test-tcp/master/Untitled%20Diagram.png" />
