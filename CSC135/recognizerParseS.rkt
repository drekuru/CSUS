#lang racket
(provide parseS)
(require "match.rkt")
; do not change any code above this line. Write your code below it.

(define (parseS toks)
  (cond ((not (list? toks)) false)
        ((empty? toks) toks)  
     
        ((equal? (first toks) "a") (match (parseS (match toks "a")) "z"))
        ((equal? (first toks) "b") (match (parseS (match toks "b")) "y"))
        ((equal? (first toks) "z") toks)
        ((equal? (first toks) "y") toks)
        (else false)))
