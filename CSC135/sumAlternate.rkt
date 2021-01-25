#lang racket
(provide sum-alternate)
; do not change any code above this line. Write your code below it.

(define (sum-alternate x)
 (if (<= x 0)
     0
     (+ x (sum-alternate (- x 2)))
 )
)