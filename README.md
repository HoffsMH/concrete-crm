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
