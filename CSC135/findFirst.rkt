#lang racket
(provide findFirst)
; do not change any code above this line. Write your code below it.

; findFirst: return first element of xs making f true, or false if none exists
; f: object --> boolean
; xs: list of objects
; (findFirst even? '(1 2 3 4)) evaluates to 2
; (findFirst even? '(1 3)) evaluates to false
(define (findFirst f xs)
  
  (if (empty? xs)
      #f(if (f (first xs))
          (first xs)(findFirst f(rest xs)))))