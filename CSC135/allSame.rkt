#lang racket
(provide all-same)
; do not change any code above this line. Write your code below it.

(define (remove-char s c)
    (cond ((= (string-length s) 0) s)
          ((equal? c (substring s 0 1)) (remove-char (substring s 1) c))
          (else (string-append (substring s 0 1) (remove-char (substring s 1) c)))))

(define (all-same s)
  (if (>= (string-length s) 1)
      (if (= 0 (string-length (remove-char s (substring s 0 1))))#t #f)#t))
  