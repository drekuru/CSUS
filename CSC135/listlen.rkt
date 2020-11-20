
#lang racket/base
(require racket/bool)
(require racket/list)
(provide listlen)
; do not change any code above this line. Write your code below it.
(define (listlen lst)
  (if (null? lst)
     0
     (+ 1
        (listlen (cdr lst)))))



(listlen '());