# concrete-crm

at the very least we can be sure that everything is a form right?

why do namespaces typically begin with `org.`?


the name for the type of data structure that `'hello-world` evaluates to is "symbol"
`'map`

but the name for the type of data structure that `'(hello-world)` evaluates to is "list"? in this case a list with a symbol in it

The mechanism at play in both is "quoting"

putting a symbol down on a .clj file results in
evaluation of that symbol which starts a  symbol resolution

symbol -> variable (Example #'symbol) -> value

why is the middle phase needed?


### I Have it serving some Text!
but why does all the stuff I learned from https://www.braveclojure.com/organization/#Anchor
not seem to matter. In the end I had to use `(:use org.httpkit.server)` within the `ns` in order to get access to `run-server`

`(use org.httpkit.server)` didn't work!

JK forgot to quote the symbol :D
looks like quoted outside of ns macro, unquoted otherwise

how could this basically empty app be tested?

soo use is a combination of  require and refer

Why underscores for file names?

### Lets get some routes

- Compojure
- what is this `Ring` thing
- Ah its like `Rack` or  Elixir/Erlang `Plug`
  which means that Im probably already using it under http-server? Is there a way to see a projects dependency tree?

```clj
(:require [compojure.core :refer :all]
            [compojure.route :as route])
(defroutes app
  (GET "/" [] "<h1>Hello World</h1>")
  (route/not-found "<h1>Page not found</h1>"))
```


can I test the function produced with `defroutes`?
what about linting? It feels like im writing these things wrong

is def affected by lexical scoping?
Can I `def` in another list?

### Handlers
