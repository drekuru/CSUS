#lang racket
(require "match.rkt")
(provide parseA)
; do not change any code above this line. Write your code below it.

(define (parseA toks)
  (cond ((not (list? toks)) false)
        
        ((empty? toks) toks)
        
         ((equal? (first toks) "a") (parseA (match (rest toks) "a")))
         
        ((equal? (first toks) "b") toks)
        
        (else false)))
