#lang racket
(require "quizS.rkt")
(provide parseS)
; do not change any code above this line. Write your code below it.

(define (parseS toks)
  (cond (
            (not 
                 (list? toks)) false)
        (
            (empty? toks) (parseB (parseA toks)))         
        (
            (equal? 
                    (first toks) "a") (parseB (parseA toks))) 
        (
            (equal? 
                    (first toks) "b") (parseB (parseA toks))) 
        (
            else false)))