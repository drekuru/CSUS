#lang racket
(provide remove-char)
; do not change any code above this line. Write your code below it.

(define (remove-char s c)
    (cond ((= (string-length s) 0) s)
          ((equal? c (substring s 0 1)) (remove-char (substring s 1) c))
          (else (string-append (substring s 0 1) (remove-char (substring s 1) c)))))