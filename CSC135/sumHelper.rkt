#lang racket
(provide sum)
; do not change any code above this line. Write your code below it.

; At each call, the answer is accum + (sum of remaining values in xs)
; which means when xs is empty the answer is in accum. Each call should
; make xs smaller and accum larger.
(define (sum-helper acc xs)
  (if(empty? xs)
     acc
     (sum-helper (+ acc (first xs)) (rest xs)))
     )
 

(define (sum xs)
  (sum-helper 0 xs)
)
