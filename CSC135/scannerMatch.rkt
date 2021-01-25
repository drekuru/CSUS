#lang racket
(provide match)
; do not change any code above this line. Write your code below it.

; match : list item -> list or false
; if first item of list equals item return rest of list, else false
; Examples:
;   '("a" "b" "c") "a" -> '("b" "c")
;   '("a" "b" "c") "b" -> false
;   '("a") "a" -> '()
;   '() "a" -> false
;   false "a" -> false
(define (match toks tok) ;function definition
    (if (list? toks) ;return false if toks not a list
        (if (empty? toks) ;return false if toks is an empty list
                false
                (if (string=? (first toks) tok) ;return false if tok is not first element of toks, else return rest of toks
                    (rest toks)
                    false))
        false))
