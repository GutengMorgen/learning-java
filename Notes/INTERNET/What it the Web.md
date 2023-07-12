*From Thinking in Java*

## Client/server computing
A key to the client/server concept is that the repository of information is centrally located so that it can be changed and so that those changes will propagate out to the information consumers.

In addition, systems often allow a client to insert new information into a server. This means you must ensure that one client’s new data doesn’t walk over another client’s new data, or that data isn’t lost in the process of adding it to the database (this is called **transaction processing**).

To minimize latency, programmers work hard to offload processing tasks, often to the client machine, but sometimes to other machines at the server site, using so-called middleware. (**Middleware** is also used to improve maintainability.)

## The Web as a giant server
The Web is actually one giant client/server system. It’s a bit worse than that, since you have all the servers and clients coexisting on a single network at once.

### Web browser
The Web browser was a big step forward: the concept that one piece of information can be displayed on any type of computer without change. However, the original browsers were still rather primitive and rapidly bogged down by the demands placed on them. They weren’t particularly interactive, and tended to clog up both the server and the Internet because whenever you needed to do something that required programming you had to send information back to the server to be processed. It could take many seconds or minutes to find out you had misspelled something in your request. Since the browser was just a viewer it couldn’t perform even the simplest computing tasks. (On the other hand, it was safe, because it couldn’t execute any programs on your local machine that might contain bugs or viruses.)

## Client-side programming
The server produced static pages for the client browser, which would simply interpret and display them. Basic HyperText Markup Language (HTML) contains simple mechanisms for data gathering: text-entry boxes, check boxes, radio boxes, lists and dropdown lists, as well as a button that could only be programmed to reset the data on the form or “submit” the data on the form back to the server.

This submission passes through the **Common Gateway Interface** (CGI) provided on all Web servers. The text within the submission tells CGI what to do with it. The most common action is to run a program located on the server in a directory that’s typically called “cgi-bin.” (If you watch the address window at the top of your browser when you push a button on a Web page, you can sometimes see “cgi-bin” within all the gobbledygook there.)
However, Web sites built on CGI programs can rapidly become overly complicated to maintain, and there is also the problem of response time.

### Scripting language
Scripting languages tend to be reasonably easy to understand and, because they are simply text that is part of an HTML page, they load very quickly as part of the single server hit required to procure that page.

## Server-side programming
What happens when you make a request of a server? Most of the time the request is simply “Send me this file.” Your browser then interprets the file in some appropriate fashion: as an HTML page, a graphic image, a Java applet, a script program, etc.




