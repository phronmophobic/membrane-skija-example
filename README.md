# membrane-skija-example

Example of using skija with membrane.

## Note

The Skija backend has an annoying quirk that you can only open one window at a time and once you close it, it will crash if you try to open another window. This is a limitation of the glfw library that the skija backend uses. Fixing the multiple windows issues is possible, but no one has complained about it, so I haven't spent time on it yet. If you want to see it fixed, please vote on this issue, https://github.com/phronmophobic/membrane/issues/20.

## Usage

Run the project directly:

    $ clojure -M -m com.phronemophobic.membrane-skija-example


## License

Copyright © 2020 Adrian

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
