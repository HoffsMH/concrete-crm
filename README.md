# concrete-crm

- at the very least we can be sure that everything is a form right?

- why do namespaces typically begin with `org.`?


- the name for the type of data structure that `'hello-world` evaluates to is "symbol"

- but the name for the type of data structure that `'(hello-world)` evaluates to is "list"? in this case a list with a symbol in it

- The mechanism at play in both is "quoting"

- putting a symbol down on a .clj file results in evaluation of that symbol which starts a symbol resolution
  - symbol -> variable (Example #'symbol) -> value
  - why is the middle phase needed?


### I Have it serving some Text!
- but why does all the stuff I learned from https://www.braveclojure.com/organization/#Anchor
not seem to matter. In the end I had to use `(:use org.httpkit.server)` within the `ns` in order to get access to `run-server`
  - for instance`(use org.httpkit.server)` didn't work!

  - JK forgot to quote the symbol :D looks like quoted outside of ns macro, unquoted otherwise

- how could this basically empty app be tested? not sure how to test `run-server`

- soo use is a combination of require and refer?
Looks like yes.

- Why underscores for file names?
Can't seem to find an answer on why instead of dashes since everything else seems to be dashes

### Lets get some routes

- Compojure
- what is this `Ring` thing
- Ah its like `Rack` or  Elixir/Erlang `Plug`
  which means that Im probably already using it under http-server? Is there a way to see a projects dependency tree?

https://stackoverflow.com/questions/33093833/display-complete-dependency-tree-with-leiningen
yes but it requires maven


```clj
(:require [compojure.core :refer :all]
            [compojure.route :as route])
(defroutes app
  (GET "/" [] "<h1>Hello World</h1>")
  (route/not-found "<h1>Page not found</h1>"))
```


- Can I test the function produced with `defroutes`?
Yup made one! :D

- what about linting? It feels like im writing these things wrong
https://tonsky.me/blog/clojurefmt/

- is def affected by lexical scoping?
I *THINK* so...

- Can I `def` in another list?
looks like the answer is yes but are there other rules around it?

### Handlers

- lets see if I can greet a specific user?
  yup. looks like we can render html as well lets refine that

- how is db interaction handled?

migrations and database interaction appear to be separate in this ecosystem

- installed this https://github.com/mmcgrana/clj-stacktrace
hopefully that helps with the stack traces some

- learning how to read auto-doc signature.
The view source button is nice

http://weavejester.github.io/hiccup/hiccup.form.html

which let me get to

```clj
  (html [:p
         (form-to [:POST "/numbers"])
         ]))

```


https://github.com/weavejester/compojure/wiki/Destructuring-Syntax

cant get form params out of this
https://stackoverflow.com/questions/27891597/clojure-hiccup-how-can-i-know-which-submit-button-got-pressed-in-a-form
doesn't seem to help either :(
