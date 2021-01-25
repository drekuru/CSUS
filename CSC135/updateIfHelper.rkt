#lang racket
(provide update-if)
; do not change any code above this line. Write your code below it.

(define (update-if-helper acc f g xs)
  (if (empty? xs)
      acc
      (if (f (first xs))
          (cons (g (first xs)) (update-if-helper acc f g (rest xs))) 
          (update-if-helper acc f g (rest xs))
          )
      )
)


(define (update-if f g xs)
  (update-if-helper empty f g xs)
  )