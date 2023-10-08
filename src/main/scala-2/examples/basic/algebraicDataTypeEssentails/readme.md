# Algebraic Data Type Essentials

## Introduction

I promised I wouldn't needlessly bury my reader with theory, but here's one you must know. However, rather than condescend and say (as someone once told me), "You ideally model your domain as an algebra," I'm going to put this plain and simple:

Algebraic Data Types are a way of trimming down too many cases you can't reason about into a small number of cases you can reason about. **They're another use of the type system to make invalid states impossible to represent.**

While hardly a concept specific to Scala, the language makes it easy to define an ADT, and the compiler uses them to prevent bugs. At the same time, they clarify precisely the intent of your interface and the behavior of its implementation.

## [Fetch Request Semantics][fetch-request-semantics]

Directly inspired by a problem a mentee of mine needed to solve, this provides a crystal-clear illustration of how this technique can dramatically simplify implementation and make obvious what a service does.

[fetch-request-semantics]: interfaceDesignImprovements