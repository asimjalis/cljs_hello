# Hello

ClojureScript hello world project with browser REPL.

## Goals

The goals of this project are:

- Set up a simple ClojureScript program 
- Compile it to JavaScript and consume it in HTML
- Have minimal dependencies (no dependencies on `ring` for example)
- Set up a browser REPL so that you can experience live code editing

## Steps

To get this project up and running on your machine, follow these
steps. You should be to copy and paste this directly into your
shell.

    # Grab lein.
    mkdir -p $HOME/bin ; cd $HOME/bin
    curl -L 'http://github.com/technomancy/leiningen/raw/stable/bin/lein' > lein
    chmod 755 lein

    # Grab this project.
    mkdir -p $HOME/git/cljs_hello
    cd $HOME/git/cljs_hello
    git clone https://github.com/asimjalis/cljs_hello.git

    # Compile it.
    lein cljsbuild once

    # Start incognito browser.
    ( sleep 20 ; \
      echo Starting browser ; \
      /Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome --incognito \
        http://localhost:9000/cljs_hello.html ) &

    # Start REPL.
    RLWRAP=$(which rlwrap)
    if test "$RLWRAP" ; then 
      RLWRAP="$RLWRAP --histsize 5000000 --logfile $HOME/tmp/cljs.log"
    fi
    $RLWRAP lein trampoline cljsbuild repl-listen

To test that the ClojureScript program is running in the browser,
click the button *Test* in the incognito browser. This should
produce the message *Hello world from ClojureScript!*. 

To test that you can talk to the browser from the ClojureScript
REPL, in the ClojureScript REPL type `(js/alert "Hello!!")`. This
should pop an alert box on your web page.

Congratulations! You can now begin live coding against the browser
in your ClojureScript REPL.

## License

Copyright (c) 2014 Asim Jalis

[Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).

## Author

Asim Jalis    
[email](mailto:asimjalis@gmail.com)    
[website](http://asimjalis.com)    
[twitter](http://twitter.com/asimjalis)    
[linkedin](http://linkedin.com/in/asimjalis)    
