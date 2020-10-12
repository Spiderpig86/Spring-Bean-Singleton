# Spring Bean Demo

This is a demo project is a small API that contains a stateful singleton bean. The `master` branch contains the fixed
 code, but the `race-condition` branch contains the non-thread-safe version of the API.
 
 The accompanying blog post can be found [here](https://slim.netlify.app/pitfalls-of-the-singleton-bean).
 
 To demonstrate the behavior mentioned in the blog post, `spammer.py` is bundled with the repo.